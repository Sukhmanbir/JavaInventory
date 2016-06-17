package hr;

public class CommissionSalesEmployee extends Employee {

    private double commissionRate, grossSales;

    public CommissionSalesEmployee(String firstName, String lastName, int age,
            String position, int year, int month, int day,
            double commissionRate, double grossSales) {
        super(firstName, lastName, age, position, year, month, day);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }
    

    //Accessor methods

    public double getCommissionRate() {
        return this.commissionRate;
    }

    public double getGrossSales() {
        return this.grossSales;
    }

    //mutator methods

    public void setCommissionRate(double commissionRate) {
        if (commissionRate > 0.0 && commissionRate < 1.0) {
            this.commissionRate = commissionRate;
        }
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double calculateCommission() {
        return grossSales * commissionRate;
    }

//    @Override
//    public double earnings() {
//        return calculateCommission();
//    }

    @Override
    public double getPaymentAmount() {
        return calculateCommission();
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\nCommission Rate: " + getCommissionRate()
                + "\nGross Sales:\t" + getGrossSales();

    }
}
