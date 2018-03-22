package intentionaly.substation.occurred;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import interpret.clarify.prompt.BatInit;
//监听器启动两个bat
public class BatInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		try {
			BatInit test = new BatInit();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
