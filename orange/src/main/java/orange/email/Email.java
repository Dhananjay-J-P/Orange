package orange.email;

public class Email {
	
	private String from, to, subject, msg;
	
	public Email(String from, String to, String subject, String msg) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.msg = msg;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
		

}
