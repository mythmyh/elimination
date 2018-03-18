package interpret.clarify.prompt;

import java.io.IOException;
import java.net.URL;

public class Test {
	public static void main(String[] args) throws IOException, InterruptedException {
		// Runtime runtime = Runtime.getRuntime();
		// System.out.println(runtime.totalMemory()/(long)Math.pow(2, 20));
		// System.out.println(runtime.freeMemory());
		URL uri = Test.class.getResource("hub.bat");
		String jpg = uri.toString().substring(6);
		System.out.println(jpg.contains("/"));
		// String k=jpg.replaceAll("/", "\\\\\\\\");

		// Process process2 = Runtime.getRuntime().exec("cmd /c start
		// D:\\hub.bat");
		Process process = Runtime.getRuntime().exec("cmd /k start " + jpg);
		Thread.sleep(3000);
		uri = Test.class.getResource("node.bat");
		Process process2 = Runtime.getRuntime().exec("cmd /c start " + uri.toString().substring(6));
	}
}