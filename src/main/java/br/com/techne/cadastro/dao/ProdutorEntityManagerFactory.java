package br.com.techne.cadastro.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutorEntityManagerFactory {
	@Produces
	@ApplicationScoped
	public EntityManagerFactory criaEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("JPA");		
	}
}
