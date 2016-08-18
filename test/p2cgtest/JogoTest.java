package p2cgtest;
import p2cg.Jogabilidade;
import p2cg.jogos.Luta;
import p2cg.jogos.Plataforma;
import p2cg.jogos.Rpg;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class JogoTest {
	
	private Rpg pokemon;
	private Plataforma mario;
	private Luta injustice;
	HashSet<Jogabilidade> jogabilidade = new HashSet<Jogabilidade>();

	
	@Before
	public void criaJogo(){
		
		try{
			pokemon = new Rpg("Pokemon", 10.2, jogabilidade);
			mario = new Plataforma("Mario", 50.2, jogabilidade);
			injustice = new Luta("injustice", 56.2, jogabilidade);
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		
	}

	@Test
	public void testConstrutor() {
		
		try{
			mario = new Plataforma("Mario", 10.2, jogabilidade);
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			mario = new Plataforma(null, 10.2, jogabilidade);
		} catch (Exception e){
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			mario = new Plataforma("", 10.2, jogabilidade);
		} catch (Exception e){
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
				
		try{
			mario = new Plataforma("Mario", 0.0, jogabilidade);
		} catch (Exception e){
			assertEquals("Preco nao pode ser menor ou igual a zero.", e.getMessage());
		}
		
		try{
			mario = new Plataforma("Mario", -1, jogabilidade);
		} catch (Exception e){
			assertEquals("Preco nao pode ser menor ou igual a zero.", e.getMessage());
		}


		
		assertEquals("Nome do jogo esta errado.", "Mario", mario.getNome());

	}
	
	@Test
	public void testRegistraJogadaRpg(){
		
		assertEquals("Quantidade de x2p ganho esta errada.", 10, pokemon.registraJogada(900, true));
		assertEquals("Quantidade de vezes finalizadas esta errada.", 1, pokemon.getFinalizado());
		assertEquals("HighScore esta errado.", 900, pokemon.getHighScore());
		
		assertEquals("Quantidade de x2p ganho esta errada.", 10, pokemon.registraJogada(900, true));
		assertEquals("Quantidade de vezes finalizadas esta errada.", 2, pokemon.getFinalizado());
		assertEquals("HighScore esta errado.", 900, pokemon.getHighScore());
		
		assertEquals("Quantidade de x2p ganho esta errada.", 10,pokemon.registraJogada(800, false));
		assertEquals("Quantidade de vezes finalizadas esta errada.", 2, pokemon.getFinalizado());
		assertEquals("HighScore esta errado.", 900, pokemon.getHighScore());
		
		assertEquals("Quantidade de x2p ganho esta errada.", 10,pokemon.registraJogada(1100, true));
		assertEquals("Quantidade de vezes finalizadas esta errada.", 3, pokemon.getFinalizado());
		assertEquals("HighScore esta errado.", 1100, pokemon.getHighScore());
	}
	
	@Test
	public void testRegistraJogadaLuta(){
		
		//TODO: terminar a implementação.
		
		assertEquals("Quantidade de x2p ganho esta errada.", 9, injustice.registraJogada(9000, true));
		assertEquals("Quantidade de vezes finalizadas esta errada.", 1, injustice.getFinalizado());
		assertEquals("HighScore esta errado.", 9000, injustice.getHighScore());
		
		assertEquals("Quantidade de x2p ganho esta errada.", 0, injustice.registraJogada(8000, true));
		assertEquals("Quantidade de vezes finalizadas esta errada.", 2, injustice.getFinalizado());
		assertEquals("HighScore esta errado.", 9000, injustice.getHighScore());
		
		assertEquals("Quantidade de x2p ganho esta errada.", 10, injustice.registraJogada(10000, false));
		assertEquals("Quantidade de vezes finalizadas esta errada.", 2, injustice.getFinalizado());
		assertEquals("HighScore esta errado.", 10000, injustice.getHighScore());
		
//		assertEquals("Quantidade de x2p ganho esta errada.", 10,pokemon.registraJogada(1100, true));
//		assertEquals("Quantidade de vezes finalizadas esta errada.", 3, pokemon.getFinalizado());
//		assertEquals("HighScore esta errado.", 1100, pokemon.getHighScore());
	}


}
