import java.util.ArrayList;

public class ArrayListPQ<E extends Comparable<E>> implements MyPriorityQueue<E>{

	private ArrayList<E> queue;
	private int objectCount;
	
	public ArrayListPQ()
	{
		queue = new ArrayList<E>();
	}
	
	public void add(E obj)
	{
		queue.add(obj);
	}
	
	public E removeMin()
	{
		E min = this.peek();
		for (int i = 0; i < queue.size(); i++){
			if (min.compareTo(queue.get(i)) < 0){ // then its negative which is first == smol
				min = queue.get(i);
			}
			queue.remove(i);
		}
		return (min);
	}
	
	public E peek()
	{
		E min = queue.get(0);
		for (int i = 0; i < queue.size(); i++){
			if (min.compareTo(queue.get(i)) < 0){ // then its negative which is first == smol
				min = queue.get(i);
			}
		}
		return min;
	}
	
	public boolean isEmpty()
	{
		return (queue.size() == 0);
	}
	
	public int size()
	{
		
	}
	
	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer ("[ ");	
		for (int i = 0; i < queue.size(); i++)
		{
			stringbuf.append(queue.get(i)+" ");
		}
		stringbuf.append("]");
		return stringbuf.toString();
	}

}
