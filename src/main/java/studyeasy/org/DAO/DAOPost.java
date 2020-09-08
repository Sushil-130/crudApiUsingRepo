package studyeasy.org.DAO;

import java.util.List;

import studyeasy.org.model.Post;
import studyeasy.org.model.User;

public interface DAOPost {

	List<Post> getPostsbyId(int id);



	public List<Post> getPosts();
	public Post getPost(int id);

	void updatedPost(Post updatedPost,int uid);

	void deletePost(int uid,int pid);
	










	void addPost(int id, Post post);



	List<Post> getSpecificPostsByUserId(int uid, int pid);




}
