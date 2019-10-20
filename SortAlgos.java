package allAlgos;
import java.util.Random;

public class SortAlgos {	    
    //The following is assignment 1: Mergesort and Quicksort Algorithms
	
	public static void main(String[] args) {
		Random rand = new Random();
		for(int n = 10000;;n+=10000) {
			//The "int n = 10" line is for checking values. 
			//Please comment out the infinite for loop and bracket too.
			//int n = 10
			int[] unsortedArray = new int[n];
			
			//Fill unsorted array.
			for(int i = 0; i < n; i++) {
				unsortedArray[i] = rand.nextInt(1000);
			}
			
			//Print unsorted array.
			/*
			System.out.print("First unsorted array: ");
			for(int i = 0; i < unsortedArray.length; i++) {
				System.out.print(unsortedArray[i] + " ");
			}
			System.out.println();
			*/
			
			//Mergesort test
			long start = System.nanoTime();
			mergesort(n, unsortedArray);
			long finish = System.nanoTime() - start;
			System.out.println("Mergesort Time (n = " + n + "): " + finish + " ns");
			//Print only the time for mergesort:
			//System.out.println(finish);
			
			//Print mergesort array.
			/*
			System.out.print("Mergesort array: ");
			for(int i = 0; i < unsortedArray.length; i++) {
				System.out.print(unsortedArray[i] + " ");
			}
			System.out.println();
			*/
			
			
			//Fill sorted array with new random numbers.
			for(int i = 0; i < n; i++) {
				unsortedArray[i] = rand.nextInt(1000);
			}
			
			//Print NEW unsorted array.
			/*
			System.out.print("NEW unsorted array: ");
			for(int i = 0; i < unsortedArray.length; i++) {
				System.out.print(unsortedArray[i] + " ");
			}
			System.out.println();
			*/
			
			//Quicksort test
			long start2 = System.nanoTime();
			quicksort(0, n-1, unsortedArray, 0);
			long finish2 = System.nanoTime() - start2;
			System.out.println("Quicksort Time (n = " + n + "): " + finish2 + " ns");
			//Print only the time for quicksort:
			//System.out.println(finish2);
			
			//Print quicksort array.
			/*
			System.out.print("Quicksort array: ");
			for(int i = 0; i < unsortedArray.length; i++) {
				System.out.print(unsortedArray[i] + " ");
			}
			System.out.println();
			*/
		}
	}
	
	//Quicksort uses partition() method.
    public static int quicksort(int low, int high, int[] array, int pivotpoint) {
        if (high > low) {
            pivotpoint = partition(low, high, array, pivotpoint);
            pivotpoint = quicksort(low, pivotpoint-1, array, pivotpoint);
            pivotpoint = quicksort(pivotpoint+1, high, array, pivotpoint);
        }
        return pivotpoint;
    }
    
    public static int partition(int low, int high, int[] array, int pivotpoint) {
        int j = low, pivotitem = array[low];
        for (int i = low + 1; i <= high; i++) {
            if (array[i] < pivotitem) {
                j++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        pivotpoint = j;
        int temp = array[low];
        array[low] = array[pivotpoint];
        array[pivotpoint] = temp;
        return pivotpoint;
    }
    
    //Mergesort uses merge() method.
    public static void mergesort(int n, int s[]) {
        if (n>1) {
            int h = n/2, m = n-h;
            int[] u = new int[h];
            int[] v = new int[m];
            
            for (int i=0;i<h;i++) {
                u[i] = s[i];
            }

            for (int i=0;i<m;i++) {
                v[i] = s[h + i];
            }

            mergesort(h, u);
            mergesort(m, v);
            merge(h-1, m-1, u, v, s);
        }
    }
    
    public static void merge(int h, int m, int u[], int v[], int s[]) {
        int i = 0, j = 0, k = 0;
        while(i <= h && j <= m) {
            if (u[i] < v[j]) {
                s[k] = u[i];
                i++;
            }
            else {
                s[k] = v[j];
                j++;
            }
            k++;
        }
        
        if (i>h) {
            for(int j2 = 0; j2<v.length-j;j2++) {
                 s[k+j2] = v[j+j2];
            }
        }
        else {
            for(int i2 = 0; i2<u.length-i;i2++) {
                 s[k+i2] = u[i + i2]; 
            }
        }
    }
}
