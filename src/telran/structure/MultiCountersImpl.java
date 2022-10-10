package telran.structure;

import java.util.Map.Entry;
import java.util.*;

public class MultiCountersImpl implements MultiCounters {
	HashMap<Object, Integer> items = new HashMap<>(); // key - item, value - counter
	TreeMap<Integer, HashSet<Object>> counters = new TreeMap<>(); // key counter, value - set of items having the key -
																	// counter

	@Override
	public Integer addItem(Object item) {

		Integer res = items.merge(item, 1, Integer::sum);
		if (res > 1) {
			removeCountItem(res - 1, item);
		}
		counters.computeIfAbsent(res, e -> new HashSet<>()).add(item);
		return res;
	}

	private void removeCountItem(Integer count, Object item) {
		HashSet<Object> set = counters.get(count);
		set.remove(item);
		if (set.isEmpty()) {
			counters.remove(count);
		}

	}

	@Override
	public Integer getValue(Object item) {

		return items.get(item);
	}

	@Override
	public boolean remove(Object item) {
		Integer count = items.remove(item);
		if (count != null) {
			removeCountItem(count, item);
		}
		return count != null;
	}

	@Override
	public Set<Object> getMaxItems() {
		Entry<Integer, HashSet<Object>> countMax = counters.lastEntry();
		return countMax != null ? countMax.getValue() : Collections.emptySet();

	}

}
