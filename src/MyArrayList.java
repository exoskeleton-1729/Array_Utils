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
        this.internalArray = (E[])new Object[100];
    }
    
    /* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity){
        this.internalArray = (E[])new Object[initialCapacity];
    }
    
    /* Return the number of active slots in the array list */
    public int size() {
    	return objectCount;
    }
    
    /* Are there zero objects in the array list? */
    public boolean isEmpty() {
    	return (objectCount == 0);
    }
    
    /* Get the index-th object in the list. */
    public E get(int index) {
    	if (index < 0 || index >= objectCount)
    	{
			throw new IndexOutOfBoundsException();
		}
		return internalArray[index];
    }
    
    /* Replace the object at index with obj.  returns object that was replaced. */
    public E set(int index, E obj)
    {
    	E temp = get(index);
		internalArray[index] = obj;
		return temp;
    }

	/* Returns true if this list contains an element equal to obj;
	 otherwise returns false. */
    public boolean contains(E obj) {
    	for(int i = 0; i < objectCount; i++)
    	{
    		if(internalArray[i].equals(obj))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    /* Insert an object at index */
	@SuppressWarnings("unchecked")
    public void add(int index, E obj) {
		if (index < 0 || index > objectCount)
		{
			throw new IndexOutOfBoundsException();
		}
		add(obj);
		for (int i = objectCount - 1; i > index; i--)
		{
			internalArray[i] = internalArray[i-1];
		}
		internalArray[index] = obj;
    }

    /* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
    public boolean add(E obj) {
		if (objectCount >= internalArray.length) 
		{
			E[] newArray = (E[]) new Object[internalArray.length * 2];
			for(int i = 0; i < internalArray.length; i++)
			{
				newArray[i] = internalArray[i];
			}
			internalArray = newArray;
		}
		internalArray[objectCount] = obj;
		objectCount++;
		return true;
    }

    /* Remove the object at index and shift.  Returns removed object. */
    public E remove(int index) {
    	if(index < 0 || index >= objectCount)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	E temp = get(index);
		for (int i = index; i < objectCount-1; i++)
		{
			internalArray[i] = internalArray[i+1];
		}
		internalArray[objectCount-1] = null;
		objectCount--;
		return temp;
    }
    
    /* Removes the first occurrence of the specified element from this list, 
     * if it is present. If the list does not contain the element, it is unchanged. 
     * More formally, removes the element with the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists). 
     * Returns true if this list contained the specified element (or equivalently, 
     * if this list changed as a result of the call). */
    public boolean remove(E obj) {
    	for(int i = 0; i < objectCount; i++)
    	{
    		if(internalArray[i].equals(obj))
    		{
    			remove(i);
    			return true;
    		}
    	}
		return false;
    }
    
    /* For testing; your string should output as "[X, X, X, X, ...]" where X, X, X, X, ... are the elements in the ArrayList.
     * If the array is empty, it should return "[]".  If there is one element, "[X]", etc.
     * Elements are separated by a comma and a space. */
    public String toString() {
    	StringBuilder sb = new StringBuilder("[");
    	if(objectCount > 0)
    	{
    		for(int i = 0; i < objectCount-1; i++)
        	{
        		sb.append(internalArray[i]);
        		sb.append(", ");
        		
        	}
        	sb.append(internalArray[objectCount-1]);
    	}
    	sb.append("]");
    	return sb.toString();
    }
    
    public void moveToBack(E obj) {
    	E [] newArray = (E[])new Object[objectCount];
    	int counter = 0;
    	for(int i = 0; i < objectCount; i++)
    	{
    		if(internalArray[i].equals(obj))
    		{
    			counter++;
    		}
    		else
    		{
    			newArray[i-counter] = internalArray[i];
    		}
    	}
    	for(int i = 1; i <= counter; i++)
    	{
    		newArray[objectCount-i] = obj;
    	}
    	internalArray = newArray;
    	
    }

}