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

    public void deposit(double transacValue) {
        if(transacValue <= 0) {
            throw new InvalidOpException("Deposit value must be greater than zero.");
        }
        addValueToBalance(transacValue);
        registerTransac(TransacType.DEPOSIT, transacValue);
    }

    public void withdrawal(double transacValue) {
        validateWithdrawal(transacValue);
        doWithdrawal(transacValue);
    }
    
    public abstract void validateWithdrawal(double transacValue);

    private void addValueToBalance(double transacValue) {
        balance += transacValue;
    }

    private void remValueFromBalance(double transacValue) {
        balance -= transacValue;
    }

    protected void doWithdrawal(double transacValue) {
        remValueFromBalance(transacValue);
        registerTransac(TransacType.WITHDRAWAL, transacValue);
    }

    protected void doSentTransfer(double transacValue) {
        remValueFromBalance(transacValue);
        registerTransac(TransacType.SENT_TRANSFER, transacValue);
    }

    protected void doReceivedTransfer(double transacValue) {
        addValueToBalance(transacValue);
        registerTransac(TransacType.RECEIVED_TRANSFER, transacValue);
    }

    public void transferTo(Account destination, double transacValue) {
        if(destination == null) {
            throw new InvalidOpException("There is no account to receive the transfer");
        }

        if(transacValue <= 0) {
            throw new InvalidOpException("Transfer value must be greater than zero");
        }

        validateWithdrawal(transacValue);
        doSentTransfer(transacValue);
        destination.doReceivedTransfer(transacValue);
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
