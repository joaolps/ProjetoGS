// src/components/Header.tsx
import Link from 'next/link';
import Image from 'next/image'; // Importando o componente Image para otimização de imagens

const Header = () => {
  return (
    <header className="bg-gray-900 text-white shadow-lg p-4">
      <div className="container mx-auto flex justify-between items-center">
        {/* Logo à esquerda do título */}
        <div className="flex items-center">
          <Image 
            src="/logopa.png" // Caminho para a logo
            alt="Logo PowerAnalytics"
            width={50} // Ajuste o tamanho conforme necessário
            height={50} // Ajuste o tamanho conforme necessário
            className="mr-2" // Espaço à direita da logo
          />
          <h1 className="text-3xl font-bold text-neon-green">PowerAnalytics</h1>
        </div>

        {/* Navegação */}
        <nav className="space-x-4">
          <Link href="/" className="text-lg hover:text-neon-green">Início</Link>
          <Link href="/cadastro" className="text-lg hover:text-neon-green">Cadastro</Link>
          <Link href="/mapa" className="text-lg hover:text-neon-green">Mapa</Link>
          <Link href="/relatorios" className="text-lg hover:text-neon-green">Relatórios</Link>
          <Link href="/admin" className="text-lg hover:text-neon-green">Admin</Link>
          <Link href="/contato" className="text-lg hover:text-neon-green">Contato</Link>
          <Link href="/conquistas" className="hover:text-neon-green">Conquistas</Link>
        </nav>
      </div>
    </header>
  );
};

export default Header;
