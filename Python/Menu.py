import Menu_Empresa
import Menu_Usuario

def exibir_menu_principal():
    print("\n===== MENU PRINCIPAL =====")
    print("1. Entrar como Usuario")
    print("2. Entrar como Empresa")
    print("3. Sair")
    print("===========================")

def main():
    while True:
        exibir_menu_principal()
        opcao = input("Escolha uma opção: ")

        if opcao == "1":
            print("\nIniciando Menu USER...")
            Menu_Usuario.main()  
        elif opcao == "2":
            print("\nIniciando Menu EMP...")
            Menu_Empresa.main()  
        elif opcao == "3":
            print("Saindo...")
            break
        else:
            print("Opção inválida! Tente novamente.")

if __name__ == "__main__":
    main()
