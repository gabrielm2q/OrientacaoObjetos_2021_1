package tp1;
import java.util.*;

public class ControleClientesProdutos_Tp1 {
	public static int TAMANHO_VETOR = 50;
	public static int numClientes = 0;
	public static int numProdutos = 0;
	
	public static void main(String[] args) { // Método Principal
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

		criarLinha(60); // Imprimindo uma linha (apenas pela estética)
		System.out.println("\nSeja bem vindo(a)!");

		do {
			opcMenu = imprimirMenu(); // Chamando o método que imprime o Menu e retorna a opção escolhida pelo usuário

			switch (opcMenu) { // Direcionando o usuário de acordo com a opção desejada
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
					cadastrarProdutos(nomeProduto, descricao, valorCompra, porcentLucro, qtdEstoque);
					break;
				case 4: // Busca por produto
					criarLinha(60);
					buscarProdutos(nomeProduto, descricao, valorCompra, porcentLucro, qtdEstoque);
					break;
				case 5: // Cadastro de venda
					break;
				case 6: // Mostrar produtos em estoque
					break;
				case 7: // Sair
					criarLinha(60);
					System.out.println("\nEncerrando! Obrigado por usar o programa!");
					break;
				default: // O default está sendo usado apenas para evitar possíveis problemas, pois os valores já são verificados no próprio menu!
					criarLinha(60);
					System.out.println("\nERRO!");
					criarLinha(60);
			}
			
			criarLinha(60);
		}while(opcMenu != 7);
		
		// Testando		
		/*for(int aux = 0; aux < numClientes; aux++) { // Recebendo os dados dos clientes
			System.out.println("\n");
			System.out.println((aux+1) + "º nome: " + nome[aux]);
			
			System.out.println("Endereço: " + endereco[aux]);
			
			System.out.println("Telefone: " + telefone[aux]);
		}
		System.out.println("\nNúmero total de clientes: " + numClientes);*/
	}
	
	
	
	public static void criarLinha(int tamanho) { // Método utilizado para criar uma linha com o tamanho determinado
		for(int aux = 0; aux < tamanho; aux++) {	
			System.out.print("-"); // Imprimindo a linha com o tamanho pedido
		}
	}
	
	
	
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

		return opcao; // Retornando a opção escolhida pelo usuário
	}
	
	
	
	public static void cadastrarClientes(String nome[], String endereco[], String telefone[]) {
		int qtdCadastrar;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ CADASTRAR CLIENTES ~");
		do { // O usuário deverá digitar uma quant. de clientes a serem cadastrados maior ou igual a 1 e menor que o tamanho máximo dos vetores (ver TAMANHO_VETOR)
			System.out.print("Digite a quantidade de clientes a serem cadastrados: ");
			qtdCadastrar = ler.nextInt();	
			
			if(qtdCadastrar < 1 || qtdCadastrar > TAMANHO_VETOR) { // Apresenta mensagem para informar o erro ao usuário
				System.out.println("O valor inserido deve ser maior que zero e menor que " + (TAMANHO_VETOR+1) + "!\n");
			}
		}while(qtdCadastrar < 1 || qtdCadastrar > TAMANHO_VETOR); //Se repete até a quant. ser maior ou igual a 1
		
		ler.nextLine(); // Limpando o Buffer do Teclado
		
		for(int aux = 0; aux < qtdCadastrar; aux++) { // Recebendo os dados dos clientes
			System.out.print("\nDigite o " + (aux+1) + "º nome: "); // Recebendo o nome
			nome[numClientes] = ler.nextLine();
			
			System.out.print("Digite seu endereço: "); // Recebendo o endereço
			endereco[numClientes] = ler.nextLine();
			
			System.out.print("Digite seu telefone: "); // Recebendo o telefone
			telefone[numClientes] = ler.nextLine();
			
			numClientes++;
		}
	}
	
	
	
	public static void buscarClientes(String nome[], String endereco[], String telefone[]) {
		String nomeBuscar;
		int indexCliente = 0;
		boolean clienteExiste = false;
		char desejaAlterar;		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ BUSCAR CLIENTES ~");
		System.out.print("Digite o nome do(a) cliente a ser procurado: ");
		nomeBuscar = ler.nextLine();
		
		for(int i = 0; i < numClientes; i++) {
			if(nome[i].equals(nomeBuscar)) {
				clienteExiste = true;
				indexCliente = i;
			}
		}
		
		if(clienteExiste) {
			System.out.println("\nDADOS DO CLIENTE: ");
			System.out.println("Nome: " + nome[indexCliente]);
			System.out.println("Endereço: " + endereco[indexCliente]);
			System.out.println("Telefone: " + telefone[indexCliente]);
			
			do { // Verificando se o usuário deseja alterar os dados do cliente em questão 
				System.out.print("\nDeseja alterar os dados do(a) cliente? ('S' ou 'N'): ");
				desejaAlterar = ler.next().charAt(0);
				ler.nextLine(); //Limpando Buffer
				
				if (desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N') {
					System.out.println("Caractere inválido!"); // Se o usuário digitar um caractere diferente do esperado, será apresentado o erro e ele deverá digitar um caractere válido para encerrar o loop
				}
				
			} while(desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N');
		
		} else {
			System.out.println("\nCliente não encontrado!");
			desejaAlterar = 'n';
		}
		
		if (desejaAlterar == 'S' || desejaAlterar == 's') {
			System.out.println("\n ~ Alterando Nome ~");
			System.out.print("Digite o nome do(a) cliente: ");
			nome[indexCliente] = ler.nextLine();
			
			System.out.println("\n~ Alterando Endereço ~");
			System.out.print("Digite o endereço do(a) cliente: ");
			endereco[indexCliente] = ler.nextLine();
			
			System.out.println("\n~ Alterando Telefone ~");
			System.out.print("Digite o telefone do(a) cliente: ");
			telefone[indexCliente] = ler.nextLine();
			
			System.out.println("\nDados Atualizados!");			
		}
		
	}
	
	
	
	public static void cadastrarProdutos(String nomeProduto[], String descricao[], double valorCompra[], double porcentLucro[], int qtdEstoque[]) {
		int qtdCadastrar;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ CADASTRAR PRODUTOS ~");
		
		do { // O usuário deverá digitar uma quant. de produtos a serem cadastrados maior ou igual a 1 e menor que o tamanho máximo dos vetores (ver TAMANHO_VETOR)
			System.out.print("Digite a quantidade de produtos a serem cadastrados: ");
			qtdCadastrar = ler.nextInt();	
			
			if(qtdCadastrar < 1 || qtdCadastrar > TAMANHO_VETOR) { // Apresenta mensagem para informar o erro ao usuário
				System.out.println("O valor inserido deve ser maior que zero e menor que " + (TAMANHO_VETOR+1) + "!\n");
			}
		}while(qtdCadastrar < 1 || qtdCadastrar > TAMANHO_VETOR); //Se repete até a quant. ser maior ou igual a 1 e menor ou igual ao TAMANHO_VETOR
		
		for(int aux = 0; aux < qtdCadastrar; aux++) { // Recebendo os dados dos produtos
			ler.nextLine(); // Limpando Buffer 
			
			System.out.print("\nDigite o nome do " + (aux+1) + "º produto: "); // Recebendo o nome
			nomeProduto[numProdutos] = ler.nextLine();
			
			System.out.print("Digite a descrição do produto: "); // Recebendo a descrição
			descricao[numProdutos] = ler.nextLine();
			
			System.out.print("Digite o valor de compra do produto: R$ "); // Recebendo o valor de compra
			valorCompra[numProdutos] = ler.nextDouble();
			
			System.out.print("Digite a porcentagem de lucro do produto (sem '%'): "); // Recebendo a porcentagem de lucro
			porcentLucro[numProdutos] = ler.nextDouble();
			
			System.out.print("Digite a quantidade em estoque do produto: "); // Recebendo a qtd em estoque
			qtdEstoque[numProdutos] = ler.nextInt();
			
			numProdutos++;
		}
		
	}
	
	
	
	public static void buscarProdutos(String nomeProduto[], String descricao[], double valorCompra[], double porcentLucro[], int qtdEstoque[]) {
		char desejaAlterar;
		boolean produtoExiste = false;
		String nomeProd;
		int indexProduto = 0;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ BUSCAR PRODUTOS ~");
		System.out.print("Digite o nome do(a) produto a ser procurado: ");
		nomeProd = ler.nextLine();
		
		for(int i = 0; i < numProdutos; i++) {
			if(nomeProduto[i].equals(nomeProd)) {
				produtoExiste = true;
				indexProduto = i;
			}
		}
		
		if(produtoExiste) {
			System.out.println("\nDADOS DO PRODUTO: ");
			System.out.println("Nome do Produto: " + nomeProduto[indexProduto]);
			System.out.println("Descrição: " + descricao[indexProduto]);
			System.out.println("Valor de Compra: R$ " + valorCompra[indexProduto]);
			System.out.println("Porcentagem de Lucro: " + porcentLucro[indexProduto] + " %");
			System.out.println("Quantidade em Estoque: " + qtdEstoque[indexProduto]);
			
			do { // Verificando se o usuário deseja alterar os dados do produto em questão 
				System.out.print("\nDeseja alterar os dados do produto? ('S' ou 'N'): ");
				desejaAlterar = ler.next().charAt(0);
				ler.nextLine(); //Limpando Buffer
				
				if (desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N') {
					System.out.println("Caractere inválido!"); // Se o usuário digitar um caractere diferente do esperado, será apresentado o erro e ele deverá digitar um caractere válido para encerrar o loop
				}
				
			} while(desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N');
			
		} else {
			System.out.println("\nProduto não encontrado!");
			desejaAlterar = 'n';
		}
		
		
		
		if (desejaAlterar == 'S' || desejaAlterar == 's') {
			System.out.println("\n ~ Alterando Nome ~");
			System.out.print("Digite o nome do(a) produto: ");
			nomeProduto[indexProduto] = ler.nextLine();
			
			System.out.println("\n~ Alterando Descrição ~");
			System.out.print("Digite a descrição do produto: ");
			descricao[indexProduto] = ler.nextLine();
			
			System.out.println("\n~ Alterando Valor de Compra ~");
			System.out.print("Digite o valor de compra do produto: R$ ");
			valorCompra[indexProduto] = ler.nextDouble();
			
			System.out.println("\n~ Alterando Porcentagem de Lucro ~");
			System.out.print("Digite a porcentagem de lucro do produto (sem '%'): ");
			porcentLucro[indexProduto] = ler.nextDouble();
			
			System.out.println("\n~ Alterando Quantidade em Estoque ~");
			System.out.print("Digite a quantidade em estoque do produto: ");
			qtdEstoque[indexProduto] = ler.nextInt();
			
			System.out.println("\nDados Atualizados!");			
		}
	}

	
}

