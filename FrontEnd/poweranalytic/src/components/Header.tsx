import Link from 'next/link';

export default function Header() {
  return (
    <header className="flex items-center justify-between px-8 py-4 bg-gray-800 shadow-lg">
      <h1 className="text-2xl font-bold text-neon-green">PowerAnalytics</h1>
      <nav className="hidden md:flex gap-6">
        <Link href="pages/cadastro" className="hover:text-neon-green">
          Cadastro/Perfil
        </Link>
        <Link href="pages/mapa" className="hover:text-neon-green">
          Mapa
        </Link>
        <Link href="pages/relatorios" className="hover:text-neon-green">
          Relatórios
        </Link>
        <Link href="pages/admin" className="hover:text-neon-green">
          Administração
        </Link>
      </nav>
      <button className="md:hidden text-neon-green">☰</button>
    </header>
  );
}
