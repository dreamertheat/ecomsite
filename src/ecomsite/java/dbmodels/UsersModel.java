package ecomsite.java.dbmodels;

public class UsersModel {
	
	private int _id;
	private String first_name;
	private String last_name;
	private String address;
	private String birthdate;
	private int enabled;
	
	public UsersModel() {
		
	}
	
	
	public UsersModel(String first_name, String last_name, String address, String birthdate, int enabled) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.birthdate = birthdate;
		this.enabled = enabled;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
	
}
