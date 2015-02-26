package Exercise;

public class ReverseDouble {
	
	public static double reverseDouble(double d){
		long a = Double.doubleToRawLongBits(d);
		System.out.println(Long.toBinaryString(a).length());
		long b = 0;
		int i_1 = 10;
		int i_2 = 53;
		while (i_2 > 0){
			b += ((a >> (53 - i_2)) & 1) << i_2;
			i_2 -= 1;
		}
		while (i_1 > 0){
			b += ((a >> (53 + i_1)) & 1) >> i_1;
			i_1 -= 1;
		}
		System.out.println(Double.longBitsToDouble(b));
		return b;
	}
	
	public static void main(String[] args){
		double rst = reverseDouble(32180989988931.4421);
		System.out.println(rst);
	}

}
