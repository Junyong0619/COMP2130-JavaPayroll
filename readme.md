# Java Payroll System

A console-based payroll calculation system demonstrating Object-Oriented Programming (OOP) principles in Java.

## OOP Concepts Demonstrated

- **Abstraction**: `Employee` abstract class with abstract `calculatePay()` method
- **Encapsulation**: Private fields with public getters/setters
- **Inheritance**: `SalaryEmployee`, `HourlyEmployee`, `CommissionEmployee` extend `Employee`
- **Polymorphism**: Different employee types processed through common `Employee` reference
- **Method Overriding**: Each subclass implements its own `calculatePay()` and `toString()`
- **Constructor Overloading**: Multiple constructors in `HourlyEmployee` and `CommissionEmployee`

## Employee Types

| Type | Description | Pay Calculation |
|------|-------------|-----------------|
| **SalaryEmployee** | Fixed annual salary | Annual Salary / 12 |
| **HourlyEmployee** | Paid by hour with overtime | Regular + 1.5x overtime (>40 hrs) |
| **CommissionEmployee** | Base + sales commission | Base Salary + (Sales × Commission Rate) |

## How to Run

```bash
# Compile all files
javac *.java

# Run the main program
java PayrollSystem
```

## Sample Output

```
=== Java Payroll System Demo ===

Adding employees to the system...

========================================
         EMPLOYEE PAYROLL REPORT        
========================================

Employee ID: EMP001
Name: John Smith
Type: Salary Employee
Annual Salary: $75000.00
Monthly Pay: $6250.00
----------------------------------------
...

========================================
TOTAL PAYROLL: $24437.50
========================================
```

## Project Structure

```
JavaPayrollSystem/
├── Employee.java           # Abstract base class
├── SalaryEmployee.java     # Salary employee subclass
├── HourlyEmployee.java     # Hourly employee subclass
├── CommissionEmployee.java # Commission employee subclass
├── PayrollSystem.java      # Main class with demo
└── README.md
```

## Author

Junyong Choi - George Brown College  
Computer Programming & Analysis - Fall 2025
