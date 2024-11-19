import Header from "@/components/Header";
import Footer from "@/components/Footer";
import Link from "next/link";

export default function Cadastro() {
  return (
    <div className="bg-gray-900 text-white min-h-screen">
      {/* Header */}
      <Header />

      <main className="flex flex-col items-center justify-center px-6 py-16 space-y-8">
        <h2 className="text-3xl font-bold text-neon-green">Cadastro</h2>
        <p className="text-lg">Preencha os dados abaixo para se cadastrar na plataforma PowerAnalytics</p>
        
        {/* Formulário de Cadastro */}
        <form className="space-y-4 max-w-md w-full">
          <div>
            <label htmlFor="name" className="block text-sm font-semibold">Nome</label>
            <input
              type="text"
              id="name"
              className="w-full px-4 py-2 bg-gray-800 text-white rounded border border-gray-700 focus:outline-none focus:ring-2 focus:ring-neon-green"
            />
          </div>
          <div>
            <label htmlFor="email" className="block text-sm font-semibold">E-mail</label>
            <input
              type="email"
              id="email"
              className="w-full px-4 py-2 bg-gray-800 text-white rounded border border-gray-700 focus:outline-none focus:ring-2 focus:ring-neon-green"
            />
          </div>
          <div>
            <label htmlFor="password" className="block text-sm font-semibold">Senha</label>
            <input
              type="password"
              id="password"
              className="w-full px-4 py-2 bg-gray-800 text-white rounded border border-gray-700 focus:outline-none focus:ring-2 focus:ring-neon-green"
            />
          </div>
          <button
            type="submit"
            className="w-full bg-neon-green text-gray-900 px-6 py-3 rounded hover:bg-green-500"
          >
            Cadastrar
          </button>
        </form>
      </main>

      {/* Footer */}
      <Footer />
    </div>
  );
}
