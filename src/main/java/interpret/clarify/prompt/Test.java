package interpret.clarify.prompt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;


public class Test {

	public Test() throws IOException, InterruptedException {
		System.out.println("hewll=");

		try {
			InetAddress address = InetAddress.getLocalHost();
			String hostAddress = address.getHostAddress();
			System.out.println(hostAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}

		URL uri = Test.class.getResource("hub.bat");
		String jpg = uri.toString().substring(6);
		Process process = Runtime.getRuntime().exec("cmd /k start " + jpg);
		uri = Test.class.getResource("node.bat");
		Thread.sleep(3000);
		process = Runtime.getRuntime().exec("cmd /k start " + uri.toString().substring(6));
	}
}