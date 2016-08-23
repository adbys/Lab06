package p2cgtest;

import java.util.HashSet;

import p2cg.Jogabilidade;
import p2cg.jogos.Jogo;

public class JogoSupport extends Jogo {
	
	public JogoSupport(String nome, double preco) throws Exception{
		
		super(nome, preco);

	}
	
	public JogoSupport(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception{
		
		super(nome, preco, jogabilidade);

	}

	@Override
	public int registraJogada(int score, boolean zerou) throws Exception {
		return 0;
	}

}