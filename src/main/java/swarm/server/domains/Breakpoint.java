package swarm.server.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Breakpoint implements Serializable {


	private static final long serialVersionUID = -6819150292632153873L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional = false)
	private Type type;

	@Column(nullable = false)
	String charStart;
	
	@Column(nullable = false)
	String charEnd;
	
	@Column(nullable = false)
	Integer lineNumber;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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
}