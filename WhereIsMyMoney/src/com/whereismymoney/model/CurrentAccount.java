package com.whereismymoney.model;

/**
 * This class keeps track of the current account 
 * for purposes of accurately attributing 
 * transactions to the correct account.
 */

public class CurrentAccount {
    private static CurrentAccount currentAccount;
    private String accountName;
    
    // make constructor private to bar external classes from creating new CurrentAccount
    private CurrentAccount() { 
    	accountName = null; 
    }
    
    public static synchronized CurrentAccount getCurrentAccount()
    {
        if (currentAccount == null) {
            currentAccount = new CurrentAccount();
        }

        return currentAccount;
    }
    
    /**
     * Returns the current account's name.
     * @return The account name
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the current account's name.
     * @param accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}