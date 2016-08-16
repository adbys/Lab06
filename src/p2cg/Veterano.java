package p2cg;

public class Veterano extends Usuario {
	
	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
		this.setX2p(1000);
	}
	
	public double getDesconto(double valor){
		return valor - (valor * 0.2);
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
		
		int pontuacao = (int)(this.getX2p() + precoDoJogo * 15);
		
		this.setX2p(pontuacao);
		
	}
	
	

}
