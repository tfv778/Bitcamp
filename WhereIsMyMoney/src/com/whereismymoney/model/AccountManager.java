package com.whereismymoney.model;

import java.util.ArrayList;
import java.util.List;
import com.whereismymoney.database.DatabaseConnect;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AccountManager {

    // return a list of all accounts of a given user
    public List<Account> getAllAccounts(String username) {
        List<Account> accountList = new ArrayList<Account>();

        Document doc = DatabaseConnect.getDatabaseConnect().getAllAccounts(
                username);
        Elements fullNameList = doc.select("full_name");
        Elements displayNameList = doc.select("display_name");
        Elements balanceList = doc.select("balance");
        Elements intRateList = doc.select("interest_rate");

        // extract and pack the information pertain to the current account
        for (int i = 0; i < fullNameList.size(); i++) {
            String fullName = fullNameList.get(i).text();
            String displayName = displayNameList.get(i).text();
            Double balance = Double.parseDouble(balanceList.get(i).text());
            Double intRate = Double.parseDouble(intRateList.get(i).text());
            accountList
                    .add(new Account(fullName, displayName, balance, intRate));
        }
        return accountList;
    }

    public boolean createAccount(String username, String account_display_name,
            String account_full_name, double balance, double interest_rate) {

        Document doc = DatabaseConnect.getDatabaseConnect().createAccount(
                username, account_display_name, account_full_name, balance,
                interest_rate);
        String loginResult = (doc.text());
        if (loginResult.equals("account created")) {
            // setting the current account for transaction purposes
            CurrentAccount.getCurrentAccount().setAccountName(
                    account_display_name);
            return true;
        }

        return false;
    }
}
