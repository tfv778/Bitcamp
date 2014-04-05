package com.whereismymoney.database;

import org.jsoup.nodes.Document;
import com.whereismymoney.service.Date;

/**
 * database interface; contains methods needed for interactions with the db
 * @author Zhuoming Li
 * 
 */
public interface Idatabase {

    public Document getAllAccounts(String username);

    public Document createAccount(String username, String account_display_name,
            String account_full_name, double balance, double interest_rate);

    public Document login(String username, String password);

    public Document register(String username, String first_name,
            String last_name, String password, String email);

    public Document generateSpendingCategoryReport(String username, Date start,
            Date end);

    public Document newDeposit(String source, double amount,
            String effectiveDate);

    public Document newWithdrawal(String reason, String expenseCategory,
            double amount, String effectiveDate);

}
