package p2cg;

public class Noob extends Usuario {

	public Noob(String nome, String login) throws Exception {
		super(nome, login);
	}
	
	public double compraJogo(Jogo jogo){
		
		double novoPreco = jogo.getPreco() - (jogo.getPreco() * 0.1);
		return novoPreco;
		
	}
	
	public void atualizaX2p(double precoDoJogo){
		
		int pontuacao = (int)(this.getX2p() + precoDoJogo * 10);
		
		this.setX2p(pontuacao);
		
	}
	

}
