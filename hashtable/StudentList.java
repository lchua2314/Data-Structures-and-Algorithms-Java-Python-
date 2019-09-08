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
public class StudentList {
    
    private Node h;
    
    public StudentList() {
        h = new Node();
        h.next = null;
        h.data = null;
    }
    
    public boolean insertStd(Student std) {
        Node n = new Node();
        n.data = std;
        n.next = h.next;
        h.next = n;
        return true;
    }
    
    public boolean haveRollno(String rollno) {
        Node a = h.next;
        boolean have = false;
        while(a != null) {
            if(rollno.equals(a.data.getRollno())) {
                have = true;
            }
            a = a.next;
        }
        return have;
    }
    
    public Student fetchData(String rollno) {
        Student data = null;
        Node p = h.next;
        while(p != null) {
            if(p.data.getRollno().equals(rollno)) {
                data = p.data;
                break;
            }
            p = p.next;
        }
        return data;
    }
    
    public void deleteStudent(String rollno) {
        Node p = h;
        Node q = h.next;
        while(q != null && !(q.data.getRollno().equals(rollno))) {
            p = q;
            q = q.next;
        }
        if (q != null) {
            p.next = q.next;
        }
        else {
            //no data found.
        }
    }
    
    public void showAll() {
        Node x = h.next;
        while(x != null) {
            System.out.println(x.data);
            x = x.next;
        }
    }
    
    class Node {
        private Student data;
        private Node next;
    }
}
