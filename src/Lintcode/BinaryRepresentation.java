package Lintcode;

public class BinaryRepresentation {
	
	public static String binaryRepresentation(String n) {
        if (n == null || n.length() < 1){
        	return "";
        }
        StringBuffer beforeSB = new StringBuffer();
        StringBuffer afterSB = new StringBuffer();
        if (n.indexOf(".") == -1){
            int input = Integer.parseInt(n);
        	return Integer.toString(input, 2);
        }
        int before = Integer.parseInt(n.split("\\.")[0]);
        
        double after = Double.parseDouble("0." + n.split("\\.")[1]);
        
        beforeSB.append(Integer.toString(before, 2));
        while (after > 0.0){
        	after *= 2;

        	if (after >= 1.0){
        		after -= 1.0;
        		afterSB.append("1");
        	}else{
        		afterSB.append("0");
        	}
        	if (afterSB.length() > 32){
        		return "ERROR";
        	}
        }
        return afterSB.length() < 1? beforeSB.toString(): beforeSB.toString() + "." + afterSB.toString();
    }
	
	
	
	public static void main(String[] args){
		String n = "28187281.128121212121";
		String result = binaryRepresentation(n);
		System.out.println(result);
	}

}
