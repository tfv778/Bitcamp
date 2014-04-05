package com.whereismymoney.model;

/**
 * holds information relevant to an account.
 * 
 * @author Xinyi Chen
 * 
 */
public class Account {
    private final String myFullName;
    private final String myDisplayName;
    private final double myBalance;
    private final double myInterestRate;

    public Account(String fullName, String displayName, double balance,
            double interestRate) {
        myFullName = fullName;
        myDisplayName = displayName;
        myBalance = balance;
        myInterestRate = interestRate;
    }

    public String getFullName() {
        return myFullName;
    }

    public String getDisplayName() {
        return myDisplayName;
    }

    public double getBalance() {
        return myBalance;
    }

    public double getInterestRate() {
        return myInterestRate;
    }

    /**
     * output a formatted string represent the account information
     * 
     * @param colWidth1
     *            custom-defined column width for display name
     * @param colWidth2
     *            custom-defined column width for balance
     * @param colWidth3
     *            custom-defined column width for interest rate
     * @return a formatted string of account display name, balance, and interest
     *         rate
     */
    public String toString(int colWidth1, int colWidth2, int colWidth3) {
        // input integrity check
        String tooSmall = "";
        if (colWidth1 < myDisplayName.length()) {
            tooSmall += "colum 1 ";
        }
        if (colWidth2 < Double.toString(myBalance).length()) {
            tooSmall += "colum 2 ";
        }
        if (colWidth3 < Double.toString(myInterestRate).length()) {
            tooSmall += "colum 3";
        }

        if (tooSmall.length() > 0) {
            throw new IllegalArgumentException(
                    "please define large enough column width for " + tooSmall);
        }

        return String.format("%-" + colWidth1 + "s", myDisplayName)
                + String.format("%-" + colWidth2 + "s", myBalance)
                + String.format("%-" + colWidth3 + "s", myInterestRate);
    }
}
