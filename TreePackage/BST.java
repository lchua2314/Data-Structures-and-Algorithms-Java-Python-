/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreePackage;

/**
 * Objects
 * @author desty
 */
public class BST {
    
    private Node root; //Root is the very first node at the very top of the BST
    
    public BST(){
        root = null; //Root does not link to anything.
    }
    
    public boolean insert(Object item) {
        Node n = new Node();
        n.data = item; 
        n.lc = null;
        n.rc = null;
        if (root == null) { //Root is only null when there are no other nodes.
            root = n; //Connect the root to the newly created node.
            return true;
        }
        Node p = root; //Parent node
        Node c = root; //Child node
        while (c != null) { //While child is not the last child of the BST
            p = c; //Move to then next node
            if (item.getName().compareTo(c.data.getName()) < 0) { //String comparison.
                c = c.lc; //If less, go left.
            }
            else {
                c = c.rc; //If greater, go right.
            }
        }
        if (item.getName().compareTo(p.data.getName()) < 0) { //After reaching a child that is null...
            p.lc = n; //Assign new node to parent's left side
        }
        else {
            p.rc = n; //Assign new node to parent's right side
        }
        
        return true;
    }
    
    public Node findNode(String key) {
        Node c = root;
        while(c != null) {
            //System.out.println("In while loop");
            if(key.compareTo(c.data.getName()) == 0) {
                break;
            }
            if(key.compareTo(c.data.getName()) < 0) {
                c = c.lc;
            }
            else {
                c = c.rc;
            }
        }
        return c;
    }
    
    public Node findParent(String key) {
        Node p = root;
        Node c = root;
        do {
            if(key.compareTo(c.data.getName()) == 0) {
                break;
            }
            p = c;
            if (key.compareTo(c.data.getName()) < 0) {
                c = c.lc;
            }
            else {
                c = c.rc;
            }
        }
        while(c != null);
        System.out.println(">>" + p.data.getName());
        if (c != null) {
            return p;
        }
        else {
            return null;
        }
    }
    
    public Object getData(Node n) {
        return n.data;
    }
    
    public void showAll(Node n) {
        Node p = n;
        if (p != null) {
            System.out.println(" " + p.data);
            showAll(p.lc);
            showAll(p.rc);
        }
    }
    
    public class Node { //Two nodes and data
        private Node lc; //Left child
        private Object data; //Data stored in node
        private Node rc; //Right child
    }
}
