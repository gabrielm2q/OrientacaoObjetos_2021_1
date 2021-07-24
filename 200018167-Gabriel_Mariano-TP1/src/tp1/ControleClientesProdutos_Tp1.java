package tp1;

import java.util.Scanner;

public class ControleClientesProdutos_Tp1 {

	public static int imprimirMenu() { // Método que imprime o Menu e verifica se a opção digitada é válida
		int opcao;
		Scanner ler = new Scanner(System.in);

		do{ // Estrutura que ficará em loop enquanto o usuário não digitar a opção digitada
			System.out.println("\nPor favor, siga o menu abaixo e escolha a opção desejada:");
			System.out.println("1 - CADASTRAR NOVO CLIENTE");
			System.out.println("2 - BUSCAR POR CLIENTE");
			System.out.println("3 - CADASTRAR NOVO PRODUTO");
			System.out.println("4 - BUSCAR POR PRODUTO");
			System.out.println("5 - CADASTRAR VENDA");
			System.out.println("6 - MOSTRAR PRODUTOS EM ESTOQUE");
			System.out.println("7 - SAIR");
			System.out.print("Opção desejada: ");
			opcao = ler.nextInt();

			if (opcao < 1 || opcao > 7) { // Se a opção for inválida, ele apresentará mensagem ao usuário
				System.out.println("\nOPÇÃO INVÁLIDA!");
				criarLinha(60);
			}
		}while(opcao < 1 || opcao > 7); // Qualquer opção que não esteja no intervalo 1-7 é inválida

		return opcao; // Retornando a opção escolhida
	}

	public static void criarLinha(int tamanho) { // Método utilizado para criar uma linha com o tamanho determinado
		for(int aux = 0; aux < tamanho; aux++) {	
			System.out.print("-"); // Imprimindo a linha com o tamanho pedido
		}
	}

	public static void main(String[] args) { // Método Principal
		int opcMenu;
		Scanner ler = new Scanner(System.in);

		criarLinha(60); // Imprimindo uma linha (apenas pela estética)
		System.out.println("\nSeja bem vindo(a)!");

		do {
			opcMenu = imprimirMenu(); // Chamando o método que imprime o Menu e retorna a opção escolhida pelo usuário

			switch (opcMenu) { // Direcionando o usuário de acordo com a opção desejada
				case 1: // Cadastro de novo cliente
					break;
				case 2: // Busca por cliente
					break;
				case 3: // Cadastro de novo produto
					break;
				case 4: // Busca por produto
					break;
				case 5: // Cadastro de venda
					break;
				case 6: // Mostrar produtos em estoque
					break;
				case 7: // Sair
					criarLinha(60);
					System.out.println("\nEncerrando! Obrigado por usar o programa!");
					break;
				default: // O default está sendo usado apenas para evitar possíveis problemas, pois os
						 // valores já são verificados no próprio menu!
					criarLinha(60);
					System.out.println("\nERRO!");
					criarLinha(60);
			}
			criarLinha(60);
		}while(opcMenu != 7);
		
	}
}
