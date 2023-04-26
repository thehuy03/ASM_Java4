package modal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Users")
@Table(name="Users")
@NamedQueries({@NamedQuery(name = "Users.findUserWatchVideo", query = "SELECT o FROM Views o where o.video.id = :id")})
public class Users {
	
	@Id
	@Column(name="IDUser")
	private String id;
	@Column(name="Passwords")
	private String password;
	@Column(name="Email")
	private String email;
	@Column(name="Roles")
	private boolean role;

	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	List<Favorite> favorites;
	
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	List<History> history;
	
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	List<Views> view;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	public List<Favorite> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
	public List<History> getHistory() {
		return history;
	}
	public void setHistory(List<History> history) {
		this.history = history;
	}
}
