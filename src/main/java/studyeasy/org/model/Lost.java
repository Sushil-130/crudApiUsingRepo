package studyeasy.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="lost")
@Table(name="lost")
public class Lost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lostId")
	int lostId;
	
	@Override
	public String toString() {
		return "Lost [lostId=" + lostId + ", lostName=" + lostName + "]";
	}

	public int getLostId() {
		return lostId;
	}

	public void setLostId(int lostId) {
		this.lostId = lostId;
	}

	public String getLostName() {
		return lostName;
	}

	public void setLostName(String lostName) {
		this.lostName = lostName;
	}

	public Lost(int lostId, String lostName) {
		super();
		this.lostId = lostId;
		this.lostName = lostName;
	}

	public Lost() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="lostName")
	String lostName;
	

}
