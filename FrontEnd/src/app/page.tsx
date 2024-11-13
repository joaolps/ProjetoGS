"use client";
import Header from '../components/Header';
import Footer from '../components/Footer';
import { useState } from 'react';


const reviews = [
  {
    id: 1,
    name: "Cliente Satisfeito 1",
    rating: 5,
    feedback: "Este projeto transformou minha visão sobre sustentabilidade!",
    image: "/imagem3.png",
  },
  {
    id: 2,
    name: "Cliente Satisfeito 2",
    rating: 4,
    feedback: "A inovação e o compromisso ambiental são notáveis!",
    image: "/imagem2.png",
  },
  {
    id: 3,
    name: "Cliente Satisfeito 3",
    rating: 3,
    feedback: "Ótima iniciativa para um futuro mais verde!",
    image: "/imagem1.png",
  },
];

export default function Home() {
  const [hoveredCard, setHoveredCard] = useState<number | null>(null);
  const [hoveredReview, setHoveredReview] = useState<number | null>(null);

  return (
    <div className="min-h-screen flex flex-col bg-gray-900 text-white">
      <Header />
      <main className="flex-grow flex flex-col items-center justify-center p-8">
        
        
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
                    src={`/imagem${cardIndex}.png`}
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

        <section className="text-center my-16 max-w-4xl">
          <h3 className="text-3xl font-bold text-neon-green mb-8">O Que Dizem Nossos Usuários</h3>
          <div className="flex gap-4 overflow-x-auto p-4">
            {reviews.map((review) => (
              <div
                key={review.id}
                onMouseEnter={() => setHoveredReview(review.id)}
                onMouseLeave={() => setHoveredReview(null)}
                className={`relative flex-shrink-0 w-64 p-4 rounded-lg transition-all duration-500 ease-out transform bg-gray-800 ${
                  hoveredReview === review.id ? 'scale-105 shadow-neon-green' : ''
                }`}
              >
                {/* Imagem do Cliente */}
                <img
                  src={review.image}
                  alt={review.name}
                  className="w-24 h-24 rounded-full object-cover mx-auto mb-4 border-2 border-neon-green"
                />

                {/* Estrelas */}
                <div className="flex justify-center mb-4">
                  {[...Array(5)].map((_, index) => (
                    <span
                      key={index}
                      className={`text-xl ${
                        index < review.rating ? 'text-yellow-400' : 'text-gray-500'
                      }`}
                    >
                      &#9733;
                    </span>
                  ))}
                </div>

                {/* Conteúdo do Card */}
                <div
                  className={`transition-opacity duration-700 ease-in-out ${
                    hoveredReview === review.id ? 'opacity-100' : 'opacity-0'
                  }`}
                >
                  <p className="text-lg font-semibold text-neon-green mb-2">{review.name}</p>
                  <p className="text-gray-300 italic">{review.feedback}</p>
                </div>
              </div>
            ))}
          </div>
        </section>
        
      </main>
      <Footer />
    </div>
  );
}