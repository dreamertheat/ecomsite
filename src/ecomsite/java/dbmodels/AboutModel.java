package ecomsite.java.dbmodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional //for transactional
@Entity //javax persistence for hibernate bean
@Table(name="about") //javax persistence for hibernate table name
public class AboutModel {

	/**
	 * 
	 */

	@Id //hibernate annotation for primary key
	@Column(name="_id") //hibernate annotation for column name
	private int _id;
	
	@Column(name="description")
	private String description;
	@Column(name="date")
	private String date;
	@Column(name="sequence")
	private int sequence;
	@Transient
	private String corporation;
	@Transient
	private String about;
	
	@NotNull(groups={FormValidationGroup.class, PersistenceValidationGroup.class})
	@Size(min=5, max=100, groups={FormValidationGroup.class, PersistenceValidationGroup.class})
	private String name;
	
	
	
	public AboutModel(int _id, String name, String description, String date, int sequence, String corporation,
			String about) {
		this._id = _id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.sequence = sequence;
		this.corporation = corporation;
		this.about = about;
	}
	
	public AboutModel(String name, String description, String date, int sequence) {
		this.name = name;
		this.description = description;
		this.date = date;
		this.sequence = sequence;
		}
	
	public AboutModel() {
	}

	@Autowired
	public AboutModel(@Value("${commons.corporation}") String corporation, @Value("${commons.about}") String about) {
		this.corporation = corporation;
		this.about = about;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSequence() {
		return sequence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _id;
		result = prime * result + ((about == null) ? 0 : about.hashCode());
		result = prime * result
				+ ((corporation == null) ? 0 : corporation.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sequence;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AboutModel other = (AboutModel) obj;
		if (_id != other._id)
			return false;
		if (about == null) {
			if (other.about != null)
				return false;
		} else if (!about.equals(other.about))
			return false;
		if (corporation == null) {
			if (other.corporation != null)
				return false;
		} else if (!corporation.equals(other.corporation))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sequence != other.sequence)
			return false;
		return true;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return "AboutModel [_id=" + _id + ", description=" + description
				+ ", date=" + date + ", sequence=" + sequence
				+ ", corporation=" + corporation + ", about=" + about
				+ ", name=" + name + "]";
	}

}
