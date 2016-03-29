package swarm.server.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Invocation implements Serializable {
	
	private static final long serialVersionUID = 8724123547818474005L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	private Method invoking;

	@ManyToOne(optional = false)
	private Method invoked;

	@ManyToOne(optional = false)
	private Session session;
	
	@Transient
	private boolean isVitual;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Method getInvoking() {
		return invoking;
	}

	public void setInvoking(Method invoking) {
		this.invoking = invoking;
	}

	public Method getInvoked() {
		return invoked;
	}

	public void setInvoked(Method invoked) {
		this.invoked = invoked;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public String toString() {
		return invoking.getId() + ": " + invoking.getKey() + " -> " + invoked.getId() + ": " + invoked.getKey();
	}
	
	public boolean isVirtual() {
		return this.isVitual;
	}
	
	public void setVirtual(boolean virtual) {
		this.isVitual = virtual;
	}
	
}