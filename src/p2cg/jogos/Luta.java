package p2cg.jogos;

import java.util.HashSet;

import p2cg.Jogabilidade;

public class Luta extends Jogo {


	public Luta(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception {
		super(nome, preco, jogabilidade);
	}
	
	public int registraJogada(int score, boolean zerou){
		
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
		menssagem += "==> Jogou " + this.getJogadas() + "vez(es)\n";
		menssagem += "==> Zerou " + this.getFinalizado()  + "vez(es)\n";
		menssagem += "==> Maior score: " + this.getHighScore() + "\n";
		
		return menssagem;
		
	}
	
	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Luta){
			Luta novoJogo = (Luta)objeto;
			if (this.getNome().equals(novoJogo.getNome())){
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
			

	}
	
}
