package sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortingTest {
	
	String[] unsortedStringArray = new String[]{"e","f","b","c","a","d","g"};
	String[] sortedStringArray = new String[]{"a","b","c","d","e","f","g"};
	Integer[] intArray = new Integer[]{5,6,1,2,4,3};
	Integer[] sortedIntArray = new Integer[]{1,2,3,4,5,6};
	
	
	int[] unsortedIntArray2 = new int[]{5,6,1,2,4,3};
	int[] sortedIntArray2 = new int[]{1,2,3,4,5,6};
	
	@SuppressWarnings("deprecation")
	@Test
	public void testInsertionSort(){
		assertEquals(Sort.insertionSort(unsortedStringArray), sortedStringArray);
		assertEquals(Sort.insertionSort(unsortedStringArray), sortedStringArray);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSelectionSort(){
		assertEquals(sortedStringArray, Sort.selectionSort(unsortedStringArray));
		assertEquals(sortedStringArray,Sort.selectionSort(unsortedStringArray));
	}
	
	@Test
	public void testMergeSort(){
		//assertEquals(sortedStringArray, Sort.mergeSort(unsortedStringArray));
		//assertEquals(sortedIntArray,Sort.mergeSortInt(intArray));
	}
}
