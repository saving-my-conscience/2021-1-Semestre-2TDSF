package br.com.fiap.tds.view;

import br.com.fiap.tds.dao.UsuarioDao;
import br.com.fiap.tds.dao.impl.UsuarioDaoImpl;
import br.com.fiap.tds.entity.TipoUsuario;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class UsuarioDaoTeste {

	public static void main(String[] args) {
		
		// Obter uma instância do entity manager
//		EntityManager em = EntityManagerFactorySingleton
//								.getInstance().createEntityManager();
		
		// Obter uma instância do UsuarioDao
		UsuarioDao dao = new UsuarioDaoImpl(EntityManagerFactorySingleton
													.getInstance().createEntityManager());
		
		// Cadastrar um usuário
		Usuario usuario = new Usuario("Victor", TipoUsuario.FISICO);
		
		try {
			dao.create(usuario);
			dao.commit();
			System.out.println("Usuário registrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		// Pesquisar um usuário pelo código e exibir as informações
		try {
			usuario = dao.read(1);
			System.out.println("Usuário: " + usuario.getNome() + " Tipo: " + usuario.getTipo());
		} catch (EntityNotFoundException e) {
			System.out.println("Usuário não encontrado");
		}
		
		// Atualizar um usuário
		usuario = new Usuario(2, "Bruno", TipoUsuario.JURIDICO);
		try {
			dao.update(usuario);
			dao.commit();
			System.out.println("Usuário atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		// Remover um usuário
		try {
			dao.remove(1);
			dao.commit();
			System.out.println("Usuário removido!");
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
