//Component Header
'use client';

import { useState, useEffect } from 'react';
import Link from 'next/link';
import Image from 'next/image';

const Header = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);

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

       
        <div className="md:hidden">
          <button
            onClick={() => setIsMenuOpen(!isMenuOpen)}
            className="text-white hover:text-neon-green focus:outline-none"
          >
            <svg
              className="w-6 h-6"
              fill="none"
              stroke="currentColor"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d={isMenuOpen ? "M6 18L18 6M6 6l12 12" : "M4 6h16M4 12h16m-7 6h7"}
              />
            </svg>
          </button>
        </div>

       
        <nav
          className={`${
            isMenuOpen ? "block" : "hidden"
          } md:block space-y-4 md:space-y-0 md:space-x-4 absolute md:static bg-gray-900 w-full md:w-auto left-0 top-full md:top-auto`}
        >
          <Link href="/" className="block md:inline-block text-lg hover:bg-neon-green hover:text-black py-2 px-4 transition-all duration-300 ease-in-out rounded-md">
            Início
          </Link>
          <Link href="/mapa" className="block md:inline-block text-lg hover:bg-neon-green hover:text-black py-2 px-4 transition-all duration-300 ease-in-out rounded-md">
            Mapa
          </Link>
          <Link href="/relatorios" className="block md:inline-block text-lg hover:bg-neon-green hover:text-black py-2 px-4 transition-all duration-300 ease-in-out rounded-md">
            Relatórios
          </Link>
          <Link href="/conquistas" className="block md:inline-block text-lg hover:bg-neon-green hover:text-black py-2 px-4 transition-all duration-300 ease-in-out rounded-md">
            Conquistas
          </Link>
          <Link href="/cadastro" className="block md:inline-block text-lg hover:bg-neon-green hover:text-black py-2 px-4 transition-all duration-300 ease-in-out rounded-md">
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
