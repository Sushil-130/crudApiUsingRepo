package studyeasy.org.service;

import java.util.List;

import studyeasy.org.model.Lost;
import studyeasy.org.model.User;

public interface LostService {

	List<Lost> getLosts();

	public Lost getLost(int id);

	public Lost addLost(Lost lost);

	public Lost updatedLost(Lost updatedLost);



	public void deleteLost(int id);

}
