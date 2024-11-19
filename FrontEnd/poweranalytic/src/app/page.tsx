// src/app/page.tsx
import Header from '@/components/Header'; 
import Footer from '@/components/Footer'; 
import Link from 'next/link';

export default function Home() {
  return (
    <div className="bg-gray-900 text-white min-h-screen">
      <Header />
      <main className="flex flex-col items-center justify-center text-center px-6 py-16 space-y-8">
        <h2 className="text-4xl font-bold text-neon-green shadow-lg">
          Juntos pela Sustentabilidade
        </h2>
        <p className="max-w-2xl text-lg">
          PowerAnalytics conecta pessoas, empresas e indústrias para transformar
          o lixo eletrônico em energia sustentável. Faça parte dessa mudança!
        </p>
        <div className="space-x-4">
          <Link
            href="/cadastro"  // Link correto para a página de cadastro
            className="px-6 py-3 bg-neon-green text-gray-900 rounded shadow-md hover:shadow-lg"
          >
            Comece Agora
          </Link>
          <Link
            href="/mapa"  // Link correto para a página de mapa
            className="px-6 py-3 border border-neon-green text-neon-green rounded shadow-md hover:bg-neon-green hover:text-gray-900"
          >
            Ver Locais
          </Link>
        </div>
      </main>
      <Footer />
    </div>
  );
}
