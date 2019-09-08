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
public class IntLinkedList {
    
    private Node head;
    
    public IntLinkedList(int item) { //Will create one head and a Node.
        head = new Node(); //Creates head Node AKA first node in list. [ ]
        head.value = item; //Creates value; this data has nothing to do with the addresses.
        head.link = null; //Link head with null bc it is the first node that stores data for the ext node in list.
    }
    
    public boolean insertItem(int item) { //Adds a node in between head node and first node in front of it.
        Node n = new Node(); //Create new node
        
        //Add node to beginning of list.
        //n.value = item; //Assign the new node's value to the input data.
        //n.link = head; //This line has to be above the below line. //Link goes to head ( bc head is the next node of the next address)/
        //head = n; //This line should be below the above line. //Make head link to the new node created.
        //return true; //Looks like this: [head]-[new node|address to next node ]-[old node data | possible address to next node/null ]
        
        //Add node to the end of the list.
        Node new_node; //This node is for being at the end and then linking it to the new node.
        new_node = head; //Make it head node
        while(new_node.link != null) { //Cycle through until the end of the list.
            new_node = new_node.link;
        }
        n.value = item; //Make n Node value = item
        n.link = null; //Make next node null because we want it at the end of the list.
        new_node.link = n; //Link the last node with the new node at the end.
        return true;
    }
    
    public void printList() { //Prints out the whole list from last to first (no head, to the end with the head)
        Node z = head; //Create a new node and make it equal to the first node in list.
        while(z!=null) { //while the list does not have the null address, do the following.
            System.out.println(z.value); //Print out the value of the current node's data.
            z = z.link; //Assign z to be the next node using the link.
            //System.out.print(z.link); Creates error bc z.link is a Node and cannot be printed
        }
    }
    
    public boolean deleteItem(int item) { //Deletes a node by cutting the links and letting garbage collector delete it.
        if (head.value == item) { //If item is found in head, just make the head jump to the next node.
            head = head.link; //head = to the next Node with all values.
            System.out.println("Item found at beginning of list. Successfully deleted.");
            return true;
        }
        else { //Cut both wires and connect the Nodes that sandwich the Node.
            Node x = head; //Create new node. ake it equal to the first node in list.
            Node y = head.link; //Create another node. Assign it to the NEXT node after head.
            while(true) { //Keep going until...
                if (y == null || y.value == item) { //y is null (not a node) or y.value is found as item.
                    break;
                }
                else { //Keep searching until it is found or it has reached the end of the list.
                    x = y; //Shift x to y.
                    y = y.link; //Shift y to next node.
                }
            }
            if (y != null) { //If Item is found...
                //System.out.println(x.value + " = x.value");
                //It seems like the Node names do not define the nodes. They are nameless. They just hold two values.
                //Printing n.value from the insertItem() method does not work.
                //So it seems like these nodes can work without worrying about the variable names. The nodes get modified
                //without saving data for outside the method. All nodes are in the scope of the whole program.
                x.link = y.link; //Link x to y's next node. This separates the node in between which deletes it.
                System.out.println("Item was found using sequential search. Successfully deleted.");
                return true;
            }
            else { //If y == null, that means item is not in list.
                System.out.println(item + " is not in list. No deletions made.");
                return false;
            }
        }
    }
    
    public void sortList() { //Sorting list from head-greatest -> least.
        int c = 0;
        Node a = head.link; //Head's next node.
        while(a.link != null) { //Look through the entire list from left to right until you reach the end.
            Node b = head.link; //Node a = Node a = head's next node.
            while(b.link != null) { //Node b reaches the end of the list.
                if (b.value < b.link.value) { //If next node is lower value... Swap the values between both nodes.
                    c = b.value; //c saves b's node's current value
                    b.value = b.link.value; //b's next value is now b.value
                    b.link.value = c; //b's next node's value is now OLD b.value.
                }
                b = b.link; //Make b Node to next node.
            }
            a = a.link; //Make a Node to next node.
        }
    }
    
    class Node {
        private int value; //Stored value
        private Node link; //link to the next node.
        
    }
}
