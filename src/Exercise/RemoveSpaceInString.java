package Exercise;

public class RemoveSpaceInString {
	
	public static String removeSpace(String s){
		if (s == null || s.length() < 1){
			return s;
		}
		s = s.trim() + " ";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length() - 1; i++){
			if (s.charAt(i) == ' '){
				if (s.charAt(i + 1) != ' ' && (s.charAt(i + 1) + "").matches("[0-9a-zA-Z]{1}")){
					sb.append(s.charAt(i));
				}
			}else{
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		String s = "  The    sky  is   beautiful  ,  I like    4  ! ";
		String rst = removeSpace(s);
		System.out.println(rst);
	}

}
