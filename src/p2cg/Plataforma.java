package p2cg;

import java.util.HashSet;

public class Plataforma extends Jogo {
	
	public Plataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception {
		super(nome, preco, jogabilidade);
	}
	
	public int registraJogada(int score, boolean zerou){
		
		int x2p = 0;
		
		if (zerou == true){
			x2p = 20;
			this.setFinalizado();
		}
		
		if (this.getHighScore() < score){
			this.setHighScore(score);
		}
		
		return x2p;
		
	}

}
