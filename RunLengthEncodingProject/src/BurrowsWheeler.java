import java.util.Arrays;


public class BurrowsWheeler {
	public static void main (String [] args){

		String str = "irsbe\0a";
		String [] strArray = new String [str.length()];
		for (int i = 0; i < str.length(); i++){
			strArray[i] = str.charAt(i) + "";
		}
		
		Arrays.sort(strArray);
		
		int row = 7;
		int col = 7;
		char [] [] arr = new char [row] [col];

		for (int c = 0; c < col; c++){
			for (int r = 0; r < row; r++){
				
			}
		}


	}
}
