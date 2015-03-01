package Exercise;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * There are two problems whne using hashMap: 
 * 1. Cannot decrease the time comlexity from O(n ^ 2)
 * 2. Using too many heap spaces, since String cost more than Integer
 * @author cuiyang36
 *
 */
public class NumOfDistinctSubstringOfString {
	
	private static int numOfDistinctSubstringOfStringMethod1(String s){
		if (s == null || s.length() < 1){
			return 0;
		}
		Set<String> visited = new HashSet<String>();
		for (int i = 0; i < s.length(); i++){
			for (int j = i; j < s.length(); j++){
				visited.add(s.substring(i, j + 1));
			}
		}
		return visited.size();
	}
	
	public static int numOfDistinctSubstringOfStringMethod2(String s){
		if (s == null || s.length() < 1){
			return 0;
		}
		STreeNode root = SuffixTree.makeSuffixTree(s);
		return SuffixTree.numberOfNode(root);
	}
	
	private static char getRandomChar(){
		Random ran = new Random();
		int base = 'z' - 'a' + 1;
		return (char) ('a' + ran.nextInt(base));
	}
	
	private static String generateRandomString(int length){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++){
			sb.append(getRandomChar());
		}
		return sb.toString();
	}
	

	public static void main(String[] args){
		/**
		 * Test for String length: 2000
         * Standard hash method number: 1997568
         * Time used: 5795 ms
         * Suffix tree method number: 1997568
         * Time used: 1639 ms
		 */
		int length = 2000;
		System.out.println("Test for length: " + length);
		String input = generateRandomString(length);
		long start1 = System.currentTimeMillis();
		int rst1 = numOfDistinctSubstringOfStringMethod1(input);
		long end1 = System.currentTimeMillis();
		System.out.println("Standard hash method: " + rst1);
		System.out.println("Time used: " + (end1 - start1));
		long start2 = System.currentTimeMillis();
		int rst2 = numOfDistinctSubstringOfStringMethod2(input);
		long end2 = System.currentTimeMillis();
		System.out.println("Suffix tree method: " + rst2);
		System.out.println("Time used: " + (end2 - start2));
	}

}
