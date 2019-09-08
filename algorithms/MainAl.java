/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodproject12.algorithms;
import java.util.Scanner;

/**
 *
 * @author desty
 */
public class MainAl {
    public static void main(String[] args) {
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
                return bSR(s, low, mid-1, x);
            }
            else {
                return bSR(s, mid+1, high, x);
            }
        }
        return -1;
    }
    
    //Fibonacci Sequence Recursive; O(2^(n/2)) NOTE: The bigger the number, the more exponentially slow it is.
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
