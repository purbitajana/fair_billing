package main.com.bt.asmt.model;

import java.util.Date;

import main.com.bt.asmt.enums.Status;
/*
 * Represents a session as obtained from a single log line
 * It includes the timestamp, name of the user and the status of the session i.e. start or end
 */
public class Session {
	private Date timeStamp;
	private String userName;
	private Status status;
	
	public Session(Date timeStamp, String userName, Status status) {
		super();
		this.timeStamp = timeStamp;
		this.userName = userName;
		this.status = status;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Session [timeStamp=" + timeStamp + ", userName=" + userName + ", status=" + status + "]";
	}
}

