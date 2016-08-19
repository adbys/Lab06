package p2cg.jogos;

import java.util.HashSet;

import p2cg.Jogabilidade;
import p2cg.exceptions.PontuacaoInvalidaException;
import p2cg.exceptions.PrecoInvalidoException;
import p2cg.exceptions.StringInvalidaException;

public abstract class Jogo {
	
	private String nome;
	private double preco;
	private HashSet<Jogabilidade> jogabilidade;
	private int highScore;
	private int jogadas;
	private int finalizado;

	
	
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception{
		
		this.testaConstrutor(nome, preco);
		
		this.nome = nome;
		this.preco = preco;
		this.jogabilidade = jogabilidade;
		this.highScore = 0;
		this.jogadas = 0;
		this.finalizado = 0;
		
	}
	
	public Jogo(String nome, double preco) throws Exception{
		
		this.testaConstrutor(nome, preco);
		
		this.nome = nome;
		this.preco = preco;
		this.jogabilidade = new HashSet<Jogabilidade>();
		this.highScore = 0;
		this.jogadas = 0;
		this.finalizado = 0;
		
	}
	
	public abstract int registraJogada(int score, boolean zerou) throws Exception;
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public double getPreco(){
		return this.preco;
	}
	
	public void setPreco(double preco){
		this.preco = preco;
	}
	
	public HashSet<Jogabilidade> getJogabilidade(){
		return this.jogabilidade;
	}
	
	public void setJogabilidade(HashSet<Jogabilidade> jogabilidades){
		this.jogabilidade.addAll(jogabilidades);
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
	
	public void setJogadas(int jogadas){
		this.jogadas = jogadas;
	}
	
	public int getFinalizado(){
		return this.finalizado;
	}
	
	public void setFinalizado(){
		this.finalizado++;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Jogo){
			Jogo novoJogo = (Jogo)objeto;
			if (this.getNome().equals(novoJogo.getNome())){
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
			

	}

	protected void testaPontuacaoInvalida(int pontuacao) throws Exception{
		if (pontuacao < 0){
			throw new PontuacaoInvalidaException("Pontuacao invalida");
		}
	}
	
	private void testaConstrutor(String nome, double preco) throws Exception{
		
		if (nome == null || "".equals(nome)){
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		
		if (preco <= 0){
			throw new PrecoInvalidoException("Preco nao pode ser menor ou igual a zero.");
		}
	}


}

