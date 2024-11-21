// src/app/membros.tsx
import Image from "next/image";

const Membros = () => {
  const integrantes = [
    {
      nome: "Pedro Henrique Jorge De Paula",
      rm: "558833",
      github: "https://github.com/hDepth",
      linkedin: "https://linkedin.com/in/pedrohenrique",
      foto: "/Pedro.jpg",
    },
    {
      nome: "Thiago Oliveira",
      rm: "558834",
      github: "https://github.com/thiagoliveira",
      linkedin: "https://linkedin.com/in/thiagooliveira",
      foto: "/Thiago.jpg",
    },
    {
      nome: "João Silva",
      rm: "558835",
      github: "https://github.com/joaosilva",
      linkedin: "https://linkedin.com/in/joaosilva",
      foto: "/Joao.jpg",
    },
  ];

  return (
    <div className="bg-gray-900 text-white min-h-screen">
      <header className="bg-red-600 text-white py-4 shadow-lg">
        <div className="container mx-auto text-center">
          <h1 className="text-4xl font-bold">Equipe FIAP</h1>
          <p className="text-lg">Os alunos que tornaram este projeto possível</p>
        </div>
      </header>

      <main className="py-16 px-4">
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8 container mx-auto">
          {integrantes.map((integrante, index) => (
            <div
              key={index}
              className="bg-gray-800 rounded-lg p-6 flex flex-col items-center shadow-md hover:shadow-xl transition"
            >
              <Image
                src={integrante.foto}
                alt={integrante.nome}
                width={150}
                height={150}
                className="rounded-full mb-4"
              />
              <h2 className="text-xl font-bold">{integrante.nome}</h2>
              <p className="text-gray-400">RM: {integrante.rm}</p>
              <div className="flex mt-4 space-x-4">
                <a
                  href={integrante.github}
                  target="_blank"
                  rel="noopener noreferrer"
                  className="text-neon-green hover:underline"
                >
                  GitHub
                </a>
                <a
                  href={integrante.linkedin}
                  target="_blank"
                  rel="noopener noreferrer"
                  className="text-neon-green hover:underline"
                >
                  LinkedIn
                </a>
              </div>
            </div>
          ))}
        </div>
      </main>

      <footer className="bg-gray-800 py-4 text-center text-gray-400">
        <p>&copy; {new Date().getFullYear()} FIAP. Todos os direitos reservados.</p>
      </footer>
    </div>
  );
};

export default Membros;
