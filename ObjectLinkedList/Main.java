/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectLinkedList;

/**
 *
 * @author desty
 */
public class Main {
    public static void main(String[] args) {
        Object object1 = new Object("unair", "123");
        Object object2 = new Object("unair2", "1234");
        
        ObjectLinkedList list = new ObjectLinkedList(object1);
        list.insertItem(object2);
        
        list.printList();
    }
}
