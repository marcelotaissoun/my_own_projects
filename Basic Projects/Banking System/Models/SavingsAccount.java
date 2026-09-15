import exception.InvalidOpException;
import exception.InsuffBalanceException;

public class SavingsAccount extends Account {
    public SavingsAccount(int accId, Client client) {
        super(accId, client);
    }

    @Override
    public void withdrawal(double value) {
        if(value <= 0) {
            throw new InvalidOpException("Withdrawal value must be greater than zero.");
        }
      
        if(value > getAccBalance()) {
            throw new InsuffBalanceException("Insufficient balance.");
        }
        doWithdrawal(value);
    }
}
