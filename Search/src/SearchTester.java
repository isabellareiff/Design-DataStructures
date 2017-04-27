
public class SearchTester {

	
	//Searches an array of ints that WAS once sorted, but has been rotated
	//by an unknown amount.  Returns TRUE if target is in nums.
	public static boolean myFind(int[] nums, int target)
	{
		int low = nums[0];
		int high = nums[nums.length-1];
		while (high >= low) {
			int mid = (high + low) / 2 ;
			if (nums[mid-1] > nums [mid]) {
			//ENDCASE
			//SPLIT @ [mid-1] AND [mid]
			}
			
			else  			{ // NUMS [MID-1] < = NUMS [MID]
				// IF THE FIRST NUMBER OF NUMS[] IS LARGER THAN NUMS [MID-1], THEN NUMS [MID-1] IS AFTER THE BREAK
				// 			MEANING YOU SHOULD GET RID OF THE ARRAY FROM NUMS [MID-1] TO NUMS[NUMS.LENGTH - 1]
				
				}
			}
		return false;
		   
		
	}
	
	public static void main(String[] args) {
		int[] evens = new int[100000000];
		int shift = 44159460;
		int j = 2;
		for (int i = shift; i < evens.length; i++, j += 2)
			evens[i] = j;
		for (int i = 0; i < shift; i++, j += 2)
			evens[i] = j;

//		int[] odds = new int[1000000000];
//		shift = 81119436;
//		j = 1;
//		for (int i = shift; i < odds.length; i++, j += 2)
//			odds[i] = j;
//		for (int i = 0; i < shift; i++, j += 2)
//			odds[i] = j;

		long startTime = System.currentTimeMillis();
		System.out.println("Should be: T F F T T F T F");
		int x = 50911454;
		System.out.println(myFind(evens, x));
//		System.out.println(myFind(odds, x));
		
		x = 119316641;
		System.out.println(myFind(evens, x));
//		System.out.println(myFind(odds, x));
		
		x = 179126190;
		System.out.println(myFind(evens, x));
//		System.out.println(myFind(odds, x));
		
		x = 102922776;
		System.out.println(myFind(evens, x));
//		System.out.println(myFind(odds, x));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time is " + totalTime + " milliseconds.  Should be 0 milliseconds.");
	}

}
