package ecomsite.java.dbmodels;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AboutModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 729678249666320770L;


	private int _id;
	

	private String description;
	private String date;
	private int sequence;

	private String corporation;

	private String about;
	
	
	@Size(min=5)
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

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return "AboutModel [_id=" + _id + ", name=" + name + ", description=" + description + ", date=" + date
				+ ", sequence=" + sequence + "]";
	}

}
