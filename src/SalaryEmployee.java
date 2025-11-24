/**
 * SalaryEmployee - Fixed annual salary employee
 * Demonstrates: Inheritance, Method Overriding
 */
public class SalaryEmployee extends Employee {
    private double annualSalary;

    // Constructor using super()
    public SalaryEmployee(String firstName, String lastName, String employeeId, double annualSalary) {
        super(firstName, lastName, employeeId);
        this.annualSalary = annualSalary;
    }

    // Getter and Setter
    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        if (annualSalary >= 0) {
            this.annualSalary = annualSalary;
        }
    }

    // Method overriding - calculates monthly pay
    @Override
    public double calculatePay() {
        return annualSalary / 12;
    }

    @Override
    public String toString() {
        return String.format("%s\nType: Salary Employee\nAnnual Salary: $%.2f\nMonthly Pay: $%.2f",
                super.toString(), annualSalary, calculatePay());
    }
}
