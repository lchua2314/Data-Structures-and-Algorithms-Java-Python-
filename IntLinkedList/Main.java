/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntLinkedList;

/**
 *
 * @author desty
 */
public class Main {
    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList(2);
        list.insertItem(5);
        list.insertItem(8);
        list.insertItem(4);
        list.printList();
        
        //list.deleteItem(5);
        //list.printList();
        
        //list.deleteItem(19);
        //list.printList();
        
        list.sortList();
        list.printList();
    }
}
