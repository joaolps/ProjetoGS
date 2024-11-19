// src/app/mapa.tsx
import Header from '@/components/Header';
import Footer from '@/components/Footer';

const Mapa = () => {
  return (
    <div className="bg-gray-900 text-white min-h-screen">
      <Header />
      <main className="flex flex-col items-center justify-center text-center px-6 py-16 space-y-8">
        <h2 className="text-4xl font-bold text-neon-green shadow-lg">Mapa de Concentração de Lixo Eletrônico</h2>
        <p className="max-w-2xl text-lg">
          Aqui você pode ver os locais com maior concentração de lixo eletrônico para que você possa colaborar com a reciclagem energética.
        </p>
        
        {/* Aqui, você pode integrar um mapa interativo com Google Maps ou outra solução */}
        <div className="w-full h-96 bg-gray-700">
          {/* Exemplo de estrutura de mapa, adicione a biblioteca de mapa desejada */}
          <p className="text-center text-white">Mapa interativo (Google Maps ou outra biblioteca).</p>
        </div>
      </main>
      <Footer />
    </div>
  );
};

export default Mapa;
