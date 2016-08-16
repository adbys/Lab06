package p2cg;

import java.util.HashSet;

public class Jogo {
	
	private String nome;
	private double preco;
	private HashSet<Jogabilidade> jogabilidade;
	private int highScore;
	private int jogadas;
	private int finalizado;
	private String categoria;
	
	
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception{
		
		this.testaConstrutor(nome, preco);
		
		this.nome = nome;
		this.preco = preco;
		this.jogabilidade = new HashSet<Jogabilidade>(jogabilidade);
		this.highScore = 0;
		this.jogadas = 0;
		this.finalizado = 0;
		
	}

	public String getNome(){
		return this.nome;
	}
	
	public double getPreco(){
		return this.preco;
	}
	
	public HashSet<Jogabilidade> getJogabilidade(){
		return this.jogabilidade;
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
		
	public int registraJogada(int score, boolean zerou){
		
		if (zerou == true){
			this.setFinalizado();
		}
		
		if (this.getHighScore() < score){
			this.setHighScore(score);
		}
		
		return 0;
		
	}

	private void testaConstrutor(String nome, double preco) throws Exception{
		
		if (nome == null || "".equals(nome)){
			throw new Exception("Nome nao pode ser nulo ou vazio.");
		}
		
		if (preco <= 0){
			throw new Exception("Preco nao pode ser menor ou igual a zero.");
		}
	}
	
	@Override
	public String toString(){
		String menssagem = "";
		
		menssagem += "+ " + this.getNome() + " - Jogo: \n";
		menssagem += "==> Jogou " + this.getJogadas() + "vez(es)\n";
		menssagem += "==> Zerou " + this.getFinalizado()  + "vez(es)\n";
		menssagem += "==> Maior score: " + this.getHighScore() + "\n";
		
		return menssagem;
		
	}

}
