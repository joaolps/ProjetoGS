"use client";

import React, { useState } from "react";

export default function Cadastro() {
  const [formData, setFormData] = useState({
    nome: "",
    email: "",
    senha: "",
    cpf: "",
    telefone: "",
  });

  const [mensagem, setMensagem] = useState("");

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const res = await fetch("/api/cadastro", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
      });

      const data = await res.json();
      if (res.ok) {
        setMensagem("Cadastro realizado com sucesso!");
        setFormData({ nome: "", email: "", senha: "", cpf: "", telefone: "" });
      } else {
        setMensagem(`Erro: ${data.message}`);
      }
    } catch (error) {
      setMensagem("Erro ao cadastrar. Tente novamente mais tarde.");
    }
  };

  return (
    <div className="bg-gray-900 text-white min-h-screen flex items-center justify-center px-4">
      <div className="bg-gray-800 p-8 rounded shadow-lg max-w-md w-full">
        <h1 className="text-2xl font-bold text-center text-neon-green mb-6">
          Cadastro
        </h1>
        <form onSubmit={handleSubmit} className="space-y-4">
          <input
            type="text"
            name="nome"
            value={formData.nome}
            onChange={handleChange}
            placeholder="Nome"
            className="w-full p-3 rounded bg-gray-700 text-white"
            required
          />
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Email"
            className="w-full p-3 rounded bg-gray-700 text-white"
            required
          />
          <input
            type="password"
            name="senha"
            value={formData.senha}
            onChange={handleChange}
            placeholder="Senha"
            className="w-full p-3 rounded bg-gray-700 text-white"
            required
          />
          <input
            type="text"
            name="cpf"
            value={formData.cpf}
            onChange={handleChange}
            placeholder="CPF"
            className="w-full p-3 rounded bg-gray-700 text-white"
            required
          />
          <input
            type="text"
            name="telefone"
            value={formData.telefone}
            onChange={handleChange}
            placeholder="Telefone"
            className="w-full p-3 rounded bg-gray-700 text-white"
          />
          <button
            type="submit"
            className="w-full p-3 bg-neon-green text-gray-900 font-bold rounded hover:shadow-lg"
          >
            Cadastrar
          </button>
        </form>
        {mensagem && (
          <p className="text-center text-sm mt-4 text-neon-green">
            {mensagem}
          </p>
        )}
      </div>
    </div>
  );
}
