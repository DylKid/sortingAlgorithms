package sortingAlgorithms;

import java.util.Arrays;

public class Sort {
	
	public static void main(String args[]){
		//unsorted array 
		Integer[] input = new Integer[]{3,2,1,4};
	
		//call merge sort 
		//mergeSort(input);
		
		//check the output which is sorted array
		//System.out.println(Arrays.toString(input));
		
		/*int[] a = new int[]{1,3,5,7,9};
		int[] b = new int[]{2,4,6,8,133,250,360};
		printArray(mergeInt(a,b));*/
		tests(10, 1000);

		
		
	}
	
	public static void tests(int noTests, int arraySize){
		//set up the running totals of the time taken by insertion and merge
		double insertSum = 0;
		double mergeSum = 0;
		
		for(int i = 0; i < noTests; i++){
			//generate an array of random integers
			Integer[] randInput = generateRandomArray(arraySize);

			//start the clock for insertion
			final long insertionStart = System.nanoTime();
			//sort it 
			insertionSort(randInput);
			//stop the clock for insertion
			final long insertionFinish = System.nanoTime();
			System.out.println("Time taken for insertion: " + (insertionFinish - insertionStart)/1000 + " ms");
			//add it to the running total 
			insertSum += (insertionFinish - insertionStart)/1000;
			
			//likewise for merge 
			final long mergeStart = System.nanoTime();
			mergeSort(randInput);
			final long mergeFinish = System.nanoTime();
			System.out.println("Time taken for merge: " + (mergeFinish - mergeStart)/1000 + " ms");
			mergeSum += (mergeFinish - mergeStart)/1000;
		}
		//Get the average by diving by the number of times it ran 
		System.out.println("-------------------------------------------------------");
		System.out.println("Insert average: " + insertSum/noTests);
		System.out.println("Merge average: " + mergeSum/noTests);
	}
	
	//Generate an array of random Integers 
	public static Integer[] generateRandomArray(int n){
		Integer[] arr = new Integer[n];
		for(int i = 0; i < n; i++){
			arr[i] = (int) Math.floor(Math.random()*100);
		}
		return arr;
	}
	
	public static <T extends Comparable<T>> T[] insertionSort(T[] a){
		for(int i = 1; i < a.length; i++){
			int j = i-1;
			T key = a[i];
			
			while(j >= 0 && a[j].compareTo(key) > 0){
				a[j+1] = a[j];
				j = j-1;
			}
			a[j+1] = key;
		}
		return a;
	}
	
	@SuppressWarnings("rawtypes")
	public static Comparable[] mergeSort(Comparable[] input){
		
		if(input.length<=1){
			return input;
		}
		
		int middle = Math.floorDiv(input.length, 2);
		
		Comparable a[] = new Comparable[middle];
		for(int i = 0; i < middle; i++){
			a[i] = input[i];
		}
	
		Comparable b[] = new Comparable[input.length - middle];
		for(int i = middle; i < input.length; i++){
			b[i-middle] = input[i];
		}
		
	    mergeSort(a);
		mergeSort(b);
		merge(input, a, b);
		
		return input;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void merge(Comparable[] input, Comparable[] a, Comparable[] b){
		
		int inputIndex = 0;
		int aIndex = 0;
		int bIndex = 0;
		
		while(aIndex < a.length && bIndex < b.length){
				
				if(aIndex < a.length & a[aIndex].compareTo(b[bIndex]) < 0){
					input[inputIndex] = a[aIndex];
					aIndex++;
				} else{
					input[inputIndex] = b[bIndex];
					bIndex++;
				}
				inputIndex++;
		}
	}
	
	public static <T extends Comparable<T>> T[] selectionSort(T[] a){
		for(int i = 0; i < a.length; i++){
			int smallestIndex = i;
			for(int j = (i+1); j < a.length; j++){
				if(a[j].compareTo(a[smallestIndex]) < 0){
					smallestIndex = j;
				}
			}
			swap(a, i, smallestIndex);
		}
		return a;
	}
	
	/*public static void mergeSortInt(int[] a, int low, int high){
		System.out.print("a:");
		printArray(a);
		System.out.printf("low:%d, high:%d\n", low, high);
		if(low < high){

			int middle = Math.floorDiv((low+high), 2);
			mergeSortInt(a, low, middle);
			mergeSortInt(a, middle+1, high);
		}
	}
	
	public static void mergeInt(int[] a, int low, int medium,int high){
		int n1 = medium - low + 1;
		int n2 = high-medium;
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];
		for(int i = 0; i < n1; i++){
			left[i] = a[low+i-1];
		}
		for(int i = 0; i < n2; i++){
			right[i] = a[medium + i];
		}
	}*/
	


	
	public static int[] mergeSortInt(int[] a){

		int size = a.length;
		
		if(size<=1){
			return a;
		}
		
		else {
			System.out.println("------------merge sort---------------");
			System.out.print("a:");
			printArray(a);
			
			int pivot = Math.floorDiv(size, 2);
			System.out.printf("size:%d, pivot:%d\n", size, pivot);

			int[] b = new int[pivot];
			
			for(int i = 0; i < pivot; i++){
				b[i] = a[i];
			}

			
			int[] c = new int[size-pivot];
			
			for(int i = pivot; i < size; i++){
				c[i-pivot] = a[i];
			}
			
			
			System.out.print("b:");
			printArray(b);
			mergeSortInt(b);
			
			System.out.print("c:");
			printArray(c);
			mergeSortInt(c);
			//System.out.println("--merge--");
			
			//printArray(mergeInt(b,c));
			mergeInt(a,b,c);	
			return a;
		}
		
	}
	
	
	public static void mergeInt(int[] list, int[] a, int[] b){
		System.out.println("----MERGING----");
		printArray(a);
		printArray(b);
		
		int sizeA = a.length;
		int sizeB = b.length;
		
		//setup left 
		int[] left = new int[sizeA+1];
		for(int i = 0; i < sizeA; i++){
			left[i] = a[i];
		}
		left[sizeA] = Integer.MAX_VALUE;
		
		//setup right 
		int[] right = new int[sizeB+1];
		for(int i = 0; i < sizeB; i++){
			right[i] = b[i];
		}
		right[sizeB] = Integer.MAX_VALUE;
		
		//left index
		int i = 0;
		//right index
		int j = 0;
		//m's index 
		int k = 0;
		//output
		int[] m = new int[sizeA + sizeB];
		while(i < sizeA || j < sizeB){
			//System.out.printf("left[%d]:%d, right[%d]:%d, k:%d\n", i, left[i], j, right[j], k);
			//System.out.print("m:");
			//printArray(m);
			if(left[i] <= right[j]){
				m[k] = left[i];
				i++;
			}
			else {
				m[k] = right[j];
				j++;
			}
			k++;
		}
		//System.out.printf("i:%d < sizeA:%d = %b, j:%d < sizeB:%d = %b\n", i, sizeA, i < sizeA, j, sizeB, j < sizeB);
		//return m;
		for(int z = 0; z < list.length; z++){
			list[z] = m[z];
		}
		
	}
	
	public static void printArray(int[] a){
		if(a.length > 0){
			for(int i = 0; i < a.length-1; i++){
				System.out.printf("%d, ", a[i]);
			}
			System.out.println(a[a.length-1]);
		}
		else{
			System.out.println("Empty array");
		}
	}
	
	public static <T> void printArray(T[] a){
		for(int i = 0; i < a.length-1; i++){
			System.out.printf("%d, ", a[i]);
		}
		System.out.println(a[a.length-1]);
	}

	
	/*public static <T extends Comparable<T>> T[] mergeSort(T[] a){
		return a;
	}
	
	public static <T> T[] merge(T[] a, int p, int q, int r){
		//compute the length of subarray A[p...q]
		int n1 = q - p + 1;
		//Compute the length of subarray A[q+1...r] 
		int n2 = r-q;
		return a;
	}*/
	
	
	
	public static <T> T[] merge(T[] a1, T[] a2){
		return null;
	}
	
	public static <T> void swap(T[] arr, int index1, int index2){
		T temp = arr[index2];
		arr[index2] = arr[index1];
		arr[index1] = temp;
	}

}
