
public class HeapPQ < E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;

	@SuppressWarnings("unchecked")
	public HeapPQ()
	{
		this.heap = (E[])new Comparable[3];
		this.objectCount = 0;
	}

	//Adds obj to the Priority Queue
	public void add(E obj)
	{
		if (objectCount == heap.length - 1) {
			increaseCapacity();
		}
		objectCount ++;
		heap [objectCount] = obj;
		bubbleUp (objectCount);
	}

	//Removes and returns the MINIMUM element from the Priority Queue
	public E removeMin()
	{
		swap (1,objectCount);
		E temp = heap [objectCount];
		heap [objectCount] = null;
		objectCount --;
		bubbleDown(1);
		return temp;
	}

	//Returns the MINIMUM element from the Priority Queue without removing it
	public E peek()
	{
		if (objectCount==0){
			return null;
		}
		else {
			return heap[1];
		}
	}

	//	// Returns true if the priority queue is empty
	public boolean isEmpty()
	{
		return (objectCount==0);
	}

	//Returns the number of elements in the priority queue
	public int size()
	{
		return objectCount;
	}

	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++)
		{
			stringbuf.append(heap[i+1]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for(int rowLength = 1, j = 0; j < objectCount; rowLength *= 2)
		{
			for (int i = 0; i < rowLength && j < objectCount; i++, j++)
			{
				stringbuf.append(heap[j+1] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount)
			{
				for (int i = 0; i < Math.min(objectCount - j, rowLength*2); i++)
				{
					if (i%2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}

	//Doubles the size of the heap array
	@SuppressWarnings("unchecked")
	private void increaseCapacity()
	{
		@SuppressWarnings("rawtypes")
		Comparable [] temp = new Comparable [2*objectCount]; 
		for (int i = 1; i <= objectCount; i++){
			temp[i] = heap[i];
		}
		heap = (E[]) temp;
	}

	//	//Returns the index of the "parent" of index i
	private int parent(int i)
	{
		if (i > objectCount || i < 1){
			throw (new IndexOutOfBoundsException());
		}
		return i/2;
	}
	//Returns the *smaller child* of index i
	private int smallerChild(int i)
	{
		if (i > objectCount || i < 1){
			throw (new IndexOutOfBoundsException());
		}
		if (2*i > objectCount){
			throw (new NullPointerException());
		}
		else if (2*i + 1 > objectCount){
			return 2*i;
		}
		else {
			if (heap[2*i].compareTo(heap[2*i+1]) <= 0){
				return 2*i;
			}
			return 2*i + 1;
		}
	}
	//	//Swaps the contents of indices i and j
	private void swap(int i, int j)
	{
		if (i > objectCount || i < 1 || j > objectCount || j < 1){
			throw (new IndexOutOfBoundsException());
		}
		E temp = heap [i];
		heap [i] = heap [j];
		heap [j] = temp;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i)
	{
		if (i > objectCount || i < 1){
			throw (new IndexOutOfBoundsException());
		}
		if (i==1){ ; }
		else{
			if (heap[i].compareTo (heap[parent(i) ] ) <= 0 ){
				swap (i, parent(i));
				bubbleUp (parent(i));
			}
		}
	}

	// Bubbles the element at index i downwards until the heap properties hold again.
	private void bubbleDown(int i)
	{
		if (i > objectCount || i < 1){
			throw (new IndexOutOfBoundsException());
		}
		if (2*i > objectCount){
			return ; }
		else {
			int small = smallerChild(i);
			if (heap[i].compareTo (heap[smallerChild(i) ] ) >= 0 ){
				swap (i, small);
				bubbleDown (small);
			}
		}

	}
}