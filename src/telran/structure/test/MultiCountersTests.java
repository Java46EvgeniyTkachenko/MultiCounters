package telran.structure.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.structure.MultiCounters;
import telran.structure.MultiCountersImpl;

class MultiCountersTests {
MultiCountersImpl multiCount = new MultiCountersImpl();
//	MultiCounters multiCount;	
	@BeforeEach
	void setUp() throws Exception {
		for (int i=0; i<5; i++) {
			multiCount.addItem(String.valueOf(i));
			for (int j=i; j<5; j++) {
				multiCount.addItem(String.valueOf(j));
			}
		}
	}

	@Test
	void testAddValueGetValue() {
		
		assertEquals(null,multiCount.getValue("5"));
		assertEquals(4,multiCount.addItem("1"));
		assertEquals(5,multiCount.addItem("1"));
		assertEquals(6,multiCount.addItem("1"));
		assertEquals(6,multiCount.getValue("1"));
		
	}
	@Test
	void testRemoveValue() {

		assertFalse(multiCount.remove("5"));
		assertTrue(multiCount.remove("4"));
		
	}
	@Test
	void getMaxItemsTest() {
		
		
		Object expected[] = {"4"};
		runArraySet(expected, multiCount.getMaxItems());
		multiCount.addItem("3");
		Object expected1[] = {"4", "3"};
		runArraySet(expected1, multiCount.getMaxItems());
		multiCount.remove("3");
		runArraySet(expected, multiCount.getMaxItems());
		multiCount.remove("4");
		Object expected2[] = {"2"};
		runArraySet(expected2, multiCount.getMaxItems());

		
	}
	private void runArraySet(Object[] expected, Set<Object> maxItems) {
		assertEquals(expected.length, maxItems.size());
		for(Object item: expected) {
			assertTrue(maxItems.contains(item));
		}
		
	}

}
