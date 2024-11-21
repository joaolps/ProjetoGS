
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import Link from "next/link";

export default function Home() {
  return (
    <div className="bg-gray-900 text-white min-h-screen">
      <Header />
      <main className="flex flex-col items-center justify-center text-center px-6 py-16 space-y-8 mt-12">
        <h2 className="text-4xl font-bold text-neon-green shadow-lg">
          Juntos pela Sustentabilidade
        </h2>
        <p className="max-w-2xl text-lg">
          PowerAnalytics conecta pessoas, empresas e indústrias para transformar
          o lixo eletrônico em energia sustentável. Faça parte dessa mudança!
        </p>
        <div className="space-x-4">
          <Link
            href="/cadastro"  
            className="px-6 py-3 bg-neon-green text-gray-900 rounded shadow-md hover:shadow-lg"
          >
            Comece Agora
          </Link>
          <Link
            href="/mapa"  
            className="px-6 py-3 border border-neon-green text-neon-green rounded shadow-md hover:bg-neon-green hover:text-gray-900"
          >
            Ver Locais
          </Link>
        </div>

        <section className="flex flex-col items-center justify-center bg-gray-800 text-white py-20 h-screen">
          <h3 className="text-3xl font-bold mb-8 text-neon-green">Nossos Serviços</h3>
          <div className="flex flex-wrap justify-center gap-8">
          <div className="w-full sm:w-1/3 md:w-1/4 p-6 bg-gray-700 rounded-lg shadow-lg transform transition-all duration-300 hover:scale-105 hover:border-4 hover:border-neon-green hover:shadow-neon-glow">
        <img
          src="/recycle.png"
          alt="Reciclagem"
          className="w-12 h-12 mx-auto mb-4 transform transition-all duration-300 hover:scale-150"
        />
        <h4 className="text-xl font-semibold">Reciclagem de Eletrônicos</h4>
        <p>
          Transformamos lixo eletrônico em energia, contribuindo para a sustentabilidade e redução de resíduos.
        </p>
      </div>
            <div className="w-full sm:w-1/3 md:w-1/4 p-6 bg-gray-700 rounded-lg shadow-lg transform transition duration-300 hover:scale-105 hover:border-4 hover:border-neon-green">
              <img
                src="/energyG.png"
                alt="Energia Sustentável"
                className="w-12 h-12 mx-auto mb-4 transform transition duration-300 hover:scale-150"
              />
              <h4 className="text-xl font-semibold">Energia Sustentável</h4>
              <p>
                Geramos energia limpa e renovável a partir dos resíduos eletrônicos, impactando positivamente o meio ambiente.
              </p>
            </div>
            <div className="w-full sm:w-1/3 md:w-1/4 p-6 bg-gray-700 rounded-lg shadow-lg transform transition duration-300 hover:scale-105 hover:border-4 hover:border-neon-green">
              <img
                src="/logopa.png"
                alt="Inovação"
                className="w-12 h-12 mx-auto mb-4 transform transition duration-300 hover:scale-150"
              />
              <h4 className="text-xl font-semibold">Inovação Tecnológica</h4>
              <p>
                Utilizamos tecnologia de ponta para garantir a máxima eficiência na transformação de resíduos eletrônicos.
              </p>
            </div>
          </div>
        </section>

        <h2 className="text-4xl font-bold text-neon-green shadow-lg">
          Veja o quanto voce nos ajuda e ajuda o mundo!
        </h2>
        <p className="max-w-2xl text-lg">
          PowerAnalytics te mostra por meio de gráficos o quanto de lixo eletrônico esta sendo reciclado!
        </p>
        <div className="space-x-4">
          
          <Link
            href="/relatorios"
            className="px-6 py-3 border border-neon-green text-neon-green rounded shadow-md hover:bg-neon-green hover:text-gray-900"
          >
           Checar!
          </Link>
        </div>
        
        <section className="flex flex-col items-center justify-center bg-gray-800 text-white py-20 h-screen">
          <h3 className="text-3xl font-bold mb-8 text-neon-green">Nossos Valores</h3>
          <div className="flex flex-wrap justify-center gap-8">
            <div className="w-full sm:w-1/3 md:w-1/4 p-6 bg-gray-700 rounded-lg shadow-lg transform transition duration-300 hover:scale-105 hover:border-4 hover:border-neon-green">
              <img
                src="/eco-friendly.jpeg"
                alt="Eco-Friendly"
                className="w-12 h-12 mx-auto mb-4 transform transition duration-300 hover:scale-150"
              />
              <h4 className="text-xl font-semibold">Eco-Friendly</h4>
              <p>
                Compromisso com a preservação do meio ambiente e a utilização responsável dos recursos naturais.
              </p>
            </div>
            <div className="w-full sm:w-1/3 md:w-1/4 p-6 bg-gray-700 rounded-lg shadow-lg transform transition duration-300 hover:scale-105 hover:border-4 hover:border-neon-green">
              <img
                src="/reciclagem-lixo-eletronico.jpg"
                alt="Comunidade"
                className="w-12 h-12 mx-auto mb-4 transform transition duration-300 hover:scale-150"
              />
              <h4 className="text-xl font-semibold">Engajamento Comunitário</h4>
              <p>
                Trabalhamos para criar um impacto positivo nas comunidades ao promover a educação sobre reciclagem.
              </p>
            </div>
            <div className="w-full sm:w-1/3 md:w-1/4 p-6 bg-gray-700 rounded-lg shadow-lg transform transition duration-300 hover:scale-105 hover:border-4 hover:border-neon-green">
              <img
                src="/fig-prop-1.png"
                alt="Confiança"
                className="w-12 h-12 mx-auto mb-4 transform transition duration-300 hover:scale-150"
              />
              <h4 className="text-xl font-semibold">Analise sustentavel</h4>
              <p>
              Exibimos dados que mostram o impacto positivo no meio ambiente graças aos nossos usuários
              </p>
            </div>
          </div>
        </section>

        <p className="max-w-2xl text-lg">
          Dúvidas? Sugestões? FeedBacks? Entre em contato com a PowerAnalytics!
        </p>
        <div className="space-x-4">
          
          <Link
            href="/contato"
            className="px-6 py-3 border border-neon-green text-neon-green rounded shadow-md hover:bg-neon-green hover:text-gray-900"
          >
           Fale Conosco!
          </Link>
        </div>

{/* section para membros */}
        <section className="flex flex-col items-center justify-center bg-gray-800 py-20">
  <h3 className="text-3xl font-bold text-neon-green mb-8">Nosso Time</h3>
  <div className="flex flex-wrap justify-center gap-8">
    
    {/* Pedro */}
    <div className="flex flex-col items-center text-center">
      <div className="w-48 h-48 bg-white rounded-full overflow-hidden flex items-center justify-center transform transition duration-300 hover:scale-110 hover:shadow-xl hover:shadow-neon-green">
        <img src="/Pedro2.jpg" alt="Pedro Henrique Jorge De Paula" className="w-full h-full object-cover" />
      </div>
      <div className="mt-4">
        <p className="font-semibold">Pedro Henrique Jorge De Paula</p>
        <p>RM: 558833</p>
        <p>FrontEnd Developer</p>
        <a href="https://github.com/hDepth" target="_blank" rel="noopener noreferrer">
          <img src="/github.png" alt="GitHub" className="w-8 h-8 mt-2 mx-auto" />
        </a>
      </div>
    </div>

    {/* Thiago */}
    <div className="flex flex-col items-center text-center">
      <div className="w-48 h-48 bg-white rounded-full overflow-hidden flex items-center justify-center transform transition duration-300 hover:scale-110 hover:shadow-xl hover:shadow-neon-green">
        <img src="/Thiago.jpg" alt="Thiago" className="w-full h-full object-cover" />
      </div>
      <div className="mt-4">
        <p className="font-semibold">Thiago Thomaz Sales Conceição </p>
        <p>RM: 557992</p>
        <p>BackEnd Developer</p>
        <a href="https://github.com/thiago" target="_blank" rel="noopener noreferrer">
          <img src="/github.png" alt="GitHub" className="w-8 h-8 mt-2 mx-auto" />
        </a>
      </div>
    </div>

    {/* João */}
    <div className="flex flex-col items-center text-center">
      <div className="w-48 h-48 bg-white rounded-full overflow-hidden flex items-center justify-center transform transition duration-300 hover:scale-110 hover:shadow-xl hover:shadow-neon-green">
        <img src="/Joao.jpg" alt="João" className="w-full h-full object-cover" />
      </div>
      <div className="mt-4">
        <p className="font-semibold">João Lopes Coelho Neto </p>
        <p>RM:556865</p>
        <p>BackEnd Developer</p>
        <a href="https://github.com/joao" target="_blank" rel="noopener noreferrer">
          <img src="/github.png" alt="GitHub" className="w-8 h-8 mt-2 mx-auto" />
        </a>
      </div>
    </div>
  </div>
</section>



        
      </main>
      <Footer />
    </div>
  );
}
