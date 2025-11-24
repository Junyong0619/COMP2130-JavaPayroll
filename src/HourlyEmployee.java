/**
 * HourlyEmployee - Paid by the hour with overtime
 * Demonstrates: Inheritance, Method Overriding, Encapsulation
 */
public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    private static final double OVERTIME_MULTIPLIER = 1.5;
    private static final double REGULAR_HOURS = 40.0;

    // Constructor using super()
    public HourlyEmployee(String firstName, String lastName, String employeeId, 
                          double hourlyRate, double hoursWorked) {
        super(firstName, lastName, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Constructor overloading - default hours
    public HourlyEmployee(String firstName, String lastName, String employeeId, double hourlyRate) {
        this(firstName, lastName, employeeId, hourlyRate, 0);
    }

    // Getters and Setters
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate >= 0) {
            this.hourlyRate = hourlyRate;
        }
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked >= 0) {
            this.hoursWorked = hoursWorked;
        }
    }

    // Method overriding - calculates pay with overtime
    @Override
    public double calculatePay() {
        if (hoursWorked <= REGULAR_HOURS) {
            return hourlyRate * hoursWorked;
        } else {
            double regularPay = hourlyRate * REGULAR_HOURS;
            double overtimeHours = hoursWorked - REGULAR_HOURS;
            double overtimePay = overtimeHours * hourlyRate * OVERTIME_MULTIPLIER;
            return regularPay + overtimePay;
        }
    }

    @Override
    public String toString() {
        return String.format("%s\nType: Hourly Employee\nHourly Rate: $%.2f\nHours Worked: %.1f\nWeekly Pay: $%.2f",
                super.toString(), hourlyRate, hoursWorked, calculatePay());
    }
}
