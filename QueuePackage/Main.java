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
public class Main {
    public static void main(String[] args) {
        Intq q = new Intq();
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(6);
        
        q.showAll();//System.out.println(q.dequeue());
        //System.out.println(q.dequeue());
        //System.out.println(q.dequeue());
        
        Objectq objQ = new Objectq();
        objQ.enqueue(new Object("unair", "123"));
        objQ.enqueue(new Object("ali", "1234"));
        
        objQ.showAll();
    }
}
