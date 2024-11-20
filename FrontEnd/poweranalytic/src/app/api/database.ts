import type { NextApiRequest, NextApiResponse } from 'next';
import oracledb from 'oracledb';

// Tipagem para os dados retornados (ajuste conforme a estrutura dos seus dados)
type DatabaseRow = {
  coluna1: string;
  coluna2: number;
};

export default async function handler(req: NextApiRequest, res: NextApiResponse) {
  try {
    // Configuração da conexão
    const connection = await oracledb.getConnection({
      user: process.env.ORACLE_USER,
      password: process.env.ORACLE_PASSWORD,
      connectionString: process.env.ORACLE_CONNECTION_STRING, // Exemplo: localhost:1521/xe
    });

    // Exemplo de consulta
    const result = await connection.execute<DatabaseRow[]>(
      'SELECT coluna1, coluna2 FROM tabela_exemplo'
    );

    // Fecha a conexão
    await connection.close();

    // Retorna os dados
    res.status(200).json(result.rows);
  } catch (error) {
    console.error('Erro ao conectar ao banco:', error);
    res.status(500).json({ error: 'Erro ao conectar ao banco de dados' });
  }
}
