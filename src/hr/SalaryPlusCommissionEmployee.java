package hr;

public class SalaryPlusCommissionEmployee extends CommissionSalesEmployee {

    private double baseSalary;

    public SalaryPlusCommissionEmployee(String firstName, String lastName, int age,
            String position, int year, int month, int day,
            double commissionRate, double grossSales, double baseSalary) {
        super(firstName, lastName, age, position, year, month, day, commissionRate, grossSales);
        this.baseSalary = baseSalary;
    }

    //Accessor methods

    public double getBaseSalary() {
        return this.baseSalary;
    }

    //mutator methods

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

//    @Override
//    public double earnings() {
//        return baseSalary + super.calculateCommission();
//    }
    
    @Override
    public double getPaymentAmount(){
        return baseSalary + super.calculateCommission();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nBase Salary:\t" + getBaseSalary();

    }
}
