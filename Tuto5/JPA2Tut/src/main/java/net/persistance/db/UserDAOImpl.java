package net.persistance.db;


import javax.persistence.*;
import java.util.*;

public class UserDAOImpl extends GenericDAO{
	public void createUser(List<User> users){}
	public void create(String name,String forename, Date added){
	//	log.info("Create a User");
		EntityManager em = createEntityManager();
		EntityTransaction tx = null;
		try{
			tx = em.getTransaction();
			tx.begin();
			User user = new User(name,forename,added);
			em.persist(user);
			tx.commit();
		}catch(Exception re)
           		{
			  if(tx!=null)
			  //  log.error("Something went wrong; Discard all partial changes");
			    tx.rollback();
			}finally{
			closeEntityManager();
			}
	}
	/*public List<User> findAll(){}
	public User findById(int id){}
	public void deleteUser(User persistentInstance){}*/

}
