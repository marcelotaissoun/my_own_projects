package service;

import java.util.ArrayList;
import java.util.List;
import exception.AccNotFoundException;
import exception.InvalidOpException;
import model.Account;

public class BankingService {
    private List<Account> accounts;

    public BankingService() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        if(account == null) {
            throw new InvalidOpException("Account cannot be null.");
        }
        accounts.add(account);
    }

    public Account searchAccount(int accId) {
        for (Account account : accounts) {
            if (account.getAccId() == accId) {
                return account;
            }
        }
        throw new AccNotFoundException("Account " + accId + " not found.");
    }

    public void transfer(int idFromOrigin, int destinationId, double transacValue) {
        if(idFromOrigin == destinationId) {
            throw new InvalidOpException("The origin account and destination account cannot be the same.");
        }

        Account origin = searchAccount(idFromOrigin);
        Account destination = searchAccount(destinationId);
        origin.transferTo(destination, transacValue);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
