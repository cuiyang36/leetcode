package Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入："priistiistoomdd"
 * 输出：i, i, o, d
 * 
 * 输入："priiistiistoomdd"
 * 输出：i
 */


public class PrintMostFrequent {

	public static void printMostFrequent(String s){
		if (s == null || s.length() < 1){
			return;
		}
		s = s + "$";
		int max = 1;
		List<Character> rst = new ArrayList<Character>();
		char curr = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++){
			if (s.charAt(i) == curr){
				count += 1;
			}else{
				if (count > max){
					max = count;
					rst.clear();
					rst.add(curr);
				}else if (count == max){
					rst.add(curr);
				}
				curr = s.charAt(i);
				count = 1;
			}
		}
		for (Character c: rst){
			System.out.print(c + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		printMostFrequent("priistiistoomdd");
		printMostFrequent("priiistiistoomdd");
		printMostFrequent("priistiistoomddii");
	}
	
}
