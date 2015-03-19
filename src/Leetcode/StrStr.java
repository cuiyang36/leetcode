package Leetcode;

public class StrStr {
	
	public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null){
            return -1;
        }
        // if the needle is empty, directly return 0
        if (needle.equals("")){
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                boolean flag = true;
                for (int k = 1; k < needle.length(); k++){
                    if (haystack.charAt(i + k) != needle.charAt(k)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    return i;
                }
            }
        }
        return -1;
    }

}
