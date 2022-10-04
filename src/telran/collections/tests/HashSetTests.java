package telran.collections.tests;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class HashSetTests {
Integer numbers[] = {40, 20, 32, 9, 64};
HashSet<Integer> hashSet;
LinkedHashSet<Integer> linkedHashSet;
@BeforeEach
void setUp() {
	hashSet = new HashSet<>(Arrays.asList(numbers));
	linkedHashSet = new LinkedHashSet<>(Arrays.asList(numbers));
}
@Test
void toArrayTest() {
	Integer expectedHashSet[] = {32, 64, 20, 40, 9};
	Integer expectedLinkedHashSet[] = Arrays.copyOf(numbers, numbers.length);
	assertArrayEquals(expectedHashSet, hashSet.toArray(Integer[]::new));
	assertArrayEquals(expectedLinkedHashSet, linkedHashSet.toArray(Integer[]::new));
}
}
