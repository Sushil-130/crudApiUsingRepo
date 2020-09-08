package studyeasy.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import studyeasy.org.model.User;
import studyeasy.org.service.UserService;
import studyeasy.org.service.UserServiceImpl;


@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		
		return userService.getUsers();
	}
	
	
	@GetMapping("/users/{id}")

	
	
	public User getUser(@PathVariable("id") int id) {
		
		
		User user=userService.getUser(id);
		
		
		return user;
		
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")

	public void addUser(@RequestBody User user) {
		
		userService.addUser(user);
		
	}
	
	@PutMapping("/users/{id}")
	
	public void updatedUser(@RequestBody User updatedUser,@PathVariable("id") int id) {
		
		updatedUser.setId(id);
		userService.updatedUser(updatedUser);
	}
	
	
	@DeleteMapping("/users/{id}")
	
	
	public void deleteUser( @PathVariable("id")int id) {
		userService.deleteUser(id);
	}
	

}