package sorting;

import java.util.Arrays;

public class RecursiveInsertion {
	
	public static void main (String args[]){
	
		Integer[] input = new Integer[]{10000,2,575,228,1,4,3,2,67,8,2,5,1};
		insertionSort(input, input.length-1);	
		System.out.printf("it's sorted:%s", Arrays.toString(input));
	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> Comparable[] insertionSort(Comparable[] a, int n){
		//System.out.printf("a:%s, p:%d\n", Arrays.toString(a), n);
		if(n <= 0){
			return a;
		}
		
		insertionSort(a, n-1);
		Comparable key = a[n];
		
		int j = n-1;
		
		while(j >= 0){
			//System.out.printf("key: %d j:%d a[j]:%s | ", key, j, a[j].toString());
			if(key.compareTo(a[j]) > 0){
				break;
			}
			else {
				swap(a,j,j+1);
			}

			j = j-1;
		}
	//	System.out.println();
		
		return a;
		
	
	}
	
	public static <T> void swap(Comparable[] a, int pos1, int pos2){
		Comparable temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
		//System.out.println(Arrays.toString(a));
	}

}
