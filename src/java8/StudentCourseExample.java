package java8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentCourseExample {

	public static void main(String[] args) {

		Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
		studentMap.put(1, new Student(1, "Subramanyam", LocalDate.of(1989, 8, 13), "Male", "Java",
				LocalDate.of(2021, 1, 7), LocalDate.of(2021, 6, 28),89));
		studentMap.put(2, new Student(2, "RajaShekar", LocalDate.of(1991, 2, 22), "Male", "Spring",
				LocalDate.of(2021, 2, 12), LocalDate.of(2021, 6, 10),78));
		studentMap.put(3, new Student(3, "Venkey", LocalDate.of(1994, 3, 3), "Male", "Python",
				LocalDate.of(2021, 6, 10), LocalDate.of(2021, 9, 12),67));
		studentMap.put(4, new Student(4, "Radha", LocalDate.of(1994, 6, 15), "Female", "DBA",
				LocalDate.of(2021, 11, 10), LocalDate.of(2021, 12, 22),56));
		studentMap.put(5, new Student(5, "raja", LocalDate.of(1990, 8, 31), "Male", "Java", LocalDate.of(2021, 1, 7),
				LocalDate.of(2021, 6, 28),79));
		studentMap.put(6, new Student(6, "Mahesh", LocalDate.of(1989, 8, 1), "Male", "Spring",
				LocalDate.of(2021, 12, 12), LocalDate.of(2021, 12, 12),79));
		studentMap.put(7, new Student(7, "Ramesh", LocalDate.of(1991, 9, 11), "Male", "Java", LocalDate.of(2021, 1, 7),
				LocalDate.of(2021, 6, 28),56));
		studentMap.put(8, new Student(8, "Rajesh", LocalDate.of(2000, 8, 15), "Male", "Python",
				LocalDate.of(2021, 10, 26), LocalDate.of(2021, 12, 12),90));
		studentMap.put(9, new Student(9, "Reethika", LocalDate.of(2001, 8, 31), "Female", "Java",
				LocalDate.of(2021, 1, 7), LocalDate.of(2021, 6, 28),65));

		System.out.println("Java Course Student List=========>");
		getJavaCourseStudents(studentMap);

		System.out.println(" Next Week Course Student List=========>");

		LocalDate today = LocalDate.now();

		LocalDate nextWeekDate = today.plus(1, ChronoUnit.WEEKS);
		List<LocalDate> nextWeekDateList = getDatesBetweenUsingJava8(today, nextWeekDate);

		getCourseListNextWeek(studentMap, nextWeekDateList);

		System.out.println(" Next Month Course Student List=========>");

		getCourseListNextMonth(studentMap);
		
		System.out.println(" Avg score of Course List=========>");
		
		getAvgScoreOfEachCourse(studentMap);
		

	}

	public static List<LocalDate> getDatesBetweenUsingJava8(LocalDate startDate, LocalDate endDate) {

		return IntStream.iterate(0, i -> i + 1).limit(ChronoUnit.DAYS.between(startDate, endDate))
				.mapToObj(i -> startDate.plusDays(i)).collect(Collectors.toList());
	}

	private static void getJavaCourseStudents(Map<Integer, Student> studentMap) {
		Set<Student> studentList = studentMap.values().stream().filter(student -> student.getCourse().equals("Java"))
				.collect(Collectors.toSet());
		studentList.forEach(System.out::println);

	}

	private static void getCourseListNextWeek(Map<Integer, Student> studentMap, List<LocalDate> dates) {
		List<Student> finalstudentList = new ArrayList<Student>();

		for (LocalDate date : dates) {

			List<Student> studentList = studentMap.values().stream()
					.filter(student -> student.getCourseStartDate().equals(date)).collect(Collectors.toList());
			finalstudentList.addAll(studentList);
		}
		finalstudentList.forEach(System.out::println);

	}

	private static void getCourseListNextMonth(Map<Integer, Student> studentMap) {

		List<Student> studentList = studentMap.values().stream()
				.filter(student -> student.getCourseStartDate().getMonth().equals(LocalDate.now().getMonth().plus(1)))
				.collect(Collectors.toList());
		studentList.forEach(System.out::println);

	}
	private static void getAvgScoreOfEachCourse(Map<Integer, Student> studentMap) {
			
		Map<String, List<Course>> courseMap=studentMap.values().stream().map(student->courseMapper(student)).collect(Collectors.groupingBy(Course::getCourse));
		Map<String,Double> coursesAvgMap=new HashMap<String,Double>();
		courseMap.entrySet().forEach(e->{
			double average= e.getValue().stream().map(Course::getScore)
                    .mapToInt((x) -> x)
                    .summaryStatistics().getAverage();
			
			coursesAvgMap.put(e.getKey(), average);
		});
			
		coursesAvgMap.entrySet().stream().forEach(System.out::println);
	}
	
	private static Course courseMapper(Student student) {
		Course course = new Course(student.getCourse(), student.getCourseStartDate(), student.getCourseEndDate(),student.getScore());
		return course;
	}

}
