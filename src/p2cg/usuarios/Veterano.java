//Adbys José Vasconcelos de Andrade - 116110498
package p2cg.usuarios;

import java.util.HashSet;

import p2cg.exceptions.SaldoInvalidoException;
import p2cg.jogos.Jogo;

public class Veterano extends Usuario {
	
	private final static double DESCONTO = 0.2; 
	
	public Veterano(String nome, String login, double saldo) throws Exception {
		super(nome, login, saldo);
		this.setX2p(1000);
	}
	
	public void compraJogo(Jogo jogo) throws Exception {
		if (this.getSaldo() < this.getDesconto(jogo.getPreco())){
			throw new SaldoInvalidoException("Saldo Insuficiente");
		} else {
			this.atualizaX2p(jogo.getPreco());
			double novoSaldo = this.getSaldo() - this.getDesconto(jogo.getPreco());
			this.setSaldo(novoSaldo);
			this.adicionaJogo(jogo);
		}
		
	}
	
	public void atualizaX2p(double precoDoJogo){
		
		int pontuacao = (int)(this.getX2p() + precoDoJogo * 15);
		
		this.setX2p(pontuacao);
		
	}
	
	public double getDesconto(double valor){
		return valor - (valor * this.DESCONTO);
	}
	
	@Override
	public String toString(){
		String menssagem = this.getLogin() + "\n";
		menssagem += this.getNome() + " - Jogador Veterano \n";
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
