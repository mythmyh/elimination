package interpret.clarify.prompt;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


public class TestBat {
	public static void main(String[] args) {
		try {
			Process process2 = Runtime.getRuntime().exec("cmd /k start D:\\node.bat");
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	Map<String, String> map = System.getenv();
	  for(Iterator<String> itr = map.keySet().iterator();itr.hasNext();){
          String key = itr.next();
          System.out.println(key + "=" + map.get(key));
      } 
}

}
