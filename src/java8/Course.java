package java8;

import java.time.LocalDate;
import java.util.Optional;

public class Course {
	
	private String course;
	private LocalDate courseStartDate;
	private LocalDate courseEndDate;
	private int score;
	private Optional<Student> student;
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public LocalDate getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(LocalDate courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	public LocalDate getCourseEndDate() {
		return courseEndDate;
	}
	public void setCourseEndDate(LocalDate courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Optional<Student> getStudent() {
		return student;
	}
	public void setStudent(Optional<Student> student) {
		this.student = student;
	}
	
	public Course(String course, LocalDate courseStartDate, LocalDate courseEndDate, int score) {
		super();
		this.course = course;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.score=score;
	}
	
	
	@Override
	public String toString() {
		return "Course [course=" + course + ", courseStartDate=" + courseStartDate + ", courseEndDate=" + courseEndDate + ", Score=" + score + "]";
	}
	Course() {
		
	}
	

}
