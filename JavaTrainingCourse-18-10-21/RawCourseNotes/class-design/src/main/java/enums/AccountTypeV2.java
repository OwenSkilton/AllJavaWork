package enums;

// This is what an enum looks like internally
public class AccountTypeV2 {

    public static final AccountTypeV2 SAVINGS = new AccountTypeV2("SAVINGS");
    public static final AccountTypeV2 CREDIT = new AccountTypeV2("CREDIT");
    public static final AccountTypeV2 CHEQUE = new AccountTypeV2("CHEQUE");
    public static final AccountTypeV2 ISA = new AccountTypeV2("ISA");

    private String name;

    public AccountTypeV2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
