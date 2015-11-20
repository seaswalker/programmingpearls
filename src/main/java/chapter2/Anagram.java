package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 变位词
 * @author skywalker
 *
 */
public class Anagram {

	/**
	 * 找出变位词集合
	 * @param dict 词典，简单起见，仅寻找pots的变位词
	 */
	private static List<String> findAnagrams(String[] dict) {
		List<String> anagrams = new ArrayList<String>();
		String seed = "opst";
		char[] arr;
		for (String str : dict) {
			arr = str.toCharArray();
			Arrays.sort(arr);
			if (new String(arr).equals(seed)) {
				anagrams.add(str);
			}
		}
		return anagrams;
	}
	
	public static void main(String[] args) {
		System.out.println(findAnagrams(new String[] {"pots", "stop", "tops", "shift"}));
	}
	
}
