package com.whereismymoney.service;

/**
 * for user input integrity check.
 * 
 * @author Jesus
 * 
 */
public class IntegrityCheck {
    /**
     * Checks string password to see if it is at least int length long.
     * @param password String that is passed in.
     * @param length   Int that is passed in.
     * @return         If true, password was at least the length long.
     *                 If false, password was shorter than the length.
     */
    public static boolean checkPasswordLength(String password, int length) {
        return password.matches(".{" + length + ",}");
    }
    
    /**
     * Checks string email to see if it matches the format.
     * @param email   String that is passed in.
     * @return        If true, email was of the correct format.
     *                If false, email was not of the correct format.
     */
    public static boolean checkEmail(String email) {
        return email
                .matches("[a-zA-Z][0-9A-Za-z\\_\\-\\.]*@[a-zA-Z][0-9A-Za-z\\_\\-]*.(com|org|net|edu)");
    }
    
    /**
     * Checks two strings to see if they are identical.
     * @param firstWord     String passed in.
     * @param secondWord    String passed in.
     * @return              If true, the two strings were identical.
     *                      If false, the two strings did not match.
     */
    public static boolean checkMatch(String firstWord, String secondWord) {
        return firstWord.equals(secondWord);
    }
    
    /**
     * Checks string to see if it exists.
     * @param input String passed in.
     * @return      If true, the string passed in had characters within it.
     *              If false, the string passed in had no characters within it.
     */
    public static boolean isInputValid(String input) {
        return !input.matches("\\s*");
    }
    
    /**
     * Checks string date to see if it is of a valid format.
     * @param date  String passed in.
     * @return      If true, the string passed in was of the correct format.
     *              If false, the string pased in was not of the correct format.
     */
    public static boolean validDate(String date) {
        // return date.matches("[0-9]{2}\\\\/[0-9]{2}\\\\/[0-9]{4}");
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }
    
    /**
     * Checks string amount to see if it matches the needed format.
     * @param amount    String passed in.
     * @return          If true, the string matches the needed format.
     *                  If false, the string does not match the needed format.
     */
    public static boolean amountFormat(String amount) {
        return amount.matches("[0-9]{0,}.[0-9]{2}");
    }
}