package swarm.server.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project implements Serializable {
	private static final long serialVersionUID = 5471887306464491390L;
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	String name;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")	
	private List<Session> sessions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return id + ": " + name;
	}
}