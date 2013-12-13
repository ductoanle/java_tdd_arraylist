package com.viki;

import java.lang.RuntimeException;
import java.util.Arrays;
import com.viki.exception.ArrayListException;

public class ArrayList{

	private static final int INITIAL_CAPACITY = 10;
	private String[] elementData;

	private int size = 0;

	public ArrayList(){
		this(INITIAL_CAPACITY);
	}

	public ArrayList(int initialCapacity){
		if (initialCapacity < 0){
			throw new ArrayListException();
		}
		this.elementData = new String[initialCapacity];
	}

	// Return the object at postion
	public String get(int position){
		if (position < size && position >= 0){
			return elementData[position];
		}
		else{
			throw new ArrayListException();
		}
	}

	// Return the size of the list
	public int size(){
		return size;
	}

	
	// Add new string to the end of the list
	public void add(String newStr){
		ensureCapacity(size + 1);
		elementData[size++] = newStr;		
	}

	// Add new object at indicated position
	public void add(int position, String newStr){

	}

	// Remove object at the end of the list, also return the removed object
	public String pop(){
		return null;
	}

	// Remove object at indicated position, also return the removed object
	public String remove(int position){
		return null;
	}

	
	// Check if the list is empty
	public boolean isEmpty(){
		return size == 0;
	}

	// Return the subList of this ArrayList
	public ArrayList subList(int start, int end){
		return new ArrayList();
	}

	private void ensureCapacity(int requiredCapacity){
		int oldCapacity = elementData.length;
		if (oldCapacity < requiredCapacity){
			int newCapacity = (oldCapacity * 3) / 2	+ 1;
			if (newCapacity < requiredCapacity){
				newCapacity = requiredCapacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
}