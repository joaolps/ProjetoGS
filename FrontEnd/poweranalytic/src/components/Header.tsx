'use client';

import { useEffect } from 'react';
import Link from 'next/link';
import Image from 'next/image';

const Header = () => {
  useEffect(() => {
    const handleScroll = () => {
      const header = document.querySelector('header');
      if (window.scrollY > 50) {
        header?.classList.add('shrink');
      } else {
        header?.classList.remove('shrink');
      }
    };

    window.addEventListener('scroll', handleScroll);

    return () => {
      window.removeEventListener('scroll', handleScroll);
    };
  }, []);

  return (
    <header className="bg-gray-900 text-white shadow-lg p-4 fixed top-0 w-full z-10 transition-all duration-300 ease-in-out">
      <div className="container mx-auto flex justify-between items-center">
        {/* Logo à esquerda do título */}
        <div className="flex items-center">
          <Image 
            src="/logopa.png" 
            alt="Logo PowerAnalytics"
            width={50} 
            height={50} 
            className="mr-2"
          />
          <h1 className="text-3xl font-bold text-neon-green">PowerAnalytics</h1>
        </div>

        {/* Navegação */}
        <nav className="space-x-4">
          <Link href="/" className="text-lg hover:bg-neon-green hover:text-black py-2 px-4 transition-all duration-300 ease-in-out rounded-md">
            Início
          </Link>
          
          <Link href="/mapa" className="text-lg hover:bg-neon-green hover:text-black py-2 px-4 transition-all duration-300 ease-in-out rounded-md">
            Mapa
          </Link>
          <Link href="/relatorios" className="text-lg hover:bg-neon-green hover:text-black py-2 px-4 transition-all duration-300 ease-in-out rounded-md">
            Relatórios
          </Link>
          <Link href="/conquistas" className="text-lg hover:bg-neon-green hover:text-black py-2 px-4 transition-all duration-300 ease-in-out rounded-md">
            Conquistas
          </Link>
          
          <Link href="/cadastro" className="text-lg hover:bg-neon-green hover:text-black py-2 px-4 transition-all duration-300 ease-in-out rounded-md">
            Cadastro
          </Link>
        </nav>
      </div>

      <style jsx>{`
        header {
          box-shadow: 0 2px 10px rgba(0, 0, 0, 0.5);
        }

        .container {
          transition: all 0.3s ease;
        }

        header.shrink .container {
          padding: 1rem;
        }
      `}</style>
    </header>
  );
};

export default Header;
