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
public class MainHash {
    public static void main(String[] args) {
        HashTable hashtable = new HashTable();
        
        Student std1 = new Student("unair", "15-123", 3.4);
        Student std2 = new Student("ali", "15-453", 3.1);
        Student std3 = new Student("uzair", "15-233", 3.2);
        Student std4 = new Student("awais", "15-321", 3.9);
        
        int std1key = hashtable.toHashCode(std1.getRollno());
        int std2key = hashtable.toHashCode(std2.getRollno());
        int std3key = hashtable.toHashCode(std3.getRollno());
        int std4key = hashtable.toHashCode(std4.getRollno());
        
        hashtable.insert(std1key, std1);
        hashtable.insert(std2key, std2);
        hashtable.insert(std3key, std3);
        hashtable.insert(std4key, std4);
        
        hashtable.deleteStd(std3.getRollno());
        
        hashtable.showData();
        
        /*
        Student new_std2 = hashtable.fetchStdInfo(std2.getRollno());
        if (new_std2.getName().equals(std2.getName())) {
            System.out.println("Equal");
        } */
    }
}
