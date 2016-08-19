package p2cg;

import java.util.HashMap;
import java.util.HashSet;

import p2cg.jogos.*;
import p2cg.usuarios.*;


public class Loja {
	
	private HashMap<String, Usuario> usuarios;
	private HashSet<Jogo> jogos;
	
	public Loja(){
		this.usuarios = new HashMap<String, Usuario>();
	}
	
	public void adicionaUsuarioNoob(String login, String nome, double saldo) throws Exception{
		if (!usuarios.containsKey(login)){
			Noob usuario = new Noob(nome, login, saldo);
			usuarios.put(login, usuario);
		} else {
			throw new Exception("Login ja existente.");
		}
	}
	
	public void adicionaUsuarioVeterano(String login, String nome, double saldo) throws Exception{
		if (!usuarios.containsKey(login)){
			Veterano usuario = new Veterano(nome, login, saldo);
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
	
	public void vendeJogo(String nomeJogo, String login) throws Exception {
		if (usuarios.containsKey(login)){
			for (Jogo jogo : this.jogos){
				if (nomeJogo.equalsIgnoreCase(jogo.getNome())){
					this.usuarios.get(login).compraJogo(jogo);
				}
			}
			throw new Exception("Jogo nao existe");
			
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
					HashSet<Jogo> jogos = usuario.getJogosComprados();
					int x2p = usuario.getX2p();
					double saldo = usuario.getSaldo();
					usuarios.remove(login);
					
					Veterano contaUpgrade = new Veterano(nome, login, saldo);
					contaUpgrade.setX2p(x2p);
					contaUpgrade.transfereJogos(jogos);
					
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

	public void criaJogoRpg(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws Exception{
		
		Rpg jogo = new Rpg(nome, preco, jogabilidades);
		this.jogos.add(jogo);
		
	}
	
	public void criaJogoLuta(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws Exception{
		
		Luta jogo = new Luta(nome, preco, jogabilidades);
		this.jogos.add(jogo);
		
	}
	
	public void criaJogoPlataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws Exception{
		
		Plataforma jogo = new Plataforma(nome, preco, jogabilidades);
		this.jogos.add(jogo);
		
	}
		
		
	
}
