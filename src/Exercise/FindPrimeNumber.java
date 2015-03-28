package Exercise;

import java.util.LinkedHashSet;
import java.util.Set;

public class FindPrimeNumber {

	public static int findPrimeNumber(int n){
		if (n <= 1){
			return 0;
		}
		Set<Integer> set = new LinkedHashSet<Integer>();
		for (int i = 2; i <= n; i++){
			boolean flag = false;
			for (Integer ele: set){
				if (i % ele == 0){
					flag = true;
					break;
				}
			}
			if (!flag){
				set.add(i);
			}
		}
		return set.size();
	}
}
