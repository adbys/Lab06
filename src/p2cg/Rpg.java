package p2cg;

import java.util.HashSet;

public class Rpg extends Jogo {

	public Rpg(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception {
		super(nome, preco, jogabilidade);
	}
	
	public int registraJogada(int score, boolean zerou){
		
		int x2p = 10;
		
		if (zerou == true){
			this.setFinalizado();
		}
		
		if (this.getHighScore() < score){
			this.setHighScore(score);
		}
		
		return x2p;
		
	}
	
	

}
