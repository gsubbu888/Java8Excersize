package java8;

import java.time.LocalTime;

public class TimeInterval {
	
	private LocalTime intervelStartTime;
	private LocalTime intervelEndTime;
	public LocalTime getIntervelStartTime() {
		return intervelStartTime;
	}
	public void setIntervelStartTime(LocalTime intervelStartTime) {
		this.intervelStartTime = intervelStartTime;
	}
	public LocalTime getIntervelEndTime() {
		return intervelEndTime;
	}
	public void setIntervelEndTime(LocalTime intervelEndTime) {
		this.intervelEndTime = intervelEndTime;
	}
	
	public TimeInterval(LocalTime intervelStartTime,LocalTime intervelEndTime) {
		this.intervelStartTime = intervelStartTime;
		this.intervelEndTime = intervelEndTime;
	}
	
	public TimeInterval() {
	}
	
	@Override
	public String toString() {
		return "TimeInterval [intervelStartTime=" + intervelStartTime + ", intervelEndTime=" + intervelEndTime + "]";
	}

}
