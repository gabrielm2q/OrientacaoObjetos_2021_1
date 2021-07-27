package tp1;
import java.util.*;

public class ControleClientesProdutos_Tp1 {
	public static int TAMANHO_VETOR = 50; // Essa constante define o tamanho máximo de todos os vetores
	public static int numClientes = 0; // Variável que conta o número de clientes cadastrados
	public static int numProdutos = 0; // Variável que conta o número de produtos cadastrados
	
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
		
		/* O método chamado abaixo preenche os vetores com dados (10 produtos e 10 clientes).
		 * Dados como telefone (cliente), valorCompra, porcentLucro e qtdEstoque (produto) 
		 * são preenchidos com valores gerados aleatoriamente.
		 * */		
		preencherVetores(nome, endereco, telefone, nomeProduto, descricao, valorCompra, porcentLucro, qtdEstoque);
		
		Scanner ler = new Scanner(System.in);

		criarLinha(60); // Imprimindo uma linha (apenas pela estética)
		System.out.println("\nSeja bem vindo(a)!");

		/* O loop do...while abaixo apresenta o menu de opções e, através de um switch...case, ordena o 
		 * usuário para o método escolhido.
		 * O loop somente se encerrará quando o usuário escolher a opção SAIR.
		 * */
		do{
			/* Chamando o método que imprime o Menu e retorna a opção escolhida pelo usuário
			 * */
			opcMenu = imprimirMenu(); 

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
					criarLinha(60);
					if(existeEstoque(qtdEstoque)) { 
						// Este método verifica se a quant. de estoque é diferente de zero.
						cadastrarVendas(nome, nomeProduto, qtdEstoque);
					} else {
						/* Se a soma das quantidades dos produtos no estoque for igual a 0, não será possível
						 * executar uma venda e, consequentemente, o método cadastrarVendas() não será executado.
						 * */
						System.out.println("\nNÃO HÁ PRODUTOS NO ESTOQUE!");
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
					/* O default está sendo usado apenas para evitar possíveis problemas, 
					 * pois os valores já são verificados no próprio menu e, caso sejam divergentes
					 * das opções do menu, o usuário será compelido a digitar outro valor!
					 * */
					criarLinha(60);
					System.out.println("\nERRO!");
					criarLinha(60);
			}
			criarLinha(60);
		}while(opcMenu != 7);
	}
	
	
	/* O método abaixo é responsável por preencher os vetores com 10 produtos e 10 clientes.
	 * */
	public static void preencherVetores(String nome[], String endereco[], String telefone[], String nomeProduto[], String descricao[], double valorCompra[], double porcentLucro[], int qtdEstoque[]) {
		int aux;
		
		// Dados Carregados dos Clientes
		String [] nomesGerados = {"Pedro", "Paulo", "Mateus", "João", "Maria", "Noah", "Marcos", "Louise", "Alice", "Sofia"};
		String [] enderecosGerados = {"Rua dos Cristais", "Rua da Saudade", "Rua 7 de Setembro", "Rua 9 de Julho", "Rua 5 de Agosto", "Rua Loureiros", "Parques Elísios", "Residencial Copacabana", "Rua dos Príncipes", "Avenida Conde Drácula"};
		
		// Dados Carregados dos Produtos
		String [] produtoGerado = {"Bombom", "Chips", "Paçoca", "Gelatina", "Geléia", "Brigadeiro", "Mousse", "Laranja", "Banana", "Maçã"};
		String [] descricaoGerada = {"Chocolate", "Batata Chip", "Doce de Amendoim", "Pacote de Gelatina", "Compota de Geléia", "Chocolate com Granulado", "Mousse de Maracujá", "Fruta Laranja", "Fruta Banana", "Fruta Maçã"};
		
		
		Random random = new Random(); // Instanciando a classe Random
		
		for(aux = 0; aux < 10; aux++) { //Preenchendo os vetores com os dados carregados dos produtos e clientes
			nome[aux] = nomesGerados[aux]; 
			endereco[aux] = enderecosGerados[aux]; 
			
			nomeProduto[aux] = produtoGerado[aux]; 
			descricao[aux] = descricaoGerada[aux]; 
		}
		
		/* Agora, iremos preencher os vetores "telefone" (Cliente), "valorCompra", "porcentLucro" 
		 * e "qtdEstoque" (Produto) com valores gerados aleatoriamente através da classe Random,
		 * de modo a randomizar os dados inseridos no programa.
		 * */
		
		/* Gerando os telefones aleatórios no formato (xx) 9xxxx-xxxx 
		 */
		for(aux = 0; aux < 10; aux++) { 
			telefone[aux] = "(" + random.nextInt(9) + random.nextInt(9) + ") 9" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + "-" + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
		}
		
		/* Inserindo valores aleatórios nos vetores que armazenam dados numéricos
		 * */		
		for(aux = 0; aux < 10; aux++) {
			valorCompra[aux] = (random.nextDouble() + 0.1) * 10; // Valor aleatório maior que 1
			porcentLucro[aux] = random.nextDouble() * 100; // Valor aleatório entre 0 e 100
			qtdEstoque[aux] = random.nextInt(150); // Valor aleatório entre 0 e 150
		}
		
		/* Como estamos inserindo 10 Clientes e 10 Produtos, serão incrementados em 10 os contadores
		 * de clientes (numClientes) e produtos (numProdutos) abaixo.
		 * */
		numClientes += 10;
		numProdutos += 10;
	}
	
	
	/* Método utilizado para criar uma linha com o tamanho determinado
	 */
	public static void criarLinha(int tamanho) { 
		for(int aux = 0; aux < tamanho; aux++) {	
			System.out.print("-"); // Imprimindo a linha com o tamanho pedido
		}
	}
	
	
	/* Método que imprime o Menu e verifica se a opção digitada é válida
	 * */
	public static int imprimirMenu() { 
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
	
	
	/* O método abaixo verifica se a soma da quantidade de estoque dos produtos
	 * é diferente de zero. Isto é, mesmo que existam vários produtos cadastrados,
	 * se eles não apresentarem estoque algumas funcionalidades do programa
	 * (especialmente relacionados à venda) não poderão ser executadas.
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
			return false; // Caso contrário, retornaremos false
		}
	}
	
	
	/* Método que corresponde à função de "Cadastrar Novos Clientes"
	 * */
	public static void cadastrarClientes(String nome[], String endereco[], String telefone[]) {
		int qtdCadastrar;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ CADASTRAR CLIENTES ~");
		
		/* O usuário deverá digitar uma quant. de clientes a serem cadastrados 
		 * maior ou igual a 1 e menor que o tamanho máximo dos vetores (ver TAMANHO_VETOR), 
		 * de modo que a soma dos clientes já cadastrados com os clientes a serem cadastrados 
		 * também seja menor que o TAMANHO_VETOR
		 * */
		do { 
			System.out.print("Digite a quantidade de clientes a serem cadastrados: ");
			qtdCadastrar = ler.nextInt();	
			
			/* Apresenta mensagem para informar o erro ao usuário caso o número de clientes a serem
			 * cadastrados seja menor que 1 ou exceda o tamanho máximo dos vetores, pedindo para que,
			 * nesses casos, o usuário digite outro valor.
			 * */
			if(qtdCadastrar < 1 || qtdCadastrar > (TAMANHO_VETOR - numClientes)) { 
				System.out.println("O valor inserido deve estar entre 1 e " + (TAMANHO_VETOR - numClientes) + "!\n");
			}
		}while(qtdCadastrar < 1 || qtdCadastrar > (TAMANHO_VETOR - numClientes));
		
		ler.nextLine(); // Limpando o Buffer do Teclado
		
		for(int aux = 0; aux < qtdCadastrar; aux++) { // Recebendo os dados dos clientes
			System.out.print("\nDigite o " + (aux+1) + "º nome: "); // Recebendo o nome
			nome[numClientes] = ler.nextLine();
			
			System.out.print("Digite seu endereço: "); // Recebendo o endereço
			endereco[numClientes] = ler.nextLine();
			
			System.out.print("Digite seu telefone: "); // Recebendo o telefone
			telefone[numClientes] = ler.nextLine();
			
			numClientes++; // Incrementando o número de clientes cadastrados
		}
		
		System.out.println("\nCliente(s) cadastrados(as) com sucesso!");
	}
	
	
	/* Método que permite buscar os clientes já cadastrados e, caso necessário,
	 * alterar os dados do cliente em questão!
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
		
		for(int i = 0; i < numClientes; i++) { // Verificando se o nome do cliente está cadastrado!
			if(nome[i].equals(nomeBuscar)) {
				/* Caso o nome do cliente esteja armazenado no vetor, a variável clienteExiste
				 * será TRUE e armazenaremos o index do cliente no vetor!
				 * */
				clienteExiste = true; 
				indexCliente = i;
			}
		}
		
		if(clienteExiste) { // Se o cliente estiver armazenado no sistema...
			System.out.println("\nDADOS DO CLIENTE: ");
			System.out.println("Nome: " + nome[indexCliente]);
			System.out.println("Endereço: " + endereco[indexCliente]);
			System.out.println("Telefone: " + telefone[indexCliente]);
			
			do { // Verificando se o usuário deseja alterar os dados do cliente em questão 
				System.out.print("\nDeseja alterar os dados do(a) cliente? ('S' ou 'N'): ");
				desejaAlterar = ler.next().charAt(0);
				ler.nextLine(); //Limpando Buffer
				
				/* Se o usuário digitar um caractere diferente do esperado, 
				 * será apresentado o erro e ele deverá digitar um caractere 
				 * válido para encerrar o loop. Serão aceitos os caracteres
				 * 'S' e 'N', tanto maiúsculos quanto minúsculos.
				 * */
				if (desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N') {
					System.out.println("Caractere inválido!"); 
				}
			} while(desejaAlterar != 's' && desejaAlterar != 'S' && desejaAlterar != 'n' && desejaAlterar != 'N');
		
		} else {
			System.out.println("\nCliente não encontrado!");
			desejaAlterar = 'n'; // Se o cliente não for encontrado, não será possível armazenar seus dados
		}
		
		if (desejaAlterar == 'S' || desejaAlterar == 's') { //Se o usuário quiser alterar os dados...
			System.out.println("\n ~ Alterando Nome ~");
			System.out.print("Digite o nome do(a) cliente: ");
			nome[indexCliente] = ler.nextLine();
			
			System.out.println("\n~ Alterando Endereço ~");
			System.out.print("Digite o endereço do(a) cliente: ");
			endereco[indexCliente] = ler.nextLine();
			
			System.out.println("\n~ Alterando Telefone ~");
			System.out.print("Digite o telefone do(a) cliente: ");
			telefone[indexCliente] = ler.nextLine();
			
			System.out.println("\nDados atualizados com sucesso!");			
		}
	}
	
	
	/* Método para Cadastrar Novos Produtos
	 * */
	public static void cadastrarProdutos(String nomeProduto[], String descricao[], double valorCompra[], double porcentLucro[], int qtdEstoque[]) {
		int qtdCadastrar;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ CADASTRAR PRODUTOS ~");
		
		do { // O usuário deverá digitar uma quant. de produtos a serem cadastrados maior ou igual a 1 e menor que o tamanho máximo dos vetores (ver TAMANHO_VETOR)
			System.out.print("Digite a quantidade de produtos a serem cadastrados: ");
			qtdCadastrar = ler.nextInt();	
			
			if(qtdCadastrar < 1 || qtdCadastrar > (TAMANHO_VETOR - numProdutos)) { // Apresenta mensagem para informar o erro ao usuário
				System.out.println("O valor inserido deve estar entre 1 e " + (TAMANHO_VETOR - numProdutos) + "!\n");
			}
		}while(qtdCadastrar < 1 || qtdCadastrar > (TAMANHO_VETOR - numProdutos)); //Se repete até a quant. ser maior ou igual a 1 e menor ou igual ao TAMANHO_VETOR
		
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
		System.out.println("\nProdutos cadastrados com sucesso!");		
	}
	
	
	/* Método onde o usuário poderá buscar um produto e, caso o encontre,
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
		
		for(int i = 0; i < numProdutos; i++) { // Verificando se o produto em questão está cadastrado!
			if(nomeProduto[i].equals(nomeProd)) {
				/* Caso o nome do produto esteja armazenado no vetor, a variável produtoExiste
				 * será TRUE e armazenaremos o index do produto no vetor!
				 * */
				produtoExiste = true;
				indexProduto = i;
			}
		}
		
		if(produtoExiste) { // Se o produto existir...
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
		
		/* Caso o usuário queira alterar os dados do produto encontrado...
		 * */
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
			
			System.out.println("\nDados atualizados com sucesso!");			
		}
	}
	
	
	/* Método para cadastrar vendas!
	 * Este método somente será acessível se a soma das quantidades de estoque dos produtos
	 * cadastrados for maior que zero (ver método existeEstoque()).
	 * */
	public static void cadastrarVendas(String nome[], String nomeProduto[], int qtdEstoque[]) {
		int clienteEscolhido;
		int produtoEscolhido;
		int quantidadeVendida;
		char continuarVendendo;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n~ CADASTRO DE VENDAS ~");
		
		/* Este loop do...while somente se encerrará se o usuário escolher
		 * a opção de um dos clientes cadastrados.
		 * */
		do{
			System.out.println("Selecione o(a) cliente: ");
			for (int i = 0; i < numClientes; i++) { // Apresentando todos os clientes cadastrados
				System.out.println((i+1) + " - " + nome[i] + "");
			}
			
			System.out.print("Opção Escolhida: ");
			clienteEscolhido = ler.nextInt();	
			
			if(clienteEscolhido < 1 || clienteEscolhido > numClientes) { 
				System.out.println("Opção Inválida!\n");
			}
			
		}while(clienteEscolhido < 1 || clienteEscolhido > numClientes);
		
		clienteEscolhido--; //Desta forma, a variável estará armazenando a posição do cliente no vetor (index do cliente)
		
		/* Este loop do...while serve para o usuário cadastrar as vendas realizadas.
		 * Ele somente se encerrará se:
		 * - O usuário não quiser cadastrar mais vendas para o cliente;
		 * - A soma das quantidades de estoque dos produtos for igual a zero, isto é,
		 * quando acabar o estoque (ver método existeEstoque()).
		 * */
		do{
			criarLinha(40);
			
			System.out.println("\nSelecione o produto vendido: ");
			listarProdutos(nomeProduto, qtdEstoque); // Listando os produtos cadastrados
			
			
			/* O seguinte loop do...while verifica se a opção escolhida é válida, isto é,
			 * se o usuário selecionou um produto dentre os disponíveis
			 * */
			do {
				System.out.print("Opção Escolhida: ");
				produtoEscolhido = ler.nextInt();
				
				if(produtoEscolhido < 1 || produtoEscolhido > numProdutos) {
					System.out.println("\nOpção Inválida! Digite uma opção entre 1 e " + numProdutos + ".\n");
				}
			}while(produtoEscolhido < 1 || produtoEscolhido > numProdutos);
			
			
			/* A variável produtoEscolhido será subtraída em 1
			 * para armazenar a posição do produto no vetor (index do produto)
			 * */
			produtoEscolhido--;
			
			
			/* O seguinte if...else verifica se o estoque do produto escolhido não é igual a zero,
			 * isto é, se há estoque disponível do produto
			 * */
			if(qtdEstoque[produtoEscolhido] != 0) {
				
				/* O seguinte do...while verifica se o produto possui estoque suficiente para a quantidade
				 * vendida, isto é, se o valor da variável "quantidadeVendida" é menor que o valor do vetor
				 * "qtdEstoque[]" no index do produto escolhido
				 * */
				do {
					System.out.print("\nQuantidade de " + nomeProduto[produtoEscolhido] + " vendida: ");
					quantidadeVendida = ler.nextInt();		
				
					if(quantidadeVendida < 1 || quantidadeVendida > qtdEstoque[produtoEscolhido]) {
						System.out.println("Quantidade Inválida! Selecione uma quantidade entre 1 e " + qtdEstoque[produtoEscolhido] + ".");
					}
				}while(quantidadeVendida < 1 || quantidadeVendida > qtdEstoque[produtoEscolhido]);
			
				/* Uma vez realizada a venda, subtraímos a quantidade vendida do estoque do produto
				 * */
				qtdEstoque[produtoEscolhido] -= quantidadeVendida;
			
				
				/* O seguinte loop do...while verifica se o usuário quer cadastrar mais uma venda para o
				 * cliente selecionado
				 * */
				do {
					System.out.print("\nDeseja continuar vendendo? ('S' ou 'N'): ");
					continuarVendendo = ler.next().charAt(0);
					ler.nextLine(); //Limpando Buffer
			
					if (continuarVendendo != 's' && continuarVendendo != 'S' && continuarVendendo != 'n' && continuarVendendo != 'N') {
						System.out.println("Caractere inválido!"); // Se o usuário digitar um caractere diferente do esperado, será apresentado o erro e ele deverá digitar um caractere válido para encerrar o loop
					}
					
				}while(continuarVendendo != 's' && continuarVendendo != 'S' && continuarVendendo != 'n' && continuarVendendo != 'N');
		
			} else {
				/* Caso o usuário selecione um produto que não possui estoque, é mostrada mensagem informando
				 * que o produto está indisponível e o usuário poderá selecionar outro produto para cadastrar
				 * a venda (o loop se repetirá)
				 * */
				System.out.println("\nProduto atualmente indisponível! Selecione outro!");
				continuarVendendo = 's';
			}
			
			/* Se o método existeEstoque() verificar que não há nenhum produto com estoque disponível, o
			 * loop será encerrado com um "break" e o programa retornará para o menu inicial
			 * */
			if(!existeEstoque(qtdEstoque)) {
				System.out.println("\nNÃO HÁ PRODUTOS NO ESTOQUE!");
				System.out.println("Insira mais produtos ou atualize a quantidade de estoque!");
				break;
			}
		}while(continuarVendendo == 's' || continuarVendendo == 'S');			
	}
	
	
	/* O seguinte método mostra todos os produtos cadastrados e suas respectivas quantidades
	 * disponíveis no estoque.
	 * */
	public static void listarProdutos(String nomeProduto[], int qtdEstoque[]) {
		for (int i = 0; i < numProdutos; i++) { // Loop que passa por todos os produtos e suas respectivas quantidades
			System.out.print((i+1) + " - " + nomeProduto[i] + "    ");
			System.out.print("(Quantidade no Estoque: " + qtdEstoque[i] + ").\n");
		}
	}
}