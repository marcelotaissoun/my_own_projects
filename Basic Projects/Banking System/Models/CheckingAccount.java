import exception.InvalidOpException;
import exception.InsuffBalanceException;

public class CheckingAccount extends Account {
    private double ChAccLimit;

    public CheckingAccount(int accId, Client client, double ChAccLimit) {
        super(accId, client);
        this.ChAccLimit = ChAccLimit;
    }

    @Override
    protected void validateWithdrawal(double transacValue) {
        if(transacValue <= 0) {
            throw new InvalidOpException("Withdrawal value must be greater than zero");
        }

        if(transacValue > getAccBalance() + ChAccLimit) {
            throw new InsuffBalanceException("Balance and limit are insufficient");
        }
    }
    
    @Override
    public void withdrawal(double transacValue) {
        validateWithdrawal(transacValue);
        doWithdrawal(transacValue);
    }

    public double getChAccLimit() {
        return ChAccLimit;
    }
}
