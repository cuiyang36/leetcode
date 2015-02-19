package Exercise;

public class BuyAndSell2Another {

	public static int buyAndSell2Another(int[] A) {
        if (A == null || A.length < 1){
            return 0;
        }
        int[] left = new int[A.length];
        left[0] = A[0];
        for (int i = 1; i < A.length; i++){
        	if (A[i] >= A[i - 1]){
        		left[i] = A[i];
        	}else{
        		left[i] = Math.max(left[i - 1], A[i]);
        	}
        }
        int[] right = new int[A.length];
        right[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--){
        	if (A[i] >= A[i + 1]){
        		right[i] = A[i];
        	}else{
        		right[i] = Math.max(right[i + 1], A[i]);
        	}
        }
        int rst = 0;
        for (int i = 0; i < A.length - 1; i++){
            rst = Math.max(rst, Math.min(right[i] - A[i], left[i] - A[i]));
            System.out.println(right[i] - A[i]);
            System.out.println(A[i] - left[i]);
        }
        return rst;
    }
	
	public static void main(String[] args){
		int[] input = {0, 1, 3, -2, 0, 1, 0, -3, 2, 3};
		System.out.println("result: " + buyAndSell2Another(input));
	}
}
