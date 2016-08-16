package p2cgtest;
import p2cg.*;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import p2cg.Jogo;

public class UsuarioTest {
	
	private Usuario usuario1;
	
	@Before
	public void criaUsuario(){
		
		try{
			usuario1 = new Usuario("Adbys", "adbys");
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			usuario1 = new Usuario("", "adbys");
		} catch (Exception e){
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
		try{
			usuario1 = new Usuario(null, "adbys");
		} catch (Exception e){
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}
		
	}

}
