package p2cgtest;

import java.util.HashSet;

import p2cg.jogos.Jogo;
import p2cg.usuarios.Usuario;

public class UsuarioSupport extends Usuario {
	
	public UsuarioSupport(String nome, String login, double saldo) throws Exception {
	
		super(nome, login, saldo);
		
	}

	@Override
	public void atualizaX2p(double precoDoJogo) {

		
	}

	@Override
	public double getDesconto(double valor) {

		return 0;
	}
	

}
