package java8;

import java.time.LocalDate;

public class Student {

	
	private int studentId;
	private String studentName;
	private LocalDate dateOfBirth;
	private String gender;
	private String course;
	private LocalDate courseStartDate;
	private LocalDate courseEndDate;
	private int score;

	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
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
	public Student(int studentId, String studentName, LocalDate dateOfBirth, String gender,	String course, LocalDate courseStartDate, LocalDate courseEndDate,int score) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.course = course;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.score=score;
		
	}
	
	public Student() {
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", course=" + course + ",courseStartDate= " + courseStartDate + ",courseEndDate=" + courseEndDate + ",Score=" + score +"]";
	}
}
