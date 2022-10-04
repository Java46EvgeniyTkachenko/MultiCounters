package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.Map.Entry;
class MapTests {

	@Test
	void occurrencesTest() {
		String strings[] = {"lpm", "abc", "ab", "a", "lpm", "abc", "lpm"};
		displayStringOccurrences(strings);
		/*
		 lpm => 3
		 abc => 2
		 a => 1
		 ab => 1 
		 *  */
		
	}

	private void displayStringOccurrences(String[] strings) {
		Map<String, Integer> mapOccurrences = getMapOccurrences(strings);
		List<Entry<String, Integer>> sortedListOccurrences = getSortedList(mapOccurrences);
		displayListOccurrences(sortedListOccurrences);
		
	}

	private void displayListOccurrences(List<Entry<String, Integer>> list) {
		list.forEach(e -> System.out.printf("%s => %d\n", e.getKey(), e.getValue()));
		
	}

	private List<Entry<String, Integer>> getSortedList(Map<String, Integer> mapOccurrences) {
		List<Entry<String, Integer>> res = new ArrayList<>(mapOccurrences.entrySet());
		res.sort((e1, e2) -> {
			int cmpRes = Integer.compare(e2.getValue(), e1.getValue());
			if (cmpRes == 0) {
				cmpRes = e1.getKey().compareTo(e2.getKey());
			}
			return cmpRes;
		});
		return res;
	}

	private Map<String, Integer> getMapOccurrences(String[] strings) {
		Map<String, Integer> res = new HashMap<>();
		for (String str: strings) {
			Integer count = res.getOrDefault(str, 0);
			res.put(str, count + 1);
		}
		return res;
	}

}
