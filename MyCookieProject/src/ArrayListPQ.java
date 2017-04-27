import java.util.ArrayList;

public class ArrayListPQ<E extends Comparable<E>> implements MyPriorityQueue<E>{

    private ArrayList<E> queue;
    private int objectCount;
    
    public ArrayListPQ()
    {
   	 queue = new ArrayList<E>();
   	 objectCount = queue.size();
    }
    
    public void add(E obj)
    {
   	 queue.add(obj);
   	 objectCount++;
    }
    
    public E removeMin()
    {
   	 if(isEmpty())
   	 {
   		 return null;
   	 }
   	 int priority = 0;
   	 for(int i = 1; i < objectCount; i++)
   	 {
   		 if(queue.get(i).compareTo(queue.get(priority)) < 0)
   		 {
   			 priority = i;
   		 }
   	 }
   	 objectCount--;
   	 return queue.remove(priority);
    }
    
    public E peek()
    {
   	 if(isEmpty())
   	 {
   		 return null;
   	 }
   	 int priority = 0;
   	 for(int i = 1; i < objectCount; i++)
   	 {
   		 if(queue.get(i).compareTo(queue.get(priority)) < 0)
   		 {
   			 priority = i;
   		 }
   	 }
   	 return queue.get(priority);
    }
    
    public boolean isEmpty()
    {
   	 return (objectCount == 0);
    }
    
    public int size()
    {
   	 return objectCount;
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