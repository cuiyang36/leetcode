package Exercise;

/**
 * A String contains "T" / "F" and "|" / "&" / "^", add parentness as will
 * return the number of result og True
 * 
 * @author cuiyang36
 *
 */

public class NumberOfTrue {

	public static int numberOfOne(String s) {
		int rst = 0;
		if (s == null || s.length() < 1) {
			return rst;
		}
		char[] signal = new char[s.length() / 2 + 1];
		char[] operation = new char[s.length() / 2];
		int ss = 0;
		int oo = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'T' || s.charAt(i) == 'F') {
				signal[ss++] = s.charAt(i);
			} else {
				operation[oo++] = s.charAt(i);
			}
		}
		int[][] T = new int[signal.length][signal.length];
		int[][] F = new int[signal.length][signal.length];
		// initialize the base case
		for (int i = 0; i < signal.length; i++) {
			if (signal[i] == 'T') {
				T[i][i] = 1;
			} else {
				F[i][i] = 1;
			}
		}
		// dp
		for (int m = 1; m < signal.length; m++) {
			for (int i = 0; i < signal.length - m; i++) {
				int j = i + m;
				for (int k = i; k < j; k++) {
					if (operation[k] == '&') {
						T[i][j] += T[i][k] * T[k + 1][j];
						F[i][j] += (T[i][k] * F[k + 1][j] + F[i][k]
								* T[k + 1][j] + F[i][k] * F[k + 1][j]);
					} else if (operation[k] == '|') {
						F[i][j] += F[i][k] * F[k + 1][j];
						T[i][j] += (T[i][k] * F[k + 1][j] + F[i][k]
								* T[k + 1][j] + T[i][k] * T[k + 1][j]);
					} else {
						T[i][j] += (T[i][k] * F[k + 1][j] + F[i][k]
								* T[k + 1][j]);
						F[i][j] += (T[i][k] * T[k + 1][j] + F[i][k]
								* F[k + 1][j]);
					}
				}
				System.out.println("i " + i + " j " + j + " " + T[i][j]);
			}
		}
		return T[0][signal.length - 1];
	}

	public static void main(String[] args) {
		String input = "T&T&T&T";
		int rst = numberOfOne(input);
		System.out.println(rst);
	}
}
