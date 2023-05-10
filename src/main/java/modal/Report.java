package modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Report {
	@Id
	String group;
	Long countNumber;
	
	public Report() {
		super();
	}

	public Report(String group, Long countNumber) {
		super();
		this.group = group;
		this.countNumber = countNumber;
	}

	public Serializable getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Long getCountNumber() {
		return countNumber;
	}

	public void setCountNumber(Long countNumber) {
		this.countNumber = countNumber;
	}
	
	
	
}
