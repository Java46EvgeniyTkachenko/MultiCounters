package telran.util;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackInt {
	private LinkedList<Integer> numbers = new LinkedList<>();
	private LinkedList<Integer> maxNumbers = new LinkedList<>();
public int pop() {
	//removes last number and returns removed number
	//throws exception NoSuchElementException for empty stack
	if (numbers.isEmpty()) {
		throw new NoSuchElementException();
	}
	int res = numbers.removeLast();
	if (res == maxNumbers.getLast()) {
		maxNumbers.removeLast();
	}
	return res;
}
public void push(int number) {
	//adds number at end of a stack
	numbers.add(number);
	if (maxNumbers.isEmpty() || number >= maxNumbers.getLast()) {
		maxNumbers.add(number);
	}
}
public boolean isEmpty() {
	//returns true if a stack is empty
	return numbers.isEmpty();
}
public int getMaxNumber() {
	//returns maximal number existing in a stack
	//throws exception NoSuchElementException for empty stack
	if (maxNumbers.isEmpty()) {
		throw new NoSuchElementException();
	}
	return maxNumbers.getLast();
}
}
