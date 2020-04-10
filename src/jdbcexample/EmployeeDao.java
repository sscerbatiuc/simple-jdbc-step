package jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sscerbatiuc
 */
public class EmployeeDao {

    Connection initConnection() {
        String url = "jdbc:postgresql://127.0.0.1:5432/emp_manager";
        String user = "postgres";
        String password = "aozhnl";
        try {
            System.out.println("Connecting...");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("ERROR! Can't connect to db. " + ex.getMessage());
            return null;
        }
    }

    void insert(Employee emp) {
        String sql = "INSERT INTO manager.employee(name) VALUES('" + emp.getName() + "')";
        Connection conn = initConnection();
        Statement st = null;
        try {
            if (conn != null) {
                st = conn.createStatement();
                int rows = st.executeUpdate(sql);
                System.out.println("Inserted " + rows + " rows");
            } else {
                System.out.println("Insert failed");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR! Insert failed. " + ex.getMessage());
        } finally {
            try {
                // if != null
                conn.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    void insert(ArrayList<Employee> emps) {
        String sql = "INSERT INTO manager.employee(name) VALUES(?)";
        Connection conn = initConnection();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            for (Employee emp : emps) {
                statement.setString(1, emp.getName());
                int rows = statement.executeUpdate();
                System.out.println("Inserted " + rows + " rows.");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR! Multiple insert failed. " + ex.getMessage());
        }

    }
}
