package com.whereismymoney.model;

/**
 * if an object implement this interface, it should be able
 * to output a formatted text report.
 * @author Xinyi Chen
 *
 */
public interface Report {   
    
	/**
	 * output a formatted text report.
	 * 
	 * @return return a formatted text report
	 */
    @Override String toString();
}
