import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Decompression {
	
	
	
	public static void main(String[] args) throws IOException {
		// 
		BufferedReader br = new BufferedReader (new FileReader(new File ("RLEmystery.txt")));
		
		char current = (char) br.read();
		
		while(br.ready()){
			if (current == (char)br.read()){
				 
			}
		}
		
	}

}
