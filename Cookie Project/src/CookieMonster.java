import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* YOU ARE ALLOWED (AND EXPECTED) TO USE THE JAVA ARRAYDEQUE CLASS */

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

    @SuppressWarnings("unused")
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
		if (depth > this.maxCallStackDepth)
			this.maxCallStackDepth = depth;
		if (!goodPoint(row, col + 1) && !goodPoint(row + 1, col)){
			return cookieGrid[row][col];
		}
		if (goodPoint (row, col + 1)){
			right = recursiveOptimalPath(row, col + 1, depth + 1);
		}
		if (goodPoint (row + 1, col)){
			down = recursiveOptimalPath (row + 1, col, depth + 1);
		}
		if (right > down){
			return cookieGrid [row][col] + right;
		}
		else{
			return cookieGrid [row][col] + down;
		}
	}

	/* Calculate the route which grants the most cookies, and return the maximum queue size during the operation. */
    /* From any given position, always check right before checking down */
    /* Set this.mostCookies before returning */
    public int maxQueueSize() {
        ArrayDeque<PathMarker> queue = new ArrayDeque<PathMarker>();
        int maxQueueSize = 0;
        int mostCookiesSoFar = -1;
        queue.addFirst(new PathMarker(0, 0, cookieGrid[0][0]));
        
    }

    /* Calculate the route which grants the most cookies, and return the maximum stack size during the operation. */
    /* From any given position, always check right before checking down */
    /* Set this.mostCookies before returning */
    public int maxStackSize() {
        ArrayDeque<PathMarker> stack = new ArrayDeque<PathMarker>();
        int maxStackSize = 0;
        int stackSoFar = 1;
        int mostCookiesSoFar = -1;
        int cookiesSoFar = cookieGrid [0][0];
        stack.addFirst(new PathMarker(0, 0, cookieGrid[0][0]));
        int row = 0;
        int col = 1;
        while (goodPoint(row, col)){
        	stack.addLast(new PathMarker (row, col, cookieGrid [row][col]));
        	col ++;
        	stackSoFar ++;
        	cookiesSoFar += cookieGrid[row][col];
        }
        row ++;
        col--;
        while )goodPoint(row, col){
        	
        }

    }

    /* Calculate the route which grants the most cookies, and return the maximum priority queue size during the operation. */
    /* From any given position, always check right before checking down */
    /* Set this.mostCookies before returning */
    public int maxPriorityQueueSize() {
        HeapPQ<PathMarker> priorityQueue = new HeapPQ<PathMarker>();
        int maxPriorityQueueSize = 0;
        int mostCookiesSoFar = -1;
        priorityQueue.add(new PathMarker(0, 0, cookieGrid[0][0]));

        /* -- YOU IMPLEMENT THIS -- */
    }


}
