import Link from 'next/link';

export default function Footer() {
  return (
    <footer className="fixed bottom-0 left-0 w-full bg-transparent px-6 py-4 flex items-center">
      <Link
        href="/contato"
        className="text-neon-green text-sm font-semibold hover:underline"
      >
        Contato
      </Link>
    </footer>
  );
}
