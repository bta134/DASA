package net.persistance.db;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class GenericDAO{
	EntityManager entityManager;

	public EntityManager createEntityManager(){
		 entityManager = EntityManagerFactory.createEntityManager();
	  return entityManager;	
}
	public void closeEntityManager(){
		entityManager.close();
}
}
