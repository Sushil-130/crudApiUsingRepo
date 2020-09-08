package studyeasy.org.service;

import java.util.List;

import studyeasy.org.model.Post;
import studyeasy.org.model.User;

public interface PostService {



	List<Post> getPostsbyId(int id);


	List<Post> getPosts();


	void addPost(int id, Post post);

	public void updatedPost(Post updatedPost,int uid);
	public Post getPost(int id);


	public void deletePost(int uid,int pid);


	List<Post> getSpecificPostsByUserId(int uid, int pid);



}
