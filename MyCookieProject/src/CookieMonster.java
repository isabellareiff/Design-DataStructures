import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* YOU ARE ALLOWED (AND EXPECTED) TO USE THE JAVA ARRAYDEQUE CLASS */

@SuppressWarnings("unused")
public class CookieMonster {

	private int [][] cookieGrid;
	private int numRows;
	private int numCols;
	private int mostCookies = -1;
	private int maxCallStackDepth = -1; //Used only for recursive technique

	public CookieMonster(int [][] cookieGrid) {
		this.cookieGrid = cookieGrid;
		this.numRows    = cookieGrid.length;
		this.numCols    = cookieGrid[0].length;
	}

	/* Return the calculated most cookies edible on the optimal path. */
	public int getMostCookies() {
		return mostCookies;
	}

	private boolean goodPoint(int row, int col) {
		return (row >= 0 && row < numRows && col >= 0 && col < numCols && cookieGrid[row][col] >= 0);
	}

	/* RECURSIVELY calculates the route which grants the most cookies, and returns the maximum depth the call stack reached during the operation. */
	public int maxCallStackDepth() {
		this.mostCookies = recursiveOptimalPath(0, 0, 1);
		return maxCallStackDepth;
	}       

	/* Helper function for the above, which returns the maximum number of cookies edible starting at coordinate (row, col). */
	/* From any given position, always check right before checking down */
	/* Also, updates the maxCallStackDepth variable, to find out how deep the recursion call stack got during the operation. 
	 * I've implemented this part already (you should add 1 to the depth when it calls itself). */ 

	private int recursiveOptimalPath(int row, int col, int depth) {
		int right = 0;
		int down = 0;
		int best = 0;
		if (depth > this.maxCallStackDepth)
			this.maxCallStackDepth = depth;
		if(!(goodPoint(row, col + 1)) && !(goodPoint(row + 1, col)))
		{
			best = cookieGrid[row][col];
			return best;
		}
		else {
			if(goodPoint(row, col + 1))
			{
				right += recursiveOptimalPath(row, col + 1, depth + 1);
			}
			if(goodPoint(row + 1, col))
			{
				down += recursiveOptimalPath(row + 1, col, depth + 1);
			}
			if(right > down)
			{
				best = right;
			}
			else
			{
				best = down;
			}
		}
		return best + cookieGrid [row][col];

	}

	/* Calculate the route which grants the most cookies, and return the maximum queue size during the operation. */
	/* From any given position, always check right before checking down */
	/* Set this.mostCookies before returning */
	public int maxQueueSize() {
		ArrayDeque<PathMarker> queue = new ArrayDeque<PathMarker>();
		int maxQueueSize = 0;
		int mostCookiesSoFar = -1;
		queue.addFirst(new PathMarker(0, 0, cookieGrid[0][0]));
		
		while (queue.size() > 0){
			if (queue.size()>maxQueueSize){
				maxQueueSize = queue.size();
			}
			PathMarker first = queue.remove();
			int row = first.row;
			int col = first.col;
			int total = first.total;
			if (mostCookiesSoFar < total){
				mostCookiesSoFar = total;
			}
			if (goodPoint(row, col+1)){
				queue.add(new PathMarker (row, col + 1, total + cookieGrid [row][col + 1]));
			}
			if (goodPoint (row + 1, col)){
				queue.add(new PathMarker (row + 1, col, total + cookieGrid [row + 1] [col]));
			}
		}
		this.mostCookies = mostCookiesSoFar;
		return maxQueueSize;

	}

	/* Calculate the route which grants the most cookies, and return the maximum stack size during the operation. */
	/* From any given position, always check right before checking down */
	/* Set this.mostCookies before returning */
	public int maxStackSize() {
		ArrayDeque<PathMarker> stack = new ArrayDeque<PathMarker>();
		int maxStackSize = 0;
		int mostCookiesSoFar = -1;
		stack.addFirst(new PathMarker(0, 0, cookieGrid[0][0]));
		while (stack.size()>0){
			if (stack.size()>maxStackSize){
				maxStackSize = stack.size();
			}
			PathMarker last = stack.removeLast();
			int row = last.row;
			int col = last.col;
			int total = last.total;
			
			//
			
			if (mostCookiesSoFar < total){
				mostCookiesSoFar = total;
			}
			if (goodPoint(row, col+1)){
				stack.add(new PathMarker (row, col + 1, total + cookieGrid [row][col + 1]));
			}
			if (goodPoint (row + 1, col)){
				stack.add(new PathMarker (row + 1, col, total + cookieGrid [row + 1] [col]));
			}
		}
		this.mostCookies = mostCookiesSoFar;
		return maxStackSize;

	}

	/* Calculate the route which grants the most cookies, and return the maximum priority queue size during the operation. */
	/* From any given position, always check right before checking down */
	/* Set this.mostCookies before returning */
	public int maxPriorityQueueSize() {
		HeapPQ<PathMarker> priorityQueue = new HeapPQ<PathMarker>();
		int maxPriorityQueueSize = 0;
		int mostCookiesSoFar = -1;
		priorityQueue.add(new PathMarker(0, 0, cookieGrid[0][0]));
		while(priorityQueue.size() > 0)
		{
			if(priorityQueue.size() > maxPriorityQueueSize)
			{
				maxPriorityQueueSize = priorityQueue.size();
			}
			PathMarker priority = priorityQueue.removeMin();
			int row = priority.row;
			int col = priority.col;
			int total = priority.total;
			if(total > mostCookiesSoFar)
			{
				mostCookiesSoFar = total;
			}
			if(goodPoint(row, col + 1))
			{
				priorityQueue.add(new PathMarker(row, col + 1, cookieGrid[row][col + 1] + total));
			}
			if(goodPoint(row + 1, col))
			{
				priorityQueue.add(new PathMarker(row + 1, col, cookieGrid[row + 1][col] + total));
			}
		}
		this.mostCookies = mostCookiesSoFar;
		return maxPriorityQueueSize;
	}


}