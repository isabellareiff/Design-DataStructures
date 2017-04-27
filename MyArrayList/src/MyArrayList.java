/* See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

public class MyArrayList<E> {
    
    /* Internal Object counter */
    protected int objectCount;
    
    /* Internal Object array */
    protected E [] internalArray;
    
    /* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
    public MyArrayList() {
        this.internalArray = (E[]) new Object[100];
    }
    
    /* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity){
        this.internalArray = (E[])new Object [initialCapacity];
    }
    
    /* Return the number of active slots in the array list */
    public int size() {
        return objectCount;
    }
    
    /* Are there zero objects in the array list? */
    public boolean isEmpty() {
    	return (objectCount==0);
    }
    
    /* Get the index-th object in the list. */
    public E get(int index) {
    	if (index >= objectCount){
    		throw new IndexOutOfBoundsException("You messed up");
    	}
        return internalArray[index];
    }
    
    /* Replace the object at index with obj. returns object that was replaced. */
    public E set(int index, E obj) {
    	if (index >= objectCount){
    		throw new IndexOutOfBoundsException("You messed up");
    	}
    	E replace = internalArray [index];
        internalArray[index] = obj;
        return replace;
    }

    /* Insert an object at index */
	@SuppressWarnings("unchecked")
    public void add(int index, E obj) {
        /* ---- YOUR CODE HERE ---- */
		if (index > objectCount){
    		throw new IndexOutOfBoundsException("You messed up");
    	}
		else if (objectCount==0){
			internalArray[objectCount] = obj;
			objectCount++;
		}
		else if (objectCount + 1 > internalArray.length){
			E [] newer = (E[]) new Object [2 * (objectCount)] ;
			for (int i = 0; i < index; i ++){
				newer [i] = internalArray[i];
			}
			for (int j = objectCount +1 ; j < index + 1; j--){
				newer [j] = internalArray[j-1];
			}
			internalArray = newer;
			newer[index] = obj;
			objectCount++;
		}
		else { 					// if (objectCount + 1 <= internalArray.length){
			int x = objectCount - 1;
			internalArray[objectCount] = internalArray[x];
			for (int i = objectCount - 1; i > index ; i--){
				internalArray [i] = internalArray [i-1];
			}
			internalArray[index]=obj;
			objectCount ++;
		}
	}
		
	/* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
    public boolean add(E obj) {
        /* ---- YOUR CODE HERE ---- */
		this.add(objectCount, obj);
		return true;
    }

    /* Remove the object at index and shift.  Returns removed object. */
    public E remove(int index) {
        /* ---- YOUR CODE HERE ---- */
    	E removed = internalArray[index];
    	
    	for (int i = index; i < objectCount - 1; i++){
    		internalArray[i] = internalArray[i+1];
    	}
    	return removed;
    }
    
    /* Removes the first occurrence of the specified element from this list, 
     * if it is present. If the list does not contain the element, it is unchanged. 
     * More formally, removes the element with the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists). 
     * Returns true if this list contained the specified element (or equivalently, 
     * if this list changed as a result of the call). */
    public boolean remove(E obj) {
        /* ---- YOUR CODE HERE ---- */
    	E removed;
    	int find = 0;
    	while (obj!=(internalArray[find] )){
    		find ++;
    	}
    	if (find==objectCount-1){
    		return false;
    	}
    	else{
    		this.remove (find);
    		return true;
    	}
    }
    
    /* For testing; your string should output as "{ X X X X ... }" where X X X X ... are the elements in the array.
     * If the array is empty, it should return "{ }".  If there is one element, "{ X }", etc.
     * Elements are separated by a space. */
    public String toString() {
    	String str = "" ;
    	if (this.isEmpty()){
    		return "{ }";
    	}
    	for (int i = 0; i < objectCount; i++){
    		str += " "+internalArray[i];
    	}
    	return "{" +str+ " }" ;
    }

}