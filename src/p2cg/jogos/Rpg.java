package p2cg.jogos;

import java.util.HashSet;

import p2cg.Jogabilidade;

public class Rpg extends Jogo {

	public Rpg(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception {
		super(nome, preco, jogabilidade);
	}
	
	public int registraJogada(int score, boolean zerou) throws Exception{
		
		this.testaPontuacaoNegativa(score);
		
		int x2p = 10;
		
		if (zerou){
			this.setFinalizado();
		}
		
		if (this.getHighScore() < score){
			this.setHighScore(score);
		}
		
		return x2p;
		
	}
	
	@Override
	public String toString(){
		String menssagem = "";
		
		menssagem += "+ " + this.getNome() + " - RPG: \n";
		menssagem += "==> Jogou " + this.getJogadas() + "vez(es)\n";
		menssagem += "==> Zerou " + this.getFinalizado()  + "vez(es)\n";
		menssagem += "==> Maior score: " + this.getHighScore() + "\n";
		
		return menssagem;
		
	}
	
	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Rpg){
			Rpg novoJogo = (Rpg)objeto;
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
