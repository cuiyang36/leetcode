package Leetcode;

public class ReverseWordsinaString {
	
	public String reverseWords(String s) {
        if (s == null){
            return s;
        }
        s = s.trim();
        s = " " + s;
        StringBuffer rst = new StringBuffer();
        String curr = "";
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) == ' '){
                if (curr.length() > 0){
                    rst.append(curr + " ");
                    curr = "";
                }
            }else{
                curr = s.charAt(i) + curr;
            }
        }
        return rst.toString().trim();
    }

}
