package swarm.server.domains;

import java.io.Serializable;
import java.util.Calendar;

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
	
	String color;
	
	@Column(name="CREATION_TS", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	private Calendar timestamp;

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
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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