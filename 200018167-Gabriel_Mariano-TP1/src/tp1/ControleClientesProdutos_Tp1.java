package tp1;
import java.util.Scanner;
public class ControleClientesProdutos_Tp1 {

	public static int imprimirMenu() {
		int opcao;
		Scanner ler = new Scanner(System.in);
		
		do {
			System.out.println("Por favor, siga o menu abaixo e escolha a opção desejada:");
			System.out.println("1 - CADASTRAR NOVO CLIENTE");
			System.out.println("2 - BUSCAR POR CLIENTE");
			System.out.println("3 - CADASTRAR NOVO PRODUTO");
			System.out.println("4 - BUSCAR POR PRODUTO");
			System.out.println("5 - CADASTRAR VENDA");
			System.out.println("6 - MOSTRAR PRODUTOS EM ESTOQUE");
			System.out.println("7 - SAIR");
			System.out.print("Opção desejada: ");
			opcao = ler.nextInt();
			
			if(opcao < 1 || opcao > 7) {
				System.out.println("\nOPÇÃO INVÁLIDA!");
				criarLinha(60);
				System.out.print("\n");
			}
			
		}while(opcao < 1 || opcao > 7);
		
		
		
		return opcao;
	}
	
	public static void criarLinha(int tamanho) { // Método utilizado para criar uma linha com o tamanho determinado, de modo a melhorar o visual do programa
		for(int aux = 0; aux < tamanho; aux++) { 
			System.out.print("-"); //Imprimindo a linha com o tamanho pedido
		}
	}
	
	public static void main(String[] args) {
		int opcMenu;
		Scanner ler = new Scanner(System.in);
		criarLinha(60);
		System.out.println("\nSeja bem vindo(a)!\n");
		opcMenu = imprimirMenu();
		
		switch(opcMenu) {
			case 1: 
				break;
			case 2:
				break;
			case 3:
				break;
			case 4: 
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				criarLinha(60);
				System.out.println("\nObrigado por utilizar o programa!");
				criarLinha(60);
				System.exit(0);
			default: //O default está sendo usado apenas para evitar possíveis problemas, pois os valores já são verificados no próprio menu!
				criarLinha(60);
				System.out.println("\nERRO! Por favor reinicie o programa!");
				criarLinha(60);
		}
	}
}
