package Leetcode;

public class ExcelSheetColumnTitle {
	
	public static String numberToTitle(int n) {
        String rst = "";
        if (n <= 0){
            return rst;
        }
        int base = 'Z' - 'A' + 1;
        while (n > 0){
            int p = n % base;
            if (p == 0){
                n -= base;
                rst = 'Z' + rst;
            }else{
                rst = (char)('A' + p - 1) + rst;
            }
            n /= base;
        }
        return rst;
    }
	
	public static int titleToNumber(String s) {
        int rst = 0;
        if (s == null || s.length() < 1){
            return rst;
        }
        int base = 'Z' - 'A' + 1;
        for (int i = 0; i < s.length(); i++){
            rst = base * rst + (int)(s.charAt(i) - 'A' + 1);
        }
        return rst;
    }

	public static void main(String[] args){
		String rst = numberToTitle(18954);
		System.out.println(rst);
		int num = titleToNumber(rst);
		System.out.println(num);
	}
}
