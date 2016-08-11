package p2cgtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import p2cg.Jogo;

public class JogoTest {
	
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	private Jogo jogo4;
	private Jogo jogo5;
	
	@Before
	public void criaJogo(){
		
		try{
			jogo1 = new Jogo("Pokemon", "RPG");
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			jogo2 = new Jogo(null, "RPG");
		} catch (Exception e){
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			jogo3 = new Jogo("", "RPG");
		} catch (Exception e){
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			jogo4 = new Jogo("Pokemon", "");
		} catch (Exception e){
			assertEquals("Categoria nao pode ser nula ou vazia.", e.getMessage());
		}
		
		try{
			jogo3 = new Jogo("Pokemon", null);
		} catch (Exception e){
			assertEquals("Categoria nao pode ser nula ou vazia.", e.getMessage());
		}


	}

	@Test
	public void testConstrutor() {
		
		assertEquals("Nome do jogo esta errado.", "Pokemon", jogo1.getNome());
		assertEquals("Categoria do jogo esta errado.", "RPG", jogo1.getCategoria());
	}
	
	@Test
	public void testRegistraJogada(){
		
		jogo1.registraJogada(900, true);
		assertEquals("Quantidade de vezes finalizadas esta errada.", 1, jogo1.getFinalizado());
		assertEquals("HighScore esta errado.", 900, jogo1.getHighScore());
		
		jogo1.registraJogada(800, true);
		assertEquals("Quantidade de vezes finalizadas esta errada.", 2, jogo1.getFinalizado());
		assertEquals("HighScore esta errado.", 900, jogo1.getHighScore());
		
		jogo1.registraJogada(800, false);
		assertEquals("Quantidade de vezes finalizadas esta errada.", 2, jogo1.getFinalizado());
		assertEquals("HighScore esta errado.", 900, jogo1.getHighScore());
		
		jogo1.registraJogada(1100, true);
		assertEquals("Quantidade de vezes finalizadas esta errada.", 3, jogo1.getFinalizado());
		assertEquals("HighScore esta errado.", 1100, jogo1.getHighScore());
	}

}
