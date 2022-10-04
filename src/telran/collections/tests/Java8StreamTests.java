package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Java8StreamTests {
	static class Programmer {
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		public String[] getTechnolgies() {
			return technolgies;
		}
		public Programmer(String name, int age, String[] technolgies) {
			super();
			this.name = name;
			this.age = age;
			this.technolgies = technolgies;
		}
		String name;
		int age;
		String [] technolgies;
		
	}
	List<Programmer> programmers;
	String[] technologies1 = {"Java", "SQL", "C++"};
	String[] technologies2 = {"Java"};
	String[] technologies3 = {"Java", "React", "SQL"};
	@BeforeEach
	void setUp() {
		programmers = Arrays.asList(new Programmer("Vasya", 30, technologies1),
				new Programmer("Petya", 25, technologies2),
				new Programmer("Sara", 35, technologies1));
	}

	@Test
	void testSumTwoDimArray() {
		int ar[][] = {{Integer.MAX_VALUE, 2}, {3, 4, 5}, {7}};
		assertEquals(Integer.MAX_VALUE + 21L, sumTwoDimArray(ar));
	}

	private Long sumTwoDimArray(int[][] ar) {
		
		return Arrays.stream(ar).flatMapToInt(a -> Arrays.stream(a)).asLongStream().sum();
	}
	@Test
	void averageProgrammersAgeTest() {
		assertEquals(30.0, getAverageAge());
	}

	private Double getAverageAge() {
		
//		return programmers.stream().mapToInt(p->p.getAge())
//				.average().getAsDouble();
		return programmers.stream().collect(Collectors.averagingInt(Programmer::getAge));
	}
	@Test
	void mostPopularTechnologyTest() {
		assertEquals("Java", getMostPopularTechnology());
	}

	private String getMostPopularTechnology() {
		
		return programmers.stream().flatMap(p->Arrays.stream(p.getTechnolgies()))
				.collect(Collectors.groupingBy(t -> t, Collectors.counting()))
				.entrySet().stream()
				.sorted((e1, e2)->Long.compare(e2.getValue(), e1.getValue()))
				.map(Map.Entry<String, Long>::getKey)
				.findFirst().orElse(null);
	}
	@Test
	void printDigitOccurrences() {
		int MINIMAL_VALUE = 0;
		int RUNS_NUMBER = 1000000;
		// generate 1_000_000 random numbers from 0 to Integer.MAX_VALUE
		// print digits occurrences in descending order of occurrences
		// 1: <occurrences>
		// 2: <occurrences>
		// ......

		new Random().ints(RUNS_NUMBER, MINIMAL_VALUE, Integer.MAX_VALUE).flatMap(x -> Integer.toString(x).chars())
				.boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream()
				.sorted((x1, x2) -> Long.compare(x2.getValue(), x1.getValue()))
				.forEach(x -> System.out.printf("%c -> %d\n", x.getKey(), x.getValue()));
	}
	
	
	

}
