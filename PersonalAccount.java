 import java.util.ArrayList;
import java.util.List;

public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<Amount> transactions;

    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            Amount transaction = new Amount(amount, TransactionType.DEPOSIT);
            transactions.add(transaction);
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            Amount transaction = new Amount(amount, TransactionType.WITHDRAWAL);
            transactions.add(transaction);
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (Amount transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
