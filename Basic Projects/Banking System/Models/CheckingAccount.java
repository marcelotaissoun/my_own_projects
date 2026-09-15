public class CheckingAccount extends Account {
    private double ChAccLimit;

    public CheckingAccount(int accId, Client client, double ChAccLimit) {
        super(accId, client);
        this.ChAccLimit = ChAccLimit;
    }

    @Override
    public void withdrawal(double value) {
        if(value <= 0) {
            throw new InvalidOpException("Withdrawal value must be greater than zero");
        }

        if(value > getAccBalance() + ChAccLimit) {
            throw new InsuffBalanceException("Balance and limit are insufficient");
        }
        doWithdrawal(value);
    }

    public double getChAccLimit() {
        return ChAccLimit;
    }
}
