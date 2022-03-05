package enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTypeV1Test {

    @Test
    public void testAccountTypeInterestRate() {
        assertEquals(0.01, AccountTypeV1.SAVINGS.getInterestRate());
    }

    @Test
    public void testAccountTypeOrdinal() {
        assertEquals(2, AccountTypeV1.CHEQUE.ordinal());
    }

    @Test
    public void testStringToAccountType() {
        var accountType = AccountTypeV1.valueOf("ISA");
        assertEquals(AccountTypeV1.ISA, accountType);
    }
}
