package p2cg;

import java.util.HashSet;

public class Jogo {
	
	private String nome;
	private int highScore;
	private int jogadas;
	private int finalizado;
	private String categoria;
	private HashSet<String> jogabilidade;
	
	
	public Jogo(String nome, String categoria, HashSet<String> jogabilidade){
		
		this.nome = nome;
		this.categoria = categoria;
		this.jogabilidade = jogabilidade;
		this.highScore = 0;
		this.jogadas = 0;
		this.finalizado = 0;
		
	}
	
	public String getName(){
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
	
	public int getPlayedTime(){
		return this.jogadas;
	}
	
	public int getFinished(){
		return this.finalizado;
	}
	
	public void setFinished(){
		this.finalizado++;
	}
	
	public HashSet<String> getJogabilidade(){
		return this.jogabilidade;
	}
	
	public void registraJogada(int score, boolean finished){
		
		if (finished == true){
			this.setFinished();
		}
		
		if (this.getHighScore() < score){
			this.setHighScore(score);
		}
		
	}

}
