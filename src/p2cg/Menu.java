package p2cg;

public class Menu {
	
	public Menu(){
		this.imprime("Bem vindo a P2-CG: Programa��o 2 - Central de Games\n\n");
		this.imprime("Escolha uma op��o para continuar: \n\n");
		this.imprime("1 - Adicionar Usuario\n");
		this.imprime("2 - Visualizar Usuarios\n");
		this.imprime("3 - Adicionar Jogos\n");
		this.imprime("4 - Comprar Jogos\n");
		this.imprime("0 - Sair\n\n");
		
	}
	
	public void imprime(String string){
		System.out.println(string);
		
	}

}
