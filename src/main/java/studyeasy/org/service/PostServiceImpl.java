package studyeasy.org.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import studyeasy.org.DAO.DAOPost;
import studyeasy.org.model.Post;
import studyeasy.org.model.User;



@Repository
public class PostServiceImpl implements PostService{

	@Autowired
	private DAOPost postDAO;
	
	@Transactional
	@Override
	public List<Post> getPostsbyId(int id) {
		
		List<Post> listPosts=postDAO.getPostsbyId(id);
		return listPosts;
	}
	
	@Transactional
	@Override
	public List<Post> getPosts() {
		
		List<Post> listPosts=postDAO.getPosts();
		return listPosts;
		
	}


	@Transactional
	@Override
	public void addPost(int id, Post post) {
		postDAO.addPost(id,post);
		
	}
	
	@Transactional
	@Override
	public Post getPost(int id) {
		Post post=postDAO.getPost(id);
		return post;
	}

	@Transactional
	@Override
	public void updatedPost(Post updatedPost,int uid) {
		
		postDAO.updatedPost(updatedPost,uid);
	}

	@Transactional
	@Override
	
	public void deletePost(int uid,int pid) {
		postDAO.deletePost(uid,pid);
		
	}
	@Transactional
	@Override
	public List<Post> getSpecificPostsByUserId(int uid, int pid) {
		List<Post> listPosts=postDAO.getSpecificPostsByUserId(uid,pid);
		return listPosts;
	}


	
	
	

	
}
