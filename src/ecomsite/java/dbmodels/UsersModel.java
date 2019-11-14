package ecomsite.java.dbmodels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UsersModel {
	
	private int _id;
	@NotNull(groups={FormValidationGroup.class, PersistenceValidationGroup.class})
	@Size(min=5, max=100, groups={FormValidationGroup.class, PersistenceValidationGroup.class})
	private String first_name;
	@NotNull(groups={FormValidationGroup.class, PersistenceValidationGroup.class})
	@Size(min=5, max=100, groups={FormValidationGroup.class, PersistenceValidationGroup.class})
	private String last_name;
	private String address;
	private String birthdate;
	private int enabled;
	private String notes;
	
	public UsersModel() {
		
	}
	
	
	
	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
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
	public int get_id() {
		return _id;
	}



	public void set_id(int _id) {
		this._id = _id;
	}



	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
	
}
