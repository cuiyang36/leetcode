package Exercise;

/**
 * a#3bd#5 --> aaabddddd
 * assuming all the inputs are validated
 * 
 * @author cuiyang36
 *
 */
public class StringConversion {
	
	public static String stringConversion(String input){
		StringBuffer sb = new StringBuffer();
		if (input == null || input.length() < 1){
			return sb.toString();
		}
		int index = 0;
		while (index < input.length()){
			if (index != input.length() - 1 && input.charAt(index + 1) == '#'){
				int tmp = index + 2;
				while (tmp < input.length() && (input.charAt(tmp) + "").matches("\\d+")){
					tmp += 1;
				}
				int num = Integer.parseInt(input.substring(index + 2, tmp));
				while (num > 0){
					sb.append(input.charAt(index));
					num -= 1;
				}
				index = tmp;
			}else{
				sb.append(input.charAt(index));
				index += 1;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		String input = "a#10bd#5";
		String rst = stringConversion(input);
		System.out.println(rst);
	}

}
