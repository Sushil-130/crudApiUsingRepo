package studyeasy.org.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import studyeasy.org.model.Post;
import studyeasy.org.model.User;

@Repository
public class DAOPostImpl implements DAOPost {
	
	@Autowired
	private EntityManager entityManager;
	
//	@Autowired
//	public DAOPostImpl(EntityManager theEntityManager) {
//		entityManager=theEntityManager;
//	}
	
	@Override
	public List<Post> getPostsbyId(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query<Post> query=currentSession.createQuery("from Post where user_id='"+id+"'",Post.class);
		List<Post> listPosts=query.getResultList();
		return listPosts;
		
//		User user=currentSession.get(User.class,id);
//		return user.getListPost();
//		
		
		
		
	}
	
	
	@Override
	public List<Post> getPosts() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Post> query=currentSession.createQuery("from Post",Post.class);
		List<Post> listPosts=query.getResultList();
		return listPosts;
}


	@Override
	public Post getPost(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		return currentSession.get(Post.class, id);
	}
	
	@Override
	public void addPost(int id, Post post) {
		Session currentSession=entityManager.unwrap(Session.class);
		User user=currentSession.get(User.class, id);
//	post.setUser(user);
//		currentSession.save(post);
		
		user.add(post);
		System.out.println(user);
		System.out.println(user.getListPost());
		currentSession.save(user);
		System.out.println(user.getListPost());
	
		
	}
	
	public void updatedPost(Post updatedPost,int uid) {
		Session currentSession=entityManager.unwrap(Session.class);
		User user=currentSession.get(User.class, uid);
		
		
		int id=updatedPost.getPostId();
	Post post=currentSession.get(Post.class, id);
		post.setBody(updatedPost.getBody());
		post.setUser(user);
		currentSession.save(post);
		
	}

	public void deletePost(int uid,int pid) {
		Session currentSession=entityManager.unwrap(Session.class);
		User user=currentSession.get(User.class, uid);
		Post post=currentSession.get(Post.class, pid);
		post.setUser(user);
		currentSession.delete(post);
		
		
	}


	@Override
	public List<Post> getSpecificPostsByUserId(int uid, int pid) {
		
Session currentSession=entityManager.unwrap(Session.class);
		
		Query<Post> query=currentSession.createQuery("from Post where user_id='"+uid+"' and postId='"+pid+"'",Post.class);
		List<Post> listPosts=query.getResultList();
		return listPosts;
		
		
	}


	
}


