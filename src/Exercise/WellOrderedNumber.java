package Exercise;

import java.util.ArrayList;

public class WellOrderedNumber {
	/**
	 * Write a function which, given n, prints all well-ordered integers of n digits. 
	 * A well ordered number is one where the value of the i-th digit is less than 
	 * the value of the i+1 digit.
	 */
	
	public static ArrayList<Integer> wellOrderedNumber(int n){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (n <= 0){
			return result;
		}
		for (int i = 0; i <= 9; i++){
			result.add(i);
		}
		if (n == 1){
			return result;
		}
		result.remove(0);
		while (n > 1){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for (Integer i: result){
				if (i % 10 < 9){
					for (int j = i % 10 + 1; j <= 9; j++){
						tmp.add(i * 10 + j);
					}
				}
			}
			result = tmp;
			n -= 1;
		}
		return result;
	}
	
	public static void main(String[] args){
		int n = 3;
		ArrayList<Integer> result = wellOrderedNumber(n);
		for (Integer e: result){
			System.out.println(e);
		}
	}

}
