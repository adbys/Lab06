//Adbys José Vasconcelos de Andrade - 116110498
package p2cgtest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import p2cg.jogos.Luta;
import p2cg.jogos.Plataforma;
import p2cg.jogos.Rpg;
import p2cg.usuarios.Noob;
import p2cg.usuarios.Veterano;

public class ToStringUsuarioEJogoTest {

	private Noob noob;
	private Veterano veterano;
	private Luta luta;
	private Plataforma plataforma;
	private Rpg rpg;
	
	@Before
	public void criaObjetos(){
		try{
			this.noob = new Noob("Noob", "noob", 100);
			this.veterano = new Veterano("Veterano", "veterano", 100);
			this.luta = new Luta("Luta", 10);
			this.plataforma = new Plataforma("Plataforma", 10);
			this.rpg = new Rpg("Rpg", 10);
		} catch (Exception e){
			System.out.println(e.getMessage());
			fail("Nao deveria lancar excecao");
		}
	}
	
	@Test
	public void testToString() throws IOException {
		try{
			this.noob.compraJogo(luta);
			this.noob.registraJogada("luta", 5000, true);
			this.noob.registraJogada("luta", 5000, true);
			this.noob.registraJogada("luta", 5000, true);
			this.noob.compraJogo(plataforma);
			this.noob.registraJogada("plataforma", 5000, true);
			this.noob.registraJogada("plataforma", 5000, true);
			this.noob.compraJogo(rpg);
			this.noob.registraJogada("rpg", 5000, true);
			this.veterano.compraJogo(luta);
			this.veterano.registraJogada("Luta", 5000, true);
			this.veterano.registraJogada("Luta", 5000, true);
			this.veterano.registraJogada("Luta", 5000, true);
			this.veterano.compraJogo(plataforma);
			this.veterano.registraJogada("Plataforma", 5000, true);
			this.veterano.registraJogada("Plataforma", 5000, true);
			this.veterano.compraJogo(rpg);
			this.veterano.registraJogada("Rpg", 5000, true);
		} catch (Exception e){
			fail("Nao deveria lancar excecao");
		}
		


	}
}
