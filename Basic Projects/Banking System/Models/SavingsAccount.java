import exception.InvalidOpException;
import exception.InsuffBalanceException;

public class SavingsAccount extends Account {
    public SavingsAccount(int accId, Client client) {
        super(accId, client);
    }

    @Override
    protected void validateWithdrawal(double transacValue) {
        if(transacValue <= 0) {
            throw new InvalidOpException("Withdrawal value must be greater than zero.");
        }
      
        if(transacValue > getAccBalance()) {
            throw new InsuffBalanceException("Insufficient balance.");
        }
    }
    
    @Override
    public void withdrawal(double transacValue) {
        validateWithdrawal(transacValue);
        doWithdrawal(transacValue);
    }
}
