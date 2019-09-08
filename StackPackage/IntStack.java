/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackPackage;

/**
 *
 * @author desty
 */
public class IntStack {
    
    private int[] stack; //The array stack
    private int top; //The variable on top of the stack. This is to keep track of 
    private int size; //Int variable of the number of variables in the array stack
    
    public IntStack(){ //Default constructor
        top = -1; //-1 means none.
        size = 50; //size is set to a stack array size of 50 integers
        stack = new int[50]; //Create an array 50 int memory of storage.
    }
    
    public IntStack(int size){ //Constructor with one parameter-the size of the array stack.
        top = -1; //-1 means none.
        this.size = size; //Takes the parameter and makes it equal to size.
        stack = new int[this.size]; //Take the parameter and allocate space based on parameter.
    }
    
    public boolean push(int item){ //Place the "book" (int value) on top of the stack.
        
        if (isFull() == false){ //Checks if stack is full or not. If not full, push next variable.
            top++; //Adds one to the top variable which keeps track of how many values are in a stack.
            stack[top] = item; //ex: stack[0] = 16 means it adds the value to the next allocated memory.
            return true; //Sends boolean arguement to "true" so user knows if it is successful or not.
        }
        else
            return false; //Sends boolean arguement to "false" indicating that it failed to push value onto stack.
    }
    
    public int pop(){ //Takes the first "book" off the stack array.
        
        if (!isEmpty()){ // If isEmpty() is false, do the following. If true, exit with -1.
            int popValue = stack[top]; //Saves an allocated int memory and assigns it to whatever value is on top of stack array.
            stack[top] = -1; //cannot make top of stack "null" so -1 will have to do.
            top--; //Decrement the top variable by 1 because the top value was just removed (replaced with -1 actually).
            return popValue; //Return the popped value.
        }
        else
            return -1;
    }
    
    public int peek() { //Returns the top value of the stack array.
        if (!isEmpty()){ //If isEmpty() is false, do the following. If not return -1.
        return stack[top]; //Returns value on top of the stack.
        }
        else
            return -1;
    }
    
    public boolean isFull(){ //Checks if stack is full.
        return (top == stack.length - 1); //If they are equal, boolean is "true". isFull() == True
    }
    
    public boolean isEmpty(){ //Checks if stack is empty.
        return top == -1; //If top == -1 (-1 is the value indicating there is nothing in the stack) is true, return true. If not, return false.
    }
}
