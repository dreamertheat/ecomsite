package ecomsite.java.dbmodels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AboutModel {

	private int _id;
	private String name;
	private String description;
	private String date;
	private int sequence;

	private String corporation;

	private String about;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
