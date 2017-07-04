package orange.user.impl;

import java.util.Collection;
import java.util.HashSet;

import controller.query.model.BookingModel;
import orange.user.ifc.UserIfc;
import orange.user.role.RoleIfc;

/**
 * @author Dhananjay P
 *
 */
public class User implements UserIfc {
	
	String username;
	
	String password;
	
	String firstName;
	
	String lastName;
	
	String contactNumber;
	
	String emailId;
	
	
	boolean isNewUser;
	
	RoleIfc role;	
	
	Collection <BookingModel> bookings=new HashSet<BookingModel>();
	
	
	
	/**
	 * @return the role
	 */
	public RoleIfc getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleIfc role) {
		this.role = role;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the isNewUser
	 */
	public boolean isNewUser() {
		return isNewUser;
	}

	/**
	 * @param isNewUser the isNewUser to set
	 */
	public void setNewUser(boolean isNewUser) {
		this.isNewUser = isNewUser;
	}

	/**
	 * @return the bookings
	 */
	public Collection<BookingModel> getBookings() {
		return bookings;
	}

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(Collection<BookingModel> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", contactNumber=" + contactNumber + ", emailId=" + emailId + ", isNewUser=" + isNewUser
				+ "]";
	}
	
	
	
}
