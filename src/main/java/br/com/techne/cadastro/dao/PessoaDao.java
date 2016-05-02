package br.com.techne.cadastro.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.techne.cadastro.model.Pessoa;

@Stateless
@LocalBean
public class PessoaDao {

	@PersistenceContext(unitName = "thePersistenceUnit")
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public void save(Pessoa pessoa) {
		this.getEntityManager().persist(pessoa);
	}

	public void edit(Pessoa pessoa) {
		this.getEntityManager().merge(pessoa);
	}

	public void delete(Pessoa pessoa) {
		this.getEntityManager().remove(getEntityManager().contains(pessoa) ? pessoa : getEntityManager().merge(pessoa));
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> list() {
		return (List<Pessoa>) this.getEntityManager().createQuery("select p from br.com.techne.cadastro.model.Pessoa p")
				.getResultList();
	}

	public Pessoa get(Long id) {
		return this.getEntityManager().find(Pessoa.class, id);
	}
}
