package model;

import java.time.LocalDateTime;

public class Transaction {
    private TransactionType transacType;
    private double transacValue;
    private LocalDateTime transacDate;

    public Transaction(TransactionType transacType, double transacValue) {
        this.transacType = transacType;
        this.transacValue = transacValue;
        this.transacDate = LocalDateTime.now();
    }

    public TransactionType getTransacType() {
        return transacType;
    }

    public double getTransacValue() {
        return transacValue;
    }

    public LocalDateTime getTransacDate() {
        return transacDate;
    }
}
