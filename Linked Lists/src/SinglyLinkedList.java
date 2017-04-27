// Implements a singly-linked list.

import java.util.Iterator;

public class SinglyLinkedList
{
	private ListNode head;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList()
	{
		head = null;
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(Object[] values)
	{
		ListNode next = null;
		nodeCount = values.length ;
		for (int i = values.length - 1; i >= 0; i --)
		{
			ListNode node = new ListNode (values [i]) ;
			node.setNext(next);
			next = node;
			if (i==0)
				head = node;	
		}
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty()
	{
		return (head == null);
	}

	// Returns the number of elements in this list.
	public int size()
	{
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(Object obj)
	{
		for (ListNode node = head; node != null; node = node.getNext()) {
			if (node.getValue() == obj)
				return true;
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(Object obj)
	{
		int index = 0;
		for (ListNode node = head; node != null; node = node.getNext()) {
			if (node.getValue() == obj)
				return index;
			index ++;
		}
		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(Object obj)
	{
//		ListNode add = new ListNode (obj);
//		if (head==null){
//			head = add;
//			nodeCount++;
//			return true;
//		}
//		for (ListNode node = head; node != null; node = node.getNext()) {
//			if (node.getNext()==null){
//				node.setNext(add);
//				nodeCount++;
//				return true;
//			}
//		}
		if (head != null) {
			add (head,obj);
		}
		else {
			head = new ListNode (obj);
		}
		nodeCount++;
		return true;
	}
	
	//Add obj to end of list starting at startnode
	//Returns the head of the new list
	private ListNode add(ListNode startnode, Object obj) {
		
		if (startnode ==null){
			return new ListNode (obj);
		}
		startnode.setNext(add (startnode.getNext(),obj));
		return startnode;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Object obj)
	{
		int count = nodeCount;
		head = this.remove(head, obj);
		return count != nodeCount;
//		if (head == null){
//			return false;
//		}
//		
//		if (head.getValue().equals(obj)){
//			if (nodeCount==1){
//				head = null;
//				nodeCount--;
//				return true;
//			}
//			ListNode add = head.getNext();
//			head = add;
//			nodeCount--;
//			return true;
//		}
//				
//		for (ListNode node = head; node != null; node = node.getNext()) {
//			if (node.getNext().getValue().equals(obj)){
//				node.setNext(node.getNext().getNext());
//				nodeCount--;
//				return true;
//			}
//		}
//		return false;
	}
	
	//Removes first element equal to obj, if any
	//Returns head of new list
	private ListNode remove(ListNode subhead, Object obj)
	{
		if (subhead==null)
			return null;
		if (subhead.getValue().equals(obj))
			nodeCount--;
			return subhead.getNext();
		subhead.setNext(remove (subhead.getNext(), obj));
		return subhead;
	}

	// Given a head "sbhead" and an int "k", return kth-to-last node in list
	public ListNode kthToLast (ListNode subhead, int k){
		
	}
	
	// Returns the i-th element.               
	public Object get(int i)
	{
		if (i<0 || i >= nodeCount){
			throw new IndexOutOfBoundsException();
		}
		return get(head, i);
		
//		int count = 0;
//		for (ListNode node = head; node != null; node = node.getNext()) {
//			if (count==i){
//				return node.getValue();
//			}
//			count ++;
//		}
//		return null;
	}
	
	private Object get(ListNode startnode, int distFromStart)
	{
		if (distFromStart==0)
			return startnode.getValue();
		else{
			return get(startnode.getNext(), distFromStart-1);
		}
	}

	// Replaces the i-th element with obj and returns the old value.
	public Object set(int i, Object obj)
	{
		if (i<0 || i>=nodeCount){
			throw new IndexOutOfBoundsException();
		}
		int count = 0;
		for (ListNode node = head; node != null; node = node.getNext()) {
			if (count==i){
				Object prev = node.getValue();
				node.setValue(obj);
				return prev;
			}
			count++;
		}
		return null;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj)
	{
		if (i < 0 || i >= nodeCount)
		{
			throw new IndexOutOfBoundsException();
		}
		if (i==0){
			ListNode yes = new ListNode (obj,head);
			head = yes;
			nodeCount ++;
		}
		int count = 0;
		for (ListNode node = head; node != null; node = node.getNext())
		{
			if(count == i - 1)
			{
				ListNode next = node.getNext();
				ListNode add = new ListNode(obj,next);
				node.setNext(add);
				nodeCount++;
			}
			count++;
		}	
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Object remove(int i)
	{
		if (i < 0 || i >= nodeCount)
		{
			throw new IndexOutOfBoundsException();
		}
		if (i==0){
			ListNode nice = head;
			head = head.getNext();
			nodeCount--;
			return nice.getValue();
		}
		int count = 0;
		for (ListNode node = head; node != null; node = node.getNext()) {
			if (count == i - 1){
				ListNode bad = node.getNext();
				node.setNext(bad.getNext());
				nodeCount --;
				return bad.getValue();
			}
			count ++;
		}
		return null;
	}

	// Returns a string representation of this list.
	public String toString()
	{
		String total = "{ ";
//		if (head==null){
//			return "This linked list is empty!";
//		}
		for (ListNode node = head; node != null; node = node.getNext()) {
			total+=node.getValue() +" ";
		}
		return total + "}";
	}

}
