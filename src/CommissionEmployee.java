/**
 * CommissionEmployee - Paid based on sales commission
 * Demonstrates: Inheritance, Method Overriding
 */
public class CommissionEmployee extends Employee {
    private double baseSalary;
    private double salesAmount;
    private double commissionRate; // e.g., 0.10 for 10%

    // Constructor using super()
    public CommissionEmployee(String firstName, String lastName, String employeeId,
                              double baseSalary, double salesAmount, double commissionRate) {
        super(firstName, lastName, employeeId);
        this.baseSalary = baseSalary;
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }

    // Constructor overloading - without base salary
    public CommissionEmployee(String firstName, String lastName, String employeeId,
                              double salesAmount, double commissionRate) {
        this(firstName, lastName, employeeId, 0, salesAmount, commissionRate);
    }

    // Getters and Setters
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        if (salesAmount >= 0) {
            this.salesAmount = salesAmount;
        }
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate >= 0 && commissionRate <= 1) {
            this.commissionRate = commissionRate;
        }
    }

    // Method overriding - calculates base + commission
    @Override
    public double calculatePay() {
        return baseSalary + (salesAmount * commissionRate);
    }

    @Override
    public String toString() {
        return String.format("%s\nType: Commission Employee\nBase Salary: $%.2f\nSales: $%.2f\nCommission Rate: %.0f%%\nTotal Pay: $%.2f",
                super.toString(), baseSalary, salesAmount, commissionRate * 100, calculatePay());
    }
}
