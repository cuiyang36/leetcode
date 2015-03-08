package PersonalStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*\b\w+\b can match any word */ 
public class JavaRegexStudy {

	public static void main(String[] args) throws Exception{
		BufferedReader in;
		Pattern pattern = Pattern.compile("(\\(\\d{3}\\))|(\\d{3})(\\s+|-|)?\\d{3}(-|)?\\d{4}");
		/* */
		in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s = in.readLine()).equals("")) {
			Matcher matcher = pattern.matcher(s);
			if (matcher.find()) {
				System.out.println(matcher.group());
			}
		}
		in.close();
	}
}
