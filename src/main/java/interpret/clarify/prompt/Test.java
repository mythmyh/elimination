package interpret.clarify.prompt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) throws IOException, InterruptedException {

		try {
			InetAddress address = InetAddress.getLocalHost();
			String hostAddress = address.getHostAddress();
			System.out.println(hostAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		URL uri = Test.class.getResource("hub.bat");
//		String jpg = uri.toString().substring(6);
//		Process process = Runtime.getRuntime().exec("cmd /k start " + jpg);
//		Thread.sleep(3000);
//		uri = Test.class.getResource("node.bat");
//		process = Runtime.getRuntime().exec("cmd /c start " + uri.toString().substring(6));
	}
}