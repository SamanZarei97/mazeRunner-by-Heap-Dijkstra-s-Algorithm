/**
 * Name: Saman Zarei
 * The purpose of this file is check the correctness of 
 * heap class by some test methods.
 */

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class contains some methods that checks to see if the Heap
 * class has implemented correctly.
 * @author saman
 *
 */
public class HeapTest {
	
	/**
	 * This method checks the correctness of heap class by adding and 
	 * getting the size of the list
	 */
	@Test
	public void testToArrayAndSizeAndToString() {
		
		Heap<Integer, String> list = new Heap<Integer, String>(Collections.reverseOrder
				(Integer::compare));
		
		list.add(5, "Saman");
		list.add(2, "Yasi");
		list.add(3, "Kamand");
		list.add(4, "Bita");
		list.add(1, "Keyvan");
		
		assertEquals(5, list.toArray().size());
		System.out.println(list.toArray().toString());
	}
	
	/**
	 * This method checks the correctness of Heap class by adding some elements
	 * in the list in increasing order so that we will have the min heap. Also we get the size
	 * of the list 
	 */
	@Test
	public void testAddmin() {
		
		Heap<Integer, String> list = new Heap<Integer, String>(Collections.reverseOrder
				(Integer::compare));
		
		list.add(7, "Yasi");
		list.add(6, "Kamand");
		list.add(5, "Bita");
		list.add(4, "Keyvan");
		list.add(3, "Amos");
		list.add(2, "Hooman");
		list.add(1, "Barbod");
		
		assertEquals(7, list.toArray().size());
		//System.out.println(list.toArray().toString());
	}
	
	/**
	 * This method checks the correctness of Heap class by adding some elements
	 * in the list in decreasing order so that we will have the max heap. Also we get the size
	 * of the list 
	 */
	@Test
	public void testAddMax() {
		
		Heap<Integer, String> list = new Heap<Integer, String>(Integer::compare);
		
		list.add(5, "Bita");
		list.add(4, "Keyvan");
		list.add(2, "Hooman");
		list.add(1, "Barbod");
		list.add(7, "Yasi");
		list.add(6, "Kamand");
		list.add(3, "Amos");
		
		assertEquals(7, list.toArray().size());
		//System.out.println(list.toArray().toString());
	}
	
	/**
	 * This method checks the correctness of Heap class by adding some elements
	 * in the list in increasing order so that we will have the min heap. and after
	 * that we will get the peak of the min heap which supposes to be the smallest element  
	 */
	@Test
	public void testPeekMin() {
		
		Heap<Integer, String> list = new Heap<Integer, String>(Collections.reverseOrder
				(Integer::compare));
		
		list.add(7, "Yasi");
		list.add(6, "Kamand");
		list.add(5, "Bita");
		list.add(4, "Keyvan");
		list.add(3, "Amos");
		list.add(2, "Hooman");
		list.add(1, "Barbod");
		
		assertEquals(true, list.peek().value.equals("Barbod"));
		assertEquals(true, list.peek().key.equals(1));
	}
	
	/**
	 * This method checks the correctness of Heap class by adding some elements
	 * in the list in decreasing order so that we will have the max heap. and after
	 * that we will get the peak of the max heap which supposes to be the largest element  
	 */
	@Test
	public void testPeekMax() {
		
		Heap<Integer, String> list = new Heap<Integer, String>(Integer::compare);
		
		list.add(7, "Yasi");
		list.add(6, "Kamand");
		list.add(5, "Bita");
		list.add(4, "Keyvan");
		list.add(3, "Amos");
		list.add(2, "Hooman");
		list.add(1, "Barbod");
		
		assertEquals(true, list.peek().value.equals("Yasi"));
		assertEquals(true, list.peek().key.equals(7));
	}
	
	/**
	 * This method checks the correctness of Heap class by having a min heap, 
	 * poll all the elements so that the list will be empty.
	 * Also each time we poll, the smallest elements will remove
	 */
	@Test
	public void testisEmptyforEmptyList() {
		
		Heap<Integer, String> list = new Heap<Integer, String>(Collections.reverseOrder
				(Integer::compare));
		
		list.add(7, "Yasi");
		list.add(6, "Kamand");
		list.add(5, "Bita");
		list.add(4, "Keyvan");
		list.add(3, "Amos");
		list.add(2, "Hooman");
		list.add(1, "Barbod");
		
		list.poll();
		list.poll();
		list.poll();
		list.poll();
		list.poll();
		list.poll();
		list.poll();
		
		assertEquals(true, list.toArray().isEmpty());
	}
	
	/**
	 * This method checks the correctness of Heap class by having a min heap, 
	 * poll the elements but not all of them
	 * Also each time we poll, the smallest elements will remove
	 */
	@Test
	public void testisEmptyFornonEmpty() {
		
		Heap<Integer, String> list = new Heap<Integer, String>(Collections.reverseOrder
				(Integer::compare));
		
		list.add(7, "Yasi");
		list.add(6, "Kamand");
		list.add(5, "Bita");
		list.add(4, "Keyvan");
		list.add(3, "Amos");
		list.add(2, "Hooman");
		list.add(1, "Barbod");
		
		list.poll();
		list.poll();
		list.poll();
	
		assertEquals(false, list.toArray().isEmpty());
	}
	
	/**
	 * This method checks the correctness of Heap class by having a min heap, 
	 * poll all the elements so that the list will be empty.
	 * Also each time we poll, the smallest elements will remove
	 */
	@Test
	public void testPollMin() {
		
		Heap<Integer, String> list = new Heap<Integer, String>(Collections.reverseOrder
				(Integer::compare));
		
		list.add(7, "Yasi");
		list.add(6, "Kamand");
		list.add(5, "Bita");
		list.add(4, "Keyvan");
		list.add(3, "Amos");
		list.add(2, "Hooman");
		list.add(1, "Barbod");
		
		assertEquals("Barbod", list.poll().value);
		assertEquals("Hooman", list.poll().value);
		assertEquals("Amos", list.poll().value);
		assertEquals("Keyvan", list.poll().value);
		assertEquals("Bita", list.poll().value);
		assertEquals("Kamand", list.poll().value);
		assertEquals("Yasi", list.poll().value);
		
	}
	
	/**
	 * This method checks the correctness of Heap class by having a max heap, 
	 * poll all the elements so that the list will be empty.
	 * Also each time we poll, the largest elements will remove
	 */
	@Test
	public void testPollMax() {
		
		Heap<Integer, String> list = new Heap<Integer, String>(Integer::compare);
		
		list.add(5, "Bita");
		list.add(4, "Keyvan");
		list.add(2, "Hooman");
		list.add(1, "Barbod");
		list.add(7, "Yasi");
		list.add(6, "Kamand");
		list.add(3, "Amos");
		
		assertEquals("Yasi", list.poll().value);
		assertEquals("Kamand", list.poll().value);
		assertEquals("Bita", list.poll().value);
		assertEquals("Keyvan", list.poll().value);
		assertEquals("Amos", list.poll().value);
		assertEquals("Hooman", list.poll().value);
		assertEquals("Barbod", list.poll().value);
	}
	
	/**
	 * This method checks the correctness of heap class by adding and 
	 * getting the size of the list
	 */
	@Test
	public void testHeapFunctionality_toArray() {
		
		String[] name = {"Eric", "Nandini", "Rebecca", "Greg", "Juan"};
		int[] weights = {0,1,2,3,4};
		Heap<Integer, String> list = new Heap<Integer, String>(Collections.reverseOrder
				(Integer::compare));
		
		for(int i = 0; i < name.length; i++) {
			
			list.add(weights[i], name[i]);
		}
		
		assertEquals(5, list.toArray().size());	
	}
	
	/**
	 * This method checks the correctness of Heap class by adding some elements
	 * in the list in increasing order so that we will have the min heap. Also we get the size
	 * of the list 
	 */
	@Test
	public void testHeapFunctionality_addMin() {
		
		String[] name = {"Garo", "Eric", "Nandini", "Paul", "Greg", "Rebecca"};
		int[] weights = {20, 10, 30, 5, 1, 22};
		Heap<Integer, String> list = new Heap<Integer, String>(Collections.reverseOrder
				(Integer::compare));
		
		for(int i = 0; i < name.length; i++) {
			
			list.add(weights[i], name[i]);
		}
		
		assertEquals(6, list.toArray().size());	
	}
	
	/**
	 * This method checks the correctness of Heap class by adding some elements
	 * in the list in decreasing order so that we will have the max heap. Also we get the size
	 * of the list 
	 */
	@Test
	public void testHeapFunctionality_addMax() {
		
		String[] name = {"Garo", "Eric", "Nandini", "Paul", "Greg", "Rebecca"};
		int[] weights = {20, 10, 30, 5, 1, 22};
		
		Heap<Integer, String> list = new Heap<Integer, String>(Integer::compare);
		
		for(int i = 0; i < name.length; i++) {
			
			list.add(weights[i], name[i]);
		}
		
		assertEquals(6, list.toArray().size());	
	}
	
	/**
	 * This method checks the correctness of Heap class by adding some elements
	 * in the list in increasing order so that we will have the min heap. and after
	 * that we will get the peak of the min heap which supposes to be the smallest element  
	 */
	@Test
	public void testHeapFunctionality_peek() {
		
		String[] name = {"Eric", "Nandini", "Rebecca", "Greg", "Juan"};
		int[] weights = {0,1,2,3,4};
		
		Heap<Integer, String> list = new Heap<Integer, String>(Collections.reverseOrder
				(Integer::compare));
		for(int i = 0; i < name.length; i++) {
			
			list.add(weights[i], name[i]);
		}
		
		assertEquals(true, list.peek().value.equals("Eric"));
		assertEquals(true, list.peek().key.equals(0));
	}
	
	/**
	 * This method checks the correctness of Heap class by having a min heap, 
	 * poll all the elements so that the list will be empty.
	 * Also each time we poll, the smallest elements will remove
	 */
	@Test
	public void testHeapFunctionality_removeMin() {
		
		String[] name = {"Garo", "Eric", "Nandini", "Paul", "Greg", "Rebecca"};
		int[] weights = {20, 10, 30, 5, 1, 22};
		Heap<Integer, String> list = new Heap<Integer, String>(Collections.reverseOrder
				(Integer::compare));
		
		for(int i = 0; i < name.length; i++) {
			
			list.add(weights[i], name[i]);
		}
		
        assertEquals("Greg", list.poll().value);
        assertEquals("Paul", list.poll().value);
        assertEquals("Eric", list.poll().value);
        assertEquals("Garo", list.poll().value);
        assertEquals("Rebecca", list.poll().value);
        assertEquals("Nandini", list.poll().value);
        assertEquals(true, list.isEmpty());
		
	}
	
	/**
	 * This method checks the correctness of Heap class by having a max heap, 
	 * poll all the elements so that the list will be empty.
	 * Also each time we poll, the largest elements will remove
	 */
	@Test
	public void testHeapFunctionality_removeMax() {
		
		String[] name = {"Garo", "Eric", "Nandini", "Paul", "Greg", "Rebecca"};
		int[] weights = {20, 10, 30, 5, 1, 22};
		Heap<Integer, String> list = new Heap<Integer, String>(Integer::compare);
		
		for(int i = 0; i < name.length; i++) {
			
			list.add(weights[i], name[i]);
		}
		
        assertEquals("Nandini", list.poll().value);
        assertEquals("Rebecca", list.poll().value);
        assertEquals("Garo", list.poll().value);
        assertEquals("Eric", list.poll().value);
        assertEquals("Paul", list.poll().value);
        assertEquals("Greg", list.poll().value);
	}
}
