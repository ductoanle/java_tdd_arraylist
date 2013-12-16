package com.viki.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.viki.ArrayList;
import com.viki.exception.ArrayListException;

@RunWith(JUnit4.class)
public class ArrayListTest{

	// test init constructor
	@Test
	public void thisShouldNotHaveNegativeInitialCapacity(){
		try{
			new ArrayList(-1);
			fail("it should throw exception");
		}
		catch(ArrayListException e){			
		}
	}

	// test add() method
	@Test
	public void thisShouldAddNewStr(){
		ArrayList list = new ArrayList();
		list.add("First String");
		assertEquals("First String", list.get(0));	
		list.add("Second String");
		list.add("Third String");
		assertEquals("Third String", list.get(2));
	}

	@Test 
	public void thisShouldAddMoreStringsThanInitialCapacity(){
		ArrayList list = new ArrayList(5);
		for (int i = 0 ; i < 10; i++){
			list.add("Test String");
		}
		assertEquals(10, list.size());
	}

	// test get() method

	@Test
	public void thisShouldThrowExceptionForNegativePos(){
		ArrayList list = new ArrayList();
		try{
			list.get(-1);
			fail("It should throw exception");
		}
		catch(ArrayListException e){
		}		
	}

	@Test
	public void thisShouldThrowExceptionForPositionThatExceedLength(){
		ArrayList list = new ArrayList();
		try{
			list.get(10);
			fail("it should throw exception");
		}
		catch(ArrayListException e){

		}
	}

	// test size() method
	@Test 
	public void thisShouldReturnZeroForNewList(){
		ArrayList list = new ArrayList();
		assertEquals(0, list.size());
	}

	@Test
	public void thisShouldReturnCorrectSize(){
		ArrayList list = new ArrayList();
		list.add("first");
		list.add("second");
		assertEquals(2, list.size());
		list.add("third");
		assertEquals(3, list.size());
	}

	// test isEmpty() method
	@Test
	public void thisShouldReturnWhetherListIsEmpty(){
		ArrayList list = new ArrayList();
		assertEquals(true, list.isEmpty());
		list.add("Test 1");
		assertEquals(false, list.isEmpty());
		list.add("Test 2");
		assertEquals(false, list.isEmpty());
	}

	// test add(int position, String newStr) method
	@Test
	public void thisShouldAddNewStrAtIndicatedPosition(){
		ArrayList list = new ArrayList();
		for (int i = 0; i < 10; i++){
			list.add("Test");	
		}
		list.add(5, "Special String");
		assertEquals(11, list.size());
		assertEquals("Special String", list.get(5));
	}

	@Test
	public void thisShouldThrowExceptionForNegativeAddPos(){
		ArrayList list = new ArrayList();
		try{
			list.add(-1, "Special String");
			fail("it should throw exception");
		}
		catch (ArrayListException e){}
	}

	@Test
	public void thisShouldThrowExceptionForAddPositionThatExceedLength(){
		ArrayList list = new ArrayList();
		try{
			list.add(10, "Special String");
			fail("it should throw exception");
		}
		catch (ArrayListException e){}
	}

	// test remove(int position) method
	@Test
	public void thisShouldRemoveTheStringAtIndicatedPosition(){
		ArrayList list = new ArrayList();
		list.add("Test 1");
		list.add("Test 2");
		list.add("Test 3");
		String removedStr = list.remove(1);
		assertEquals("Test 2", removedStr);
		assertEquals(2, list.size());
	}

	@Test
	public void thisShouldThrowExceptionForNegativeRemovePos(){
		ArrayList list = new ArrayList();
		try{
			list.remove(-1);
			fail("it should throw exception");
		}
		catch (ArrayListException e){}
	}

	@Test
	public void thisShouldThrowExceptionForRemovePositionThatExceedLength(){
		ArrayList list = new ArrayList();
		try{
			list.remove(10);
			fail("it should throw exception");
		}
		catch (ArrayListException e){}
	}
	
	// test subList() method
	
}