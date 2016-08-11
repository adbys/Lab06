package p2cg;


public class Jogo {
	
	private String nome;
	private double preco;
	private int highScore;
	private int jogadas;
	private int finalizado;
	private String categoria;
	
	
	public Jogo(String nome, String categoria, double preco) throws Exception{
		
		this.testaConstrutor(nome, categoria, preco);
		
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
//		this.jogabilidade = new HashSet<String>();
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
	
//	public HashSet<String> getJogabilidade(){
//		return this.jogabilidade;
//	}
	
	public void registraJogada(int score, boolean finished){
		
		if (finished == true){
			this.setFinalizado();
		}
		
		if (this.getHighScore() < score){
			this.setHighScore(score);
		}
		
	}

	private void testaConstrutor(String nome, String categoria, double preco) throws Exception{
		
		if (nome == null || "".equals(nome)){
			throw new Exception("Nome nao pode ser nulo ou vazio.");
		}
		
		if (categoria == null || categoria.equals("")){
			throw new Exception("Categoria nao pode ser nula ou vazia."); 
		}
		
		if (preco <= 0){
			throw new Exception("Preco nao pode ser menor ou igual a zero.");
		}
		
		
	}

}
