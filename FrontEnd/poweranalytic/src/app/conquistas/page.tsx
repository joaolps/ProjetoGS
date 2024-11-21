"use client";
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import React, { useState } from "react";

const desafios = [
  { id: 1, titulo: "Recicle 10 kg de Lixo Eletrônico", pontos: 100 },
  { id: 2, titulo: "Indique um Ponto de Coleta", pontos: 50 },
  { id: 3, titulo: "Leve Lixo Eletrônico para Coleta", pontos: 150 },
];

// Dados Mockados para simular ranking
const usuariosMock = [
  { id_usuario: 1, nome: "Maria Silva", pontos: 1200 },
  { id_usuario: 2, nome: "João Pereira", pontos: 1100 },
  { id_usuario: 3, nome: "PowerCorp", pontos: 900 },
  { id_usuario: 4, nome: "Ana Oliveira", pontos: 850 },
  { id_usuario: 5, nome: "EcoEmpresa", pontos: 750 },
];

export default function Conquistas() {
  const [usuarios, setUsuarios] = useState(usuariosMock);
  const usuarioAtual = usuarios.find((u) => u.id_usuario === 1); 

  // Função para obter recompensa
  const obterRecompensa = (pontos: number) => {
    setUsuarios((prevUsuarios) =>
      prevUsuarios
        .map((user) =>
          user.id_usuario === usuarioAtual?.id_usuario
            ? { ...user, pontos: user.pontos + pontos }
            : user
        )
        .sort((a, b) => b.pontos - a.pontos) 
    );
  };

  return (
    
    <div className="bg-gray-900 text-white min-h-screen px-8 py-16">
        <Header />
      
      <h1 className="text-4xl font-bold text-neon-green text-center mb-8 mt-12">
        Conquistas Sustentáveis
      </h1>

     
      <p className="text-lg text-center max-w-3xl mx-auto mb-12">
        Participe dos desafios e acumule pontos enquanto ajuda o planeta!
        Veja seu progresso no ranking e desbloqueie conquistas incríveis.
      </p>

      <section className="mb-16">
        <h2 className="text-2xl font-bold text-neon-green mb-4">Desafios</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {desafios.map((desafio) => (
            <div
              key={desafio.id}
              className="p-6 bg-gray-800 rounded shadow-lg text-center"
            >
              <h3 className="text-lg font-semibold mb-2">{desafio.titulo}</h3>
              <p className="text-sm text-gray-400 mb-4">
                Ganhe <span className="text-neon-green">{desafio.pontos} pontos</span>
              </p>
              <button
                className="px-4 py-2 bg-neon-green text-gray-900 rounded shadow hover:shadow-lg"
                onClick={() => obterRecompensa(desafio.pontos)}
              >
                Obter Recompensa
              </button>
            </div>
          ))}
        </div>
      </section>

   
      <section>
        <h2 className="text-2xl font-bold text-neon-green mb-4">Ranking</h2>
        <div className="overflow-x-auto">
          <table className="table-auto w-full text-left bg-gray-800 rounded shadow-lg">
            <thead>
              <tr className="text-neon-green">
                <th className="px-4 py-2">Posição</th>
                <th className="px-4 py-2">Nome</th>
                <th className="px-4 py-2">Pontos</th>
              </tr>
            </thead>
            <tbody>
              {usuarios.map((user, index) => (
                <tr
                  key={user.id_usuario}
                  className={`${
                    index % 2 === 0 ? "bg-gray-700" : "bg-gray-600"
                  } hover:bg-gray-500 ${
                    user.id_usuario === usuarioAtual?.id_usuario
                      ? "font-bold text-neon-green"
                      : ""
                  }`}
                >
                  <td className="px-4 py-2">{index + 1}</td>
                  <td className="px-4 py-2">{user.nome}</td>
                  <td className="px-4 py-2">{user.pontos}</td>
                </tr>
              ))}
            </tbody>
          </table>
          
        </div>
        
      </section>
      <Footer />
    </div>
  );
}
