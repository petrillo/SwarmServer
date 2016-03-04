package swarm.server.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Developer implements Serializable {

	private static final long serialVersionUID = -8377345229493337082L;

	@Id
	@GeneratedValue
	private Long id;	
	
	@Column(nullable = false)
	String name;

	@Transient
	boolean logged;
	
	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLogged() {
		return this.logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}	
	
	public String toString() {
		return id + ": " + name;
	}
}