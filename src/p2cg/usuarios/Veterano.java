package p2cg.usuarios;

import p2cg.jogos.Jogo;

public class Veterano extends Usuario {
	
	private final static double DESCONTO = 0.2; 
	
	public Veterano(String nome, String login, double saldo) throws Exception {
		super(nome, login, saldo);
		this.setX2p(1000);
	}
	
	public double getDesconto(double valor){
		return valor - (valor * this.DESCONTO);
	}
	
	public void compraJogo(Jogo jogo) throws Exception {
		if (this.getSaldo() < this.getDesconto(jogo.getPreco())){
			throw new Exception("Saldo Invalido");
		} else {
			this.atualizaX2p(jogo.getPreco());
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
