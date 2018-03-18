package interpret.clarify.prompt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class DriverTest {

	public Map<String, String> getWords(WebDriver driver) throws InterruptedException {
		// WebDriver driver = Juicy.chromeDriver();
		Map<String, String> couples = new HashMap<>();
		String eng, chn;
		// driver.get(
		// "http://fanyi.baidu.com/?aldtype=16047#en/zh/A%20passenger%E2%80%99s%20bag%20may%20have%20accidentally%20hit%20the%20fuel%20shutoff%20button%20of%20the%20doomed%20helicopter%20that%20plunged%20into%20New%20York%E2%80%99s%20East%20River%20Sunday%2C%20killing%20all%20aboard%20except%20the%20pilot%2C%20who%20issued%20a%20frantic%20distress%20call%20before%20climbing%20aboard%20a%20raft%20and%20paddling%20to%20safety.");
		StringBuffer sb = new StringBuffer();

		WebElement element = driver.findElement(By.className("keywords-inner"));
		String js = "document.getElementsByClassName('keywords-container')[0].style.cssText='overflow:visible';"
				+ "var getDom=document.getElementsByClassName('keywords-content');for(var i=0;i<getDom.length;i++){getDom[i].style.cssText='overflow:visible'}";

		((JavascriptExecutor) driver).executeScript(js);

		WebElement container = element.findElement(By.className("keywords-container"));

		List<WebElement> elements = container.findElements(By.className("keywords-content"));
		for (WebElement es : elements) {
			WebElement a = es.findElement(By.className("keywords-word"));
			eng = (a.getText() + " ");
			WebElement means = es.findElement(By.className("keywords-means"));
			List<WebElement> mean = means.findElements(By.className("keywords-mean"));

			for (WebElement e : mean) {

				sb.append(e.getText() + ";");
			}
			chn = sb.toString();
			sb = new StringBuffer("");
			couples.put(eng, chn);
		}
		return couples;

		// System.out.println(element.getText());
		// 关闭浏览器
		// driver.close();
		// 关闭 ChromeDriver 接口
	}

	// <audio id="dictVoice" style="display: none"
	// src="/gettts?lan=en&amp;text=dispute&amp;spd=3&amp;source=web"></audio>
	// <audio id="dictVoice" style="display: none"
	//

	// driver.quit();

}
