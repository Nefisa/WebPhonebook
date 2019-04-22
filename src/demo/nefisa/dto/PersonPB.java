package demo.nefisa.dto;

public class PersonPB {

	private int phonebookID;
	private String firstName;
	private String lastName;
	private String phone;
	private String mobile;
	private int userID;

	public PersonPB() {
		super();
	}

	public PersonPB(String firstName, String lastName, String phone, String mobile, int userID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.mobile = mobile;
		this.userID = userID;
	}

	public int getPhonebookID() {
		return phonebookID;
	}

	public void setPhonebookID(int phonebookID) {
		this.phonebookID = phonebookID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getUserID() {
		return phonebookID;
	}

	public void setUserID(int UserID) {
		this.userID = UserID;
	}

	@Override
	public String toString() {
		return "PersonPB [phonebookID=" + phonebookID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", mobile=" + mobile + ", userID=" + userID + "]";
	}

}