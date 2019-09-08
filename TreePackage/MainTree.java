/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreePackage;

/**
 *
 * @author desty
 */
public class MainTree {
    public static void main(String[] args) {
        Object o1 = new Object("Jason", 24);
        Object o2 = new Object("Joshua", 55);
        Object o3 = new Object("Mike", 23);
        Object o4 = new Object("Han", 34);
        Object o5 = new Object("Robert", 18);
        
        BST tree = new BST();
        tree.insert(o1);
        tree.insert(o2);
        tree.insert(o3);
        tree.insert(o4);
        tree.insert(o5);
        
        System.out.println("Jason: ");
        tree.showAll(tree.findNode("Jason"));
        System.out.println();
        System.out.println("Joshua: ");
        tree.showAll(tree.findNode("Joshua"));
        System.out.println();
        System.out.println("Mike: ");
        tree.showAll(tree.findNode("Mike"));
        System.out.println();
        System.out.println("Han: ");
        tree.showAll(tree.findNode("Han"));
        System.out.println();
        System.out.println("Robert: ");
        tree.showAll(tree.findNode("Robert"));
        System.out.println();
        
        Object o = tree.getData(tree.findParent("Mike"));
        
        System.out.println(o.toString());
    }
}
