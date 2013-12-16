package com.viki;

import java.lang.RuntimeException;
import java.util.Arrays;
import com.viki.exception.ArrayListException;
import java.lang.System;

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
		validatePosition(position);
		return elementData[position];
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
		validatePosition(position);
		ensureCapacity(size + 1);
		System.arraycopy(elementData, position, elementData, position + 1, size - position);
		elementData[position] = newStr;
		size++;
	}

	// Check if the list is empty
	public boolean isEmpty(){
		return size == 0;
	}

	// Remove object at indicated position, also return the removed object
	public String remove(int position){
		validatePosition(position);
		String value = get(position);
		if (size - position - 1 > 0){
			System.arraycopy(elementData, position, elementData, position - 1, size - position - 1);		
		}
		elementData[--size] = null;
		return value;
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

	private void validatePosition(int position){
		if (position < 0 || position > size){
			throw new ArrayListException();
		}
	}
}