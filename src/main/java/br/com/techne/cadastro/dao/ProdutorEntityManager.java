package br.com.techne.cadastro.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ProdutorEntityManager {	
	@Inject
	private EntityManagerFactory factory;
	@Produces
	@RequestScoped
	public EntityManager criaEntityManager() {
		return factory.createEntityManager();
	}

	public void fechaEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}