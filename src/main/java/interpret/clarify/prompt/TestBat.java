package interpret.clarify.prompt;

import java.io.IOException;

public class TestBat {
public static void main(String[] args) {
	   try {
		Process process2 = Runtime.getRuntime().exec("cmd /k start D:\\node.bat");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
