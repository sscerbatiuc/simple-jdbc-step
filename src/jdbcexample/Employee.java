package jdbcexample;

import java.time.LocalDate;

/**
 *
 * @author sscerbatiuc
 */
public class Employee {

    private int id;
    private String name;
    private LocalDate date;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Id:" + this.id + " Name:" + this.name;
    }
}
