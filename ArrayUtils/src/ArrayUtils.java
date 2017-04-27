public class ArrayUtils {
	
	/* countOdds
	 * This method should return the number of odd integers in the array.
	 * Odd integers are not divisible by 2.
	 * 0 is an even integer.
	 */
	public static int countOdds(int[] nums) {
		int length = nums.length;
		int count = 0;
		for (int i = 0; i < length; i++){
			if (nums[i]%2 == 1 || nums[i]%2==-1 ){
				count ++;
			}
		}
		return count;
	}

	/* onDiagonal
	 * This method takes a 2D array of integers, and a single integer parameter.
	 * It returns true if and only if the value of the parameter lies on a diagonal of the
	 * 2D array.
	 * 
	 * Diagonals are illustrated here (X is on diagonal, . is not):
	 * 
	 * X.X  X..X  X...X
	 * .X.  .XX.  .X.X.  etc.
	 * X.X  .XX.  ..X..
	 *      X..X  .X.X.
	 *            X...X
	 *            
	 * 2D arrays that are not square do not have diagonals, and should always return false.
	 */
	public static boolean onDiagonal(int[][] matrix, int test) {
		int rows = matrix.length;
		int col = matrix [0].length;
		if (rows!=col){
			return false;
		}
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < col; j++ ){
				if (matrix[i][j]==test){
					if (i==j){
						return true;
					}
					if (rows - 1 - i == j){
						return true;
					}	
				}
			}
		}
		return false;
	}

	/* addElements
	 * This method takes two 1D integer arrays: list and increment.
	 * The list array is mutated such that the ith element of list will be incremented by the ith
	 * element of increment.
	 * 
	 * e.g.             list -> (0, 0, 1, 1,  2,  2)
	 *             increment -> (4, 5, 6, 7,  8,  9)
	 * after returning, list -> (4, 5, 7, 8, 10, 11)
	 * 
	 * If increment is not as long as list, treat unspecified values as 0.
	 * 
	 * e.g.             list -> (0, 0, 1, 1, 2, 2)
	 *             increment -> (4, 5, 6, 7)
	 * after returning, list -> (4, 5, 7, 8, 2, 2)
	 * 
	 * If increment has more elements than list, ignore the extra elements.
	 */
	public static void addElements(int[] list, int[] increment) {
		/* You implement this */
		if (increment.length >= list.length){
			for (int i = 0; i < list.length; i++){
				list [i]= list[i] + increment [i];
			}
		}
		else{
			for (int j = 0; j < increment.length; j++){
				list [j] = list [j] + increment [j];
			}
		}
	}
	

	/* embiggen
	 * Merges two 1D integer arrays into a single 2D integer array.
	 * The [i][j] element of the resulting array is whichever value is larger: array1[i] or array2[j].
	 */
	public static int[][] embiggen(int[] array1, int[] array2) {
		/* You implement this */
		int [][] arr = new int [array1.length][array2.length];
		for (int i = 0; i < array1.length; i++){
			for (int j = 0; j < array2.length; j++){
				if (array1[i] >= array2[j]){
					arr[i][j]=array1[i];
				}
				else{
					arr [i][j] = array2[j];
				}
			}
		}
		return arr;
	}
}