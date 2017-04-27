import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author AStout
 *
 */
public class Satpix {

	public static void main (String[] args) throws IOException
	{
		String filename = "satpix.in";
		boolean[][] booleanArr = fileToBoolArray(fileName);
		
		
		
		PrintWriter out = new PrintWriter("satpix.out");
		out.println(sizeOfLargestPasture);
		out.close();
	}
	
	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException
	{
		// Helper method which converts the file into a 2D
		// array of booleans
		int r, c;
		Scanner scan = new Scanner (new File (fileName));
		c = scan.nextInt();
		r = scan.nextInt();
		boolean [] [] fun = new boolean [r][c];
		for (int i = 0; i < r; i++){
			String str = scan.nextLine();
			for (int j = 0; j < c; j++){
				fun[i][j] = (str.charAt(j) == '*');
			}
		}
		scan.close();
		return fun;
	}
	
	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
	{
		// Recursive method which uses the flood-fill algorithm to
		// count the size of a single pasture and "mark" it so it is not double-counted
		if(row < 0 || row >= arr.length || col < 0 || col >= arr[0].length)
		{
		throw new IndexOutOfBoundsException();
		}
		if (!arr[row][col]){
			return 0;
		}
		
		
	}
}
