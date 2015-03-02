package Exercise;

/**
 * Input one String s, add the shortest String to the end of s, 
 * making the new String T a palindromic String.
 * 
 * @author cuiyang36
 *
 */

public class AddMinimumString {
	
	public static String addMinimumString(String s){
		if (s == null || s.length() < 1){
			return s;
		}
		boolean isP = true;
		int index = 0;
		// find the maximum length palindromic string from end of s
		while (index < s.length() - 1){
			if (s.charAt(index) == s.charAt(s.length() - 1)){
				isP = true;
				int left = index + 1;
				int right = s.length() - 2;
				while (right - left > 1){
					if (s.charAt(left) != s.charAt(right)){
						isP = false;
						break;
					}
					left += 1;
					right -= 1;
				}
				if (isP){
					break;
				}
			}
			index += 1;
		}
		StringBuffer sb = new StringBuffer(s);
		for (int i = index - 1; i >= 0; i--){
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	
	public static void main(String[] args){
		String s = "abcbbabb";
		String rst = addMinimumString(s);
		System.out.println(rst);
	}
}
