//Componente Footer
import Link from 'next/link';

const Footer = () => {
    return (
      <footer className="flex justify-between items-center py-4 px-8 bg-transparent text-white">
          <Link href="/contato" className="text-lg hover:bg-neon-green hover:text-black py-2 px-4 transition-all duration-300 ease-in-out rounded-md">
            Contatos
          </Link>
  
        
        <div></div>
  
      </footer>
    );
  };
  
  export default Footer;
  