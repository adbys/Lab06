package p2cg;

import java.util.HashMap;

public class Loja {
	
	private HashMap<String, Usuario> usuarios;
	
	public Loja(){
		this.usuarios = new HashMap<String, Usuario>();
	}
	
	public void adicionaUsuario(String login, String nome) throws Exception{
		if (!usuarios.containsKey(login)){
			Usuario usuario = new Usuario(nome, login);
			usuarios.put(login, usuario);
		} else {
			throw new Exception("Login ja existente.");
		}
	}
	
	public void adicionaDinheiro(String login, double valor) throws Exception {
		if (usuarios.containsKey(login)){
			usuarios.get(login).adicionaDinheiro(valor);
		} else {
			throw new Exception("Nao foi possivel localizar login.");
		}
	}
	
	public void vendeJogo(Jogo jogo, String login) throws Exception {
		if (usuarios.containsKey(login)){
			usuarios.get(login).compraJogo(jogo);
		} else {
			throw new Exception("Nao foi possivel localizar login.");
		}
	}

}
