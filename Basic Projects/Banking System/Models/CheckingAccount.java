package model;

import exception.InvalidOpException;
import exception.InsuffBalanceException;

public class CheckingAccount extends Account {
    private double chAccLimit;

    public CheckingAccount(int accId, Client client, double chAccLimit) {
        super(accId, client);
        this.chAccLimit = chAccLimit;
    }

    @Override
    protected void validateWithdrawal(double transacValue) {
        if(transacValue <= 0) {
            throw new InvalidOpException("Withdrawal value must be greater than zero");
        }

        if(transacValue > getAccBalance() + chAccLimit) {
            throw new InsuffBalanceException("Balance and limit are insufficient");
        }
    }

    public double getChAccLimit() {
        return chAccLimit;
    }
}
