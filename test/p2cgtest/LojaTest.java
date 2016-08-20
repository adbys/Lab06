//Adbys José Vasconcelos de Andrade - 116110498
package p2cgtest;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import p2cg.Jogabilidade;
import p2cg.Loja;
import p2cg.jogos.Luta;
import p2cg.jogos.Plataforma;
import p2cg.jogos.Rpg;
import p2cg.usuarios.Noob;
import p2cg.usuarios.Usuario;
import p2cg.usuarios.Veterano;

public class LojaTest {
	
	private Loja loja;
	private Rpg pokemon;
	private Plataforma mario;
	private Luta injustice;
	private Noob usuarioNoob;
	private Veterano usuarioVeterano;
	HashSet<Jogabilidade> jogabilidade = new HashSet<Jogabilidade>();
	
	
	

	@Before
	public void criaObejtos() {
		try{
			this.loja = new Loja();
			loja.adicionaUsuarioNoob("jose", "Jose", 10);
			loja.adicionaUsuarioVeterano("joao", "Joao", 50);
			loja.adicionaUsuarioNoob("joaquim", "Joaquim", 50);
			loja.criaJogoLuta("Injustice", 10, jogabilidade);
			loja.criaJogoPlataforma("Mario", 10, jogabilidade);
			loja.criaJogoRpg("Pokemon", 10, jogabilidade);
			loja.criaJogoLuta("MortalKombat", 100, jogabilidade);
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
			
			
	}
	
	@Test
	public void testaAdicionaUsuarioNoob(){
		
		try{
			loja.adicionaUsuarioNoob("jose1", "Jose", 10);
			loja.adicionaUsuarioVeterano("joao1", "Joao", 50);
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			loja.adicionaUsuarioNoob("jose", "Joaquim", 0);
		} catch (Exception e){
			assertEquals("Login ja existente.", e.getMessage());
		}
		
		try{
			loja.adicionaUsuarioVeterano("joao", "Joaquim", 0);
		} catch (Exception e){
			assertEquals("Login ja existente.", e.getMessage());
		}		
	}
	
	@Test
	public void testaAdicionaDinheiro(){
		try{
			loja.adicionaDinheiro("jose", 50);
			loja.adicionaDinheiro("joao", 10);
			assertEquals(60, loja.getUsuario("jose").getSaldo(), 0.001);
			assertEquals(60, loja.getUsuario("joao").getSaldo(), 0.001);
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			loja.adicionaDinheiro("jose", -10);
		} catch (Exception e){
			assertEquals("Nao pode adicionar saldo menor ou igual a zero", e.getMessage());
		}
		
		try{
			loja.adicionaDinheiro("danilo", 100);
		} catch (Exception e){
			assertEquals("Nao foi possivel localizar login.", e.getMessage());
		}
	}
	
	@Test
	public void testaVendeJogo(){
		try{
			loja.vendeJogo("Pokemon", "jose");
			loja.vendeJogo("Mario", "joao");
		} catch (Exception e){
			System.out.println(e.getMessage());
			fail("Nao deveria lancar excecao");
		}
		
		try{
			loja.vendeJogo("Batman", "jose");
		} catch (Exception e){
			assertEquals("Jogo nao existe", e.getMessage());
		}
		
		try{
			loja.vendeJogo("MortalKombat", "joao");
		} catch (Exception e){
			assertEquals("Saldo Insuficiente", e.getMessage());
		}
		
		try{
			loja.vendeJogo("Mario", "jose3");
		} catch (Exception e){
			assertEquals("Nao foi possivel localizar login.", e.getMessage());
		}
	}
	
	@Test
	public void testaUpgrade(){
		
		try {
			loja.getUsuario("jose").ganhaX2p(1000);
			loja.getUsuario("joaquim").ganhaX2p(500);
			assertEquals(1000, loja.getUsuario("jose").getX2p());
			assertEquals(500, loja.getUsuario("joaquim").getX2p());
		} catch (Exception e) {
			fail("Nao deveria lancar excecao");
		}
		
		try{
			assertFalse(loja.getUsuario("jose") instanceof Veterano);
			assert(loja.getUsuario("jose") instanceof Noob);
			loja.upgrade("jose");
			assert(loja.getUsuario("jose") instanceof Veterano);
			assertEquals(2000, loja.getUsuario("jose").getX2p());
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			loja.upgrade("joaquim");			
		} catch (Exception e){
			assertEquals("Usuario nao possui experiencia suficiente para fazer upgrade", e.getMessage());
		}
		
		try{
			loja.upgrade("joao");
		} catch (Exception e){
			assertEquals("Usuario nao eh noob.", e.getMessage());
		}
		
	}

}
