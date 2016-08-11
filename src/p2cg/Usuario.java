package p2cg;

import java.util.HashSet;

public class Usuario {
	
	private String nome;
	private String login;
	private HashSet<Jogo> jogosComprados;
	private double saldo;
	private int x2p;
	
	public Usuario(String nome, String login) throws Exception {
		
		this.testaConstrutor(nome, login);
		
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
	
	public HashSet<Jogo> getJogosComprados(){
		return this.jogosComprados;		
	}
	
	public void adicionaDinheiro(double quantidade){
		this.saldo =+ quantidade;
	}
	
	private void testaConstrutor(String nome, String login) throws Exception {
		
		if (nome == null || "".equals(nome)){
			throw new Exception("Nome nao pode ser nulo ou vazio.");
		}
		
		if (login == null || login.equals("")){
			throw new Exception("Login nao pode ser nulo ou vazio."); 
		}
		
		
		
	}

}
