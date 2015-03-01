package Exercise;

/**
 * a = [3, 2, 5, 8, 7, 3, 6] 
 * define unorderness = # of indexes (i, j) such that
 * a > a[j] && i < j 
 * (a, a[j]) = (3, 2) (5, 3) (8, 3) (8, 6) (7, 3) (7, 6) (8, 7) 
 * total 6 unordered pairs ? how do I get this number?
 **/
public class Unorderness {

	public static int unorderness(int[] array){
		if (array == null || array.length < 1){
			return 0;
		}
		return mergeSort(array, 0, array.length - 1);
	}
	
	private static int mergeSort(int[] array, int start, int end){
		if (end <= start){
			return 0;
		}
		int num = (end - start + 1) / 2;
		int left = mergeSort(array, start, start + num - 1);
		int right = mergeSort(array, start + num, end);
		int sec = merge(array, start, start + num - 1, start + num, end);
		return left + right + sec;
	}
	
	private static int merge(int[] array, int s1, int e1, int s2, int e2){
		//System.out.println(s1 + " " + e1 + " " + s2 + " " + e2);
		int[] src = new int[e1 - s1 + 1 + e2 - s2 + 1];
		int sec = 0;
		int i_0 = 0, i_1 = s1, i_2 = s2;
		while (i_1 <= e1 && i_2 <= e2){
			if (array[i_1] > array[i_2]){
				sec += (e1 - i_1 + 1);
				src[i_0++] = array[i_2++];
			}else{
				src[i_0++] = array[i_1++];
			}
		}
		if (i_1 > e1){
			while (i_2 <= e2){
				src[i_0++] = array[i_2++];
			}
		}else{
			while (i_1 <= e1){
				src[i_0++] = array[i_1++];
			}
		}
		System.arraycopy(src, 0, array, s1, e1 - s1 + 1);
		System.arraycopy(src, e1 - s1 + 1, array, s2, e2 - s2 + 1);
		//System.out.println("sec: " + sec);
		return sec;
	}
	
	public static void main(String[] args){
		int[] array = new int[]{3, 2, 5, 8, 7, 3, 6};
		int rst = unorderness(array);
		System.out.println(rst);
	}
}
