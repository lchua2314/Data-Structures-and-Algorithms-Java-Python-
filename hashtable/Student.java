/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodproject12.hashtable;

/**
 *
 * @author desty
 */
public class Student {
    private String name;
    private String roll_no;
    private double cgpa;
    
    public Student(String name, String roll_no, double cgpa) {
        this.name = name;
        this.roll_no = roll_no;
        this.cgpa = cgpa;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setRollno(String roll_no) {
        this.roll_no = roll_no;
    }
    
    public String getRollno() {
        return roll_no;
    }
    
    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }
    
    public String toString() {
        return "Name: " + name + " Roll_no: " + roll_no + " CGPA: " + cgpa; 
    }
}
