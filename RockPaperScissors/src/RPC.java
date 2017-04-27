import java.util.Scanner;

public class RPC {
	
	static String total, respond = "";
	static int computer, player = 0;
	
	public RPC (){
		init
	}
	
	//ask user for number, send number to initRespond
		public static void getResponse(){
			Scanner s = new Scanner (System.in);
			System.out.println("What do you choose? Type R for rock, P for paper, and S for scissors.");
			respond = s.next();
		}
	
	public String initRespond(String answer){
		if ( !answer.equalsIgnoreCase("r") || !answer.equalsIgnoreCase("p") || !answer.equalsIgnoreCase("r") ){
			throw new IndexOutOfBoundsException("Your answer " + answer + " was out of bounds!");
		}
		if (answer.equalsIgnoreCase("r")){
			player = 1;
			return "You chose ROCK!";
		}
		else if (answer.equalsIgnoreCase("P")){
			player = 2;
			return "You chose PAPER!";
		}
		else {
			player = 3;
			return "You chose SCISSORS!";
		}
	}
	
	public static String computerResponse (){
		int random = (int)(Math.random()*100 +1)  ;
		if (random <= 33){
			computer = 1;
			return "The computer chooses ROCK!";
		}
		else if (random <= 66){
			computer = 2;
			return "The computer chooses PAPER!";
		}
		else {
			computer = 3;
			return "The computer chooses SCISSORS!";
		}
		
	}
	
	public static String Result (){
		if (player==computer){
			return "The game is a tie!";
		}
		//player wins - player = 1, comp = 3; player = 2, comp = 1; player = 3, comp = 2;
		else if  ((player == 1 && computer == 3) || (player ==2 && computer == 1) || (player == 3 && computer ==2)){
			return "Great job! You won!";
		}
		else {
			return "Sorry, you lost!";
		}
	}
	
	public String totalGame(){
		
		
		return null;
		
	}
}
	
	
