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
        accounts.add(account);
    }

    public Conta searchAccount(int accId) {
        for (Account account : accounts) {
            if (account.getAccId() == accId) {
                return accId;
            }
        }
        throw new accNotFoundException("Account " + numero + " not found.");
    }

    public void transfer(int idFromOrigin, int destinationId, double transacValue) {
        if(idFromOrigin == destinationId) {
            throw new InvalidOpException("The origin account and destination account cannot be the same.");
        }

        Accout origin = searchAccount(idFromOrigin);
        Conta destination = searchAccount(destinationId);
        origin.transferTo(destinationId, transacValue);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
