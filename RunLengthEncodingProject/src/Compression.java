import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Compression {

	static String fileName;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		Scanner k = new Scanner(System.in);
		FileWriter fw = new FileWriter ("output.txt");
		// ask user for file
		//System.out.println("What is the name of the file you wish to read from?");
		//fileName = k.nextLine();
		String fileName = "test.txt";

		FileReader fr = new FileReader(fileName);
		br = new BufferedReader (fr);
		int character = br.read();
		
		
		while (br.ready()){
			int num = 1 ;
			int now = br.read();
			
			while (character == now){
				num++;
				now = (char)br.read();
			}
			if (num > 1 && num <= 255){
				fw.write(character);
				fw.write(character);
				fw.write((int)num);
				
			}
			
			else if (num > 1){
				while (num > 255){
					fw.write(character);
					fw.write(character);
					fw.write((int)255);
					num -= 255;
				}
			
			fw.write(character);
			fw.write(character);
			fw.write((int)num);
			
			}
			else{
				fw.write(now);
				character = now;
			}
			fw.write(character);
		}
		
		br.close();
		fw.close();
	}
}


