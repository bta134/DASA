package net.persistance.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

public abstract class GenericDAO{
	EntityManager em;
	

	public  EntityManager createEntityManager(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("USER");
		em = emf.createEntityManager();
		return em;
	}	

	public void closeEntityManager(){
		em.close();
	}
}
