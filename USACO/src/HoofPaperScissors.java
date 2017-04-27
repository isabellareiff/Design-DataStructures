import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class HoofPaperScissors {
	int [] A;
	int [] B;
	static int number;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("hps.in"));
		int num = scan.nextInt();
		int [] A = new int [num];
		int [] B = new int [num];
		for (int i = 0 ; i < num; i ++){
			A[i] = scan.nextInt();
			B[i] = scan.nextInt();
		int totalWins;
		number = num;
		}
	}
	public int helperOne(){ // if hoof == 1, paper ==2, scissors == 3;
		int ties =0;
		int wins=0;
		for (int i = 0; i < number;  i ++){
			if (A[i] == B[i]){
				ties ++;
			}
			if (A[i]==1 && B[i] == 2) {
				; //loss
			}
			if (A[i]== 1 && B [i] == 3) {
				wins ++;
			}
			if (A[i] == 2 && B [i] == 1){
				wins ++;
			}
			if (A[i] == 2 && B [i] == 3){
				; //loss
			}
			if (A [i] == 3 && B [i] == 1){
				; //loss
			}
			if (A [i] == 3 && B [i] == 2){
				wins++;
			}
		}
		
		return wins;
		
	}
	public int helperTwo(){ // if paper == 1, hoof ==2, scissors == 3;
		int ties = 0;
		int wins = 0;
		for (int i = 0; i < number;  i ++){
			if (A[i] == B[i]){
				ties ++;
			}
			if (A[i]==1 && B[i] == 2) {
				wins ++;
			}
			if (A[i]== 1 && B [i] == 3) {
				; // loss
			}
			if (A[i] == 2 && B [i] == 1){
				; // loss
			}
			if (A[i] == 2 && B [i] == 3){
				wins++;
			}
			if (A [i] == 3 && B [i] == 1){
				wins++;
			}
			if (A [i] == 3 && B [i] == 2){
				; //loss
			}
		}
		
		return wins;
		
	}
}
