package tp1;
import java.util.*;

public class ControleClientesProdutos_Tp1 {
	
	public static void cadastrarClientes(ArrayList<String> nome, ArrayList<String> endereco, ArrayList<String> telefone) {
		int qtdCadastrar;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ CADASTRAR CLIENTES ~");
		do { // O usu�rio dever� digitar uma quant. de clientes a serem cadastrados maior ou igual a 1
			System.out.print("Digite a quantidade de clientes a serem cadastrados: ");
			qtdCadastrar = ler.nextInt();	
			
			if(qtdCadastrar < 1) { // Apresenta mensagem para informar o erro ao usu�rio
				System.out.println("O valor inserido deve ser maior que zero!");
			}
		}while(qtdCadastrar < 1); //Se repete at� a quant. ser maior ou igual a 1
		
		ler.nextLine(); // Limpando o Buffer do Teclado
		
		for(int aux = 0; aux < qtdCadastrar; aux++) { // Recebendo os dados dos clientes
			System.out.println("\nDigite o " + (aux+1) + "� nome: "); // Recebendo o nome
			nome.add(ler.nextLine());
			
			System.out.println("Digite seu endere�o: "); // Recebendo o endere�o
			endereco.add(ler.nextLine());
			
			System.out.println("Digite seu telefone: "); // Recebendo o telefone
			telefone.add(ler.nextLine());
		}
	}

	public static int imprimirMenu() { // M�todo que imprime o Menu e verifica se a op��o digitada � v�lida
		int opcao;
		Scanner ler = new Scanner(System.in);

		do{ // Estrutura que ficar� em loop enquanto o usu�rio n�o digitar a op��o digitada
			System.out.println("\nPor favor, siga o menu abaixo e escolha a op��o desejada:");
			System.out.println("1 - CADASTRAR NOVO CLIENTE");
			System.out.println("2 - BUSCAR POR CLIENTE");
			System.out.println("3 - CADASTRAR NOVO PRODUTO");
			System.out.println("4 - BUSCAR POR PRODUTO");
			System.out.println("5 - CADASTRAR VENDA");
			System.out.println("6 - MOSTRAR PRODUTOS EM ESTOQUE");
			System.out.println("7 - SAIR");
			System.out.print("Op��o desejada: ");
			opcao = ler.nextInt();

			if (opcao < 1 || opcao > 7) { // Se a op��o for inv�lida, ele apresentar� mensagem ao usu�rio
				System.out.println("\nOP��O INV�LIDA!");
				criarLinha(60);
			}
		}while(opcao < 1 || opcao > 7); // Qualquer op��o que n�o esteja no intervalo 1-7 � inv�lida

		return opcao; // Retornando a op��o escolhida pelo usu�rio
	}

	public static void criarLinha(int tamanho) { // M�todo utilizado para criar uma linha com o tamanho determinado
		for(int aux = 0; aux < tamanho; aux++) {	
			System.out.print("-"); // Imprimindo a linha com o tamanho pedido
		}
	}

	public static void main(String[] args) { // M�todo Principal
		int opcMenu;
		ArrayList<String> nome = new ArrayList<String>();
		ArrayList<String> endereco = new ArrayList<String>();
		ArrayList<String> telefone = new ArrayList<String>();
		
		Scanner ler = new Scanner(System.in);

		criarLinha(60); // Imprimindo uma linha (apenas pela est�tica)
		System.out.println("\nSeja bem vindo(a)!");

		do {
			opcMenu = imprimirMenu(); // Chamando o m�todo que imprime o Menu e retorna a op��o escolhida pelo usu�rio

			switch (opcMenu) { // Direcionando o usu�rio de acordo com a op��o desejada
				case 1: // Cadastro de novo cliente
					criarLinha(60);
					cadastrarClientes(nome, endereco, telefone);
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
				default: // O default est� sendo usado apenas para evitar poss�veis problemas, pois os
						 // valores j� s�o verificados no pr�prio menu!
					criarLinha(60);
					System.out.println("\nERRO!");
					criarLinha(60);
			}
			
			criarLinha(60);
		}while(opcMenu != 7);
		
	}
}

