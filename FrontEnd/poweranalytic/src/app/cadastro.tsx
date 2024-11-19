// src/app/cadastro.tsx
import Header from '@/components/Header';
import Footer from '@/components/Footer';

const Cadastro = () => {
  return (
    <div className="bg-gray-900 text-white min-h-screen">
      <Header />
      <main className="flex flex-col items-center justify-center text-center px-6 py-16 space-y-8">
        <h2 className="text-4xl font-bold text-neon-green shadow-lg">Cadastro</h2>
        <p className="max-w-2xl text-lg">
          Cadastre-se para fazer parte do movimento de reciclagem energética e contribuir com a sustentabilidade!
        </p>
        
        <form className="space-y-4 w-full max-w-md">
          <div>
            <label className="block text-left" htmlFor="nome">
              Nome
            </label>
            <input
              id="nome"
              type="text"
              className="w-full p-3 bg-gray-800 text-white rounded"
              placeholder="Digite seu nome"
            />
          </div>
          
          <div>
            <label className="block text-left" htmlFor="email">
              E-mail
            </label>
            <input
              id="email"
              type="email"
              className="w-full p-3 bg-gray-800 text-white rounded"
              placeholder="Digite seu e-mail"
            />
          </div>

          <div>
            <label className="block text-left" htmlFor="senha">
              Senha
            </label>
            <input
              id="senha"
              type="password"
              className="w-full p-3 bg-gray-800 text-white rounded"
              placeholder="Digite sua senha"
            />
          </div>
          
          <button
            type="submit"
            className="w-full p-3 bg-neon-green text-gray-900 rounded shadow-md hover:shadow-lg"
          >
            Cadastrar
          </button>
        </form>
      </main>
      <Footer />
    </div>
  );
};

export default Cadastro;
