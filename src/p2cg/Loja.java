package p2cg;

import java.util.HashMap;
import java.util.HashSet;

import p2cg.exceptions.ExperienciaInvalidaException;
import p2cg.exceptions.JogoInvalidoException;
import p2cg.exceptions.LoginInvalidoException;
import p2cg.exceptions.PrecoInvalidoException;
import p2cg.exceptions.SaldoInvalidoException;
import p2cg.exceptions.StringInvalidaException;
import p2cg.exceptions.TipoUsuarioException;
import p2cg.jogos.*;
import p2cg.usuarios.*;

//TODO: ToString

public class Loja {
	
	private HashMap<String, Usuario> usuarios;
	private HashSet<Jogo> jogos;
	
	public Loja(){
		this.usuarios = new HashMap<String, Usuario>();
		this.jogos = new HashSet<Jogo>();
	}
		
	/**
	 * adicionaUsuario[Tipo]
	 * adiciona um usuario [Tipo], que pode ser Veterano ou Noob na lista de usuarios da loja
	 * @param login
	 * @param nome
	 * @param saldo
	 * @throws Exception
	 */
	
	public void adicionaUsuarioNoob(String login, String nome, double saldo) throws Exception{
		if (!usuarios.containsKey(login)){
			Noob usuario = new Noob(nome, login, saldo);
			usuarios.put(login, usuario);
		} else {
			throw new LoginInvalidoException("Login ja existente.");
		}
	}
	
	public void adicionaUsuarioVeterano(String login, String nome, double saldo) throws Exception{
		if (!usuarios.containsKey(login)){
			Veterano usuario = new Veterano(nome, login, saldo);
			usuarios.put(login, usuario);
		} else {
			throw new LoginInvalidoException("Login ja existente.");
		}
	}
	
	public Usuario getUsuario(String login) throws Exception{
		if (!usuarios.containsKey(login)){
			throw new LoginInvalidoException("Login invalido");
		} else {
			return usuarios.get(login);
		}
	}
	
	public void adicionaDinheiro(String login, double valor) throws Exception {
		if (valor <= 0){
			throw new SaldoInvalidoException("Nao pode adicionar saldo menor ou igual a zero");
		}
		if (usuarios.containsKey(login)){
			usuarios.get(login).adicionaDinheiro(valor);
		} else {
			throw new LoginInvalidoException("Nao foi possivel localizar login.");
		}
	}

	public boolean vendeJogo(String nomeJogo, String login) throws Exception {
		if (usuarios.containsKey(login)){
			for (Jogo jogo : this.jogos){
				if (nomeJogo.equalsIgnoreCase(jogo.getNome())){
					this.usuarios.get(login).compraJogo(jogo);
					return true;
				}
			}
			throw new JogoInvalidoException("Jogo nao existe");
		} else {
			throw new LoginInvalidoException("Nao foi possivel localizar login.");
		}
	}

	/**
	 * upgrade.
	 * Faz upgrade de uma conta noob se ela tiver pelo menos 1000 x2p
	 * apos ser feito o upgrade, a conta veterana tera a quantidade de x2p que tinha quando era noob + 1000 x2p
	 * pois quando eh criada uma conta veterana a respectiva ja comeca com 1000 x2p
	 * @param login
	 * @return
	 * @throws Exception
	 */
	
	public boolean upgrade(String login) throws Exception {
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
					contaUpgrade.ganhaX2p(x2p);
					contaUpgrade.setJogos(jogos);
					
					usuarios.put(login, contaUpgrade);
					return true;
				} else {
					throw new ExperienciaInvalidaException("Usuario nao possui experiencia suficiente para fazer upgrade");					
				}
			} else {
				throw new TipoUsuarioException("Usuario nao eh noob.");
			}
		
		
		} else {
			throw new LoginInvalidoException("Login nao existe.");
		}
		
	}
	
	/**
	 * criaJogo[Tipo].
	 * cria um jogo [Tipo], que pode ser rpg, luta ou plataforma e adiciona na lista de jogos que uma loja tem
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @throws Exception
	 */

	public void criaJogoRpg(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws Exception{
		
		this.testaCriacaoJogo(nome, preco);
		
		Rpg jogo = new Rpg(nome, preco, jogabilidades);
		this.jogos.add(jogo);
		
	}
	
	public void criaJogoLuta(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws Exception{
		
		this.testaCriacaoJogo(nome, preco);
		
		Luta jogo = new Luta(nome, preco, jogabilidades);
		this.jogos.add(jogo);
		
	}
	
	public void criaJogoPlataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws Exception{
		
		this.testaCriacaoJogo(nome, preco);
		
		Plataforma jogo = new Plataforma(nome, preco, jogabilidades);
		this.jogos.add(jogo);
		
	}
	
	private void testaCriacaoJogo(String nome, double preco) throws Exception{
		if (nome == null || "".equals(nome)){
			throw new StringInvalidaException("Nome nao pode ser null ou vazio.");
		}
		
		if (preco <= 0){
			throw new PrecoInvalidoException("Preco nao pode ser menor ou igual a zero.");
		}
	}
	
	@Override
	public String toString(){
		String menssagem = "=== Central P2-CG ===\n\n";
		for (String key : this.usuarios.keySet()){
			menssagem += this.usuarios.get(key) + "\n";
		}
		return menssagem;
	}
		
	
}
