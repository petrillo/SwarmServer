package swarm.server.domains;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Session implements Serializable {
	private static final long serialVersionUID = -1945528119276270987L;
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	private Developer developer;
	
	@ManyToOne(optional = false)
	private Project project;
	
	@Column(nullable = false)
	String version;	
	
	@Column(nullable = false)
	String description;	
	
	@Column(nullable = false)
	String label;	
	
	@Column(nullable = false)
	String purpose;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date started;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date finished;

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public Date getFinished() {
		return finished;
	}

	public void setFinished(Date finished) {
		this.finished = finished;
	}
}