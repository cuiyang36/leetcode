package PersonalStudy;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class ArrayQueue<E>{
	
	private E[] array;
	private static final int DEFAULT_CAPACITY = 6; 
	private int front; // front index
	private int back; // back index
	private int nItems; //current number of elements
	
	public ArrayQueue(){
		//array = (E[])new E[DEFAULT_CAPACITY];
		front = 0;
		back = -1;
		nItems = 0;
	}
	
	/**
	 * enqueues a new element to the back of the queue in O(1)
	 * @param e a new element to add
	 */
	public void enqueue(E e) {
		if(isFull()) 
			throw new RuntimeException("Queue is full");
		back++;
		array[back % array.length] = e;
		nItems++;
	}
	
	/**
	 * gets and deletes an element from the front of the queue in O(1)
	 * @return the first element in the queue
	 */
	public E dequeue() {
		if(isEmpty())
			throw new NoSuchElementException();	
		int index = front % array.length;
		E e = array[index];
		array[index] = null;
		front++; // front moves up to the right
		nItems--;
		return e;
	}
	
	/**
	 * gets an element from the front of the queue in O(1)
	 * but does not delete it
	 * @return the first element in the queue
	 */
	public E peekFront() {
		if(isEmpty())
			throw new NoSuchElementException();
		return array[front%array.length];
	}

	/**
	 * check if the queue is empty or not in O(1)
	 * @return true if the queue is empty, false if not
	 */
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	// private helper method to check if queue is full or not
	private boolean isFull() {
		return nItems == array.length;
	}

}
