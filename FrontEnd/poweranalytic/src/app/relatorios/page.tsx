// src/app/relatorios.tsx
import Header from '@/components/Header';
import Footer from '@/components/Footer';

const Relatorios = () => {
  return (
    <div className="bg-gray-900 text-white min-h-screen">
      <Header />
      <main className="flex flex-col items-center justify-center text-center px-6 py-16 space-y-8">
        <h2 className="text-4xl font-bold text-neon-green shadow-lg">Relatórios de Reciclagem</h2>
        <p className="max-w-2xl text-lg">
          Acompanhe o impacto da reciclagem energética. Veja os dados atualizados sobre a quantidade de lixo eletrônico reciclado.
        </p>

        <div className="space-y-4">
          {/* Exemplo de gráficos ou dados (usando uma biblioteca de gráficos como Chart.js ou outra) */}
          <div className="w-full bg-gray-800 p-4 rounded">
            <p className="text-center">Gráfico de impacto da reciclagem</p>
          </div>
        </div>
      </main>
      <Footer />
    </div>
  );
};

export default Relatorios;
