package modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "Views" )
@Table(name = "Views" ,uniqueConstraints = {
		@UniqueConstraint(columnNames = {"IDVideo","IDUser"})
})
public class Views {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne @JoinColumn(name="IDUser")
	Users user;
	@ManyToOne @JoinColumn(name="IDVideo")
	Video video;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
	
}
