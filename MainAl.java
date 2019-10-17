/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodproject12.algorithms;
import java.util.Random;
//import java.util.Scanner;

/**
 *
 * @author desty
 */
public class MainAl {
    public static void main(String[] args) {
        /*
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter a number for peasent multi: ");
        int firstNum;
        firstNum = kb.nextInt();
        System.out.print("Enter another number for peasent multi: ");
        int secondNum;
        secondNum = kb.nextInt();
        
        int answer;
        answer = pMI(firstNum, secondNum);
        System.out.println("Answer: " + answer);
        
        int sum = 0;
        int sum1 = 0;
        boolean gotHere = false;
        answer = pMR(firstNum, secondNum, sum);
        System.out.println("Answer: " + answer);

        
        int n;

        System.out.print("How many numbers in array?: ");
        n = kb.nextInt();
        int array[] = new int[n];
        
        for (int i=0;i<n;i++) {
            array[i] = i;
        }
        System.out.print("Array values: ");
        for (int i=0;i<n;i++) {
            System.out.print(array[i]);
        }
        
        System.out.print("\nSearch for number: ");
        int i = kb.nextInt();
        System.out.println("Sequential Search: Found(if unfound, -1): " + sLS(array, n, i));
        System.out.println("Binary Search Iterative: Found(if unfound, -1): " + bSI(array, 0, n-1, i));
        System.out.println("Binary Search Recursive: Found(if unfound, -1): " + bSR(array, 0, n-1, i));

        System.out.print("Number for Fibonacci Sequence: ");
        n = kb.nextInt();
        System.out.println("Fibonacci Sequence Recursive: " + fSR(n));
        System.out.println("Fibonacci Sequence Iterative: " + fSI(n));
        */
        
        
        /*
        //int[] array = { 4, 5, 7, 2};
        int[] array = {6, 2, 3, 8, 5, 1};
        //int[] array = {1,2,3,4,5,6,7,8,9,10};
        //int[] array2 = { 4, 7, 5, 8};
        int re = highestSum(array.length, array);
        System.out.println(re);
        */
        
        /* MERGE SORT
        //int[] mergeTest = {45,100,35,20,50,10};
        int[] mergeTest = {10, 50, 40, 60, 10, 100, 110, 110, 120};
        for(int i=0; i<mergeTest.length;i++) {
            System.out.print(mergeTest[i] + " ");
        }
        
        mergesort(mergeTest.length, mergeTest);
        
        for(int i=0; i<mergeTest.length;i++) {
            System.out.print(" "+mergeTest[i] + " ");
        }        
        */
        
        //Quicksort
        //int[] quickTest = { 102, 50, 70, 90, 10};
        //int[] quickTest = { 50, 10, 60, 100, 200, 60, 40};
        /*
        int[] quickTest = { 100, 50, 30, 6, 0, 100, 100};
        
        for(int i=0; i<quickTest.length;i++) {
            System.out.print(quickTest[i] + " ");
        }        
        System.out.println();
        quicksort(0, quickTest.length-1, quickTest, 0);
        
        for(int i=0; i<quickTest.length;i++) {
            System.out.print(quickTest[i] + " ");
        }
        */
        
        /*
        int[][] a = {{1,0,2,4}, 
                     {-3,2,2,4},
                     {-3,2,2,4},
                     {-3,2,2,4}};
        int[][] b = {{1,0,2,4}, 
                     {-3,2,2,4},
                     {-3,2,2,4},
                     {-3,2,2,4}};
        int[][] a1 = { {2,4},
                       {2,4}};
        int[][] b1 = { {3,5},
                       {4,5}};        

        int n = a.length;
        int[][] c = new int[n][n];

        //matrixMult(n, a, b, c);
        System.out.println("Printing old matrix: ");
        printMat(c);
        
        c = strassenMult(n, a, b);
        int[][] d = matrixMult(n, a, b);
        System.out.println("Normie: ");
        printMat(d);
        //straAdd(n, a, b, c);
        
        System.out.println("Printing resulting matrix: ");
        printMat(c);
        */
        towerOfHanoi(4, 'A', 'B', 'C');
    }
    
    //2^n-1 time complexity!
    public static void towerOfHanoi(int n, char firstTower, char secondTower, char thirdTower) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod: " + firstTower + " to rod: " + thirdTower);
            return;
        }
        towerOfHanoi(n-1, firstTower, thirdTower, secondTower);
        System.out.println("Move " + n + " from rod: " + firstTower + " to rod: " + thirdTower);
        towerOfHanoi(n-1, secondTower, firstTower, thirdTower);
    }
    
    public static void printMat(int[][] c) {
        for(int i = 0; i < c.length; i++) {
            for(int j = 0; j < c.length; j++) {
                System.out.print("c["+ (i) + "][" + (j) + "]" + c[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int[][] straAdd(int n, int a[][], int b[][]) {
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                //System.out.println(a[i][j] + b[i][j]);
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    
    public static int[][] straSub(int n, int a[][], int b[][]) {
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                //System.out.println(a[i][j] - b[i][j]);
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }
    
    public static void partitionMat(int[][] input, int[][] output, int row, int col) {
        for (int i = 0, i2 = row; i < output.length; i++, i2++) {
            for(int j = 0, j2 = col; j < output.length; j++, j2++) {
                //System.out.println(input[i2][j2]);
                output[i][j] = input[i2][j2];
            }
        }
    }
    
    public static void buildMat(int[][] result, int[][] c, int col, int row) {
        for(int i = 0, i2 = row; i < c.length; i++, i2++) {
            for(int j = 0, j2 = col; j < c.length; j++, j2++) {
                //System.out.println("buildMat: " + c[i][j]); //All 0's
                result[i2][j2] = c[i][j];
            }
        }
    }
    
    public static int[][] strassenMult(int n, int a[][], int b[][]){
        
        if (n == 1) { //When a and b is 1x1.
            int[][] result; // = new int[n][n]; //Idk if it is mid.
            //result[0][0] = a[0][0]*b[0][0];
            //c[0][0] = a[0][0]*b[0][0];
            return result = matrixMult(n, a, b);
        }
        else {
            int mid = n/2;
            int[][] result = new int[n][n]; //Idk if it is mid.        
            int[][] a11 = new int[mid][mid];
            int[][] a12 = new int[mid][mid];
            int[][] a21 = new int[mid][mid];
            int[][] a22 = new int[mid][mid];
            
            int[][] b11 = new int[mid][mid];
            int[][] b12 = new int[mid][mid];
            int[][] b21 = new int[mid][mid];
            int[][] b22 = new int[mid][mid];
          
            int[][] c11;// = new int[mid][mid];
            int[][] c12;// = new int[mid][mid];
            int[][] c21;// = new int[mid][mid];
            int[][] c22;// = new int[mid][mid];
            
            //Partition matrices into 4 smaller pieces.
            partitionMat(a,a11,0,0);
            partitionMat(a,a12,0,mid);
            partitionMat(a,a21,mid,0);
            partitionMat(a,a22,mid,mid);
            
            partitionMat(b,b11,0,0);
            partitionMat(b,b12,0,mid);
            partitionMat(b,b21,mid,0);
            partitionMat(b,b22,mid,mid);
            
            int[][] p;// = new int[mid][mid];
            int[][] q;// = new int[mid][mid];
            int[][] r;// = new int[mid][mid];
            int[][] s;// = new int[mid][mid];
            int[][] t;// = new int[mid][mid];
            int[][] u;// = new int[mid][mid];
            int[][] v;// = new int[mid][mid];
            
            //Not sure if we return what again?
            p = strassenMult(mid, straAdd(mid, a11, a22), straAdd(mid, b11, b22));
            q = strassenMult(mid, straAdd(mid, a21, a22), b11);
            r = strassenMult(mid, a11, straSub(mid, b12, b22));
            s = strassenMult(mid, a22, straSub(mid, b21, b11));
            t = strassenMult(mid, straAdd(mid, a11, a12), b22);
            u = strassenMult(mid, straSub(mid, a21, a11), straAdd(mid, b11, b12));
            v = strassenMult(mid, straSub(mid, a12, a22), straAdd(mid, b21, b22));
            
            //Forming c
            c11 = straAdd(mid, straSub(mid, straAdd(mid, p, s), t), v);
            c12 = straAdd(mid, r, t);
            c21 = straAdd(mid, q, s);
            c22 = straAdd(mid, straSub(mid, straAdd(mid, p, r), q), u);
            
            //Put c together
            buildMat(result, c11, 0, 0);
            buildMat(result, c12, mid, 0);
            buildMat(result, c21, 0, mid);
            buildMat(result, c22, mid, mid);
            return result;
        }
    }
    
    public static int[][] matrixMult(int n, int a[][], int b[][]) {
        int[][] result = new int[n][n];
        if (n == 1) {
            result[0][0] = a[0][0]*b[0][0];             
        }
        else {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    result[i][j] = a[i][0]*b[0][j]; 
                    for(int k = 1 ; k < n; k++) {
                        result[i][j] += a[i][k]*b[k][j];
                    }  
                }
            }
        }
        return result;
    }
    
    public static int quicksort(int low, int high, int[] array, int pivotpoint) {
        if (high > low) {
            System.out.println("quicksort if: high > low");
            System.out.println("Into partition");
            pivotpoint = partition(low, high, array, pivotpoint);
            System.out.println("Into quicksort 1");
            pivotpoint = quicksort(low, pivotpoint-1, array, pivotpoint); //Index of pivotpoint
            System.out.println("Into quicksort 2");
            pivotpoint = quicksort(pivotpoint+1, high, array, pivotpoint);
        }
        return pivotpoint;
    }
    
    public static int partition(int low, int high, int[] array, int pivotpoint) {
        int j = low, pivotitem = array[low];
        for (int i = low + 1; i <= high; i++) {
            System.out.print("i: " + i + " low: " + low + " high: " + high + " pivotitem: " + pivotitem + " ");
            if (array[i] < pivotitem) {
                j++;
                System.out.println("In if: " + "array[i]: " + array[i] + " array[j]: " + array [j]);                
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                System.out.println("In if: " + "array[i]: " + array[i] + " array[j]: " + array [j]);
                //j++;
            }
        }
        System.out.println();
        pivotpoint = j;
        int temp = array[low];
        array[low] = array[pivotpoint];
        array[pivotpoint] = temp;
        return pivotpoint;
    }
    
    public static void mergesort(int n, int s[]) {
        if (n>1) {
            int h = n/2, m = n-h;
            //Math.floor(h);
            int[] u = new int[h];
            int[] v = new int[m];
            System.out.println("h: " + h);
            System.out.println("m: " + m);
            
            //System.arraycopy(s, 0, u, 0, h);
            for (int i=0;i<h;i++) {
                u[i] = s[i];
            }
            for (int i=0;i<h;i++) {
                System.out.print(i + ": " + u[i] + " ");
            }
            //System.arraycopy(s, 0, u, 0, h);
            
            //System.arraycopy(s, 0, v, 0, h+1);
            System.out.println("\nNext v[]: ");
           
            //System.arraycopy(s, h, v, 0, m);
            
            for (int i=0;i<m;i++) {
                v[i] = s[h + i];
                //System.out.print(" h: " + (h + i) + " index. Value: " + s[h+i]);
            }
            for (int i=0;i<m;i++) {
                System.out.print(i + ": " + v[i] + " ");
            }
            System.out.println("\n");
            
            System.out.println("Going in (h,u)");
            mergesort(h, u);
            System.out.println("Going in (m,v)");
            mergesort(m, v);
            System.out.println("Going in merge");
            merge(h-1, m-1, u, v, s);
        }
    }
    
    public static void merge(int h, int m, int u[], int v[], int s[]) {
        int i = 0, j = 0, k = 0; //indexes
        while(i <= h && j <= m) {
            System.out.println("Index i: " + i);
            System.out.println("Index j: " + j);
            System.out.println("Index k: " + k);
            if (u[i] < v[j]) {
                System.out.println("Was in If");
                System.out.println("u[" + i + "] = " + u[i] + " v[" + j + "] = " + v[j]);
                System.out.println("h: " + h + " m: " + m);
                s[k] = u[i];
                i++;
            }
            else {
                System.out.println("Was in else");
                System.out.println("u[" + i + "] = " + u[i] + " v[" + j + "] = " + v[j]);
                System.out.println("h: " + h + " m: " + m);
                s[k] = v[j];
                j++;
            }
            k++;
        }
        
        if (i>h) {
            /*
            while( m < j) {
                s[k+j] = v[j]; //s[k] might not reach s[h+m]
                j++;
            } */
            System.out.println("i>h");
            //System.arraycopy(v, j, s, k, m);
            
            for(int j2 = 0; j2<v.length-j;j2++) {
                 s[k+j2] = v[j+j2]; //s[k] might not reach s[h+m]
            }
            for(int j2 = 0; j2<v.length-j;j2++) {
                 System.out.println("s[" + k + j2 + "]: " + s[k+j2]);
            }
        }/*
        else if(i == h && i == 1) {
            System.out.println("Else if");
            for(int i2 = 0; i2<h;i2++) {
                 s[k+i2] = u[i + i2]; //s[k] might not reach s[h+m]
                 System.out.println("s[" + (k + i2) + "]: " + s[k+i2] + " u[" + (i + i2) + "]: " + u[i+i2]);
            }
        }*/
        else {
            /*
            while( h < i) {
                s[k+i] = u[i]; //s[k] might not reach s[h+m]
                i++;
            }*/
            System.out.println("i: " + i + " h: " + h);
            
            //while
            
            //System.arraycopy(u, i, s, k, h);
            
            for(int i2 = 0; i2<u.length-i;i2++) {
                 s[k+i2] = u[i + i2]; //s[k] might not reach s[h+m]
                 System.out.println("s[" + (k + i2) + "]: " + s[k+i2] + " u[" + (i + i2) + "]: " + u[i+i2]);
            }
            for(int i2 = 0; i2<u.length-i;i2++) {
                 System.out.println("s[" + k + i2 + "]: " + s[k+i2]);
            }
        }
        System.out.println("Out of merge");
    }
    
     public static int highestSum(int size, int[] array) { //Algorithm in which half the array and get highest

        //Sort the array first.
        //Insert sorting algorithm here
        int newArray[] = new int[size], newArray2[] = new int[size], lowest = array[0], index = 0;
        
        System.out.println("First for loop: Copy new array.");
        for(int i=0; i< size; i++) { //Copy new array to maniuplate it.
            newArray2[i] = array[i];
            System.out.print(newArray2[i]+" ");
        }
        
        for(int i=0; i < size; i++) { //Sort array elements from least to greatest.
            for (int j=0; j < size; j++) {
                if (lowest > newArray2[j]) {
                    System.out.print("lowest > newArray2: " + newArray[2] + " ");
                    lowest = newArray2[j];
                    //newArray2[j] = 100;
                    index = j;
                }
                //else if (newArray2[j] != 100){
                    //lowest = newArray2[j];
                //}
            }
            //Once found new lowest, swap them.
            newArray[i] = lowest;
            System.out.print("Remove: " + newArray2[index] + " ");
            newArray2[index] = 100;
            System.out.print("Index: " + index + " ");
     
            for (int h = 0; h < size; h++) {
                if (!(size <= (i+1+h)) && newArray2[i+1+h] != 100) {
                    lowest = newArray2[i + 1];   
                    break;
                }                
            }
            //if (newArray2[i] != 100){
                    //lowest = newArray2[i];
            //}
            //lowest = newArray2[i];
            //int swap = array[i];
            //array[i] = lowest;
            //array[index] = swap;
        }
        
        System.out.println("\nSecond Loop: newArray2's data ");
        for(int i=0; i< size; i++) { //Copy new array to maniuplate it.
            //newArray[i] = array[i];
            System.out.print(newArray2[i]+" ");
        }
        
        System.out.println("\nThird Loop: newArray's data ");
        for(int i=0; i< size; i++) { //Copy new array to maniuplate it.
            //newArray[i] = array[i];
            System.out.print(newArray[i]+" ");
        }
        System.out.println();
        
        int halfArray = size/2, firstHalfTotal = 0, secondHalfTotal = 0; //If array is sorted, it works.
        for(int i=0; i < halfArray; i++) { //Add each element in each subarray.
            firstHalfTotal += newArray[i]; //First array has lower numbers.
            secondHalfTotal += newArray[halfArray + i]; //Second half of the array should have largest nums
        }
        return secondHalfTotal - firstHalfTotal; //With binary search and this for loop, O(nlgn).
    }
    
    //Peasent Multiplication Iterative: lg(n) level algorithm
    public static int pMI(int n, int m) { //Only with positive values.
        int sum = 0; //Add only when n is odd.
        while (n != 0) { //While n is not done.
            if ( n % 2 == 0) { //When n is even...
                n = n/2; //Divide n by 2.
                m = m*2; //Mutiply m by 2.
            }
            else { //When n is odd...
                sum += m; //Add n to the sum.
                n = (n-1)/2; //Subtract one from n bc it is odd to make it even. Divide by 2.
                m = m*2; //Multiply m by 2.
            }
        }
        return sum; //After n reaches 0, return the sum.
    }
    
    //Peasent Multiplication Recursive; lg(n)
    public static int pMR(int n, int m, int sum) {
        if (n % 2 == 0) {
            n = n/2;
            m = m*2;
        }
        else {
            sum += m;
            n = (n-1)/2;
            m = m*2;
        }
        if (n != 0) { //If n is not 0, call the method again.
            return pMR(n, m, sum);
        }
        return sum;
    }
    
    //Sequential-Linear Search; O(n); List does NOT have to be sorted.
    public static int sLS(int[] s, int n, int x) {
        for (int i=0;i<n;i++) { //Iterate through the array and check each element until found unless...
            if (s[i] == x) //If element value is equal to found data, return it.
                return i;
        }
        return -1; //If unfound, return -1.
    }
    
    //Binary Search Iterative; O(lg(2)); Must be a sorted list
    public static int bSI(int s[], int low, int high, int x){
        while(low <= high) { //low has to be lower than high. Cannot be equal or greater. End loop if so.
            int mid = (high+low)/2; //New index
            if(s[mid] == x) { //Check if x is present at mid
                return mid;
            }
            if(s[mid] < x) { //If x greater, ignore left half
                low = mid + 1; //Shrink low from left to right (low goes to mid and + 1 bc it dodges the mid value since iti si already checked)
            }
            else { //If x is smaller, ignore right half
                high = mid -1; //Shrink high from right to left (high moves to mid - 1.
            }
        }
        return -1;
    }
    
    //Binary Search Recursive; O(lg(2)); Must be a sorted list
    public static int bSR(int s[], int low, int high, int x) {
        if(high >= low) { //low has to be lower than high. Cannot be equal or greater. Return -1 if false. Ends recursion.
            int mid = (low+high)/2; //New index
            if(s[mid] == x) { //Check if x is present at mid
                return mid;
            }
            if(s[mid] > x) { //If x greater, ignore left half
                return bSR(s, low, mid, x);
            }
            else {
                return bSR(s, mid+1, high, x);
            }
        }
        return -1;
    }
    
    //Fibonacci Sequence Recursive; O(2^(mid)) NOTE: The bigger the number, the more exponentially slow it is.
    //Iterative is much faster.
    public static int fSR(int n) {
        if (n <= 1) { //If it is 0 or 1, return n bc those are base cases.
            return n;
        }
        else { //If n > 1...
            return fSR(n-1) + fSR(n-2); //Add the one before and the one before that.
        }
    }
    
    //Fibonacci Sequence Iterative; O(?) -> O(n)?
    public static int fSI(int n) {
        int f[] = new int[n+1]; //Had to increase the array size by 1.
        f[0] = 0; //Always make first index 0. Return value if it is 0 or less.
        if (n > 0) { //If input is greater than 0...
            f[1] = 1; //Make index 1 = 1 bc base case.
            for(int i = 2; i <= n; i++) { //Starting at 2, because that is when iteration happens. Fill the array from f[2] to f[n].
                f[i] = f[i-1] + f[i-2]; //Value is the value before plus the value before that.
            }
        }
        return f[n]; //Return n's number with the last index used.
    }
}
