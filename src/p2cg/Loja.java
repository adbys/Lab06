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

	public void upgrade(String login) throws Exception {
		if (usuarios.containsKey(login)){
			Usuario usuario = usuarios.get(login);
			if (usuario instanceof Noob){
				if (usuario.getX2p() >= 1000){
					String nome = usuario.getNome();
					String novoLogin = login;
					int x2p = usuario.getX2p();
				
					usuarios.remove(login);
					Veterano contaUpgrade = new Veterano(nome, novoLogin);
					contaUpgrade.setX2p(x2p);
					
					usuarios.put(login, contaUpgrade);
				} else {
					throw new Exception("Usuario nao possui experiencia suficiente para fazer upgrade");					
				}
			} else {
				throw new Exception("Usuario nao eh noob.");
			}
		
		
		} else {
			throw new Exception("Login nao existe.");
		}
		
	}
	
}
