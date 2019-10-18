package ecomsite.java.dbmodels;

public class AboutModel {
	private int _id;
	private String name;
	private String description;
	private String date;
	private int sequence;
	
	
	
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
