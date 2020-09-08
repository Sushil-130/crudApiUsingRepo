package studyeasy.org.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import studyeasy.org.model.Lost;
import studyeasy.org.model.User;

@Repository
public class DAOLostImpl implements DAOLost {

	@Autowired
	private EntityManager entityManager;
	
	
	
	@Override
	public List<Lost> getLosts() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Lost> query=currentSession.createQuery("from lost",Lost.class);
		List<Lost> listLosts=query.getResultList();
		return listLosts;
}
	@Override
	public Lost getLost(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		return currentSession.get(Lost.class, id);
	}

	public Lost addLost(Lost lost) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(lost);
		return lost;
		
	}

	public Lost updatedLost(Lost updatedLost) {
		Session currentSession=entityManager.unwrap(Session.class);
		int id=updatedLost.getLostId();
		Lost lost=currentSession.get(Lost.class, id);
		lost.setLostName(updatedLost.getLostName());
		currentSession.save(lost);
		return lost;
		
	}

	public void deleteLost(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Lost lost=currentSession.get(Lost.class, id);
		currentSession.delete(lost);
		
		
	}
	}
	
	


