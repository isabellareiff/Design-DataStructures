import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class greatGatsby {

	//static Hashtable hash = new Hashtable();
	static HashMap <String, ArrayList <Character> > hash = new HashMap <String, ArrayList<Character>>();
	static int markov;
	static String fileName;
	static int bookLength;
	static String current = "";
	static String largest;
	static BufferedReader br; //ask if this is correct


	public static void main (String [] args) throws IOException{


		Scanner k = new Scanner(System.in);

		// ask user for file
		System.out.println("What is the name of the file you wish to read from?");
		fileName = k.nextLine();

		//read in file to FileReader and BufferedReader
		FileReader fr = new FileReader(fileName);
		br = new BufferedReader (fr);

		//ask user for markov order
		System.out.println("What is the Markov Order you wish to use?");
		markov = k.nextInt();

		//ask user for number of characters to be printed
		System.out.println("How many characters do you want your sequel to be?");
		bookLength = k.nextInt();


		//read in markov number characters
		readMarkov(markov);

		//put mOrder length groups of characters into hashset keys, move thru file until all read
		putMarkov();
		
		//write the book
		writeBook();

	}

	public static void readMarkov(int mark) throws IOException{
		//read in first group of charactrs of length mOrder
		for (int i = 0; i < mark; i++){
			current += ((char)+br.read() + "");
		}
		largest = current;
	}

	// put mOrder length groups of characters into hashset keys, move thru file until all read
	public static void putMarkov () throws IOException{
		while (br.ready()){
			if (!hash.containsKey(current)){
				hash.put(current, new ArrayList <Character>());
			}
			char freq = (char) br.read();
			hash.get(current).add(freq);
			if (hash.get(current).size() > hash.get(largest).size());
			largest = current;
			current = current.substring(1) + "" + freq;
		}
		if (!hash.containsKey(current))
			hash.put(current, new ArrayList <Character>());
	}

	//write the damn book
	public static String writeBook(){
		String book = largest;
		for (int i = 0; i < bookLength; i++){
			char character;
			String key = book.substring(book.length()-markov);
			Random r = new Random();
			if (hash.get(key).isEmpty()){
				break;
			}
			character = hash.get(key).get(r.nextInt(hash.get(key).size()));
			book+=character;
		}
		return ("Here is your book:\n" + book);
	}
}
