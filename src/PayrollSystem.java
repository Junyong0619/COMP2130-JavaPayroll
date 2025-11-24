import java.util.ArrayList;

/**
 * PayrollSystem - Main class to demonstrate the payroll system
 * Demonstrates: Polymorphism, ArrayList usage, formatted output
 */
public class PayrollSystem {
    private ArrayList<Employee> employees;

    public PayrollSystem() {
        employees = new ArrayList<>();
    }

    // Add employee to the system
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Added: " + employee.getFullName());
    }

    // Remove employee by ID
    public boolean removeEmployee(String employeeId) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId().equals(employeeId)) {
                employees.remove(emp);
                return true;
            }
        }
        return false;
    }

    // Calculate total payroll
    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.calculatePay();
        }
        return total;
    }

    // Display all employees
    public void displayAllEmployees() {
        System.out.println("\n========================================");
        System.out.println("         EMPLOYEE PAYROLL REPORT        ");
        System.out.println("========================================\n");

        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
            return;
        }

        for (Employee emp : employees) {
            System.out.println(emp.toString());
            System.out.println("----------------------------------------");
        }

        System.out.println("\n========================================");
        System.out.printf("TOTAL PAYROLL: $%.2f%n", calculateTotalPayroll());
        System.out.println("========================================\n");
    }

    // Main method - demonstrates the system
    public static void main(String[] args) {
        PayrollSystem payroll = new PayrollSystem();

        System.out.println("=== Java Payroll System Demo ===\n");
        System.out.println("Adding employees to the system...\n");

        // Create different types of employees (Polymorphism)
        Employee salary1 = new SalaryEmployee("John", "Smith", "EMP001", 75000);
        Employee salary2 = new SalaryEmployee("Sarah", "Johnson", "EMP002", 85000);
        
        Employee hourly1 = new HourlyEmployee("Mike", "Williams", "EMP003", 25.00, 45);
        Employee hourly2 = new HourlyEmployee("Emily", "Brown", "EMP004", 20.00, 38);
        
        Employee commission1 = new CommissionEmployee("David", "Lee", "EMP005", 2000, 50000, 0.08);
        Employee commission2 = new CommissionEmployee("Lisa", "Chen", "EMP006", 1500, 75000, 0.10);

        // Add employees to the system
        payroll.addEmployee(salary1);
        payroll.addEmployee(salary2);
        payroll.addEmployee(hourly1);
        payroll.addEmployee(hourly2);
        payroll.addEmployee(commission1);
        payroll.addEmployee(commission2);

        // Display payroll report
        payroll.displayAllEmployees();

        // Demonstrate polymorphism - same method, different behavior
        System.out.println("=== Demonstrating Polymorphism ===\n");
        Employee[] empArray = {salary1, hourly1, commission1};
        
        for (Employee emp : empArray) {
            System.out.printf("%s (%s): $%.2f%n", 
                emp.getFullName(), 
                emp.getClass().getSimpleName(), 
                emp.calculatePay());
        }
    }
}
