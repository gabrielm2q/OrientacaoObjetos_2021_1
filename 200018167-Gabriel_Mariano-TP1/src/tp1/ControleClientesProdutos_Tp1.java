package tp1;
import java.util.*;

public class ControleClientesProdutos_Tp1 {
	public static int TAMANHO_VETOR = 50;
	public static int numClientes = 0;
	public static int numProdutos = 0;
	
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
		
		preencherVetores(nome, endereco, telefone, nomeProduto, descricao, valorCompra, porcentLucro, qtdEstoque);
		
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
					cadastrarProdutos(nomeProduto, descricao, valorCompra, porcentLucro, qtdEstoque);
					break;
				case 4: // Busca por produto
					criarLinha(60);
					buscarProdutos(nomeProduto, descricao, valorCompra, porcentLucro, qtdEstoque);
					break;
				case 5: // Cadastro de venda
					criarLinha(60);
					cadastrarVendas(nome, nomeProduto, qtdEstoque);
					break;
				case 6: // Mostrar produtos em estoque
					break;
				case 7: // Sair
					criarLinha(60);
					System.out.println("\nEncerrando! Obrigado por usar o programa!");
					break;
				default: // O default est� sendo usado apenas para evitar poss�veis problemas, pois os valores j� s�o verificados no pr�prio menu!
					criarLinha(60);
					System.out.println("\nERRO!");
					criarLinha(60);
			}
			
			criarLinha(60);
		}while(opcMenu != 7);
	}
	
	
	
	public static void preencherVetores(String nome[], String endereco[], String telefone[], String nomeProduto[], String descricao[], double valorCompra[], double porcentLucro[], int qtdEstoque[]) {
		int aux;
		
		// Dados Carregados dos Clientes
		String [] nomesGerados = {"Pedro", "Paulo", "Mateus", "Jo�o", "Maria", "Noah", "Marcos", "Louise", "Alice", "Sofia"};
		String [] enderecosGerados = {"Rua dos Cristais", "Rua da Saudade", "Rua 7 de Setembro", "Rua 9 de Julho", "Rua 5 de Agosto", "Rua Loureiros", "Parques El�sios", "Residencial Copacabana", "Rua dos Pr�ncipes", "Avenida Conde Dr�cula"};
		
		// Dados Carregados dos Produtos
		String [] produtoGerado = {"Bombom", "Chips", "Pa�oca", "Gelatina", "Gel�ia", "Brigadeiro", "Mousse", "Laranja", "Banana", "Ma��"};
		String [] descricaoGerada = {"Chocolate", "Batata Chip", "Doce de Amendoim", "Pacote de Gelatina", "Compota de Gel�ia", "Chocolate com Granulado", "Mousse de Maracuj�", "Fruta Laranja", "Fruta Banana", "Fruta Ma��"};
		
		
		Random random = new Random(); // Instanciando a classe Random
		
		for(aux = 0; aux < 10; aux++) { //Preenchendo os vetores com os dados carregados dos produtos e clientes
			nome[aux] = nomesGerados[aux]; 
			endereco[aux] = enderecosGerados[aux]; 
			
			nomeProduto[aux] = produtoGerado[aux]; 
			descricao[aux] = descricaoGerada[aux]; 
		}
		
		/* Agora, iremos preencher os vetores "telefone" (Cliente), "valorCompra", "porcentLucro" 
		 * e "qtdEstoque" (Produto) com valores gerados aleatoriamente atrav�s da classe Random,
		 * de modo a randomizar os dados inseridos no programa.
		 * */
		
		for(aux = 0; aux < 10; aux++) { // Gerando os telefones aleat�rios (com DDD)
			telefone[aux] = "(" + random.nextInt(9) + random.nextInt(9) + ") 9" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + "-" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
		}
		
		for(aux = 0; aux < 10; aux++) {
			valorCompra[aux] = (random.nextDouble() + 0.1) * 10; // Inserindo um valor de compra aleat�rio que necessariamente ser� maior que 1
			porcentLucro[aux] = random.nextDouble() * 100; //Gerando uma porcentagem de lucro entre 0 e 100
			qtdEstoque[aux] = random.nextInt(1000); // Gerando uma quantidade de estoque entre 0 e 1000
		}
		
		/* Como estamos inserindo 10 Clientes e 10 Produtos, ser�o incrementados em 10 os contadores
		 * de clientes (numClientes) e produtos (numProdutos) abaixo.
		 * */
		numClientes += 10;
		numProdutos += 10;
		
		/*System.out.println("Apresentando os dados dos clientes inseridos (teste): ");
		for(aux = 0; aux < 10; aux++) {
			System.out.println("Nome: " + aux + ": " + nome[aux]);
			System.out.println("Endere�o: " + endereco[aux]);
			System.out.println("Telefone: " + telefone[aux]);
			System.out.println("\n");
		}
		
		System.out.println("\nApresentando os dados dos produtos inseridos (teste): ");
		for(aux = 0; aux < 10; aux++) {
			System.out.println("Nome do: " + aux + "� produto: " + nomeProduto[aux]);
			System.out.println("Descri��o: " + descricao[aux]);
			System.out.println("Valor de Compra: R$ " + valorCompra[aux]);
			System.out.println("Porcentagem de Lucro: " + porcentLucro[aux] + "%");
			System.out.println("Quantidade no Esoque: " + qtdEstoque[aux]);
			System.out.println("\n");
		}*/
		
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
		do { // O usu�rio dever� digitar uma quant. de clientes a serem cadastrados maior ou igual a 1 e menor que o tamanho m�ximo dos vetores (ver TAMANHO_VETOR)
			System.out.print("Digite a quantidade de clientes a serem cadastrados: ");
			qtdCadastrar = ler.nextInt();	
			
			if(qtdCadastrar < 1 || qtdCadastrar > TAMANHO_VETOR) { // Apresenta mensagem para informar o erro ao usu�rio
				System.out.println("O valor inserido deve ser maior que zero e menor que " + (TAMANHO_VETOR+1) + "!\n");
			}
		}while(qtdCadastrar < 1 || qtdCadastrar > TAMANHO_VETOR); //Se repete at� a quant. ser maior ou igual a 1
		
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
			System.out.println("Endere�o: " + endereco[indexCliente]);
			System.out.println("Telefone: " + telefone[indexCliente]);
			
			do { // Verificando se o usu�rio deseja alterar os dados do cliente em quest�o 
				System.out.print("\nDeseja alterar os dados do(a) cliente? ('S' ou 'N'): ");
				desejaAlterar = ler.next().charAt(0);
				ler.nextLine(); //Limpando Buffer
				
				if (desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N') {
					System.out.println("Caractere inv�lido!"); // Se o usu�rio digitar um caractere diferente do esperado, ser� apresentado o erro e ele dever� digitar um caractere v�lido para encerrar o loop
				}
				
			} while(desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N');
		
		} else {
			System.out.println("\nCliente n�o encontrado!");
			desejaAlterar = 'n';
		}
		
		if (desejaAlterar == 'S' || desejaAlterar == 's') {
			System.out.println("\n ~ Alterando Nome ~");
			System.out.print("Digite o nome do(a) cliente: ");
			nome[indexCliente] = ler.nextLine();
			
			System.out.println("\n~ Alterando Endere�o ~");
			System.out.print("Digite o endere�o do(a) cliente: ");
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
		
		do { // O usu�rio dever� digitar uma quant. de produtos a serem cadastrados maior ou igual a 1 e menor que o tamanho m�ximo dos vetores (ver TAMANHO_VETOR)
			System.out.print("Digite a quantidade de produtos a serem cadastrados: ");
			qtdCadastrar = ler.nextInt();	
			
			if(qtdCadastrar < 1 || qtdCadastrar > TAMANHO_VETOR) { // Apresenta mensagem para informar o erro ao usu�rio
				System.out.println("O valor inserido deve ser maior que zero e menor que " + (TAMANHO_VETOR+1) + "!\n");
			}
		}while(qtdCadastrar < 1 || qtdCadastrar > TAMANHO_VETOR); //Se repete at� a quant. ser maior ou igual a 1 e menor ou igual ao TAMANHO_VETOR
		
		for(int aux = 0; aux < qtdCadastrar; aux++) { // Recebendo os dados dos produtos
			ler.nextLine(); // Limpando Buffer 
			
			System.out.print("\nDigite o nome do " + (aux+1) + "� produto: "); // Recebendo o nome
			nomeProduto[numProdutos] = ler.nextLine();
			
			System.out.print("Digite a descri��o do produto: "); // Recebendo a descri��o
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
			System.out.println("Descri��o: " + descricao[indexProduto]);
			System.out.println("Valor de Compra: R$ " + valorCompra[indexProduto]);
			System.out.println("Porcentagem de Lucro: " + porcentLucro[indexProduto] + " %");
			System.out.println("Quantidade em Estoque: " + qtdEstoque[indexProduto]);
			
			do { // Verificando se o usu�rio deseja alterar os dados do produto em quest�o 
				System.out.print("\nDeseja alterar os dados do produto? ('S' ou 'N'): ");
				desejaAlterar = ler.next().charAt(0);
				ler.nextLine(); //Limpando Buffer
				
				if (desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N') {
					System.out.println("Caractere inv�lido!"); // Se o usu�rio digitar um caractere diferente do esperado, ser� apresentado o erro e ele dever� digitar um caractere v�lido para encerrar o loop
				}
				
			} while(desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N');
			
		} else {
			System.out.println("\nProduto n�o encontrado!");
			desejaAlterar = 'n';
		}
		
		
		
		if (desejaAlterar == 'S' || desejaAlterar == 's') {
			System.out.println("\n ~ Alterando Nome ~");
			System.out.print("Digite o nome do(a) produto: ");
			nomeProduto[indexProduto] = ler.nextLine();
			
			System.out.println("\n~ Alterando Descri��o ~");
			System.out.print("Digite a descri��o do produto: ");
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
	
	
	
	public static void cadastrarVendas(String nome[], String nomeProduto[], int qtdEstoque[]) {
		int clienteEscolhido;
		int produtoEscolhido;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ CADASTRO DE VENDAS ~");
		
		do{
			System.out.println("\nSelecione o(a) cliente: ");
			
			for (int i = 0; i < numClientes; i++) {
				System.out.println((i+1) + " - " + nome[i] + "");
			}
			
			System.out.print("Op��o Escolhida: ");
			clienteEscolhido = ler.nextInt();	
			
			if(clienteEscolhido < 1 || clienteEscolhido > numClientes) {
				System.out.println("Op��o Inv�lida!\n");
			}
			
		}while(clienteEscolhido < 1 || clienteEscolhido > numClientes);
		
		criarLinha(40); //Inserindo linha para melhorar a est�tica do programa		
		clienteEscolhido--; //Desta forma, a vari�vel estar� armazenando a posi��o do cliente no vetor (index do cliente)
		
		do{
			System.out.println("\nSelecione o produto: ");
			
			for (int i = 0; i < numProdutos; i++) {
				System.out.println((i+1) + " - " + nomeProduto[i] + "");
				System.out.println("Quantidade no Estoque: " + qtdEstoque[i] + ".\n");
			}
			
			System.out.print("Op��o Escolhida: ");
			produtoEscolhido = ler.nextInt();	
			
			if(produtoEscolhido < 1 || produtoEscolhido > numProdutos) {
				System.out.println("\nOp��o Inv�lida!\n");
			}
			
		}while(produtoEscolhido < 1 || produtoEscolhido > numProdutos);
		
		criarLinha(40); //Inserindo linha para melhorar a est�tica do programa
		produtoEscolhido--; //Desta forma, a vari�vel estar� armazenando a posi��o do produto no vetor (index do produto)
		
	}

	
}

