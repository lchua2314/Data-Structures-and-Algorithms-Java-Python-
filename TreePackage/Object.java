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
public class Object {
    private String name;
    private int age;
    public Object(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String toString() {
        return "Name: " + this.name + " Age: " + this.age;
    }
    
    public void copyObject(Object obj) {
        this.name = obj.name;
        this.age = obj.age;
    }
}
