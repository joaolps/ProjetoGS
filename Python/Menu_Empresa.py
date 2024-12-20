import oracledb
from Banco import conectar_db  
from Empresa import inserir_registro, consultar_registros, atualizar_registro, excluir_registro, exportar_para_json
from ErrorBanco import ErroBanco

def exibir_menu():
    print("\n===== MENU EMP =====")
    print("1. Inserir Empresa")
    print("2. Consultar Empresa")
    print("3. Atualizar Empresa")
    print("4. Excluir Empresa")
    print("5. Sair")
    print("================")

def main():
    try:
        # Conectar ao banco de dados
        conn = conectar_db()

        while True:
            exibir_menu()
            opcao = input("Escolha uma opção: ")

            if opcao == "1":
                try:
                    inserir_registro(conn)
                except Exception as MsgErro:
                    print(MsgErro.args[0])
            elif opcao == "2":
                # Consultar registros
                consultar_registros(conn)
            elif opcao == "3":
                # Atualizar um registro existente
                atualizar_registro(conn)
            elif opcao == "4":
                # Excluir um registro
                excluir_registro(conn)
            elif opcao == "5":
                consultar_registros(conn)
            elif opcao == "6":
                # Sair do programa
                print("Saindo...")
                break
            else:
                print("Opção inválida! Tente novamente.")
    
    except ErroBanco as e:
        print(f"Erro de banco de dados: {e}")
    except oracledb.DatabaseError as e:
        print(f"Erro na conexão ou execução no banco: {e}")
    finally:
        if 'conn' in locals() and conn:
            conn.close()
            print("Conexão com o banco de dados fechada.")

if __name__ == "__main__":
    main()
