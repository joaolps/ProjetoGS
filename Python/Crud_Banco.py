import json
import oracledb
from ErrorBanco import ErroBanco
from Banco import conectar_db

#Funções com "api" no final são exclusivas do Api.py
#Funções sem "api" no final são exclusivas do Menu.py

def exportar_para_json(dados):
    try:
        with open("consulta.json", "w") as arquivo_json:
            json.dump([dict(row) for row in dados], arquivo_json, indent=4)
        print("Dados exportados para consulta.json com sucesso.")
    except Exception as e:
          raise ErroBanco(e)

def inserir_registro(conn):
    try:
        cursor = conn.cursor()
        nome = input("Digite o nome: ")
        idade = int(input("Digite a idade: "))
        sql = "INSERT INTO tabela_teste (nome, idade) VALUES (:nome, :idade)"
        cursor.execute(sql, {'nome': nome, 'idade': idade})
        conn.commit()
        print("Registro inserido com sucesso.")
        return {'nome': nome, 'idade': idade}
    except Exception as e:
        raise ErroBanco(e)  
    
def inserir_registro_api(conn, nome, idade):
    try:
        cursor = conn.cursor()
        id_saida = cursor.var(int)  
        sql = """
        INSERT INTO tabela_teste (nome, idade)
        VALUES (:nome, :idade)
        RETURNING id INTO :id_saida
        """
        cursor.execute(sql, {'nome': nome, 'idade': idade, 'id_saida': id_saida})
        conn.commit()
        print("Registro inserido com sucesso.")
        return {'nome': nome, 'idade': idade, 'id': id_saida.getvalue()}
    except Exception as e:
        raise ErroBanco(e)
    finally:
        cursor.close()

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
    
def consultar_registros_api(conn, filtro):
    try:
        cursor = conn.cursor()
        sql = "SELECT * FROM tabela_teste WHERE nome LIKE :filtro"
        cursor.execute(sql, {'filtro': f"%{filtro}%"})
        registros = cursor.fetchall() 
        for registro in registros:
            return registros
    except Exception as e:
        raise ErroBanco(e)
    finally:
        cursor.close()


def atualizar_registro(conn):
    try:
        cursor = conn.cursor()
        id_registro = int(input("Digite o ID do registro para atualizar: "))
        novo_nome = input("Digite o novo nome: ")
        
        sql = "UPDATE tabela_teste SET nome = :novo_nome WHERE id = :id_registro"
        cursor.execute(sql, {'novo_nome': novo_nome, 'id_registro': id_registro})
        conn.commit()
        print("Registro atualizado com sucesso.")
    except oracledb.DatabaseError as e:
          raise ErroBanco(e)
    
def atualizar_registro_api(conn, id_saida, novo_nome):
    try:
        cursor = conn.cursor()
        if not id_saida or not novo_nome:
            raise ValueError("ID e nome não podem ser nulos ou vazios.")
        sql = "UPDATE tabela_teste SET nome = :novo_nome WHERE id = :id_registro"
        cursor.execute(sql, {'novo_nome': novo_nome, 'id_registro': id_saida})
        conn.commit()  
        print("Registro atualizado com sucesso.")
        return {'nome': novo_nome, 'id': id_saida}
    except oracledb.DatabaseError as e:
        raise ErroBanco(e)
    finally:
        cursor.close()


def excluir_registro(conn):
    try:
        cursor = conn.cursor()
        id_registro = int(input("Digite o ID do registro para excluir: "))
        
        sql = "DELETE FROM tabela_teste WHERE id = :id_registro"
        cursor.execute(sql, {'id_registro': id_registro})
        conn.commit()
        print("Registro excluído com sucesso.")
    except oracledb.DatabaseError as e:
         raise ErroBanco(e)
    