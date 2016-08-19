package p2cg.usuarios;

import java.util.HashSet;

import p2cg.exceptions.SaldoInvalidoException;
import p2cg.exceptions.StringInvalidaException;
import p2cg.jogos.Jogo;

public abstract class Usuario {
	
	private String nome;
	private String login;
	private HashSet<Jogo> jogosComprados;
	private double saldo;
	private int x2p;
	
	public Usuario(String nome, String login, double saldo) throws Exception {
		
		this.testaConstrutor(nome, saldo);
		
		this.nome = nome;
		this.login = login;
		this.saldo = saldo;
		this.jogosComprados = new HashSet<Jogo>();
		this.x2p = 0;
		
	}
	
	public abstract void compraJogo(Jogo jogo) throws Exception;
	
	public abstract void atualizaX2p(double precoDoJogo);
	
	public abstract double getDesconto(double valor);
	
	public int getX2p(){
		return this.x2p;
	}
	
	public void setX2p(int x2p){
		this.x2p = x2p;
	}
	
	public void ganhaX2p(int x2p){
		this.x2p += x2p;
	}

	public HashSet<Jogo> getJogos(){
		return this.jogosComprados;
	}
	
	public void setJogos(HashSet<Jogo> jogos){
		this.jogosComprados.addAll(jogos);
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public void setSaldo(double saldo){
		this.saldo = saldo;
	}
	
	protected void adicionaJogo(Jogo jogo){
		this.jogosComprados.add(jogo);
	}
	
	public HashSet<Jogo> getJogosComprados(){
		return this.jogosComprados;		
	}
	
	public void adicionaDinheiro(double quantidade){
		this.saldo += quantidade;
	}

	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws Exception{
		
		int x2p = 0; 
		
		for(Jogo jogo : this.jogosComprados){
			
			if (nomeDoJogo.equals(jogo.getNome())){
				x2p = jogo.registraJogada(score, zerou);
			}
			
		}
		
		this.setX2p(x2p + this.getX2p());
		
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
	
	private void testaConstrutor(String nome, double saldo) throws Exception {
		
		if (nome == null || "".equals(nome)){
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		
		if (saldo < 0){
			throw new SaldoInvalidoException("Saldo nao pode ser menor que zero");
		}
		
	}
	
	
}
