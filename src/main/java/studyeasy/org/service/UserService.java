package studyeasy.org.service;

import java.util.List;

import studyeasy.org.model.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public User getUser(int id);

	public void addUser(User user);

	public void updatedUser(User updatedUser);



	public void deleteUser(int id);


}
