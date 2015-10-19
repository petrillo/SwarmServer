package swarm.server.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Method implements Serializable {
	private static final long serialVersionUID = 5499015545204459102L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	private Type type;

	@Column(nullable = false)
	String key;

	@Column(nullable = false)
	String name;

	@Column(nullable = false)
	String signature;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}