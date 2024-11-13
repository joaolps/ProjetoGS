/* src/components/Footer.tsx */
const Footer = () => {
    return (
      <footer className="flex justify-between items-center py-4 px-8 bg-transparent text-white">
        {/* Botão Contato */}
        <button className="hover:text-gray-400">Contato</button>
  
        {/* Espaço vazio ao centro */}
        <div></div>
  
        {/* Botão Membros */}
        <button className="hover:text-gray-400">Membros</button>
      </footer>
    );
  };
  
  export default Footer;
  