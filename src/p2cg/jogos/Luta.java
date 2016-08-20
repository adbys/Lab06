//Adbys José Vasconcelos de Andrade - 116110498
package p2cg.jogos;

import java.util.HashSet;

import p2cg.Jogabilidade;
import p2cg.exceptions.PontuacaoInvalidaException;

public class Luta extends Jogo {


	public Luta(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception {
		super(nome, preco, jogabilidade);
	}
	
	public Luta(String nome, double preco) throws Exception {
		super(nome, preco);
	}
	
	public int registraJogada(int score, boolean zerou) throws Exception {
		
		this.testaPontuacaoInvalida(score);
		
		int x2p = 0;
		
		if (zerou){
			this.setFinalizado();
		}
		
		if (this.getHighScore() < score){
			x2p = score / 1000;
			this.setHighScore(score);
		}
		
		return x2p;
		
	}
	
	@Override
	public String toString(){
		String menssagem = "";
		
		menssagem += "+ " + this.getNome() + " - Luta: \n";
		menssagem += "==> Jogou " + this.getJogadas() + " vez(es)\n";
		menssagem += "==> Zerou " + this.getFinalizado()  + " vez(es)\n";
		menssagem += "==> Maior score: " + this.getHighScore() + "\n";
		
		return menssagem;
		
	}
	
	@Override
	protected void testaPontuacaoInvalida(int pontuacao) throws Exception{
		if (pontuacao < 0 || pontuacao > 100000){
			throw new PontuacaoInvalidaException("Pontuacao invalida");
		}
	}
	
	
}
