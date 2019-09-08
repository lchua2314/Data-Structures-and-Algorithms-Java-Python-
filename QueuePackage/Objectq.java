/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueuePackage;

/**
 *
 * @author desty
 */
public class Objectq {
    private Object [] q; //Array
    private int size; //Size of array
    private int total; //current total elements
    private int front; //value of element in the front of array
    private int rear; //value of element in the back of array
    
    public Objectq() { //Default constructor
        size = 100; //Allocate 100 * 2 bytes of RAM
        total = 0; //All 0
        front = 0;
        rear = 0;
        q = new Object[size]; //Allocate the q space
    }
    
    public Objectq(int size) { //Constructor that allows a number of space by user.
        this.size = size;
        total = 0;
        front = 0;
        rear = 0;
        q = new Object[size];
    }
    
    public boolean enqueue(Object item) { //Add value at the rear of array
        if(isFull()) { //If it is full, do not add value at rear
            return false;
        }
        else {
            total++; 
            q[rear] = item;
            rear = (rear + 1) % size; //rear++; //Basically increment by 1 unless size >= 100.
            return true;
        }
    }
    
    public Object dequeue() { //Takes away value at the front of the queue.
        Object item = q[front];
        total--;
        front = (front + 1) % size; //front++;
        return item;
    }
    
    public boolean isFull() { //Checks if queue array is full.
        if (size == total)
            return true;
        else
            return false;
    }
    
    public void showAll() { //Prints every element in the array.
        int f = front;
        if (total != 0) { //Checks if array is empty or not.
            for (int i = 0; i < total; i++) {
                System.out.println(" " + q[f].toString());
                System.out.println("size: " + size);
                System.out.println("f: " + f);
                f = (f + 1) % size;
            }
        }
    }
}
