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
	private String noobExpected = "";
	private String veteranoExpected = "";
	
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
		
		noobExpected += "noob\nNoob - Jogador Noob\nLista de Jogos:\n";
		noobExpected += "+ Luta - Luta:\n==> Jogou 0 vez(es)\n==> Zerou 3 vez(es)\n==> Maior score: 5000\n";
		noobExpected += "+ Plataforma - Plataforma:\n==> Jogou 0 vez(es)\n==> Zerou 2 vez(es)\n==> Maior score: 5000\n";
		noobExpected += "+ Rpg - RPG:\n==> Jogou 0 vez(es)\n==> Zerou 1 vez(es)\n==> Maior score: 5000\n";
		noobExpected += "Total de preco dos jogos: R$ 30.0\n\n--------------------------------------------\n";
		
		veteranoExpected += "veterano\nVeterano - Jogador Veterano\nLista de Jogos:\n";
		veteranoExpected += "+ Luta - Luta:\n==> Jogou 0 vez(es)\n==> Zerou 3 vez(es)\n==> Maior score: 5000\n";
		veteranoExpected += "+ Plataforma - Plataforma:\n==> Jogou 0 vez(es)\n==> Zerou 2 vez(es)\n==> Maior score: 5000\n";
		veteranoExpected += "+ Rpg - RPG:\n==> Jogou 0 vez(es)\n==> Zerou 1 vez(es)\n==> Maior score: 5000\n";
		veteranoExpected += "Total de preco dos jogos: R$ 30.0\n\n--------------------------------------------\n";

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
		

		assertEquals("ToString esta errado", noobExpected, noob.toString());
		assertEquals("ToString esta errado", veteranoExpected, veterano.toString());



	}
}
