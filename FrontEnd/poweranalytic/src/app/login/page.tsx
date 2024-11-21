"use client";

import Link from "next/link";

export default function Login() {
  return (
    
    <div className="min-h-screen flex items-center justify-center bg-gradient">
      <div className="bg-gray-800 p-8 rounded-lg shadow-md w-96">
        <form>
          <div className="mb-6">
            <label className="block text-gray-400 mb-2" htmlFor="username">
              Email
            </label>
            <input
              id="username"
              type="text"
              required
              className="w-full p-2 bg-transparent border-b-2 border-gray-400 focus:outline-none focus:border-[#39ff14] text-gray-300"
            />
          </div>
          <div className="mb-6">
            <label className="block text-gray-400 mb-2" htmlFor="password">
              Senha
            </label>
            <input
              id="password"
              type="password"
              required
              className="w-full p-2 bg-transparent border-b-2 border-gray-400 focus:outline-none focus:border-[#39ff14] text-gray-300"
            />
          </div>
          <p className="text-[#39ff14] text-sm mb-4">
            <Link href="/cadastro">Não possui uma conta?</Link>
          </p>
          <div className="text-center">
            <Link
              href="/"
              className="px-6 py-2 bg-[#39ff14] text-black font-bold uppercase rounded hover:bg-[#2fdf10] transition"
            >
              Entre!
            </Link>
          </div>
        </form>
      </div>
    </div>
  );
}
