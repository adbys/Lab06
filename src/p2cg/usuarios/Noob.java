package p2cg.usuarios;

import p2cg.jogos.Jogo;

public class Noob extends Usuario {
	
	private final static double DESCONTO = 0.1;

	public Noob(String nome, String login) throws Exception {
		super(nome, login);
	}
	
	public double getDesconto(double valor){
		return valor - (valor * this.DESCONTO);
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
	
	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Noob){
			Noob novoUsuario = (Noob)objeto;
			if (this.getNome().equals(novoUsuario.getNome())){
				if (this.getLogin().equals(novoUsuario.getLogin())){
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}
	
	

}
