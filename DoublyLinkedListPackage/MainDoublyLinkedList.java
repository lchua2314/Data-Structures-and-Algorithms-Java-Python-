/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublyLinkedListPackage;

/**
 *
 * @author desty
 */
public class MainDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(2);
        list.insertItem(3);
        list.insertItem(6);
        list.printList();
        System.out.println();
        list.deleteItem(3);
        list.printList();
    }
}
