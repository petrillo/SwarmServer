package swarm.server.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Event implements Serializable {
	
	private static final long serialVersionUID = 4778378924903070737L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	private Method method;

	@ManyToOne(optional = false)
	private Session session;

	String charStart;

	String charEnd;

	Integer lineNumber;

	String detail;

	String kind;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getCharStart() {
		return charStart;
	}

	public void setCharStart(String charStart) {
		this.charStart = charStart;
	}

	public String getCharEnd() {
		return charEnd;
	}

	public void setCharEnd(String charEnd) {
		this.charEnd = charEnd;
	}

	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
}