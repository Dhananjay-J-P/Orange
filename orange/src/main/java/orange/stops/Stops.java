package orange.stops;

public class Stops implements StopsIfc{
	
	String stopId;
	
	String stopMessageCode;

	public String getStopId() {
		return stopId;
	}

	public void setStopId(String stopId) {
		this.stopId = stopId;
	}

	public String getStopMessageCode() {
		return stopMessageCode;
	}

	public void setStopMessageCode(String stopMessageCode) {
		this.stopMessageCode = stopMessageCode;
	}

	@Override
	public String toString() {
		return "Stops [stopId=" + stopId + ", stopMessageCode=" + stopMessageCode + "]";
	}
	
	

}
