from Crud_Banco import inserir_registro
from Banco import conectar_db

def menu():
    conn = conectar_db()
    if conn is None:
        return
    
    while True:
        print("\nMenu de Opções:")
        print("1. Inserir Registro")
        print("2. Consultar Registros")
        print("3. Atualizar Registro")
        print("4. Excluir Registro")
        print("5. Sair")  

        opcao = input("Escolha uma opção: ")

        if opcao.isdigit(): 
            opcao = int(opcao)
            if opcao == 1:
                inserir_registro(conn)
            elif opcao == 5:
                print("Saindo...")
                break
            else:
                print("Opção inválida. Tente novamente.")
        else:
            print("Entrada inválida. Por favor, insira um número.")

    conn.close()

if __name__ == "__main__":
    menu()
