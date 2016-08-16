package p2cg;

public class Noob extends Usuario {

	public Noob(String nome, String login) throws Exception {
		super(nome, login);
	}
	
	public double getDesconto(double valor){
		return valor - (valor * 0.1);
	}
	
	public void compraJogo(Jogo jogo) throws Exception {
		if (this.getSaldo() < this.getDesconto(jogo.getPreco())){
			throw new Exception("Saldo Invalido");
		} else {
			double novoSaldo = this.getSaldo() - this.getDesconto(jogo.getPreco());
			this.setSaldo(novoSaldo);
			this.adicionaJogo(jogo);
		}
		
	}
	
	public void atualizaX2p(double precoDoJogo){
		
		int pontuacao = (int)(this.getX2p() + precoDoJogo * 10);
		
		this.setX2p(pontuacao);
		
	}
	

}
