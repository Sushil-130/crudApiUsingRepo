package studyeasy.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import studyeasy.org.DAO.DAOLost;
import studyeasy.org.model.Lost;
import studyeasy.org.model.User;

@Repository
public class LostServiceImpl implements LostService {

	@Autowired
	private DAOLost daoLost;
	
	@Override
	public List<Lost> getLosts() {
		
		List<Lost> listLosts=daoLost.getLosts();
		return listLosts;
	}


	@Transactional
	@Override
	public Lost getLost(int id) {
		Lost lost=daoLost.getLost(id);
		return lost;
	}
	@Transactional
	@Override
	public Lost addLost(Lost lost) {
		daoLost.addLost(lost);
		return lost;
	}
	@Transactional
	@Override
	public Lost updatedLost(Lost updatedLost) {
		
		daoLost.updatedLost(updatedLost);
		return updatedLost;
	}

	@Transactional
	@Override
	public void deleteLost(int id) {
		daoLost.deleteLost(id);
		
	}


}
