package main.com.bt.asmt.model;
/*
 * Represents the session data for reporting
 * A user can have more than one sessions represented by session count
 * Duration represents the total active duration of a user in a day
 */
public class ReportData {
	private String userName;
	private int sessionCount;
	private long duration;
	
	public ReportData(int sessionCount, long sessionDuration) {
		super();
		this.sessionCount = sessionCount;
		this.duration = sessionDuration;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getSessionCount() {
		return sessionCount;
	}
	public void setSessionCount(int sessionCount) {
		this.sessionCount = sessionCount;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	
}
