package com.whereismymoney.database;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.os.StrictMode;
import android.util.Log;

import com.whereismymoney.model.CurrentAccount;
import com.whereismymoney.model.CurrentUser;
import com.whereismymoney.service.Date;

/**
 * A database interfacer, which allows manipulation on database without changing files in other packages.
 * Note: This package only separates the database itself but not the jsoup library.
 * @author Zhuoming Li
 *
 */
public class DatabaseConnect implements Idatabase {

    private static DatabaseConnect databaseConnect;
    private final static String ROOT_ADDRESS = "http://192.185.4.36/~zli342/";
    private final static String GET_ALL_ACCOUNTS = "get_account_info.php";
    private final static String CREATE_ACCOUNT = "create_account.php";
    private final static String LOGIN = "login.php";
    private final static String REGISTER = "register.php";
    private final static String GENERATE_SPENDING_CATEGORY_REPORT = "get_withdraw_summary.php";
    private final static String CREATE_WITHDRAWAL = "create_withdrawal.php";
    private final static String CREATE_DEPOSIT = "create_deposit.php";
    StringBuffer buffer = new StringBuffer();

   /* public DatabaseConnect() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }*/

    @Override
    public Document getAllAccounts(String username) {
        try {
            String address = buffer.append(ROOT_ADDRESS)
                    .append(GET_ALL_ACCOUNTS).toString();
            Document doc = Jsoup.connect(address).data("username", username)
                    .timeout(15 * 1000).get();

            return doc;
        } catch (IOException e) {
            Log.i("fail", e.toString());
        }
        return null;
    }

    @Override
    public Document createAccount(String username, String account_display_name,
            String account_full_name, double balance, double interest_rate) {
        try {
            String address = buffer.append(ROOT_ADDRESS).append(CREATE_ACCOUNT)
                    .toString();
            Document doc = Jsoup.connect(address).data("username", username)
                    .data("account_display_name", account_display_name)
                    .data("account_full_name", account_full_name)
                    .data("balance", Double.toString(balance))
                    .data("interest_rate", Double.toString(interest_rate))
                    .timeout(15 * 1000).get();

            return doc;
        } catch (IOException e) {
            Log.i("fail", e.toString());
        }
        return null;
    }

    @Override
    public Document login(String username, String password) {
        try {
            String address = buffer.append(ROOT_ADDRESS).append(LOGIN)
                    .toString();
            Document doc = Jsoup.connect(address).data("username", username)
                    .data("password", password).timeout(15 * 1000).get();

            return doc;
        } catch (IOException e) {
            Log.i("fail", e.toString());
        }
        return null;
    }

    @Override
    public Document register(String username, String first_name,
            String last_name, String password, String email) {
        try {
            String address = buffer.append(ROOT_ADDRESS).append(REGISTER)
                    .toString();
            Document doc = Jsoup.connect(address).data("username", username)
                    .data("password", password).data("first_name", first_name)
                    .data("last_name", last_name).data("email", email)
                    .timeout(15 * 1000).get();

            return doc;
        } catch (IOException e) {
            Log.i("fail", e.toString());
        }
        return null;
    }

    @Override
    public Document generateSpendingCategoryReport(String username, Date start,
            Date end) {
        try {
            String address = buffer.append(ROOT_ADDRESS)
                    .append(GENERATE_SPENDING_CATEGORY_REPORT).toString();
            Document doc = Jsoup.connect(address).data("username", username)
                    .data("start_date", start.toStringYMD())
                    .data("end_date", end.toStringYMD()).timeout(15 * 1000)
                    .get();

            return doc;
        } catch (IOException e) {
            Log.i("fail", e.toString());
        }
        return null;
    }

    public static DatabaseConnect getDatabaseConnect() {
        return new DatabaseConnect();
    }

    @Override
    public Document newDeposit(String source, double amount,
            String effectiveDate) {
        try {
            String address = buffer.append(ROOT_ADDRESS).append(CREATE_DEPOSIT)
                    .toString();
            Document doc = Jsoup
                    .connect(address)
                    .data("username",
                            CurrentUser.getCurrentUser().getUserName())
                    .data("account_name",
                            CurrentAccount.getCurrentAccount().getAccountName())
                    .data("amount", Double.toString(amount))
                    .data("source", source)
                    .data("effective_date", effectiveDate).timeout(15 * 1000)
                    .get();
            return doc;

        } catch (IOException e) {
            Log.i("fail", e.toString());
        }
        return null;
    }

    @Override
    public Document newWithdrawal(String reason, String expenseCategory,
            double amount, String effectiveDate) {
        try {
            String address = buffer.append(ROOT_ADDRESS)
                    .append(CREATE_WITHDRAWAL).toString();
            Document doc = Jsoup
                    .connect(address)
                    .data("username",
                            CurrentUser.getCurrentUser().getUserName())
                    .data("account_name",
                            CurrentAccount.getCurrentAccount().getAccountName())
                    .data("amount", Double.toString(amount))
                    .data("reason", reason).data("category", expenseCategory)
                    .data("effective_date", effectiveDate).timeout(15 * 1000)
                    .get();
            return doc;
        } catch (IOException e) {
            Log.i("fail", e.toString());
        }
        return null;
    }

}
