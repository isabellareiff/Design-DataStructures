
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class NotLast {

	public static void main(String[] args) throws FileNotFoundException {
		int num;
		String output = "";
		Scanner scan = new Scanner (new File ("notlast.in"));
		num = scan.nextInt();
		int Annabelle = 0;
		int Bessie = 0;
		int Maggie = 0;
		int Henrietta = 0;
		int Gertie = 0;
		int Daisy = 0;
		int Elsie = 0;
		int [] arr = new int [101];
		String [] names = new String[7];
		
		int [] allNums = new int [num];
		String [] allNames = new String [num];
		for (int i = 0; i < num; i++){
			allNames [i] = scan.next();
			allNums [i] = scan.nextInt();
		}
		scan.close();
		
		for (int i = 0; i < num; i++){
			if (allNames[i].equals("Bessie")){
				arr[i] = allNums[i];
				names [i] = "Bessie";
			}
			else if (allNames[i].equals("Elsie")){
				arr[i] = allNums[i];
				names [i] = "Elsie"; 
			}
			else if (allNames[i].equals("Daisy")){
				arr[i] = allNums[i];
				names [i] = "Daisy";
			}
			else if (allNames[i].equals("Gertie")){
				arr[i] = allNums[i];
				names [i] = "Gertie";
			}
			else if (allNames[i].equals("Annabelle")){
				arr[i] = allNums[i];
				names [i] = "Annabelle";
			}
			else if (allNames[i].equals("Maggie")){
				arr[i] = allNums[i];
				names [i] = "Maggie";
			}
			else {
				arr[i] = allNums[i];
				names [i] = "Henrietta";
			}
		}
		for (int j = 0; j < num; j++){
			if (names[j].equals("Bessie")){
				Bessie += arr [j];
			}
			else if (names[j].equals("Elsie")){
				Elsie += arr [j];
			}
			else if (names[j].equals("Daisy")){
				Daisy += arr [j];
			}
			else if (names[j].equals("Gertie")){
				Gertie += arr [j];
			}
			else if (names[j].equals("Annabelle")){
				Annabelle += arr [j];
			}
			else if (names[j].equals("Maggie")){
				Maggie += arr [j];
			}
		}
		int [] order = {Annabelle, Bessie, Maggie, Elsie, Daisy, Gertie, Henrietta} ;
		Arrays.sort(order);
		int secondLow;
		if (order[0] == order [6]){
			output = "Tie";
		}
		if (order[0] == order[5]){
			secondLow = order[6];
			if (secondLow == Annabelle) { output = "Annabelle";}
			if (secondLow == Bessie) { output = "Bessie";}
			if (secondLow == Daisy) { output = "Daisy";}
			if (secondLow == Elsie) { output = "Elsie";}
			if (secondLow == Gertie) { output = "Gertie";}
			if (secondLow == Henrietta) { output =  "Henrietta";}
			if (secondLow == Maggie) { output = "Maggie";}
		}
		if (order[0] == order [4]){
			if (order[5]==order[6]){
				output = "Tie";
			}
			secondLow = order [5];
			if (secondLow == Annabelle) { output = "Annabelle";}
			if (secondLow == Bessie) { output = "Bessie";}
			if (secondLow == Daisy) { output = "Daisy";}
			if (secondLow == Elsie) { output = "Elsie";}
			if (secondLow == Gertie) { output = "Gertie";}
			if (secondLow == Henrietta) { output =  "Henrietta";}
			if (secondLow == Maggie) { output = "Maggie";}
		}
		if (order [0]== order[3]){
			if (order [4] == order [5]){
				output = "Tie";
			}
			secondLow = order [4];
			if (secondLow == Annabelle) { output = "Annabelle";}
			if (secondLow == Bessie) { output = "Bessie";}
			if (secondLow == Daisy) { output = "Daisy";}
			if (secondLow == Elsie) { output = "Elsie";}
			if (secondLow == Gertie) { output = "Gertie";}
			if (secondLow == Henrietta) { output =  "Henrietta";}
			if (secondLow == Maggie) { output = "Maggie";}
		}
		if (order [0] == order [2]){
			if (order [3]==order[4]){
				output = "Tie";
			}
			secondLow = order [3];
			if (secondLow == Annabelle) { output = "Annabelle";}
			if (secondLow == Bessie) { output = "Bessie";}
			if (secondLow == Daisy) { output = "Daisy";}
			if (secondLow == Elsie) { output = "Elsie";}
			if (secondLow == Gertie) { output = "Gertie";}
			if (secondLow == Henrietta) { output =  "Henrietta";}
			if (secondLow == Maggie) { output = "Maggie";}
		}
		if (order[0]==order[1]){
			if (order [2]==order[4]){
				output = "Tie";
			}
			secondLow = order [2];
			if (secondLow == Annabelle) { output = "Annabelle";}
			if (secondLow == Bessie) { output = "Bessie";}
			if (secondLow == Daisy) { output = "Daisy";}
			if (secondLow == Elsie) { output = "Elsie";}
			if (secondLow == Gertie) { output = "Gertie";}
			if (secondLow == Henrietta) { output =  "Henrietta";}
			if (secondLow == Maggie) { output = "Maggie";}
		}
		else{
			secondLow = order [1];
			if (secondLow == Annabelle) { output = "Annabelle";}
			if (secondLow == Bessie) { output = "Bessie";}
			if (secondLow == Daisy) { output = "Daisy";}
			if (secondLow == Elsie) { output = "Elsie";}
			if (secondLow == Gertie) { output = "Gertie";}
			if (secondLow == Henrietta) { output =  "Henrietta";}
			if (secondLow == Maggie) { output = "Maggie";}
		}
		
		PrintWriter pw = new PrintWriter("notlast.out");
		pw.println(output);

		pw.close();
 
	}

}
