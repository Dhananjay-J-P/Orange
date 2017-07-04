package orange.bus.seats;

import java.io.Serializable;

public class Seat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Seat(  String busId, String travelDate , String seatId, String status) {
		super();
		this.seatId = seatId;
		this.status = status;
		this.busId = busId;
		this.travelDate = travelDate;
	}

	public Seat()
	{
		
	}
	private String seatId;
	
	private String status;

	private String busId;
	
	private String travelDate;

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getStatus() {
		return status;
	}
	
	public boolean isBooked()
	{
		return status.equalsIgnoreCase("booked")? true:false;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", status=" + status + ", busId=" + busId + ", travelDate=" + travelDate
				+ "]";
	}
	
	
	

}
