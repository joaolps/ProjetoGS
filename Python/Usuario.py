import json
import oracledb
from ErrorBanco import ErroBanco
import re

def validar_cpf(cpf):
    return len(str(cpf)) == 11 and cpf.isdigit()

def validaTelefone(telefone):
    if len(telefone) != 11:
        raise Exception("Telefone Invalido")
    
def validarEmail(email):
    # Regex para validar email
    padrao = r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'
    if not re.match(padrao, email):
        raise Exception("Email Invalido")

def exportar_para_json(dados, arquivo="consulta.json"):
    if not dados:
        print("Nenhum dado para exportar.")
        return
    try:
        with open(arquivo, "w") as arquivo_json:
            json.dump([dict(row) for row in dados], arquivo_json, indent=4)
        print(f"Dados exportados para {arquivo} com sucesso.")
    except Exception as e:
        raise ErroBanco(e)

def inserir_registro(conn):
    try:
        cursor = conn.cursor()
        nome = input("Digite o nome: ")
        cpf = input("Digite seu CPF: ")
        
        if not validar_cpf(cpf):
            print("CPF inválido.")
            return
        
        email = input("Digite seu e-mail: ")
        validarEmail(email)

        telefone = input("Digite seu telefone: ")
        validaTelefone(telefone)
        
        # Validação simples do formato do e-mail
        if not re.match(r"[^@]+@[^@]+\.[^@]+", email):
            print("E-mail inválido.")
            return
        
        sql = """
        INSERT INTO TBL_USUARIO (nome, cpf, email, telefone) 
        VALUES (:nome, :cpf, :email, :telefone)
        """
        cursor.execute(sql, {'nome': nome, 'cpf': cpf, 'email': email, 'telefone': telefone})
        conn.commit()
        print("Registro inserido com sucesso.")
        return {'nome': nome, 'cpf': cpf, 'email': email, 'telefone': telefone}
    except Exception as e:
        raise ErroBanco(e)

def consultar_registros(conn):
    try:
        cursor = conn.cursor()
        
        # Consulta para obter todos os registros da tabela
        sql = "SELECT * FROM TBL_USUARIO"
        cursor.execute(sql)
        registros = cursor.fetchall()
        
        if not registros:
            print("Nenhum registro encontrado.")
            return []
        
        colunas = [col[0] for col in cursor.description]
        
        registros_dict = [dict(zip(colunas, registro)) for registro in registros]
        
        exportar_para_json(registros_dict, arquivo="consulta_usuarios.json")
        
        print(f"{len(registros)} registro(s) encontrado(s):")
        for registro in registros_dict:
            print(registro)
        
        return registros_dict
    except Exception as e:
        raise ErroBanco(e)



def atualizar_registro(conn):
    try:
        cursor = conn.cursor()
        id_usuario = int(input("Digite o ID do registro para atualizar: "))
        
        # Verificar se o ID existe
        cursor.execute("SELECT * FROM TBL_USUARIO WHERE id_usuario = :id_usuario", {'id_usuario': id_usuario})
        if not cursor.fetchone():
            print(f"Nenhum registro encontrado com o ID {id_usuario}.")
            return
        
        novo_nome = input("Digite o novo nome: ")
        novo_email = input("Digite o novo e-mail: ")
        novo_telefone = input("Digite o novo telefone: ")
        
        sql = """
        UPDATE TBL_USUARIO 
        SET nome = :novo_nome, email = :novo_email, telefone = :novo_telefone 
        WHERE id_usuario = :id_usuario
        """
        cursor.execute(sql, {'novo_nome': novo_nome, 'novo_email': novo_email, 'novo_telefone': novo_telefone, 'id_usuario': id_usuario})
        conn.commit()
        print("Registro atualizado com sucesso.")
    except oracledb.DatabaseError as e:
        raise ErroBanco(e)


def excluir_registro(conn):
    try:
        cursor = conn.cursor()
        id_usuario = int(input("Digite o ID do registro para excluir: "))
        
        # Verificar se o ID existe
        cursor.execute("SELECT * FROM TBL_USUARIO WHERE id_usuario = :id_usuario", {'id_usuario': id_usuario})
        if not cursor.fetchone():
            print(f"Nenhum registro encontrado com o ID {id_usuario}.")
            return
        
        sql = "DELETE FROM TBL_USUARIO WHERE id_usuario = :id_usuario"
        cursor.execute(sql, {'id_usuario': id_usuario})
        conn.commit()
        print("Registro excluído com sucesso.")
    except oracledb.DatabaseError as e:
        raise ErroBanco(e)


