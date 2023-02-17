package Asc;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class SavingAccount implements Comparable<SavingAccount> {

    private double acc_balance;
    private int acc_ID;
    private String accountHolderName;
    private boolean isSalaryAccount;

    public SavingAccount(double acc_balance, int acc_ID, String accountHolderName, boolean isSalaryAccount) {
        this.acc_balance = acc_balance;
        this.acc_ID = acc_ID;
        this.accountHolderName = accountHolderName;
        this.isSalaryAccount = isSalaryAccount;
    }

    public double getAcc_balance() {
        return acc_balance;
    }

    public void setAcc_balance(double acc_balance) {
        this.acc_balance = acc_balance;
    }

    public int getAcc_ID() {
        return acc_ID;
    }

    public void setAcc_ID(int acc_ID) {
        this.acc_ID = acc_ID;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public boolean isSalaryAccount() {
        return isSalaryAccount;
    }

    public void setSalaryAccount(boolean salaryAccount) {
        isSalaryAccount = salaryAccount;
    }

    public void deposit(double amount) {
        this.acc_balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= this.acc_balance) {
            this.acc_balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public int compareTo(SavingAccount savingAccount) {
        return this.acc_ID - savingAccount.acc_ID;
    }
}

class BankAccountList {

    private TreeSet<SavingAccount> savingAccounts = new TreeSet<>();

    public boolean addSavingAccount(SavingAccount savingAccount) {
        return savingAccounts.add(savingAccount);
    }

    public List<Integer> displaySavingAccountIds() {
        List<Integer> ids = new ArrayList<>();
        for (SavingAccount savingAccount : savingAccounts) {
            ids.add(savingAccount.getAcc_ID());
        }
        return ids;
    }
}

public class Assignment3Q9 {
    public static void main(String[] args) {
        BankAccountList bankAccountList = new BankAccountList();

        SavingAccount savingAccount1 = new SavingAccount(10000, 101, "John Doe", false);
        SavingAccount savingAccount2 = new SavingAccount(20000, 102, "Jane Doe", true);

        bankAccountList.addSavingAccount(savingAccount1);
        bankAccountList.addSavingAccount(savingAccount2);

        System.out.println("Saving account IDs: " + bankAccountList.displaySavingAccountIds());
    }
}
