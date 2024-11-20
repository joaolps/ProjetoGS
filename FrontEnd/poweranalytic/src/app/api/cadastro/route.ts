import { NextRequest, NextResponse } from "next/server";
import bcrypt from "bcrypt";
import oracledb from "oracledb";

// Configuração para conexão com o banco de dados
oracledb.initOracleClient();
const dbConfig = {
  user: "rm556865",
  password: "100606",
  connectString: "oracle.fiap.com.br:1521/ORCL",
};

export async function POST(req: NextRequest) {
  try {
    const { nome, email, senha, cpf, telefone } = await req.json();

    // Hash da senha para segurança
    const hashedPassword = await bcrypt.hash(senha, 10);

    // Conexão com o banco de dados
    const connection = await oracledb.getConnection(dbConfig);

    // Inserção no banco de dados
    const sql = `
      INSERT INTO TBL_USUARIO (nome, email, senha, cpf, telefone)
      VALUES (:nome, :email, :senha, :cpf, :telefone)
    `;
    const binds = {
      nome,
      email,
      senha: hashedPassword,
      cpf,
      telefone,
    };

    await connection.execute(sql, binds, { autoCommit: true });
    await connection.close();

    return NextResponse.json({ message: "Usuário cadastrado com sucesso!" });
  } catch (error) {
    console.error("Erro ao cadastrar usuário:", error);
    return NextResponse.json(
      { message: "Erro ao cadastrar usuário", error: error.message },
      { status: 500 }
    );
  }
}
