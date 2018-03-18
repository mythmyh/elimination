package interpret.clarify.prompt;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URL;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class TestMp3 {
	public static void main(String[] args) {
	     URL uri=    TestMp3.class.getResource("Time.mp3");
		try {
			new Player(new BufferedInputStream(new FileInputStream(new File(uri.toString().substring(6))))).play();
		} catch (FileNotFoundException | JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
