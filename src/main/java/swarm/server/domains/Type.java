package swarm.server.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Type implements Serializable {
	private static final long serialVersionUID = -7812590943533400550L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional = false)
	private Namespace namespace;
	
	@ManyToOne(optional = false)
	private Session session;

	@Column(nullable = false)
	String fullName;
	
	@Column(nullable = false)
	String fullPath;
	
	@Column(nullable = false)
	String name;
	
	@Column(length = 1000000)
	String source;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Namespace getNamespace() {
		return namespace;
	}

	public void setNamespace(Namespace namespace) {
		this.namespace = namespace;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}