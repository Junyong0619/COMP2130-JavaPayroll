/**
 * Abstract Employee class - base class for all employee types
 * Demonstrates: Abstraction, Encapsulation
 */
public abstract class Employee {
    private String firstName;
    private String lastName;
    private String employeeId;

    // Constructor
    public Employee(String firstName, String lastName, String employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Abstract method - must be implemented by subclasses
    public abstract double calculatePay();

    // Common method for all employees
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return String.format("Employee ID: %s\nName: %s", employeeId, getFullName());
    }
}
