
import Header from '@/components/Header';
import Footer from '@/components/Footer';

const Mapa = () => {
  return (
    <div className="bg-gray-900 text-white min-h-screen">
      <Header />
      <main className="flex flex-col items-center justify-center text-center px-6 py-16 space-y-8 mt-12">
        <h2 className="text-4xl font-bold text-neon-green shadow-lg">Mapa de Concentração de Lixo Eletrônico</h2>
        <p className="max-w-2xl text-lg">
          Aqui você pode ver os locais com maior concentração de lixo eletrônico para que você possa colaborar com a reciclagem energética.
        </p>
        
      
        <div 
          className="w-full h-96 relative bg-cover bg-center" 
          style={{ backgroundImage: "url('/mapa1.png')" }}
        >
          <div className="absolute top-20 left-20 bg-red-500 p-2 rounded-full text-white">
            Local 1
          </div>
          <div className="absolute top-40 left-40 bg-blue-500 p-2 rounded-full text-white">
            Local 2
          </div>
          <div className="absolute top-60 left-60 bg-green-500 p-2 rounded-full text-white">
            Local 3
          </div>
          <p className="absolute bottom-4 left-1/2 transform -translate-x-1/2 text-center text-white">
            Mapa simulado de pontos de concentração de resíduos eletrônicos
          </p>
        </div>
      </main>
      <Footer />
    </div>
  );
};

export default Mapa;
