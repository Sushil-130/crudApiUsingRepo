package studyeasy.org.DAO;

import java.util.List;

import studyeasy.org.model.Lost;
import studyeasy.org.model.User;

public interface DAOLost {

	List<Lost> getLosts();
	
	public Lost getLost(int id);

	 public Lost addLost(Lost lost);

	Lost updatedLost(Lost updatedLost);

	void deleteLost(int id);

}
