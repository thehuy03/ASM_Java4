package modal;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@NamedNativeQueries({
//	@NamedNativeQuery(name="")
//})
@Entity(name="Video")
@Table(name="Video")
public class Video {
	@Id
	@Column(name="IDVideo")
	private String id;
	@Column(name="Title")
	private String title;
	@Column(name="Poster")
	private String poster;

	@Column(name="Describe")
	private String describe;
	
	@OneToMany(mappedBy = "video",fetch = FetchType.EAGER)
	List<Favorite> favorites;
	
	@OneToMany(mappedBy="video",fetch = FetchType.EAGER)
	List<History> history;
	
	@OneToMany(mappedBy="video",fetch = FetchType.EAGER)
	List<Views> view;
	
	public Video() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String idVideo) {
		this.id = idVideo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title.replaceAll("'", "’");
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
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
	public List<Views> getView() {
		return view;
	}
	public void setView(List<Views> view) {
		this.view = view;
	}
	
	
}
