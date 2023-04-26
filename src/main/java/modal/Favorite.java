package modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity(name = "Favorite" )
@Table(name = "Favorite" ,uniqueConstraints = {
		@UniqueConstraint(columnNames = {"IDVideo","IDUser"})
})
public class Favorite {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne @JoinColumn(name="IDUser")
	Users user;
	@ManyToOne @JoinColumn(name="IDVideo")
	Video video;
	@Temporal(TemporalType.DATE)
	Date likeDate = new Date();
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
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
	
}
