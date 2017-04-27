import java.util.*;
public class RPCTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		String answer;
		//		int computer;
		//		int person;
		//		int game;
		Scanner k = new Scanner (System.in);
		System.out.println("Welcome to Rock Paper Scissors!\n"
				+ "If you want to play Rock Paper Scissors Lizard Spock, enter '1'."
				+ "\nIf you want the classic game, enter '2'.");
		int game = k.nextInt();
		chooseGame(game);
		// RPC game = new RPC();
		//game.totalGame();
	}

	//ask user for number, send number to initRespond
	public static String getResponse(){
		Scanner s = new Scanner (System.in);
		System.out.println("What do you choose? Type R for rock, P for paper, and S for scissors.");
		String str = s.next();
		return null;
	}



	public static void chooseGame(int i) {
		if (i < 1 || i > 2){
			throw new IndexOutOfBoundsException("Your answer " + i + " was out of bounds!");
		}
		startGame(i);
		//begin rpc method
	}


	public static void startGame(int i){
		if (i==1){
			System.out.println("Welcome to Izzy's Game of Rock Paper Scissors Lizard Spock!\nEnjoy playing!");
			RPC fun = new RPC (){
				;
			}
		}
		else {
			System.out.println("Welcome to Izzy's Game of Rock Paper Scissors!\nEnjoy playing!");
			RPCLS nice = new RPCLS (){
				;
			}
		}
		
	}
}
