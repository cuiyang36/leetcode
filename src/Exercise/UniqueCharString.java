package Exercise;

/**
 * Given a string, which contains ASI II code char, 
 * there is duplicate, not using external package, 
 * return string only have unique char in the same order.
 * @author cuiyang36
 *
 */
public class UniqueCharString {
	
	public static String uniqueCharString(String s){
		if (s == null || s.length() < 1){
			return s;
		}
		StringBuffer rst = new StringBuffer();
		StringBuffer dup = new StringBuffer();
		
		for (int i = 0; i < s.length(); i++){
			if (dup.indexOf(s.charAt(i) + "") != -1){
				continue;
			}
			if (s.substring(i + 1).indexOf(s.charAt(i)) != -1){
				dup.append(s.charAt(i));
				continue;
			}
			rst.append(s.charAt(i));
		}
		
		return rst.toString();
	}
	
	public static void main(String[] args){
		String s = "23981c92889008114u889i776ya8094068ng128941380";
		String rst = uniqueCharString(s);
		System.out.println(rst);
	}

}
