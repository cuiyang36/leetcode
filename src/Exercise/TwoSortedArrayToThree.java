package Exercise;

import java.util.Arrays;

/**
 * Two unsorted array
 * 
 * output 3 sorted array, one of which contains the 
 * dumplicated elements in both array 
 * 
 * Input
 * 1, 3, 5, 7, 8, 9, 10, 11 
 * 2, 4, 6, 8, 10
 * 
 * Output
 * 1, 3, 5, 7, 9, 11
 * 2, 4, 6
 * 8, 10
 */

public class TwoSortedArrayToThree {
	
	private static int[] sortRemoveDup(int[] array){
		Arrays.sort(array);
		int i = 0;
		for (int j = 0; j < array.length; j++){
			if (j != array.length - 1 && array[j] == array[j + 1]){
				continue;
			}
			array[i++] = array[j];
		}
		int[] rst = new int[i];
		System.arraycopy(array, 0, rst, 0, i);
		return rst;
	}
	
	public static int[] solve(int[] a, int[] b){
		a = sortRemoveDup(a);
		b = sortRemoveDup(b);
		int[] c = new int[Math.min(a.length, b.length)];
		int i_a = 0, i_b = 0, i_c = 0;
		int t_a = 0, t_b = 0;
		while (t_a < a.length && t_b < b.length){
			if (a[t_a] > b[t_b]){
				b[i_b++] = b[t_b++];
			}else if (a[t_a] < b[t_b]){
				a[i_a++] = a[t_a++];
			}else{
				c[i_c++] = a[t_a];
				t_a++;
				t_b++;
			}
		}
		if (t_a == a.length){
			while (t_b < b.length){
				b[i_b++] = b[t_b++];
			}
		}else{
			while (t_a < a.length){
				a[i_a++] = a[t_a++];
			}
		}
		System.out.println("\nArray a: " + "length: " + i_a);
		for (int ele: a){
			System.out.print(ele + " ");
		}
		System.out.println("\nArray b: " + "length: " + i_b);
		for (int ele: b){
			System.out.print(ele + " ");
		}
		int[] rst = new int[i_c];
		System.arraycopy(c, 0, rst, 0, i_c);
		return rst;
	}

	public static void main(String[] args){
		int[] a = new int[]{1, 3, 5, 7, 8, 9, 10, 11};
		int[] b = new int[]{2, 4, 6, 8, 10};
		int[] c = solve(a, b);
		System.out.println("\nArray c:");
		for (int ele: c){
			System.out.print(ele + " ");
		}
	}
}
