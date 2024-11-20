// src/components/Header.tsx
import Link from 'next/link';

const Header = () => {
  return (
    <header className="bg-gray-900 text-white shadow-lg p-4">
      <div className="container mx-auto flex justify-between items-center">
        <h1 className="text-3xl font-bold text-neon-green">PowerAnalytics</h1>
        <nav className="space-x-4">
          <Link href="/" className="text-lg hover:text-neon-green">
            Início
          </Link>
          <Link href="/cadastro" className="text-lg hover:text-neon-green">
            Cadastro
          </Link>
          <Link href="/mapa" className="text-lg hover:text-neon-green">
            Mapa
          </Link>
          <Link href="/relatorios" className="text-lg hover:text-neon-green">
            Relatórios
          </Link>
          <Link href="/admin" className="text-lg hover:text-neon-green">
            Admin
          </Link>
          <Link href="/contato" className="text-lg hover:text-neon-green">
            Contato
          </Link>

          <Link href="/conquistas" className="hover:text-neon-green">
            Conquistas
          </Link>

        </nav>
      </div>
    </header>
  );
};

export default Header;
