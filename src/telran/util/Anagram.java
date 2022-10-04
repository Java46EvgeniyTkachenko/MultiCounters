package telran.util;

import java.util.HashMap;

public class Anagram {
/**
 * 
 * @param word
 * @param anagram
 * @return true if anagram is one of the possible anagrams of a given word
 * anagram is a string containing all symbols from a given word with different order
 * Example: yellow (wolely, lowlye, yellow) , wrong anagrams (yello, yelllw)
 */
	public static boolean isAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		char arr1[] = word.toCharArray();
		char arr2[] = anagram.toCharArray();

		for (int i = 0; i < arr1.length; i++) {
			hashmap.compute(arr1[i], (k, v) -> v != null ? ++v : 1);
			hashmap.compute(arr2[i], (k, v) -> v != null ? --v : -1);
			}
		for (HashMap.Entry<Character, Integer> set : hashmap.entrySet()) {
			
			if (set.getValue() != 0) {
				return false;
			}
		}
		return true;
}


}
