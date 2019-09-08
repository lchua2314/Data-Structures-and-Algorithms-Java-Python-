/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackPackage;

/**
 * Creates and tests out an integer stack and an object stack.
 * @author desty
 */
public class Main {
    public static void main(String[] args){
        
        IntStack testDefConstruct = new IntStack(); //Allocate memory based on IntStack default constructor.
            
        if(!testDefConstruct.isFull()) { //If stack is NOT full, do the following.
            testDefConstruct.push(2); //array[0] = 2
            testDefConstruct.push(4); //array[1] = 4
            testDefConstruct.push(6); //array[2] = 6
            testDefConstruct.push(9); //array[3] = 9
        }
        
        System.out.println(testDefConstruct.peek()); //Value on top of stack: 9
        System.out.println(testDefConstruct.pop()); //Remove top and show value: 9
        System.out.println(testDefConstruct.peek()); //Value on top of stack: 6
        System.out.println(testDefConstruct.pop()); //Remove top and show value: 6
        System.out.println(testDefConstruct.peek()); //Value on top of stack: 4
        //Note: Did not test other constructor with int parameter.
        
        Object obj1 = new Object("Mike", "1234");
        Object obj2 = new Object("Jensen", "4321");
        
        ObjectStack testObj = new ObjectStack(); //Allocate memory based on IntStack default constructor.
            
        testObj.push(obj1);
        testObj.push(obj2);
        
        System.out.println(testObj.pop().toString());
        System.out.println(testObj.pop().toString());
    }
}
