package PersonalStudy;

public class BinaryOperationCheck {
	
	public static void main(String[] args){
		int a = 50;
		int length = 1, copy = a, rst = 0;
		while (copy > 1){
			length += 1;
			copy /= 2;
		}
		// + and - have the higher priority than & or other bit operation signal
		while (length > 0){
			int tmp = Math.abs(((a >> (length - 1)) & 1) - 1);
			//System.out.println("tmp: " + tmp);
			rst = (rst << 1) + tmp;
			//System.out.println("rst: " + rst);
			length -= 1;
		}
		System.out.println(rst);
	}

}
