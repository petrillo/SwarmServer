package swarm.server.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

	@Column(nullable = false)
	String version;

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

}