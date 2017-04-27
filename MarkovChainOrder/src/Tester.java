import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tester {

public static void main(String[] args) throws IOException
{
Scanner scan = new Scanner(System.in);
System.out.println("What is the name of the file you wish to read from?");
String fileName = scan.nextLine();
System.out.println("What is the Markov Order you wish to use?");
int markov = scan.nextInt();

BufferedReader br = new BufferedReader(new FileReader( "thegreatgatsby.txt"));


HashMap<String, ArrayList<Character> > hash = new HashMap<String, ArrayList<Character>>();

//for every letter, look in hash set for that combination and if exists, increment the 3d letter. If doesn't exist, create new column and incrememnt 3rd letter.

//needs work
String current = "";
for(int i =0; i <markov; i++)
{
current += ((char)br.read() + "");
}

String largest = current;

//repeat this:
while(br.ready())
{
//adding col into hash table
if(!hash.containsKey(current))
{
hash.put(current, new ArrayList<Character>());
}

//adding frequency of 6th char
char afterMarkov = (char) br.read();
hash.get(current).add(afterMarkov);
if(hash.get(current).size() > hash.get(largest).size());
{
largest = current;
}


current = current.substring(1) + "" + afterMarkov;

}

if(!hash.containsKey(current))
{
hash.put(current, new ArrayList<Character>());
}

//System.out.println(hash);

//WRITING THE NEW BOOK

String book = largest;
System.out.println("How many characters do you want your sequel to be?");
int bookLength = scan.nextInt();

for(int i = 0; i <bookLength; i ++)
{
char character;
String key = book.substring(book.length() -markov);
Random r = new Random();
if(hash.get(key).isEmpty())
{
break;
}
character = hash.get(key).get(r.nextInt(hash.get(key).size()));

book += character;

}
System.out.println(book); 




}

}