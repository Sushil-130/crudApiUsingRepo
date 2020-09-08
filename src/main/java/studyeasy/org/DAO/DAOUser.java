package studyeasy.org.DAO;

import java.util.List;

import studyeasy.org.model.User;



public interface DAOUser {

	List<User> getUsers();
	
	public User getUser(int id);

	void addUser(User user);

	void updatedUser(User updatedUser);

	void deleteUser(int id);
	

}
