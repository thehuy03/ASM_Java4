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

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

@Entity(name="History")
@Table(name="History" ,uniqueConstraints = {
		@UniqueConstraint(columnNames = {"IDVideo","IDUser"})
})
public class History {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne @JoinColumn(name="IDUser")
	Users user;
	@ManyToOne @JoinColumn(name="IDVideo")
	Video video;
	@Temporal(TemporalType.TIMESTAMP)
	Date viewedDate = new Date();
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
	public Date getViewedDate() {
		return viewedDate;
	}
	public void setViewedDate(Date viewedDate) {
		this.viewedDate = viewedDate;
	}

	
	
}
