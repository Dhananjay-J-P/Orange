package controller.query.model;

import java.util.Arrays;

import orange.bus.Bus;
import orange.user.impl.User;

/**
 * @author Dhananjay P
 *
 */
public class BookingModel {
	
	String bookingId;
	
	String busFrom;
	
	String busTo;
	
	String boardingPoint;
	
	
	String travelDate;
	
	String busId;
	
	int noOfSeats;
	
	String seatArray[];
	
	User user ;
	
	Bus bus;
	
	String userId;
	
	String busTime;	
	
	
	

	/**
	 * @param bookingId
	 * @param busFrom
	 * @param busTo
	 * @param boardingPoint
	 * @param travelDate
	 * @param busId
	 * @param noOfSeats
	 * @param seatArray
	 * @param user
	 * @param bus
	 * @param userId
	 * @param busTime
	 */
	public BookingModel(String bookingId, String busFrom, String busTo, String boardingPoint, String travelDate,
			String busId, int noOfSeats, String[] seatArray, User user, Bus bus, String userId, String busTime) {
		this.bookingId = bookingId;
		this.busFrom = busFrom;
		this.busTo = busTo;
		this.boardingPoint = boardingPoint;
		this.travelDate = travelDate;
		this.busId = busId;
		this.noOfSeats = noOfSeats;
		this.seatArray = seatArray;
		this.user = user;
		this.bus = bus;
		this.userId = userId;
		this.busTime = busTime;
	}




	/**
	 * 
	 */
	public BookingModel() {
	}




	/**
	 * @return the bookingId
	 */
	public String getBookingId() {
		return bookingId;
	}




	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}




	/**
	 * @return the busFrom
	 */
	public String getBusFrom() {
		return busFrom;
	}




	/**
	 * @param busFrom the busFrom to set
	 */
	public void setBusFrom(String busFrom) {
		this.busFrom = busFrom;
	}




	/**
	 * @return the busTo
	 */
	public String getBusTo() {
		return busTo;
	}




	/**
	 * @param busTo the busTo to set
	 */
	public void setBusTo(String busTo) {
		this.busTo = busTo;
	}




	/**
	 * @return the boardingPoint
	 */
	public String getBoardingPoint() {
		return boardingPoint;
	}




	/**
	 * @param boardingPoint the boardingPoint to set
	 */
	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}




	/**
	 * @return the travelDate
	 */
	public String getTravelDate() {
		return travelDate;
	}




	/**
	 * @param travelDate the travelDate to set
	 */
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}




	/**
	 * @return the busId
	 */
	public String getBusId() {
		return busId;
	}




	/**
	 * @param busId the busId to set
	 */
	public void setBusId(String busId) {
		this.busId = busId;
	}




	/**
	 * @return the noOfSeats
	 */
	public int getNoOfSeats() {
		return noOfSeats;
	}




	/**
	 * @param noOfSeats the noOfSeats to set
	 */
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}




	/**
	 * @return the seatArray
	 */
	public String[] getSeatArray() {
		return seatArray;
	}




	/**
	 * @param seatArray the seatArray to set
	 */
	public void setSeatArray(String[] seatArray) {
		this.seatArray = seatArray;
	}




	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}




	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}




	/**
	 * @return the bus
	 */
	public Bus getBus() {
		return bus;
	}




	/**
	 * @param bus the bus to set
	 */
	public void setBus(Bus bus) {
		this.bus = bus;
	}




	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}




	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}




	/**
	 * @return the busTime
	 */
	public String getBusTime() {
		return busTime;
	}




	/**
	 * @param busTime the busTime to set
	 */
	public void setBusTime(String busTime) {
		this.busTime = busTime;
	}




	@Override
	public String toString() {
		return "BookingModel [bookingId=" + bookingId + ", busFrom=" + busFrom + ", busTo=" + busTo + ", travelDate="
				+ travelDate + ", busId=" + busId + ", noOfSeats=" + noOfSeats + ", seatArray="
				+ Arrays.toString(seatArray) + ", user=" + user + ", userId=" + userId + ", busTime=" + busTime + "]";
	}

	
}
