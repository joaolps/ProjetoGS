import { useEffect, useState } from 'react';

// Tipagem para os dados retornados pela API
type DatabaseRow = {
  coluna1: string;
  coluna2: number;
};

export default function Dados() {
  const [dados, setDados] = useState<DatabaseRow[]>([]);
  const [erro, setErro] = useState<string | null>(null);

  useEffect(() => {
    async function fetchDados() {
      try {
        const response = await fetch('/api/database');
        if (!response.ok) {
          throw new Error('Erro ao buscar dados da API');
        }
        const data: DatabaseRow[] = await response.json();
        setDados(data);
      } catch (error) {
        setErro((error as Error).message);
      }
    }

    fetchDados();
  }, []);

  return (
    <div>
      <h1>Dados do Banco de Dados</h1>
      {erro ? (
        <p style={{ color: 'red' }}>Erro: {erro}</p>
      ) : (
        <ul>
          {dados.map((item, index) => (
            <li key={index}>
              {item.coluna1} - {item.coluna2}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
