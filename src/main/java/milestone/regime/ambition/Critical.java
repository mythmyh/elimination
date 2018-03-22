package milestone.regime.ambition;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.websocket.MessageHandler.Partial;
import javax.websocket.MessageHandler.Whole;
import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.RemoteEndpoint.Basic;
import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.Extension;
import javax.websocket.MessageHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import interpret.clarify.prompt.DriverMain;
import interpret.clarify.prompt.SaveSound;
//主要线程类
public class Critical implements Runnable {
	static AtomicInteger i = new AtomicInteger(1);
	static HttpSession session2;
	String eng;
	int index;
	Session session;

	public Critical(String eng, int index, Session session) {
		this.eng = eng;
		this.index = index;
		this.session = session;
	}

	@Override
	public void run() {
		WebDriver driver = null;
		// TODO Auto-generated method stub
		// String window = "window.open('" + str + "')";
		// ((JavascriptExecutor) dr).executeScript(window);
		ChromeOptions option = new ChromeOptions();
		/*
		 * 隐藏浏览器窗口
		 */
		option.addArguments("headless");
		option.addArguments("disable-infobars");
		// option.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User
		// Data");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(ChromeOptions.CAPABILITY, option);

		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//

		// WebElement container =
		// dr.findElement(By.className("keywords-container"));
		// System.out.println(container.getText());
         
		String encodeString = null;
		try {
			//转换字符串
			encodeString = URLEncoder.encode(eng, "utf-8").replaceAll("\\+", "%20");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     //保存声音文件
		SaveSound save = new SaveSound();
		try {
			save.save(index, encodeString);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			System.out.println("保存出错！");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
	
			driver.get("http://fanyi.baidu.com/?aldtype=16047#en/zh/" + encodeString);
		} catch (Exception e) {

			try {
				session.getBasicRemote().sendText("    <div data-id=\"" + index + "\">" + index + "  "
						+ "[ 该段翻译出错...]<br><p>" + eng + "</p></div>");
			} catch (IOException e1) {
				// TODO Auto-generated catch block

			}

		}

	
		String reload = index + encodeString;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement container2 = driver.findElement(By.className("target-output"));
	
		// 
		// 给重要单词上色
		Map<String, String> couples = new HashMap<>();
		try {
			couples = new DriverMain().getWords(driver);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (couples!=null &&couples.size() > 0) {
			for (String se : couples.keySet()) {
				int x = i.getAndAdd(1);
				int c = i.getAndAdd(1);
				String jk = se.trim();
				//处理字符串加class，js点击事件等
				if (jk.matches("\\w+\\W\\w+")) {
					eng = eng.replace(se,
							"<span  class=\"ss\" id=\" " + x + "\" onclick=\"hide(this)\">" + se + "</span><span class=\"word\" id=\""
									+ c + "\" style=\"display: none;\">【" + couples.get(se) + "】</span>");
				} else {
					eng = eng.replace(se, "<span  id=\" " + x + "\" onclick=\"hide(this)\">" + se + "</span><span id=\""
							+ c + "\" style=\"display: none;\" class=\"word\">【" + couples.get(se) + "】</span>");
				}
			}
		}

		// Send the first message to the client
		String j = "    <div data-id=\"" + index + "\"><p>" + index + "  " + container2.getText() + "</p><br><p >" + eng
				+ "<span class=\"icon\" onmouseover=\"playSolo(this.id)\" id=\"" + index
				+ ".mp3\"><span><a href=\"javascript:void(0)\" onclick=\"reSave('" + reload
				+ "')\"  >Reload</a></p><br><br></div>";

		try {
			try {
				synchronized (session) {
					session.getBasicRemote().sendText(j);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {

			driver.close();
			driver.quit();
		}
	}
}
