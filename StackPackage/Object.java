/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackPackage;

/**
 *
 * @author desty
 */
public class Object {
    private String name;
    private String rollno;
    public Object(String name, String rollno) {
        this.name = name;
        this.rollno = rollno;
    }
    
    public String toString() {
        return "Name: " + this.name + " Rollno: " + this.rollno;
    }
    
    public void copyObject(Object obj) {
        this.name = obj.name;
        this.rollno = obj.rollno;
    }
}
