package p2cgtest;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import p2cg.Jogabilidade;
import p2cg.jogos.Luta;
import p2cg.jogos.Plataforma;
import p2cg.jogos.Rpg;
import p2cg.usuarios.Noob;
import p2cg.usuarios.Usuario;
import p2cg.usuarios.Veterano;

public class UsuarioTest {
	HashSet<Jogabilidade> jogabilidade = new HashSet<Jogabilidade>();
	
	private Noob usuarioNoob;
	private Veterano usuarioVeterano;
	private Rpg pokemon;
	private Plataforma mario;
	private Luta injustice;


	@Before
	public void criaUsuario(){
	
		try{
			usuarioNoob = new Noob("Jose", "jose", 25);
			usuarioVeterano = new Veterano("Joao", "joao", 10);
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{ 
			pokemon = new Rpg("Pokemon", 10, jogabilidade); 
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			mario = new Plataforma("Mario", 10, jogabilidade);
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			injustice = new Luta("Injustice", 10, jogabilidade);
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
	}
	
	
	@Test
	public void testConstrutor() {
		
		try{
			usuarioNoob = new Noob("Jose", "jose", -1);
		} catch (Exception e) {
			assertEquals("Saldo nao pode ser menor que zero", e.getMessage());
		}
		
		try{
			usuarioNoob = new Noob("", "jose", 0);
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			usuarioNoob = new Noob(null, "jose", 0);
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			usuarioVeterano = new Veterano("", "jose", 0);
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			usuarioVeterano = new Veterano(null, "jose", 0);
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
	}

	
	@Test
	public void testCompraJogo() {

		
		
		usuarioNoob.adicionaDinheiro(10);
		assertEquals(35, usuarioNoob.getSaldo(), 0.001);
		
		try{
			usuarioNoob.compraJogo(mario);
			assertEquals(26, usuarioNoob.getSaldo(), 0.001);
			assertEquals(100, usuarioNoob.getX2p());
			usuarioVeterano.compraJogo(mario);
			assertEquals(2, usuarioVeterano.getSaldo(), 0.001);
			assertEquals(1150, usuarioVeterano.getX2p());
			usuarioNoob.compraJogo(injustice);
			assertEquals(17, usuarioNoob.getSaldo(), 0.001);
			assertEquals(200, usuarioNoob.getX2p());
			usuarioNoob.compraJogo(pokemon);
			assertEquals(8, usuarioNoob.getSaldo(), 0.001);
			assertEquals(300, usuarioNoob.getX2p());
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			usuarioVeterano.compraJogo(injustice);
		} catch (Exception e){
			assertEquals("Saldo Invalido", e.getMessage());
		}
		
		try{
			usuarioNoob.registraJogada("Pokemon", 50, true);
			assertEquals(310, usuarioNoob.getX2p());
			usuarioNoob.registraJogada("Injustice", 50000, true);
			assertEquals(360, usuarioNoob.getX2p());
			usuarioNoob.registraJogada("Mario", 50000, true);
			assertEquals(380, usuarioNoob.getX2p());
		} catch(Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			usuarioNoob.registraJogada("Need for Speed", 50000, true);
		} catch (Exception e){
			assertEquals("Jogo nao encontrado", e.getMessage());
		}
		
	}
	
}
