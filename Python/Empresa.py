import json
import oracledb
from ErrorBanco import ErroBanco
import re

def validar_cnpj(cnpj):
    return len(str(cnpj)) == 14 and cnpj.isdigit()

def validaTelefone(telefone):
    if len(telefone) != 10:
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
        cnpj = input("Digite seu cnpj: ")
        
        if not validar_cnpj(cnpj):
            print("cnpj inválido.")
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
        INSERT INTO TBL_EMPRESA (nome, cnpj, email, telefone) 
        VALUES (:nome, :cnpj, :email, :telefone)
        """
        cursor.execute(sql, {'nome': nome, 'cnpj': cnpj, 'email': email, 'telefone': telefone})
        conn.commit()
        print("Registro inserido com sucesso.")
        return {'nome': nome, 'cnpj': cnpj, 'email': email, 'telefone': telefone}
    except Exception as e:
        raise ErroBanco(e)

def consultar_registros(conn):
    try:
        cursor = conn.cursor()
        filtro = input("Digite um valor de filtro (ex: nome ou cnpj): ").strip()
        
        if not filtro:
            print("Filtro vazio. Operação cancelada.")
            return []
        
        sql = "SELECT * FROM TBL_EMPRESA WHERE nome LIKE :filtro OR cnpj LIKE :filtro"
        cursor.execute(sql, {'filtro': f"%{filtro}%"})
        registros = cursor.fetchall()
        
        if not registros:
            print("Nenhum registro encontrado.")
        else:
            for registro in registros:
                print(registro)
        
        return registros
    except Exception as e:
        raise ErroBanco(e)


def atualizar_registro(conn):
    try:
        cursor = conn.cursor()
        id_empresa = int(input("Digite o ID do registro para atualizar: "))
        
        # Verificar se o ID existe
        cursor.execute("SELECT * FROM TBL_EMPRESA WHERE id_empresa = :id_empresa", {'id_empresa': id_empresa})
        if not cursor.fetchone():
            print(f"Nenhum registro encontrado com o ID {id_empresa}.")
            return
        
        novo_nome = input("Digite o novo nome: ")
        novo_email = input("Digite o novo e-mail: ")
        novo_telefone = input("Digite o novo telefone: ")
        
        sql = """
        UPDATE TBL_EMPRESA 
        SET nome = :novo_nome, email = :novo_email, telefone = :novo_telefone 
        WHERE id_empresa = :id_empresa
        """
        cursor.execute(sql, {'novo_nome': novo_nome, 'novo_email': novo_email, 'novo_telefone': novo_telefone, 'id_empresa': id_empresa})
        conn.commit()
        print("Registro atualizado com sucesso.")
    except oracledb.DatabaseError as e:
        raise ErroBanco(e)


def excluir_registro(conn):
    try:
        cursor = conn.cursor()
        id_empresa = int(input("Digite o ID do registro para excluir: "))
        
        # Verificar se o ID existe
        cursor.execute("SELECT * FROM TBL_EMPRESA WHERE id_empresa = :id_empresa", {'id_empresa': id_empresa})
        if not cursor.fetchone():
            print(f"Nenhum registro encontrado com o ID {id_empresa}.")
            return
        
        sql = "DELETE FROM TBL_EMPRESA WHERE id_empresa = :id_empresa"
        cursor.execute(sql, {'id_empresa': id_empresa})
        conn.commit()
        print("Registro excluído com sucesso.")
    except oracledb.DatabaseError as e:
        raise ErroBanco(e)


