/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcexample;

import java.util.ArrayList;

/**
 *
 * @author sscerbatiuc
 */
public class JDBCExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        
        Employee emp = new Employee(0, "John");
        dao.insert(emp);
        
        
        ArrayList<Employee> emps = new ArrayList<>();
        emps.add(new Employee(0, "Peter"));
        emps.add(new Employee(0, "Jack"));
        emps.add(new Employee(0, "Stas"));
        
        dao.insert(emps);
        
        System.out.println(dao.get(9));
        
        
    }
    
}
