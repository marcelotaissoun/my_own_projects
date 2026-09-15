import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private int accId;
    private Client client;
    private double accBalance;

    private List<Transactions> transactions;

    public Account(int accId, Client client) {
        this.accId = accId;
        this.client = client;
        this.accBalance = 0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double value) {
        if(value <= 0) {
            throw new InvalidOpException("Deposit value must be greater than zero.");
        }
        addValueToBalance(valor);
        transactions.add(new Transaction(TransacType.DEPOSIT, value));
    }

    public abstract void withdrawal(double value);

    private void addValueToBalance(double value) {
        balance += value;
    }

    private void remValueFromBalance(double value) {
        balance -= value;
    }

    protected void doWithdrawal(double value) {
        remValueFromBalance(value);
        transactions.add(new Transaction(TransacType.WITHDRAWAL, value));
    }

    public double getAccBalance() {
        return accBalance;
    }

    public int getAccId() {
        return AccId;
    }

    public Cliente getClient() {
        return client;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
