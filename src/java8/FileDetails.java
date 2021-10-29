package java8;

import java.time.Duration;
import java.time.LocalTime;

public class FileDetails {
	
	private String visitId;
	private LocalTime loginTime;
	private LocalTime logoutTime;
	private long duration;
	
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public LocalTime getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(LocalTime loginTime) {
		this.loginTime = loginTime;
	}
	public LocalTime getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(LocalTime logoutTime) {
		this.logoutTime = logoutTime;
	}
	
	public FileDetails(String visitId, LocalTime loginTime, LocalTime logoutTime,long duration) {
		this.visitId = visitId;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.duration = duration;
		

	}
	
	public FileDetails() {
	}
	
	@Override
	public String toString() {
		return "FileDetails [visitId=" + visitId + ", loginTime=" + loginTime + ", logoutTime=" + logoutTime + ", duration=" + duration +"]";
	}

}
