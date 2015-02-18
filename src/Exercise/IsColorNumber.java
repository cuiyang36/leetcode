package Exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Determine whether a number is colorful or not. 
 * 263 is a colorful number because (2,6,3,2x6,6x3,2x3x6) 
 * are all different whereas 236 is not because 
 * (2,3,6,2x3,3x6,2x3x6) have 6 twice. 
 * So take all consecutive subsets of digits, 
 * take their product and ensure all the products are different
 */

public class IsColorNumber {
	
	public static boolean isColorNumber(int n){
		if (n < 0){
			return false;
		}
		if (n == 0){
			return true;
		}
		Set<Integer> values = new HashSet<Integer>();
		List<Integer> data = new ArrayList<Integer>();
		while (n > 0){
			int curr = n % 10;
			if (values.contains(curr)){
				return false;
			}
			data.add(curr);
			values.add(curr);
			n /= 10;
		}
		for (int i = 2; i < data.size() + 1; i++){
			for (int j = 0; j < data.size() - i + 1; j++){
				int tmp = 1;
				for (int k = j; k < j + i; k++){
					tmp *= data.get(k);
				}
				System.out.println(tmp);
				if (values.contains(tmp)){
					return false;
				}
				values.add(tmp);
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		int n = 263584;
		boolean rst = isColorNumber(n);
		System.out.println(rst);
	}

}
