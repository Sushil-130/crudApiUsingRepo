package studyeasy.org.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="name")
	String name;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	@JsonBackReference
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id")
	private List<Post> listPost;
	
	@Override
	public String toString() {
		return "User [listPost=" + listPost + "]";
	}
	public void setListPost(List<Post> listPost) {
		this.listPost = listPost;
	}
	public List<Post> getListPost() {
		return listPost;
	}

	
	public void add(Post post) {
		listPost=new ArrayList<>();
		
		listPost.add(post);
		post.setUser(this);
		
	}

}
