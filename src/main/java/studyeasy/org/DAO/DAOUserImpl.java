package studyeasy.org.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import studyeasy.org.model.User;

@Repository
public class DAOUserImpl implements DAOUser {
	
	@Autowired
	private EntityManager entityManager;
	

	@Autowired
	public DAOUserImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	public List<User> getUsers() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<User> query=currentSession.createQuery("from User",User.class);
		List<User> listUsers=query.getResultList();
		return listUsers;
}


	@Override
	public User getUser(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		return currentSession.get(User.class, id);
	}

	public void addUser(User user) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(user);
		
	}

	public void updatedUser(User updatedUser) {
		Session currentSession=entityManager.unwrap(Session.class);
		int id=updatedUser.getId();
		User user=currentSession.get(User.class, id);
		user.setName(updatedUser.getName());
		currentSession.save(user);
		
	}

	public void deleteUser(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		User user=currentSession.get(User.class, id);
		currentSession.delete(user);
		
		
	}



}