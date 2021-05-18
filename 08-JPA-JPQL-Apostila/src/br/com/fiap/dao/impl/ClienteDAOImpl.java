package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		//Criar a query
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.nome like :churros", Cliente.class);
		//Setar o parametro na query
		query.setParameter("churros", "%" + nome + "%");
		//Executar a query
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :pEstado", Cliente.class)
				.setParameter("pEstado", estado)
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReserva(int dias) {
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :d", Cliente.class)
				.setParameter("d", dias)
				.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome like :pNome and c.endereco.cidade.nome like :pCidade", Cliente.class)
				.setParameter("pCidade", "%" + cidade + "%")
				.setParameter("pNome", "%" + nome + "%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf in :pEstado", Cliente.class)
				.setParameter("pEstado", estados)
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome2(String nome) {
		return em.createQuery("from Cliente c where upper(c.nome) like upper(:pNome) order by c.nome desc", Cliente.class)
				.setParameter("pNome", "%" + nome + "%")
				.getResultList();
	}

	@Override
	public long contarPorEstado(String estado) {
		return em.createQuery("select count(c) from Cliente c where c.endereco.cidade.uf = :p", Long.class)
				.setParameter("p", estado)
				.getSingleResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarPorNomeOuCpf(String nome, String cpf) {
		return em.createNativeQuery("select * from TB_EAD_CLIENTE where nm_cliente like :pNome or nr_cpf = :pCpf", Cliente.class)
				.setParameter("pNome", "%" + nome + "%")
				.setParameter("pCpf", cpf)
				.getResultList();
	}

}
