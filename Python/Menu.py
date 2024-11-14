import oracledb
from Banco import conectar_db  
from Crud_Banco import inserir_registro, consultar_registros, atualizar_registro, excluir_registro, exportar_para_json
from ErrorBanco import ErroBanco

def exibir_menu():
    print("\n===== MENU =====")
    print("1. Inserir Registro")
    print("2. Consultar Registros")
    print("3. Atualizar Registro")
    print("4. Excluir Registro")
    print("5. Exportar Dados para JSON")
    print("6. Sair")
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
                # Exportar dados para JSON
                registros = consultar_registros(conn)
                if registros:
                    exportar_para_json(registros)
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
