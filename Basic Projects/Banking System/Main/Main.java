import model.Account;
import model.CheckingAccount;
import model.Client;
import model.SavingsAccount;
import model.Transaction;
import service.BankingService;

import exception.AccNotFoundException;
import exception.InsuffBalanceException;
import exception.InvalidOpException;

public class Main {
    public static void main(String[] args) {
        BankingService bank = new BankingService();
      
        Client client01 = new Client("Marcelo", "123.456.789-11");
        Client client02 = new Client("João", "987.654.321-11");

        Account checkingAccount = new CheckingAccount(1, client01, 1000);
        Account savingsAccount = new SavingsAccount(2, client02);
        bank.addAccount(checkingAccount);
        bank.addAccount(savingsAccount);

        try {
            checkingAccount.deposit(2000);
            savingsAccount.deposit(1000);
            System.out.println("Depósitos realizados com sucesso.");
          
        } catch(InvalidOpException e) {
            System.out.println("Deposit error: " + e.getMessage());
        }

        System.out.println("\nStarting balances:");
        System.out.println("Account 1: R$ " + checkingAccount.getAccBalance());
        System.out.println("Account 2: R$ " + savingsAccount.getAccBalance());

        try {
            checkingAccount.withdrawal(500);
            System.out.println("\nBalance was updated.");
          
        } catch(InsuffBalanceException e) {
            System.out.println("Withdrawal error: " + e.getMessage());
        } catch(InvalidOpException e) {
            System.out.println("Invalid operation: " + e.getMessage());
        }

        try {
            checkingAccount.withdrawal(2200);
            System.out.println("Withdrawal was made using the account limit.");
          
        } catch(InsuffBalanceException e) {
            System.out.println("Insufficient balance: " + e.getMessage());
        } catch(InvalidOpException e) {
            System.out.println("Invalid operation: " + e.getMessage());
        }

        try {
            bank.transfer(1, 2, 500);
            System.out.println("\nTransfer successfully made.");

        } catch(InsuffBalanceException e) {
            System.out.println("Transfer error: " + e.getMessage());
        } catch(AccNotFoundException e) {
            System.out.println("Account not found: " + e.getMessage());
        } catch(InvalidOpException e) {
            System.out.println("Invalid operation: " + e.getMessage());
        }

        System.out.println("\nCurrent balance:");
        System.out.println("Account 1: R$ " + checkingAccount.getAccBalance());
        System.out.println("Account 2: R$ " + savingsAccount.getAccBalance());

        System.out.println("\nBank Statement for Account 1:");
        for(Transaction transaction : checkingAccount.getTransactions()) {
            System.out.println("Type: " + transaction.getTransacType() + " | Value: R$ " + transaction.getTransacValue() + " | Date: " + transaction.getTransacDate());
        }

        System.out.println("\nBank Statement for Account 2");
        for (Transaction transaction : savingsAccount.getTransactions()) {
            System.out.println("Type: " + transaction.getTransacType() + " | Value: R$ " + transaction.getTransacValue() + " | Date: " + transaction.getTransacDate());
        }

        try {
            bank.searchAccount(3);

        } catch(AccNotFoundException e) {
            System.out.println("\nError: " + e.getMessage());
        }

        try {
            savingsAccount.withdrawal(5000);

        } catch(InsuffBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(InvalidOpException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            checkingAccount.deposit(-100);
          
        } catch (InvalidOpException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
