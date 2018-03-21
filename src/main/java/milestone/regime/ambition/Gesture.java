package milestone.regime.ambition;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Gesture {
	

	@RequestMapping("/frank")
	public ModelAndView index(HttpSession session) {

		Map<String, String> urls = new HashMap<>();
		WebDriver driver = Juicy.chromeDriver();
		try {
			driver.get("http://www.foxnews.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement as = driver.findElement(By.className("main-content"));
			List<WebElement> elements = new ArrayList<>();
			elements = as.findElements(By.tagName("a"));

			for (WebElement es : elements) {
				String url = es.getAttribute("href");
				if ((!url.contains("video")) && url.contains("2018")) {
					if (es.getText().length() > 0) {
						urls.put(url, es.getText());
					} else {
						urls.put(url, url);
					}

				}
			}
			System.out.println(urls.size());
		} catch (Exception e) {

		} finally {
			driver.close();
			driver.quit();
		}
		ModelAndView model = new ModelAndView("translate", "urls", urls);
		//
		return model;
	}

	@RequestMapping("/translation")
	public ModelAndView vcs(HttpServletRequest request) {

		String uri = request.getParameter("url");
		WebSocketTest.url = uri;
		ModelAndView model = new ModelAndView("chinese");
		return model;
	}

	@RequestMapping("/single")
	public ModelAndView single(HttpServletRequest request, @RequestParam(value = "news_url") String url) {

		// String uri = request.getParameter("url");
		WebSocketTest.url = url;
		ModelAndView model = new ModelAndView("chinese");
		return model;
	}

}
