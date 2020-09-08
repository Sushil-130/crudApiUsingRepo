package studyeasy.org.service;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import studyeasy.org.DAO.DAOUser;
import studyeasy.org.DAO.DAOUserImpl;
import studyeasy.org.model.User;

	@Repository
	public class UserServiceImpl implements UserService {
		
		@Autowired
		DAOUser userDAO;
		
		@Transactional
		@Override
		public List<User> getUsers() {
			List<User> listUsers=userDAO.getUsers();
			return listUsers;
		}

		@Transactional
		@Override
		public User getUser(int id) {
			User user=userDAO.getUser(id);
			return user;
		}
		@Transactional
		@Override
		public void addUser(User user) {
			userDAO.addUser(user);
		}

		@Transactional
		@Override
		public void updatedUser(User updatedUser) {
			
			userDAO.updatedUser(updatedUser);
		}

		@Transactional
		@Override
		
		public void deleteUser(int id) {
			userDAO.deleteUser(id);
			
		}

		
	}

