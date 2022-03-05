package Static_methods;

public class EmploymentContract {
    private double grossHourlyPay;
    private double hoursPerWeek;
    public static int weeksPerYear = 52;
    public static double taxRate = 0.3;

    public EmploymentContract(double grossHourlyPay, double hoursPerWeek){
        setGrossHourlyPay(grossHourlyPay);
        setHoursPerWeek(hoursPerWeek);
    }
    public double annualNetSalary(){
        return this.getGrossHourlyPay() * this.getHoursPerWeek() * weeksPerYear * (1-taxRate);
    }

    public double getGrossHourlyPay() {
        return grossHourlyPay;
    }

    public void setGrossHourlyPay(double grossHourlyPay) {
        this.grossHourlyPay = grossHourlyPay;
    }

    public double getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(double hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
}
