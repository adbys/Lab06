package p2cg;

public class Veterano extends Usuario {
	
	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
		this.setX2p(1000);
	}
	
	public double compraJogo(Jogo jogo){
		
		double novoPreco = jogo.getPreco() - (jogo.getPreco() * 0.2);
		return novoPreco;
		
	}
	
	

}