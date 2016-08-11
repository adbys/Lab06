package p2cg;

public class Noob extends Usuario {

	public Noob(String nome, String login) throws Exception {
		super(nome, login);
	}
	
	public double compraJogo(Jogo jogo){
		
		double novoPreco = jogo.getPreco() - (jogo.getPreco() * 0.1);
		return novoPreco;
		
	}
	
	public void atualizaX2p(double valorGasto) {
		//TODO: Implementaition unfinished
		
		double novoX2p = this.getX2p() + valorGasto * 10;
		
		
	}
	

}
