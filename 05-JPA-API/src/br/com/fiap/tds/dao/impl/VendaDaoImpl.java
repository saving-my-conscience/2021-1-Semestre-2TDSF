package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.VendaDao;
import br.com.fiap.tds.entity.Venda;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.VendaNotFoundException;

public class VendaDaoImpl implements VendaDao {

	private EntityManager em;
	
	public VendaDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void create(Venda venda)  {
		em.persist(venda);
	}
	
//	public boolean create2(Venda venda) {
//		em.persist(venda);
//		try {
//			em.getTransaction().begin();
//			em.getTransaction().commit();
//			return true;
//		}catch(Exception e) {
//			em.getTransaction().rollback();
//			e.printStackTrace();
//			return false;
//		}
//	}

	@Override
	public Venda read(int id) throws VendaNotFoundException {
		Venda venda = em.find(Venda.class, id);
		if (venda == null) {
			throw new VendaNotFoundException();
		}
		return venda;
	}

	@Override
	public void update(Venda venda) {
		em.merge(venda);
	}

	@Override
	public void delete(int id) throws VendaNotFoundException {
		Venda venda = read(id);
		em.remove(venda);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao realizar o commit");
		}
	}
	
}
