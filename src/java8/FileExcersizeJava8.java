package java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileExcersizeJava8 {

	public static void main(String[] args) {

		String fileName = "D:\\Courses\\processFile.txt";

		Path path = Paths.get(fileName);
		LocalTime startTime = LocalTime.now(ZoneId.systemDefault());

		/*
		 * try (BufferedWriter writer = Files.newBufferedWriter(path,
		 * StandardCharsets.UTF_8)) { int id = 7140001; int min = 10; int max = -60;
		 * 
		 * int minHour = 10; int maxHour = 60; for (int i = 0; i < 3; i++) { //
		 * writer.write(id+i+","+startTime.plusMinutes((int)(Math.random()*(max-min+1)+
		 * min))+","+endTime.plusMinutes((int)(Math.random()*(maxHour-minHour+1)+minHour
		 * ))+"\n");
		 * 
		 * writer.write( id + i + "," + startTime.plusMinutes((int) (Math.random() *
		 * (maxHour - minHour + 1) + minHour)) + "," + startTime.plusMinutes((int)
		 * (Math.random() * (max - min + 1) + min)) + "\n");
		 * 
		 * } id = 8140001; for (int i = 0; i < 2; i++) { writer.write( id + i + "," +
		 * startTime.plusMinutes((int) (Math.random() * (maxHour - minHour + 1) +
		 * minHour)) + "," + startTime.plusMinutes((int) (Math.random() * (max - min +
		 * 1) + min)) + "\n");
		 * 
		 * } id = 9140001; for (int i = 0; i < 4; i++) { //
		 * writer.write(id+i+","+startTime.plusMinutes((int)(Math.random()*(max-min+1)+
		 * min))+","+endTime.plusMinutes((int)(Math.random()*(maxHour-minHour+1)+minHour
		 * ))+"\n");
		 * 
		 * writer.write( id + i + "," + startTime.plusMinutes((int) (Math.random() *
		 * (maxHour - minHour + 1) + minHour)) + "," + startTime.plusMinutes((int)
		 * (Math.random() * (max - min + i) + min)) + "\n");
		 * 
		 * }
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */
		List<String> recordslist = new ArrayList<>();

		List<FileDetails> fileDetailslist = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			recordslist = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String record : recordslist) {
			FileDetails fdetails = new FileDetails();
			String[] recArray = record.split(",");
			fdetails.setVisitId(recArray[0]);
			fdetails.setLoginTime(LocalTime.parse(recArray[1]));
			fdetails.setLogoutTime(LocalTime.parse(recArray[2]));
			fdetails.setDuration(
					Duration.between(LocalTime.parse(recArray[1]), LocalTime.parse(recArray[2])).toMinutes());
			fileDetailslist.add(fdetails);

		}

		fileDetailslist.forEach(System.out::println);

		Map<LocalTime, List<FileDetails>> loginTimeMap = fileDetailslist.stream()
				.collect(Collectors.groupingBy(FileDetails::getLoginTime));

		// Map<LocalTime,String> map=new HashMap<LocalTime,String>();

		loginTimeMap = loginTimeMap.entrySet().stream().sorted(Map.Entry.<LocalTime, List<FileDetails>>comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		loginTimeMap.entrySet().forEach(System.out::println);

		Map<LocalTime, List<FileDetails>> logoutTimeMap = fileDetailslist.stream()
				.collect(Collectors.groupingBy(FileDetails::getLogoutTime));

		logoutTimeMap = logoutTimeMap.entrySet().stream()
				.sorted(Map.Entry.<LocalTime, List<FileDetails>>comparingByKey()).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		// logoutTimeMap.entrySet().forEach(System.out::println);

		LocalTime loginFirstValue = loginTimeMap.entrySet().stream().findFirst().get().getKey();

		final long count = loginTimeMap.entrySet().stream().count();
		LocalTime loginLastValue = loginTimeMap.entrySet().stream().skip(count - 1).findFirst().get().getKey();

		System.out.println("firstValue=====>" + loginFirstValue);
		System.out.println("lastValue=====>" + loginLastValue);

		List<Integer> hourList = Stream.iterate(loginFirstValue, h -> h.plusHours(1))
				.limit(ChronoUnit.HOURS.between(loginFirstValue, loginLastValue) + 1).map(LocalTime::getHour)
				.collect(Collectors.toList());

		// hourList.stream().forEach(t -> System.out.println(t));
		List<TimeInterval> timeIntervals = new ArrayList<TimeInterval>();

		for (int i : hourList) {
			TimeInterval t1 = new TimeInterval();
			t1.setIntervelStartTime(LocalTime.of(i, 0));
			t1.setIntervelEndTime(LocalTime.of(i + 1, 0));
			timeIntervals.add(t1);

		}
		mapFinal(loginTimeMap, timeIntervals);

	}

	public static void timeStream(LocalTime startTime, LocalTime endTime) {

		List<Integer> hourList = Stream.iterate(startTime, h -> h.plusMinutes(1))
				.limit(ChronoUnit.MINUTES.between(startTime, endTime) + 1).map(LocalTime::getMinute)
				.collect(Collectors.toList());

		hourList.stream().forEach(t -> System.out.println(t));

	}

	public static void mapFinal(Map<LocalTime, List<FileDetails>> loginTimeMap, List<TimeInterval> timeIntervals) {


		Map<TimeInterval, Integer> result = new HashMap<TimeInterval, Integer>();
		for (TimeInterval t : timeIntervals) {

			loginTimeMap.entrySet().forEach(e -> {

				if (t.getIntervelStartTime().getHour() == e.getKey().getHour()) {
					int c = 0;
					if (result.get(t) != null) {
						c = result.get(t);
					}

					result.put(t, c + 1);
				}

			});

		}
		System.out.println("**************************s");
		result.entrySet().forEach(System.out::println);
	}

}
