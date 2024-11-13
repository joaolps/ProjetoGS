"use client";
import Header from '../components/Header';
import Footer from '../components/Footer';
import { useState } from 'react';

export default function Home() {
  const [hoveredCard, setHoveredCard] = useState<number | null>(null);

  return (
    <div className="min-h-screen flex flex-col bg-gray-900 text-white">
      <Header />
      <main className="flex-grow flex flex-col items-center justify-center p-8">
        
        {/* Seção Hero */}
        <section className="text-center mb-16">
          <h1 className="text-5xl font-extrabold text-neon-green mb-4">
            Bem-vindo ao Futuro da Sustentabilidade
          </h1>
          <p className="text-lg text-gray-300 max-w-md mx-auto">
            Nossa missão é unir tecnologia avançada e responsabilidade ambiental para um futuro mais verde e conectado.
          </p>
          <button className="mt-8 px-6 py-3 bg-neon-green text-gray-900 font-bold rounded-full hover:bg-opacity-90 transition duration-300">
            Saiba Mais
          </button>
        </section>

        {/* Seção Funcionalidades */}
        <section className="grid grid-cols-1 md:grid-cols-2 gap-8 text-center max-w-5xl">
          {[1, 2].map((cardIndex) => (
            <div
              key={cardIndex}
              onMouseEnter={() => setHoveredCard(cardIndex)}
              onMouseLeave={() => setHoveredCard(null)}
              className={`relative p-6 rounded-lg transition-all duration-500 ease-out ${
                hoveredCard === cardIndex
                  ? 'col-span-2 transform scale-y-110 scale-x-95 shadow-neon-green bg-gray-800'
                  : 'bg-gray-800 hover:shadow-neon-green transform scale-y-90'
              }`}
              style={{
                minHeight: hoveredCard === cardIndex ? '300px' : '200px',
                overflow: 'hidden',
              }}
            >
              <h2 className="text-2xl font-bold text-neon-green mb-2">
                {cardIndex === 1 ? "Tecnologia Verde" : "Energia Sustentável"}
              </h2>
              <div
                className={`transition-opacity duration-500 ease-out ${
                  hoveredCard === cardIndex ? 'opacity-100' : 'opacity-0 h-0'
                }`}
              >
                <div className="mb-4 w-40 h-24 relative border-2 border-neon-green rounded-lg overflow-hidden flex items-center justify-center">
                  <img
                    src={`/imagem${cardIndex}.png`}  // Caminho das imagens dentro da pasta public
                    alt={`Imagem ${cardIndex}`}
                    className="object-cover w-full h-full"
                  />
                </div>
                <p className="text-gray-300 mb-4">
                  {cardIndex === 1
                    ? "Explore soluções de ponta para redução de impacto ambiental."
                    : "Descubra o poder de fontes renováveis para um futuro mais limpo."}
                </p>
                <button className="px-4 py-2 bg-neon-green text-gray-900 font-bold rounded-full hover:bg-opacity-90 transition duration-300">
                  Conhecer
                </button>
              </div>
              {hoveredCard !== cardIndex && (
                <p className="text-gray-400">
                  {cardIndex === 1
                    ? "Soluções de última geração para reduzir o impacto ambiental."
                    : "Aproveite fontes renováveis para uma operação mais limpa."}
                </p>
              )}
            </div>
          ))}
        </section>

        {/* Depoimentos (opcional) */}
        <section className="text-center my-16 max-w-3xl">
          <h3 className="text-3xl font-bold text-neon-green mb-4">O Que Dizem Nossos Usuários</h3>
          <p className="text-gray-300 italic">
            “Este projeto transformou a maneira como pensamos sobre sustentabilidade e inovação tecnológica.”
          </p>
          <p className="text-gray-300 mt-2">— Cliente Satisfeito</p>
        </section>
        
      </main>
      <Footer />
    </div>
  );
}
