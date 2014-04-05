package com.whereismymoney.model;

import org.jsoup.nodes.Document;

import com.whereismymoney.database.DatabaseConnect;

/**
 * This class handles both types of transactions (withdrawals and deposits) for
 * a given username and account.
 */

public class TransactionManager {

    /**
     * Creates a new withdrawal for the given user's account. current timeStamp
     * automatically added by mysql. Negative balance not allowed.
     * 
     * @param reason reason for withdrawal
     * @param expenseCategory category of withdrawal
     * @param amount amount of withdrawal
     * @param effectiveDate effective date of withdrawal
     * @return if new withdrawal is added successfully
     */
    public boolean newWithdrawal(String reason, String expenseCategory,
            double amount, String effectiveDate) {

        Document doc = DatabaseConnect.getDatabaseConnect().newWithdrawal(
                reason, expenseCategory, amount, effectiveDate);
        String result = doc.select("body").first().text();
        if (result.equals("success")) {
            return true;
        }

        return false;
    }

    /**
     * Creates a new deposit for the given user's account. current timeStamp
     * automatically added by mysql.
     * 
     * @param source source of deposit
     * @param amount amount of deposit
     * @param effectiveDate effective date of deposit
     * @return if new deposit is added successfully
     */
    public boolean newDeposit(String source, double amount, String effectiveDate) {
        Document doc = DatabaseConnect.getDatabaseConnect().newDeposit(source,
                amount, effectiveDate);
        String result = doc.select("body").first().text();
        if (result.equals("success")) {
            return true;
        }
        return false;
    }
}
