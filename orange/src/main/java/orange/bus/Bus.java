package orange.bus;

import java.util.HashSet;
import java.util.Set;

import controller.query.model.BookingModel;



public class Bus {

	String busid;
	String busNameCode;
	String operatedBy;
	String busType;
	String srcStop;
	String destStop;
	String busTime;
	String busContact;
	
	String busRoute;
	String chargePerSeat;
	String noOfSeats;
	
	Set<BookingModel> bookings=new HashSet<BookingModel>();
	
	public Set<BookingModel> getBookings() {
		return bookings;
	}
	public void setBookings(Set<BookingModel> bookings) {
		this.bookings = bookings;
	}
	
	@Override
	public String toString() {
		return "Bus [busid=" + busid + ", busNameCode=" + busNameCode + ", operatedBy=" + operatedBy + ", busType="
				+ busType + ", srcStop=" + srcStop + ", destStop=" + destStop + ", bustTime=" + busTime
				+ ", busContact=" + busContact + ", busRoute=" + busRoute + ", chargePerSeat=" + chargePerSeat
				+ ", noOfSeats=" + noOfSeats + "]";
	}
	public String getBusid() {
		return busid;
	}
	public void setBusid(String busid) {
		this.busid = busid;
	}
	public String getBusNameCode() {
		return busNameCode;
	}
	public void setBusNameCode(String busNameCode) {
		this.busNameCode = busNameCode;
	}
	public String getOperatedBy() {
		return operatedBy;
	}
	public void setOperatedBy(String operatedBy) {
		this.operatedBy = operatedBy;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getSrcStop() {
		return srcStop;
	}
	public void setSrcStop(String srcStop) {
		this.srcStop = srcStop;
	}
	public String getDestStop() {
		return destStop;
	}
	public void setDestStop(String destStop) {
		this.destStop = destStop;
	}
	public String getBusTime() {
		return busTime;
	}
	public void setBusTime(String bustTime) {
		this.busTime = bustTime;
	}
	public String getBusContact() {
		return busContact;
	}
	public void setBusContact(String busContact) {
		this.busContact = busContact;
	}
	public String getBusRoute() {
		return busRoute;
	}
	public void setBusRoute(String busRoute) {
		this.busRoute = busRoute;
	}
	public String getChargePerSeat() {
		return chargePerSeat;
	}
	public void setChargePerSeat(String chargePerSeat) {
		this.chargePerSeat = chargePerSeat;
	}
	public String getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(String noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	


}
