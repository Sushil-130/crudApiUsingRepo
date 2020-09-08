package studyeasy.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import studyeasy.org.model.Post;
import studyeasy.org.model.User;
import studyeasy.org.service.PostService;

@RestController
@RequestMapping("/store")
public class PostController {
	
	@Autowired
	private PostService service;
	private int id;
	
	@GetMapping("/users/{id}/posts")
	public List<Post> getPostsById(@PathVariable("id") int id){
		
		return service.getPostsbyId(id);
	}


	@GetMapping("/posts")
	public List<Post> getPosts(){
		
		return service.getPosts();
	}
	
	
	@PostMapping("/users/{id}/posts")
	

	public void addPost(@RequestBody Post post,@PathVariable("id") int id) {
		
		
		service.addPost(id,post);
		
	}
	
@GetMapping("/posts/{id}")
	public Post getPost(@PathVariable("id") int id) {
		
		
		Post post=service.getPost(id);
		
		
		return post;
		
		
		
	}
	
@PutMapping("/users/{uid}/posts/{pid}")
	
	public void updatedPost  ( @RequestBody Post updatedPost,@PathVariable("uid") int uid,@PathVariable("pid") int pid) {
		
		updatedPost.setPostId(pid);
		service.updatedPost(updatedPost,uid);
	}
	
	
	@DeleteMapping("/users/{uid}/posts/{pid}")
	
	
	public void deletePost( @PathVariable("uid")int uid,@PathVariable("pid") int pid) {
		service.deletePost(uid,pid);
	}
	
	@GetMapping("/users/{uid}/posts/{pid}")
	public List<Post> getSpecificPostByUserId(@PathVariable("uid") int uid,@PathVariable("pid") int pid){
		
		
		return service.getSpecificPostsByUserId(uid,pid);
	}
}
