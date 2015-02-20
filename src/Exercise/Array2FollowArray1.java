package Exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * If array2 has the element in array1, output the element just like array1,
 * or output the natural sequence
 * array2: 0, 6, 3, 8, 4, 5, 2
 * array1: 5, 2, 6, 8, -1, 3
 * output: 5, 2, 6, 8, 3, 0, 4
 * @author cuiyang36
 *
 */
public class Array2FollowArray1 {

	public static int[] array2FollowArray1(int[] array1, int[] array2){
		if (array1 == null || array1.length < 1 || array2 == null || array2.length < 1){
			return array2;
		}
		int[] rst = new int[array2.length];
	    Set<Integer> set = new HashSet<Integer>();
	    for (int ele: array2){
	    	set.add(ele);
	    }
	    int index = 0;
	    for (int ele: array1){
	    	if (set.contains(ele)){
	    		rst[index++] = ele;
	    	}
	    }
	    set.clear();
	    for (int ele: array1){
	    	set.add(ele);
	    }
	    for (int ele: array2){
	    	if (!set.contains(ele)){
	    		rst[index++] = ele;
	    	}
	    }
	    return rst;
	}
	
	public static void main(String[] args){
		int[] array1 = new int[]{5, 2, 6, 8, -1, 3};
		int[] array2 = new int[]{0, 6, 3, 8, 4, 5, 2};
		int[] rst = array2FollowArray1(array1, array2);
		for (int i: rst){
			System.out.println(i);
		}
	}
}
