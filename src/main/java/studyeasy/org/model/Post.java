package studyeasy.org.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="post")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="postId")
	private int postId;
	
	

	
	@Column(name="body")
	private String body;
	
	
	@ManyToOne
@JoinColumn(name="user_id")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post(int postId, String body) {
		super();
		this.postId = postId;
		
		this.body = body;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
