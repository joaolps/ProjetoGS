"use client";

import React, { useState } from "react";
import Link from "next/link";

export default function Cadastro() {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    phone: "",
    cpf: "",
    password: "",
    confirmPassword: "",
  });

  const [errors, setErrors] = useState({
    name: "",
    email: "",
    phone: "",
    cpf: "",
    password: "",
    confirmPassword: "",
  });

  const validateEmail = (email: string) => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);

  const validateCPF = (cpf: string) => /^\d{3}\.\d{3}\.\d{3}-\d{2}$/.test(cpf);

  const validatePhone = (phone: string) =>
    /^\(\d{2}\) \d \d{4}-\d{4}$/.test(phone);

  const formatCPF = (value: string) => {
    const cleanValue = value.replace(/\D/g, ""); 
    if (cleanValue.length <= 3) return cleanValue;
    if (cleanValue.length <= 6)
      return `${cleanValue.slice(0, 3)}.${cleanValue.slice(3)}`;
    if (cleanValue.length <= 9)
      return `${cleanValue.slice(0, 3)}.${cleanValue.slice(3, 6)}.${cleanValue.slice(6)}`;
    return `${cleanValue.slice(0, 3)}.${cleanValue.slice(3, 6)}.${cleanValue.slice(
      6,
      9
    )}-${cleanValue.slice(9, 11)}`;
  };

  const formatPhone = (value: string) => {
    const cleanValue = value.replace(/\D/g, "");
    if (cleanValue.length === 0) return ""; 
    if (cleanValue.length <= 2) return `(${cleanValue}`; 
    if (cleanValue.length <= 6)
      return `(${cleanValue.slice(0, 2)}) ${cleanValue.slice(2)}`;
    return `(${cleanValue.slice(0, 2)}) ${cleanValue.slice(2, 3)} ${cleanValue.slice(
      3,
      7
    )}-${cleanValue.slice(7, 11)}`;
  };
  
  

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { id, value } = e.target;

    let formattedValue = value;
    if (id === "cpf") formattedValue = formatCPF(value);
    if (id === "phone") formattedValue = formatPhone(value);

    setFormData({ ...formData, [id]: formattedValue });

    let error = "";
    if (id === "email" && !validateEmail(value)) error = "E-mail inválido.";
    if (id === "cpf" && value.length === 14 && !validateCPF(value))
      error = "CPF inválido.";
    if (id === "phone" && value.length === 15 && !validatePhone(value))
      error = "Número de telefone inválido.";
    if (id === "confirmPassword" && value !== formData.password)
      error = "As senhas não coincidem.";
    setErrors({ ...errors, [id]: error });
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();

    const newErrors = {
      name: formData.name ? "" : "O nome é obrigatório.",
      email: validateEmail(formData.email) ? "" : "E-mail inválido.",
      cpf: validateCPF(formData.cpf) ? "" : "CPF inválido.",
      phone: validatePhone(formData.phone) ? "" : "Número de telefone inválido.",
      password: formData.password ? "" : "A senha é obrigatória.",
      confirmPassword:
        formData.confirmPassword === formData.password
          ? ""
          : "As senhas não coincidem.",
    };

    setErrors(newErrors);

    const hasErrors = Object.values(newErrors).some((error) => error);
    if (!hasErrors) {
      alert("Cadastro realizado com sucesso!");
      console.log(formData);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient">
      <div className="bg-gray-800 p-8 rounded-lg shadow-md w-96">
        <form onSubmit={handleSubmit}>
          

          <div className="mb-6">
            <label className="block text-gray-400 mb-2" htmlFor="email">
              E-mail
            </label>
            <input
              id="email"
              type="email"
              value={formData.email}
              onChange={handleInputChange}
              className="w-full p-2 bg-transparent border-b-2 border-gray-400 focus:outline-none focus:border-[#39ff14] text-gray-300"
            />
            {errors.email && <p className="text-red-500 text-sm">{errors.email}</p>}
          </div>

          <div className="mb-6">
            <label className="block text-gray-400 mb-2" htmlFor="phone">
              Número
            </label>
            <input
              id="phone"
              type="text"
              value={formData.phone}
              onChange={handleInputChange}
              maxLength={15}
              className="w-full p-2 bg-transparent border-b-2 border-gray-400 focus:outline-none focus:border-[#39ff14] text-gray-300"
            />
            {errors.phone && <p className="text-red-500 text-sm">{errors.phone}</p>}
          </div>

          <div className="mb-6">
            <label className="block text-gray-400 mb-2" htmlFor="cpf">
              CPF
            </label>
            <input
              id="cpf"
              type="text"
              value={formData.cpf}
              onChange={handleInputChange}
              maxLength={14}
              className="w-full p-2 bg-transparent border-b-2 border-gray-400 focus:outline-none focus:border-[#39ff14] text-gray-300"
            />
            {errors.cpf && <p className="text-red-500 text-sm">{errors.cpf}</p>}
          </div>

          <div className="mb-6">
            <label className="block text-gray-400 mb-2" htmlFor="password">
              Senha
            </label>
            <input
              id="password"
              type="password"
              value={formData.password}
              onChange={handleInputChange}
              className="w-full p-2 bg-transparent border-b-2 border-gray-400 focus:outline-none focus:border-[#39ff14] text-gray-300"
            />
            {errors.password && (
              <p className="text-red-500 text-sm">{errors.password}</p>
            )}
          </div>

          <div className="mb-6">
            <label
              className="block text-gray-400 mb-2"
              htmlFor="confirmPassword"
            >
              Confirme sua Senha
            </label>
            <input
              id="confirmPassword"
              type="password"
              value={formData.confirmPassword}
              onChange={handleInputChange}
              className="w-full p-2 bg-transparent border-b-2 border-gray-400 focus:outline-none focus:border-[#39ff14] text-gray-300"
            />
            {errors.confirmPassword && (
              <p className="text-red-500 text-sm">{errors.confirmPassword}</p>
            )}
          </div>

          <p className="text-[#39ff14] text-sm mb-4">
            <Link href="/login">Já possui uma conta?</Link>
          </p>
          <div className="text-center">
            <Link href="/"
              type="submit"
              className="px-6 py-2 bg-[#39ff14] text-black font-bold uppercase rounded hover:bg-[#2fdf10] transition"
            >
              Cadastrar
            </Link>
          </div>
        </form>
      </div>
    </div>
  );
}
