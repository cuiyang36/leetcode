package Leetcode;

public class DivideTwoIntegers {

	public static int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MAX_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        int flag = 1;
        if ((divisor > 0 && dividend < 0) || (divisor < 0 && dividend > 0)){
            flag = -1;
        }
        // import cast format
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        System.out.println(a);
        System.out.println(b);
        int rst = 0;
        while (a >= b){
            int curr = 0;
            while ((b << curr) <= a){
                curr += 1;
            }
            System.out.println(curr - 1);
            a -= (b << (curr - 1));
            rst += (1 << (curr - 1));
            
        }
        return flag * rst;
    }
	
	public static void main(String[] args){
		int rst = divide(-1010369383, -2147483648);
		System.out.println(rst);
		StringBuffer sb = new StringBuffer();
		sb.insert(3, ' ');
	}
}
