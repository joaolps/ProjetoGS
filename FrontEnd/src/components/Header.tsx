/* src/components/Header.tsx */
import Link from 'next/link';

const Header = () => {
  return (
    <header className="flex items-center justify-between py-4 px-8 bg-gray-800">
      {/* Logo */}
      <div className="text-white font-bold text-lg">
        Logo
      </div>

      {/* Menu */}
      <nav className="flex space-x-4">
        {['Página1', 'Página2', 'Página3', 'Página4', 'Página5'].map((page, index) => (
          <Link href={`/${page.toLowerCase()}`} key={index} className="text-white hover:text-gray-400">
            {page}
          </Link>
        ))}
      </nav>

      {/* Espaço vazio à direita */}
      <div className="w-16"></div>
    </header>
  );
};

export default Header;
