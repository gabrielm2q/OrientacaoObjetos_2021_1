package tp1;
import java.util.*;

public class ControleClientesProdutos_Tp1 {
	public static int TAMANHO_VETOR = 50; // Essa constante define o tamanho m�ximo de todos os vetores
	public static int numClientes = 0; // Vari�vel que conta o n�mero de clientes cadastrados
	public static int numProdutos = 0; // Vari�vel que conta o n�mero de produtos cadastrados
	
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
		
		/* O m�todo chamado abaixo preenche os vetores com dados (10 produtos e 10 clientes).
		 * Dados como telefone (cliente), valorCompra, porcentLucro e qtdEstoque (produto) 
		 * s�o preenchidos com valores gerados aleatoriamente.
		 * */		
		preencherVetores(nome, endereco, telefone, nomeProduto, descricao, valorCompra, porcentLucro, qtdEstoque);
		
		Scanner ler = new Scanner(System.in);

		criarLinha(60); // Imprimindo uma linha (apenas pela est�tica)
		System.out.println("\nSeja bem vindo(a)!");

		/* O loop do...while abaixo apresenta o menu de op��es e, atrav�s de um switch...case, ordena o 
		 * usu�rio para o m�todo escolhido.
		 * O loop somente se encerrar� quando o usu�rio escolher a op��o SAIR.
		 * */
		do{
			/* Chamando o m�todo que imprime o Menu e retorna a op��o escolhida pelo usu�rio
			 * */
			opcMenu = imprimirMenu(); 

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
					if(existeEstoque(qtdEstoque)) { 
						// Este m�todo verifica se a quant. de estoque � diferente de zero.
						cadastrarVendas(nome, nomeProduto, qtdEstoque);
					} else {
						/* Se a soma das quantidades dos produtos no estoque for igual a 0, n�o ser� poss�vel
						 * executar uma venda e, consequentemente, o m�todo cadastrarVendas() n�o ser� executado.
						 * */
						System.out.println("\nN�O H� PRODUTOS NO ESTOQUE!");
						System.out.println("Insira mais produtos ou atualize a quantidade de estoque!");
					}
					break;
					
				case 6: // Mostrar produtos em estoque
					criarLinha(60);
					System.out.println("\n~ MOSTRAR ESTOQUE ~\n");
					listarProdutos(nomeProduto, qtdEstoque);
					break;
					
				case 7: // Sair
					criarLinha(60);
					System.out.println("\nEncerrando! Obrigado por usar o programa!");
					break;
					
				default: 
					/* O default est� sendo usado apenas para evitar poss�veis problemas, 
					 * pois os valores j� s�o verificados no pr�prio menu e, caso sejam divergentes
					 * das op��es do menu, o usu�rio ser� compelido a digitar outro valor!
					 * */
					criarLinha(60);
					System.out.println("\nERRO!");
					criarLinha(60);
			}
			criarLinha(60);
		}while(opcMenu != 7);
	}
	
	
	/* O m�todo abaixo � respons�vel por preencher os vetores com 10 produtos e 10 clientes.
	 * */
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
		
		/* Gerando os telefones aleat�rios no formato (xx) 9xxxx-xxxx 
		 */
		for(aux = 0; aux < 10; aux++) { 
			telefone[aux] = "(" + random.nextInt(9) + random.nextInt(9) + ") 9" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + "-" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
		}
		
		/* Inserindo valores aleat�rios nos vetores que armazenam dados num�ricos
		 * */		
		for(aux = 0; aux < 10; aux++) {
			valorCompra[aux] = (random.nextDouble() + 0.1) * 10; // Valor aleat�rio maior que 1
			porcentLucro[aux] = random.nextDouble() * 100; // Valor aleat�rio entre 0 e 100
			qtdEstoque[aux] = random.nextInt(150); // Valor aleat�rio entre 0 e 150
		}
		
		/* Como estamos inserindo 10 Clientes e 10 Produtos, ser�o incrementados em 10 os contadores
		 * de clientes (numClientes) e produtos (numProdutos) abaixo.
		 * */
		numClientes += 10;
		numProdutos += 10;
	}
	
	
	/* M�todo utilizado para criar uma linha com o tamanho determinado
	 */
	public static void criarLinha(int tamanho) { 
		for(int aux = 0; aux < tamanho; aux++) {	
			System.out.print("-"); // Imprimindo a linha com o tamanho pedido
		}
	}
	
	
	/* M�todo que imprime o Menu e verifica se a op��o digitada � v�lida
	 * */
	public static int imprimirMenu() { 
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
	
	
	/* O m�todo abaixo verifica se a soma da quantidade de estoque dos produtos
	 * � diferente de zero. Isto �, mesmo que existam v�rios produtos cadastrados,
	 * se eles n�o apresentarem estoque algumas funcionalidades do programa
	 * (especialmente relacionados � venda) n�o poder�o ser executadas.
	 * */
	public static boolean existeEstoque(int qtdEstoque[]) {
		int somaEstoque = 0;
		
		if(numProdutos != 0) { // Se houver produtos cadastrados...
			for(int aux = 0; aux < numProdutos; aux++) { // ...somaremos as quantidades de estoque de todos eles
				somaEstoque += qtdEstoque[aux];
			}
		}
		
		if(somaEstoque > 0) { // Se a soma do estoque for maior que 0...
			return true; // ...retornaremos true
		} else {
			return false; // Caso contr�rio, retornaremos false
		}
	}
	
	
	/* M�todo que corresponde � fun��o de "Cadastrar Novos Clientes"
	 * */
	public static void cadastrarClientes(String nome[], String endereco[], String telefone[]) {
		int qtdCadastrar;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ CADASTRAR CLIENTES ~");
		
		/* O usu�rio dever� digitar uma quant. de clientes a serem cadastrados 
		 * maior ou igual a 1 e menor que o tamanho m�ximo dos vetores (ver TAMANHO_VETOR), 
		 * de modo que a soma dos clientes j� cadastrados com os clientes a serem cadastrados 
		 * tamb�m seja menor que o TAMANHO_VETOR
		 * */
		do { 
			System.out.print("Digite a quantidade de clientes a serem cadastrados: ");
			qtdCadastrar = ler.nextInt();	
			
			/* Apresenta mensagem para informar o erro ao usu�rio caso o n�mero de clientes a serem
			 * cadastrados seja menor que 1 ou exceda o tamanho m�ximo dos vetores, pedindo para que,
			 * nesses casos, o usu�rio digite outro valor.
			 * */
			if(qtdCadastrar < 1 || qtdCadastrar > (TAMANHO_VETOR - numClientes)) { 
				System.out.println("O valor inserido deve estar entre 1 e " + (TAMANHO_VETOR - numClientes) + "!\n");
			}
		}while(qtdCadastrar < 1 || qtdCadastrar > (TAMANHO_VETOR - numClientes));
		
		ler.nextLine(); // Limpando o Buffer do Teclado
		
		for(int aux = 0; aux < qtdCadastrar; aux++) { // Recebendo os dados dos clientes
			System.out.print("\nDigite o " + (aux+1) + "� nome: "); // Recebendo o nome
			nome[numClientes] = ler.nextLine();
			
			System.out.print("Digite seu endere�o: "); // Recebendo o endere�o
			endereco[numClientes] = ler.nextLine();
			
			System.out.print("Digite seu telefone: "); // Recebendo o telefone
			telefone[numClientes] = ler.nextLine();
			
			numClientes++; // Incrementando o n�mero de clientes cadastrados
		}
		
		System.out.println("\nCliente(s) cadastrados(as) com sucesso!");
	}
	
	
	/* M�todo que permite buscar os clientes j� cadastrados e, caso necess�rio,
	 * alterar os dados do cliente em quest�o!
	 * */
	public static void buscarClientes(String nome[], String endereco[], String telefone[]) {
		String nomeBuscar;
		int indexCliente = 0;
		boolean clienteExiste = false;
		char desejaAlterar;		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ BUSCAR CLIENTES ~");
		System.out.print("Digite o nome do(a) cliente a ser procurado: ");
		nomeBuscar = ler.nextLine();
		
		for(int i = 0; i < numClientes; i++) { // Verificando se o nome do cliente est� cadastrado!
			if(nome[i].equals(nomeBuscar)) {
				/* Caso o nome do cliente esteja armazenado no vetor, a vari�vel clienteExiste
				 * ser� TRUE e armazenaremos o index do cliente no vetor!
				 * */
				clienteExiste = true; 
				indexCliente = i;
			}
		}
		
		if(clienteExiste) { // Se o cliente estiver armazenado no sistema...
			System.out.println("\nDADOS DO CLIENTE: ");
			System.out.println("Nome: " + nome[indexCliente]);
			System.out.println("Endere�o: " + endereco[indexCliente]);
			System.out.println("Telefone: " + telefone[indexCliente]);
			
			do { // Verificando se o usu�rio deseja alterar os dados do cliente em quest�o 
				System.out.print("\nDeseja alterar os dados do(a) cliente? ('S' ou 'N'): ");
				desejaAlterar = ler.next().charAt(0);
				ler.nextLine(); //Limpando Buffer
				
				/* Se o usu�rio digitar um caractere diferente do esperado, 
				 * ser� apresentado o erro e ele dever� digitar um caractere 
				 * v�lido para encerrar o loop. Ser�o aceitos os caracteres
				 * 'S' e 'N', tanto mai�sculos quanto min�sculos.
				 * */
				if (desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N') {
					System.out.println("Caractere inv�lido!"); 
				}
			} while(desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N');
		
		} else {
			System.out.println("\nCliente n�o encontrado!");
			desejaAlterar = 'n'; // Se o cliente n�o for encontrado, n�o ser� poss�vel armazenar seus dados
		}
		
		if (desejaAlterar == 'S' || desejaAlterar == 's') { //Se o usu�rio quiser alterar os dados...
			System.out.println("\n ~ Alterando Nome ~");
			System.out.print("Digite o nome do(a) cliente: ");
			nome[indexCliente] = ler.nextLine();
			
			System.out.println("\n~ Alterando Endere�o ~");
			System.out.print("Digite o endere�o do(a) cliente: ");
			endereco[indexCliente] = ler.nextLine();
			
			System.out.println("\n~ Alterando Telefone ~");
			System.out.print("Digite o telefone do(a) cliente: ");
			telefone[indexCliente] = ler.nextLine();
			
			System.out.println("\nDados atualizados com sucesso!");			
		}
	}
	
	
	/* M�todo para Cadastrar Novos Produtos
	 * */
	public static void cadastrarProdutos(String nomeProduto[], String descricao[], double valorCompra[], double porcentLucro[], int qtdEstoque[]) {
		int qtdCadastrar;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ CADASTRAR PRODUTOS ~");
		
		do { // O usu�rio dever� digitar uma quant. de produtos a serem cadastrados maior ou igual a 1 e menor que o tamanho m�ximo dos vetores (ver TAMANHO_VETOR)
			System.out.print("Digite a quantidade de produtos a serem cadastrados: ");
			qtdCadastrar = ler.nextInt();	
			
			if(qtdCadastrar < 1 || qtdCadastrar > (TAMANHO_VETOR - numProdutos)) { // Apresenta mensagem para informar o erro ao usu�rio
				System.out.println("O valor inserido deve estar entre 1 e " + (TAMANHO_VETOR - numProdutos) + "!\n");
			}
		}while(qtdCadastrar < 1 || qtdCadastrar > (TAMANHO_VETOR - numProdutos)); //Se repete at� a quant. ser maior ou igual a 1 e menor ou igual ao TAMANHO_VETOR
		
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
		System.out.println("\nProdutos cadastrados com sucesso!");		
	}
	
	
	/* M�todo onde o usu�rio poder� buscar um produto e, caso o encontre,
	 * alterar seus dados!
	 * */
	public static void buscarProdutos(String nomeProduto[], String descricao[], double valorCompra[], double porcentLucro[], int qtdEstoque[]) {
		char desejaAlterar;
		boolean produtoExiste = false;
		String nomeProd;
		int indexProduto = 0;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ BUSCAR PRODUTOS ~");
		System.out.print("Digite o nome do(a) produto a ser procurado: ");
		nomeProd = ler.nextLine();
		
		for(int i = 0; i < numProdutos; i++) { // Verificando se o produto em quest�o est� cadastrado!
			if(nomeProduto[i].equals(nomeProd)) {
				/* Caso o nome do produto esteja armazenado no vetor, a vari�vel produtoExiste
				 * ser� TRUE e armazenaremos o index do produto no vetor!
				 * */
				produtoExiste = true;
				indexProduto = i;
			}
		}
		
		if(produtoExiste) { // Se o produto existir...
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
		
		/* Caso o usu�rio queira alterar os dados do produto encontrado...
		 * */
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
			
			System.out.println("\nDados atualizados com sucesso!");			
		}
	}
	
	
	/* M�todo para cadastrar vendas!
	 * Este m�todo somente ser� acess�vel se a soma das quantidades de estoque dos produtos
	 * cadastrados for maior que zero (ver m�todo existeEstoque()).
	 * */
	public static void cadastrarVendas(String nome[], String nomeProduto[], int qtdEstoque[]) {
		int clienteEscolhido;
		int produtoEscolhido;
		int quantidadeVendida;
		char continuarVendendo;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ CADASTRO DE VENDAS ~");
		
		/* Este loop do...while somente se encerrar� se o usu�rio escolher
		 * a op��o de um dos clientes cadastrados.
		 * */
		do{
			System.out.println("Selecione o(a) cliente: ");
			for (int i = 0; i < numClientes; i++) { // Apresentando todos os clientes cadastrados
				System.out.println((i+1) + " - " + nome[i] + "");
			}
			
			System.out.print("Op��o Escolhida: ");
			clienteEscolhido = ler.nextInt();	
			
			if(clienteEscolhido < 1 || clienteEscolhido > numClientes) { 
				System.out.println("Op��o Inv�lida!\n");
			}
			
		}while(clienteEscolhido < 1 || clienteEscolhido > numClientes);
		
		clienteEscolhido--; //Desta forma, a vari�vel estar� armazenando a posi��o do cliente no vetor (index do cliente)
		
		/* Este loop do...while serve para o usu�rio cadastrar as vendas realizadas.
		 * Ele somente se encerrar� se:
		 * - O usu�rio n�o quiser cadastrar mais vendas para o cliente;
		 * - A soma das quantidades de estoque dos produtos for igual a zero, isto �,
		 * quando acabar o estoque (ver m�todo existeEstoque()).
		 * */
		do{
			criarLinha(40);
			
			System.out.println("\nSelecione o produto vendido: ");
			listarProdutos(nomeProduto, qtdEstoque); // Listando os produtos cadastrados
			
			
			/* O seguinte loop do...while verifica se a op��o escolhida � v�lida, isto �,
			 * se o usu�rio selecionou um produto dentre os dispon�veis
			 * */
			do {
				System.out.print("Op��o Escolhida: ");
				produtoEscolhido = ler.nextInt();
				
				if(produtoEscolhido < 1 || produtoEscolhido > numProdutos) {
					System.out.println("\nOp��o Inv�lida! Digite uma op��o entre 1 e " + numProdutos + ".\n");
				}
			}while(produtoEscolhido < 1 || produtoEscolhido > numProdutos);
			
			
			/* A vari�vel produtoEscolhido ser� subtra�da em 1
			 * para armazenar a posi��o do produto no vetor (index do produto)
			 * */
			produtoEscolhido--;
			
			
			/* O seguinte if...else verifica se o estoque do produto escolhido n�o � igual a zero,
			 * isto �, se h� estoque dispon�vel do produto
			 * */
			if(qtdEstoque[produtoEscolhido] != 0) {
				
				/* O seguinte do...while verifica se o produto possui estoque suficiente para a quantidade
				 * vendida, isto �, se o valor da vari�vel "quantidadeVendida" � menor que o valor do vetor
				 * "qtdEstoque[]" no index do produto escolhido
				 * */
				do {
					System.out.print("\nQuantidade de " + nomeProduto[produtoEscolhido] + " vendida: ");
					quantidadeVendida = ler.nextInt();		
				
					if(quantidadeVendida < 1 || quantidadeVendida > qtdEstoque[produtoEscolhido]) {
						System.out.println("Quantidade Inv�lida! Selecione uma quantidade entre 1 e " + qtdEstoque[produtoEscolhido] + ".");
					}
				}while(quantidadeVendida < 1 || quantidadeVendida > qtdEstoque[produtoEscolhido]);
			
				/* Uma vez realizada a venda, subtra�mos a quantidade vendida do estoque do produto
				 * */
				qtdEstoque[produtoEscolhido] -= quantidadeVendida;
			
				
				/* O seguinte loop do...while verifica se o usu�rio quer cadastrar mais uma venda para o
				 * cliente selecionado
				 * */
				do {
					System.out.print("\nDeseja continuar vendendo? ('S' ou 'N'): ");
					continuarVendendo = ler.next().charAt(0);
					ler.nextLine(); //Limpando Buffer
			
					if (continuarVendendo != 's' && continuarVendendo != 'S' && continuarVendendo != 'n' && continuarVendendo != 'N') {
						System.out.println("Caractere inv�lido!"); // Se o usu�rio digitar um caractere diferente do esperado, ser� apresentado o erro e ele dever� digitar um caractere v�lido para encerrar o loop
					}
					
				}while(continuarVendendo != 's' && continuarVendendo != 'S' && continuarVendendo != 'n' && continuarVendendo != 'N');
		
			} else {
				/* Caso o usu�rio selecione um produto que n�o possui estoque, � mostrada mensagem informando
				 * que o produto est� indispon�vel e o usu�rio poder� selecionar outro produto para cadastrar
				 * a venda (o loop se repetir�)
				 * */
				System.out.println("\nProduto atualmente indispon�vel! Selecione outro!");
				continuarVendendo = 's';
			}
			
			/* Se o m�todo existeEstoque() verificar que n�o h� nenhum produto com estoque dispon�vel, o
			 * loop ser� encerrado com um "break" e o programa retornar� para o menu inicial
			 * */
			if(!existeEstoque(qtdEstoque)) {
				System.out.println("\nN�O H� PRODUTOS NO ESTOQUE!");
				System.out.println("Insira mais produtos ou atualize a quantidade de estoque!");
				break;
			}
		}while(continuarVendendo == 's' || continuarVendendo == 'S');			
	}
	
	
	/* O seguinte m�todo mostra todos os produtos cadastrados e suas respectivas quantidades
	 * dispon�veis no estoque.
	 * */
	public static void listarProdutos(String nomeProduto[], int qtdEstoque[]) {
		for (int i = 0; i < numProdutos; i++) { // Loop que passa por todos os produtos e suas respectivas quantidades
			System.out.print((i+1) + " - " + nomeProduto[i] + "    ");
			System.out.print("(Quantidade no Estoque: " + qtdEstoque[i] + ").\n");
		}
	}
}