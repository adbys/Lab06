//Adbys José Vasconcelos de Andrade - 116110498
package p2cg.usuarios;

import java.util.HashSet;

import p2cg.exceptions.SaldoInvalidoException;
import p2cg.jogos.Jogo;

public class Noob extends Usuario {
	
	private final static double DESCONTO = 0.1;

	public Noob(String nome, String login, double saldo) throws Exception {
		super(nome, login, saldo);
	}
	
	public void atualizaX2p(double precoDoJogo){
		
		int pontuacao = (int)(precoDoJogo * 10);
		pontuacao += this.getX2p();
		
		this.setX2p(pontuacao);
		
	}
	
	public double getDesconto(double valor){
		return valor - (valor * this.DESCONTO);
	}
	
	@Override
	public String toString(){
		String menssagem = this.getLogin() + "\n";
		menssagem += this.getNome() + " - Jogador Noob\n";
		menssagem += "Lista de Jogos:\n";
		
		double gastoTotal = 0;
		
		for (Jogo jogo : this.getJogosComprados()){
			menssagem += jogo;
			gastoTotal += jogo.getPreco();
		}
		
		menssagem += "Total de preco dos jogos: R$ " + gastoTotal + "\n";
		menssagem += "\n--------------------------------------------\n";
	
		return menssagem;
		
	}
	
	
}
