package br.com.techne.cadastro.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.techne.cadastro.model.Pessoa;

@ApplicationScoped
public class PessoaDao {

	@Inject
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public void save(Pessoa pessoa) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
	}

	public void edit(Pessoa pessoa) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
	}

	public void delete(Pessoa pessoa) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(em.contains(pessoa) ? pessoa : em.merge(pessoa));
		em.getTransaction().commit();
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
