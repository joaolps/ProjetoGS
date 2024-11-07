import json
import oracledb
from ErrorBanco import ErroBanco
from Banco import conectar_db

def inserir_registro(conn):
    try:
        cursor = conn.cursor()
        #exemplo de tabela basica(nome, idade) a gente vai modificar esses campos depois, joao ainda vai criar as tabelas -- 
        nome = input("Digite o nome: ")
        idade = int(input("Digite a idade: "))

        sql = "INSERT INTO tabela_teste (nome, idade) VALUES (:nome, :idade)"
        cursor.execute(sql, {'nome': nome, 'idade': idade})
        conn.commit()
        print("Registro inserido com sucesso.")
    except Exception as e:
       raise ErroBanco(e)
    
def consultar_registros(conn):
    try:
        cursor = conn.cursor()
        filtro = input("Digite um valor de filtro (ex: nome): ")
        sql = "SELECT * FROM tabela_teste WHERE nome LIKE :filtro"
        cursor.execute(sql, {'filtro': f"%{filtro}%"})
        registros = cursor.fetchall()
    
        for registro in registros:
            print(registro)
        return registros
    except Exception as e:
        raise ErroBanco(e)