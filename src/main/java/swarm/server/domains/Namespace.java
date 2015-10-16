package swarm.server.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Namespace implements Serializable {
	private static final long serialVersionUID = -7145408705221743773L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	String version;

	@Column(nullable = false)
	String name;

	@Column(nullable = false)
	String fullPath;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

}