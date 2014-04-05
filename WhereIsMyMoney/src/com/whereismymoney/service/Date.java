package com.whereismymoney.service;

import java.util.Calendar;

/**
 * utility class that holds a date and is able to output date in different.
 * formats
 * @author cxy
 *
 */
public class Date {
	/**
	 * year component of a date.
	 */
    private int year;
    
    /**
     * month component of a date.
     */
    private int month;
    
    /**
     * day component of a date.
     */
    private int day;

    /**
     * default constructor that initializes year, month, day to the current date.
     */
    public Date() {
        Calendar today = Calendar.getInstance();
        year = today.get(Calendar.YEAR);
        month = today.get(Calendar.MONTH) + 1; // offset the zero-indexed month number
        day = today.get(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * initialize year, month, day to a specific date.
     * 
     * @param year year we want to initialize to
     * @param month month we want to initialize to
     * @param day day we want to initialize to
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // TODO: integrity check for setters
    
    /**
     * get the year component of a date.
     * 
     * @return year component of a date
     */
    public int getYear() {
        return year;
    }
    
    /**
     * set the year component of a date.
     * 
     * @param year component of a date
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * get the month component of a date.
     * 
     * @return month component of a date
     */
    public int getMonth() {
        return month;
    }

    /**
     * set the month component of a date.
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * get the day component of a date.
     * 
     * @return day component of a date
     */
    public int getDay() {
        return day;
    }

    /**
     * set the day component of a date.
     */
    public void setDay(int day) {
        this.day = day;
    }
    
    // default format MM/DD/YYYY
    @Override
    public String toString() {
        return toStringMDY();
    }
    
    /**
     * output date in format of month/day/year.
     * 
     * @return date in format of month/day/year
     */
    public String toStringMDY() {
        return month + "/" + day + "/" + year;
    }
    
    /**
     * output date in format of year-month-day.
     * 
     * @return date in format of year-month-day
     */
    // for sql query
    public String toStringYMD() {
        return year + "-" + month + "-" + day;
    }
    
    // TODO: define more date format
}
