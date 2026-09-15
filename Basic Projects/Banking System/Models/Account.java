import java.util.ArrayList;
import java.util.List;
import exception.InvalidOpException;

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
        registerTransac(TransacType.DEPOSIT, value);
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
        registerTransac(TransacType.WITHDRAWAL, value);
    }

    protected void doSentTransfer(double value) {
        remValueFromBalance(value);
        registerTransac(TransacType.SENT_TRANSFER, value);
    }

    protected void doReceivedTransfer(double value) {
        addValueToBalance(value);
        registerTransac(TransacType.RECEIVED_TRANSFER, value);
    }

    public void transferTo(Account destination, double value) {
        if(destination == null) {
            throw new InvalidOpException("There is no account to receive the transfer");
        }

        if(value <= 0) {
            throw new InvalidOpException("Transfer value must be greater than zero");
        }

        doSentTransfer(value);
        destination.doReceivedTransfer(value);
    }

    private void registerTransac(TransactionType transacType, double transacValue) {
        Transaction transaction = new Transaction(transacType, transacValue);
        transactions.add(transaction);
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
