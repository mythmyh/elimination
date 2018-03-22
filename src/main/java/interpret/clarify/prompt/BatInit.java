package interpret.clarify.prompt;
//初始化启动selenium hub和node
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;


public class BatInit {

	public BatInit() throws IOException, InterruptedException {

		try {
			InetAddress address = InetAddress.getLocalHost();
			String hostAddress = address.getHostAddress();
			System.out.println(hostAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}

		URL uri = BatInit.class.getResource("hub.bat");
		String jpg = uri.toString().substring(6);
		Process process = Runtime.getRuntime().exec("cmd /k start " + jpg);
		uri = BatInit.class.getResource("node.bat");
		Thread.sleep(3000);
		process = Runtime.getRuntime().exec("cmd /k start " + uri.toString().substring(6));
	}
}