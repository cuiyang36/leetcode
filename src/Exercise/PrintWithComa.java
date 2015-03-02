package Exercise;

public class PrintWithComa {

	public static void printWithComa(int n){
		int num = 1; // very tricky
		int digit = 1; // change
		while (n / digit >= 10){
			digit *= 10;
			num += 1;
		}
		int traverse = num; // change
		while (traverse > 0){
			if (traverse % 3 == 0 && traverse != num){
				System.out.print(",");
			}
			System.out.print((n / digit) % 10);
			digit /= 10;
			traverse -= 1;
		}
	}
	
	public static void main(String[] args){
		printWithComa(1234567889);
	}
}
