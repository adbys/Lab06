package p2cgtest;

import static org.junit.Assert.*;

import org.junit.Test;

import p2cg.Usuario;
import p2cg.Noob;
import p2cg.Veterano;

public class UsuarioTest {
	
	private Usuario usuario;
	private Noob usuarioNoob;
	private Veterano usuarioVeterano;

	@Test
	public void testConstrutor() {
		
		try{
			usuario = new Usuario("Adbys", "adbys");
		} catch (Exception e) {
			fail("Nao deveria ter lancado excecao.");
		}
		
		try{
			usuario = new Usuario("", "adbys");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			usuario = new Usuario(null, "adbys");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			usuarioNoob = new Noob("Adbys", "adbys");
		} catch (Exception e) {
			fail("Nao deveria ter lancado excecao.");
		}
		
		try{
			usuarioNoob = new Noob("", "adbys");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			usuarioNoob = new Noob(null, "adbys");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			usuarioVeterano = new Veterano("Adbys", "adbys");
		} catch (Exception e) {
			fail("Nao deveria ter lancado excecao.");
		}
		
		try{
			usuarioVeterano = new Veterano("", "adbys");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			usuarioVeterano = new Veterano(null, "adbys");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
	}

}
