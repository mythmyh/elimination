package interpret.clarify.prompt;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

	public static void main(String[] args) {
//		String bs = "my clock is ticking ";
//		bs = bs.replace("my", "your");
//		bs = bs.replace("is", "were");
//		System.out.println(bs);
		System.out.println(Integer.parseInt("2"));
		System.out.println(" colleges ab " .matches("\\w+\\W\\w+"));
		
		System.out.println(Arrays.toString("abc22abc" .split("\\d+")));
		Pattern p=Pattern.compile("^\\d+");
		String j="Vanessa Trump filed for divorce from her h222usband, President Trump’s eldest son, Donald Trump Jr., on Thursday in New York City.";
		Matcher m=p.matcher(j);
		m.find();
		System.out.println(m.group()+" --"+ j.substring(1));
	}

}
