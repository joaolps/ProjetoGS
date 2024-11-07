from Crud_Banco import inserir_registro, consultar_registros, atualizar_registro, excluir_registro, exportar_para_json
from Banco import conectar_db

def menu():
    conn = conectar_db
    if conn is None:
        return

    while True:
        print("\nMenu de Opções:")
        print("1. Inserir Registro")
        print("2. Consultar Registros")
        print("3. Atualizar Registro")
        print("4. Excluir Registro")
        print("6. Sair")
        
        opcao = input("Escolha uma opção: ")
        
        if opcao == '1':
            inserir_registro(conn)
        elif opcao == '2':
            consultar_registros(conn)
        elif opcao == '3':
            atualizar_registro(conn)
        elif opcao == '4':
            excluir_registro(conn)
        elif opcao == '5':
            print("Saindo...")
            break
        else:
            print("Opção inválida. Tente novamente.")
    
    conn.close()

# Executa o menu ao rodar o arquivo
if __name__ == "__main__":
    menu()
