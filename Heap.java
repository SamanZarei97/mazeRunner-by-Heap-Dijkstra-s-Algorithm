/**
 * Name: Saman Zarei
 * The purpose of this class is implementing the methods
 * that are required to create a max & min heap.
 */
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This is the helper class to help us to create 
 * an Entry list based on key & value
 * @author saman
 *
 * @param <K>
 * @param <V>
 */
class Entry<K, V> {
    K key; 
    V value;
    public Entry(K k, V v) { this.key = k; this.value = v; }
    public String toString() {
        return key + ": " + value;
    }
}

/**
 * This class has designed to implement some required method so that
 * by implementing those method we can create max and min heap
 * @author saman
 *
 * @param <K>
 * @param <V>
 */
public class Heap<K,V> implements PriorityQueue<K,V> {
	
	private static final int NUMBER_TWO = 2;
	public List<Entry<K, V>> entries;
	public Comparator<K> comparator;
	
	/**
	 * This the constructor that initializes the instance variables
	 * @param comparable
	 */
	public Heap(Comparator<K> comparable) {
		
		this.entries = new ArrayList<>();
		this.comparator = comparable;
	}
	
	/**
	 * This method returns true if the entry at index1 is greater than that at index2
	 * and false otherwise. 
	 * @param index1
	 * @param index2
	 * @return
	 */
	public boolean existsAndGreater(int index1, int index2) {
		
		if((index1 >= 0 && index1 < this.entries.size()) &&  
				(index2 >= 0 && index2 < this.entries.size())) {
			
			if(this.entries.get(index1) != null && this.entries.get(index2) != null) {
				
				if(this.comparator.compare(this.entries.get(index1).key,
						this.entries.get(index2).key) > 0) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * This method takes the index of two entries and swaps them.
	 * @param i1
	 * @param i2
	 */
	public void swap(int i1, int i2) {
		
		Entry<K,V> e = this.entries.get(i1);
		this.entries.set(i1, this.entries.get(i2));
		this.entries.set(i2, e);
	}
	
	/**
	 * This method returns the parent index.
	 * @param index
	 * @return
	 */
	public int parent(int index) {
		
		 return (index) / NUMBER_TWO;
	}
	
	/**
	 * This method returns the left child index.
	 * @param index
	 * @return
	 */
	public int left(int index) {
		
		return (index * NUMBER_TWO);
	}
	
	/**
	 * This method returns the right child index
	 * @param index
	 * @return
	 */
	public int right(int index) {
		
		return ((index * NUMBER_TWO) + 1);
	}
	
	/**
	 * This method returns the number of elements in entries
	 * @return
	 */
	public int size() {
		
		return this.entries.size();
	}
	
	/**
	 * This method returns a string representation of the elements in entries
	 */
	public String toString() {
		
		return this.entries.toString();
	}
	
	/**
	 * This is a  recursive method that moves the entry at the specified index to
	 * a smaller index (up the tree) while maintaining 
	 * the heap structure. In the case where the element is
	 * equal to the parent, you should not swap.
	 * @param index
	 */
	public void bubbleUp(int index) {
		
		if(index <= 0) {
			return;
		}
		
		Entry<K,V> e = this.entries.get(index);
		Entry<K,V> parent = this.entries.get(parent(index));
		int comparing = this.comparator.compare(e.key, parent.key);
		if(comparing > 0) {
			
			swap(index,parent(index));
			bubbleUp(parent(index));
		}
		
		else {
			
			return;
		}
	}
	
	/**
	 * This is a recursive method that moves the entry at the specified index to a larger index
	 * (down the tree) while maintaining the heap structure. Swap with the child with
	 * higher priority. If both children are equal and swapping is needed, swap with the
	 * left child. In the case where the element is equal to the smaller child, you should
	 * not swap. However, if the child with high priority has greater priority than the
	 * parent, you still must swap.
	 * @param index
	 */
	public void bubbleDown(int index) {
		
		if(index >= this.entries.size()) {
			return;
		}
		
		int leftIndex = left(index);
		int rightIndex = right(index);
		int largeChildIndex = leftIndex;
		if(existsAndGreater(rightIndex, leftIndex)) {
			
			largeChildIndex = rightIndex;
		}
		
		if(existsAndGreater(largeChildIndex, index)) {
			
			swap(index, largeChildIndex);
			bubbleDown(largeChildIndex);
		}
	}
	
	/**
	 * This method inserts a new entry with the given key and value to the end of the heap. 
	 * Then, bubbleUp so that the heap properties are not violated
	 */
	public void add(K k, V v) {
		
		Entry<K, V> e = new Entry<K, V>(k,v); 
		this.entries.add(e);
		bubbleUp(this.entries.indexOf(e));
	}
	
	/**
	 * This method removes and returns the root element in the heap. 
	 * it sets the last entry in the heap to the root.
	 * and uses bubbleDown to fix the heap after the removal. 
	 * If the size is zero, throw NoSuchElementException()
	 */
	public Entry<K, V> poll(){
		
		if(this.entries.size() == 0) {
			throw new NoSuchElementException();
		}
		
		Entry<K,V> root = this.entries.get(0);
		this.entries.set(0, this.entries.get(this.entries.size() - 1));
		this.entries.remove((this.entries.size() - 1));
		bubbleDown(0);
		return root;
	}
	
	/**
	 * this method returns the root element of the heap. If the size is zero, 
	 * throw NoSuchElementException()
	 */
	public Entry<K, V> peek(){
		
		if(this.entries.size() == 0) {
			throw new NoSuchElementException();
		}
		
		Entry<K,V> root = this.entries.get(0);
		return root;
	}
	
	/**
	 * This method returns the list of entries.
	 */
	public List<Entry<K,V>> toArray(){
		
		List<Entry<K,V>> e = new ArrayList<>();
		
		for(Entry element : this.entries) {
			
			e.add(element);
		}
		
		return e;
	}
	
	/**
	 * This method returns true if the size is zero and false otherwise
	 */
	public boolean isEmpty() {
		
		if(this.entries.size() == 0) {
			
			return true;
		}
		
		return false;
	}		
}


