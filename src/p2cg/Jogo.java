package p2cg;

import java.util.HashSet;

public class Jogo {
	
	private String nome;
	private int highScore;
	private int jogadas;
	private int finalizado;
	private String categoria;
	private HashSet<String> jogabilidade;
	
	
	public Jogo(String nome, String categoria, HashSet<String> jogabilidade) throws Exception{
	
		this.testaConstrutor(nome, categoria);
		
		this.nome = nome;
		this.categoria = categoria;
//		this.jogabilidade = jogabilidade;
		this.highScore = 0;
		this.jogadas = 0;
		this.finalizado = 0;
		
	}

	public Jogo(String nome, String categoria) throws Exception{
		
		this.testaConstrutor(nome, categoria);
		
		this.nome = nome;
		this.categoria = categoria;
//		this.jogabilidade = new HashSet<String>();
		this.highScore = 0;
		this.jogadas = 0;
		this.finalizado = 0;
		
	}

	public String getNome(){
		return this.nome;
	}
	
	public String getCategoria(){
		return this.categoria;
	}
	
	public int getHighScore(){
		return this.highScore;
	}
	
	public void setHighScore(int score){
		this.highScore = score;
	}
	
	public int getJogadas(){
		return this.jogadas;
	}
	
	public int getFinalizado(){
		return this.finalizado;
	}
	
	public void setFinalizado(){
		this.finalizado++;
	}
	
	public HashSet<String> getJogabilidade(){
		return this.jogabilidade;
	}
	
	public void registraJogada(int score, boolean finished){
		
		if (finished == true){
			this.setFinalizado();
		}
		
		if (this.getHighScore() < score){
			this.setHighScore(score);
		}
		
	}

	private void testaConstrutor(String nome, String categoria) throws Exception{
		
		if (nome == null || "".equals(nome)){
			throw new Exception("Nome nao pode ser nulo ou vazio.");
		}
		
		if (categoria == null || categoria.equals("")){
			throw new Exception("Categoria nao pode ser nula ou vazia."); 
		}
		
		
	}

}
