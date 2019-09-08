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
public class DoublyLinkedList {
    
    private Node head;
    
    public DoublyLinkedList(int item) { //Will create one head and a Node.
        head = new Node(); //Creates head Node AKA first node in list. [ ]
        head.value = item; //Creates value; this data has nothing to do with the addresses.
        head.next = null; //Link head with null bc it is the first node that stores data for the ext node in list.
        head.prev = null;
    }
    
    public boolean insertItem(int item) { //Adds a node in between head node and first node in front of it.
        Node n = new Node();
        n.value = item;
        n.prev = null;
        head.prev = n;
        n.next = head;
        head = n;
        return true;
    }
    
    public void printList() { //Prints out the whole list from last to first (no head, to the end with the head)
        Node z = head; //Create a new node and make it equal to the first node in list.
        while(z!=null) { //while the list does not have the null address, do the following.
            System.out.println(z.value); //Print out the value of the current node's data.
            z = z.next; //Assign z to be the next node using the next.
            //System.out.print(z.next); Creates error bc z.next is a Node and cannot be printed
        }
    }
    
    public boolean deleteItem(int item) { //Deletes a node by cutting the nexts and letting garbage collector delete it.
        if (head.value == item) { //If item is found in head, just make the head jump to the next node.
            head = head.next; //head = to the next Node with all values.
            System.out.println("Item found at beginning of list. Successfully deleted.");
            return true;
        }
        else { //Cut both wires and connect the Nodes that sandwich the Node.
            Node x = head; //Create new node. ake it equal to the first node in list.
            Node y = head.next; //Create another node. Assign it to the NEXT node after head.
            while(true) { //Keep going until...
                if (y == null || y.value == item) { //y is null (not a node) or y.value is found as item.
                    break;
                }
                else { //Keep searching until it is found or it has reached the end of the list.
                    x = y; //Shift x to y.
                    y = y.next; //Shift y to next node.
                }
            }
            if (y != null) { //If Item is found...
                //System.out.println(x.value + " = x.value");
                //It seems like the Node names do not define the nodes. They are nameless. They just hold two values.
                //Printing n.value from the insertItem() method does not work.
                //So it seems like these nodes can work without worrying about the variable names. The nodes get modified
                //without saving data for outside the method. All nodes are in the scope of the whole program.
                x.next = y.next; //Link x to y's next node. This separates the node in between which deletes it.
                System.out.println("Item was found using sequential search. Successfully deleted.");
                return true;
            }
            else { //If y == null, that means item is not in list.
                System.out.println(item + " is not in list. No deletions made.");
                return false;
            }
        }
    }
    
    class Node {
        private Node prev;
        private int value; //Stored value
        private Node next; //next to the next node.
    }
}
