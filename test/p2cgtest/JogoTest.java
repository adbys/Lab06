package p2cgtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import p2cg.Jogo;

public class JogoTest {
	
	private Jogo jogo1;
	private Jogo jogo2;

	
	@Before
	public void criaJogo(){
		
		try{
			jogo1 = new Jogo("Pokemon", "RPG", 10.2);
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
	}

	@Test
	public void testConstrutor() {
		
		try{
			jogo2 = new Jogo("Pokemon", "RPG", 10.2);
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			jogo2 = new Jogo(null, "RPG", 10.2);
		} catch (Exception e){
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			jogo2 = new Jogo("", "RPG", 10.2);
		} catch (Exception e){
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			jogo2 = new Jogo("Pokemon", "", 10.2);
		} catch (Exception e){
			assertEquals("Categoria nao pode ser nula ou vazia.", e.getMessage());
		}
		
		try{
			jogo2 = new Jogo("Pokemon", null, 10.2);
		} catch (Exception e){
			assertEquals("Categoria nao pode ser nula ou vazia.", e.getMessage());
		}
		
		try{
			jogo2 = new Jogo("Pokemon", "RPG", 0.0);
		} catch (Exception e){
			assertEquals("Preco nao pode ser menor ou igual a zero.", e.getMessage());
		}
		
		try{
			jogo2 = new Jogo("Pokemon", "RPG", -1);
		} catch (Exception e){
			assertEquals("Preco nao pode ser menor ou igual a zero.", e.getMessage());
		}


		
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
