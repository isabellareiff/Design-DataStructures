
public class SortedSLLPQ<E extends Comparable<E>> implements MyPriorityQueue<E> 
{

	private ListNode queueHead;
	private int objectCount;

	public SortedSLLPQ()
	{
		queueHead = null;
		objectCount = 0;
	}

	@SuppressWarnings("unchecked")
	public void add(E obj)
	{
		ListNode node = queueHead;
		if (node==null){
			queueHead.setValue(obj);
		}
		else if (((E) node.getValue()).compareTo(obj)>0){
			queueHead= new ListNode (obj,node);
		}
		
		else for (int i = 0; i < objectCount; i++){
			if (obj.compareTo ((E)node.getNext().getValue()) <= 0){
				node.setNext(new ListNode(obj,node.getNext()));
			}
		}
	}

	public E removeMin()
	{
		@SuppressWarnings("unchecked")
		E min = (E) queueHead.getValue();
		queueHead = queueHead.getNext();
		return min;
	}

	@SuppressWarnings("unchecked")
	public E peek()
	{
		return (E) queueHead.getValue();
	}

	public boolean isEmpty()
	{
		return (queueHead==null);
	}

	public int size()
	{
		return objectCount;
	}

	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer ("[ ");
		for (ListNode node = queueHead; node != null; node = node.getNext()) 
		{
			stringbuf.append(node.getValue()+" ");
		}
		stringbuf.append("]");
		return stringbuf.toString();
	}
}