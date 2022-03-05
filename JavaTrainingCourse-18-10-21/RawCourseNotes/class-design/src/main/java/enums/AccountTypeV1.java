package enums;

// In the same way that interface is syntactic sugar for an abstract class so is enum for a class of constants
public enum AccountTypeV1 {

    SAVINGS(0.01), CREDIT(0), CHEQUE(0.005), ISA(0.015);

    private double interestRate;

    AccountTypeV1(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
