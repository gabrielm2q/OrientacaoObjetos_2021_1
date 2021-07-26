package tp1;
import java.util.*;

public class ControleClientesProdutos_Tp1 {
	public static int TAMANHO_VETOR = 50;
	public static int numClientes = 0;
	
	public static void main(String[] args) { // M�todo Principal
		int opcMenu;
		
		// Dados dos Clientes
		String [] nome = new String[TAMANHO_VETOR];
		String [] endereco = new String[TAMANHO_VETOR];
		String [] telefone = new String[TAMANHO_VETOR];
		
		// Dados dos Produtos
		String [] nomeProduto = new String[TAMANHO_VETOR];
		String [] descricao = new String[TAMANHO_VETOR];
		double [] valorCompra = new double[TAMANHO_VETOR];
		double [] porcentLucro = new double[TAMANHO_VETOR];
		int [] qtdEstoque = new int[TAMANHO_VETOR];
		
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
					criarLinha(60);
					buscarClientes(nome, endereco, telefone);
					break;
				case 3: // Cadastro de novo produto
					criarLinha(60);
					//cadastrarProdutos(nomeProduto, descricao, valorCompra, porcentLucro, qtdEstoque);
					break;
				case 4: // Busca por produto
					criarLinha(60);
					//buscarProdutos(nomeProduto, descricao, valorCompra, porcentLucro, qtdEstoque);
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
		
		// Testando		
		/*for(int aux = 0; aux < numClientes; aux++) { // Recebendo os dados dos clientes
			System.out.println("\n");
			System.out.println((aux+1) + "� nome: " + nome[aux]);
			
			System.out.println("Endere�o: " + endereco[aux]);
			
			System.out.println("Telefone: " + telefone[aux]);
		}
		System.out.println("\nN�mero total de clientes: " + numClientes);*/
	}
	
	
	
	public static void criarLinha(int tamanho) { // M�todo utilizado para criar uma linha com o tamanho determinado
		for(int aux = 0; aux < tamanho; aux++) {	
			System.out.print("-"); // Imprimindo a linha com o tamanho pedido
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
	
	
	
	public static void cadastrarClientes(String nome[], String endereco[], String telefone[]) {
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
			System.out.print("\nDigite o " + (aux+1) + "� nome: "); // Recebendo o nome
			nome[numClientes] = ler.nextLine();
			
			System.out.print("Digite seu endere�o: "); // Recebendo o endere�o
			endereco[numClientes] = ler.nextLine();
			
			System.out.print("Digite seu telefone: "); // Recebendo o telefone
			telefone[numClientes] = ler.nextLine();
			
			numClientes++;
		}
	}
	
	
	
	public static void buscarClientes(String nome[], String endereco[], String telefone[]) {
		String nomeBuscar;
		int posicaoCliente = 0;
		boolean clienteExiste = false;
		char desejaAlterar;		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ BUSCAR CLIENTES ~");
		System.out.print("Digite o nome do(a) cliente a ser procurado: ");
		nomeBuscar = ler.nextLine();
		
		for(int i = 0; i < numClientes; i++) {
			if(nome[i].equals(nomeBuscar)) {
				System.out.println("TRUE");
				clienteExiste = true;
				posicaoCliente = i;
			}
		}
		
		if(clienteExiste) {
			System.out.println("\nDADOS DO CLIENTE: ");
			System.out.println("Nome: " + nome[posicaoCliente]);
			System.out.println("Endere�o: " + endereco[posicaoCliente]);
			System.out.println("Telefone: " + telefone[posicaoCliente]);
			
			do { // Verificando se o usu�rio deseja alterar os dados do cliente em quest�o 
				System.out.print("\nDeseja alterar os dados do(a) cliente? ('S' ou 'N'): ");
				desejaAlterar = ler.next().charAt(0);
				ler.nextLine(); //Limpando Buffer
				
				if (desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N') {
					System.out.println("Caractere inv�lido!"); // Se o usu�rio digitar um caractere diferente do
															   // esperado, ser� apresentado o erro e ele dever�
															   // digitar um caractere v�lido para encerrar o loop
				}
				
			} while(desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N');
		
		} else {
			System.out.println("\nCliente n�o encontrado!");
			desejaAlterar = 'n';
		}
		
		if (desejaAlterar == 'S' || desejaAlterar == 's') {
			System.out.println("\n ~ Alterando Nome ~");
			System.out.print("Digite o nome do(a) cliente: ");
			nome[posicaoCliente] = ler.nextLine();
			
			System.out.println("\n~ Alterando Endere�o ~");
			System.out.print("Digite o endere�o do(a) cliente: ");
			endereco[posicaoCliente] = ler.nextLine();
			
			System.out.println("\n~ Alterando Telefone ~");
			System.out.print("Digite o telefone do(a) cliente: ");
			telefone[posicaoCliente] = ler.nextLine();
			
			System.out.println("\nDados Atualizados!");			
		}
		
	}
	
	
	
	/*public static void cadastrarProdutos(ArrayList<String> nomeProduto, ArrayList<String> descricao, ArrayList<Double> valorCompra, ArrayList<Double> porcentLucro, ArrayList<Integer> qtdEstoque) {
		int qtdCadastrar;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ CADASTRAR PRODUTOS ~");
		
		do { // O usu�rio dever� digitar uma quant. de produtos a serem cadastrados maior ou igual a 1
			System.out.print("Digite a quantidade de produtos a serem cadastrados: ");
			qtdCadastrar = ler.nextInt();	
			
			if(qtdCadastrar < 1) { // Apresenta mensagem para informar o erro ao usu�rio
				System.out.println("O valor inserido deve ser maior que zero!");
			}
		}while(qtdCadastrar < 1); //Se repete at� a quant. ser maior ou igual a 1
		
		for(int aux = 0; aux < qtdCadastrar; aux++) { // Recebendo os dados dos produtos
			ler.nextLine(); // Limpando Buffer 
			
			System.out.print("\nDigite o nome do " + (aux+1) + "� produto: "); // Recebendo o nome
			nomeProduto.add(ler.nextLine());
			
			System.out.print("Digite a descri��o do produto: "); // Recebendo a descri��o
			descricao.add(ler.nextLine());
			
			System.out.print("Digite o valor de compra do produto: R$ "); // Recebendo o valor de compra
			valorCompra.add(ler.nextDouble());
			
			System.out.print("Digite a porcentagem de lucro do produto (sem '%'): "); // Recebendo a porcentagem de lucro
			porcentLucro.add(ler.nextDouble());
			
			System.out.print("Digite a quantidade em estoque do produto: "); // Recebendo a qtd em estoque
			qtdEstoque.add(ler.nextInt());
		}
		
	}
	
	
	
	public static void buscarProdutos(ArrayList<String> nomeProduto, ArrayList<String> descricao, ArrayList<Double> valorCompra, ArrayList<Double> porcentLucro, ArrayList<Integer> qtdEstoque) {
		char desejaAlterar;
		String nomeProd;
		int indexProduto;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ BUSCAR PRODUTOS ~");
		System.out.print("Digite o nome do(a) produto a ser procurado: ");
		nomeProd = ler.nextLine();
		
		if(nomeProduto.contains(nomeProd)) {
			System.out.println("\nDados do Produto: ");
			System.out.println("Nome do Produto: " + nomeProduto.get(nomeProduto.indexOf(nomeProd)));
			System.out.println("Descri��o: " + descricao.get(nomeProduto.indexOf(nomeProd)));
			System.out.println("Valor de Compra: R$ " + valorCompra.get(nomeProduto.indexOf(nomeProd)));
			System.out.println("Porcentagem de Lucro: " + porcentLucro.get(nomeProduto.indexOf(nomeProd)) + " %");
			System.out.println("Quantidade em Estoque: " + qtdEstoque.get(nomeProduto.indexOf(nomeProd)));
			
			System.out.print("\nDeseja alterar os dados do(a) produto? ('S' ou 'N'): ");
			desejaAlterar = ler.next().charAt(0);
			ler.nextLine(); //Limpando Buffer
		} else {
			System.out.println("\nProduto n�o encontrado!");
			desejaAlterar = 'n';
		}
		
		
		
		if (desejaAlterar == 'S' || desejaAlterar == 's') {
			indexProduto = nomeProduto.indexOf(nomeProd);
			System.out.println("\n ~ Alterando Nome ~");
			System.out.print("Digite o nome do(a) produto: ");
			nomeProduto.set(indexProduto, ler.nextLine());
			
			System.out.println("\n~ Alterando Descri��o ~");
			System.out.print("Digite a descri��o do produto: ");
			descricao.set(indexProduto, ler.nextLine());
			
			System.out.println("\n~ Alterando Valor de Compra ~");
			System.out.print("Digite o valor de compra do produto: R$ ");
			valorCompra.set(indexProduto, ler.nextDouble());
			
			System.out.println("\n~ Alterando Porcentagem de Lucro ~");
			System.out.print("Digite a porcentagem de lucro do produto (sem '%'): ");
			porcentLucro.set(indexProduto, ler.nextDouble());
			
			System.out.println("\n~ Alterando Quantidade em Estoque ~");
			System.out.print("Digite a quantidade em estoque do produto: ");
			qtdEstoque.set(indexProduto, ler.nextInt());
			
			System.out.println("\nDados Atualizados!");			
		}
	}*/

	
}

