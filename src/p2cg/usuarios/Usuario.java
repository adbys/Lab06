package p2cg.usuarios;

import java.util.HashSet;

import p2cg.jogos.Jogo;

public abstract class Usuario {
	
	private String nome;
	private String login;
	private HashSet<Jogo> jogosComprados;
	private double saldo;
	private int x2p;
	
	public Usuario(String nome, String login) throws Exception {
		
		this.testaConstrutor(nome);
		
		this.nome = nome;
		this.login = login;
		this.saldo = 0.0;
		this.jogosComprados = new HashSet<Jogo>();
		this.x2p = 0;
		
	}
	
	public int getX2p(){
		return this.x2p;
	}
	
	public void setX2p(int pontuacao){
		this.x2p += pontuacao;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	protected void setSaldo(double saldo){
		this.saldo = saldo;
	}
	
	protected void adicionaJogo(Jogo jogo){
		this.jogosComprados.add(jogo);
	}
	
	public HashSet<Jogo> getJogosComprados(){
		return this.jogosComprados;		
	}
	
	public void adicionaDinheiro(double quantidade){
		this.saldo =+ quantidade;
	}
	
	private void testaConstrutor(String nome) throws Exception {
		
		if (nome == null || "".equals(nome)){
			throw new Exception("Nome nao pode ser nulo ou vazio.");
		}
		
	}
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou){
		
		int x2p = 0; 
		
		for(Jogo jogo : this.jogosComprados){
			
			if (nomeDoJogo.equals(jogo.getNome())){
				x2p = jogo.registraJogada(score, zerou);
			}
			
		}
		
		this.setX2p(x2p);
		
	}

	public abstract void compraJogo(Jogo jogo) throws Exception;
	
	public abstract void atualizaX2p(double precoDoJogo);
	
	public abstract double getDesconto(double valor);
	
	@Override
	public String toString(){
		String menssagem = this.getLogin() + "\n";
		menssagem += this.getNome() + " - Jogador \n";
		menssagem += "Lista de Jogos:\n";
		
		double gastoTotal = 0;
		
		for (Jogo jogo : this.jogosComprados){
			menssagem += jogo;
			gastoTotal += jogo.getPreco();
		}
		
		menssagem += "Total de preco dos jogos: R$ \n" + gastoTotal;
		menssagem += "\n--------------------------------------------\n";
	
		return menssagem;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Usuario){
			Usuario novoUsuario = (Usuario)objeto;
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
