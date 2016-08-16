package p2cg;

import java.util.HashSet;

public class Luta extends Jogo {


	public Luta(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception {
		super(nome, preco, jogabilidade);
	}
	
	public int registraJogada(int score, boolean zerou){
		
		int x2p = 0;
		
		if (zerou == true){
			this.setFinalizado();
		}
		
		if (this.getHighScore() < score){
			x2p = score / 1000;
			this.setHighScore(score);
		}
		
		return x2p;
		
	}
	
	
}
