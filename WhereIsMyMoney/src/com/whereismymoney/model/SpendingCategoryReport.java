package com.whereismymoney.model;

import java.util.ArrayList;
import java.util.List;

import com.whereismymoney.service.Date;
import com.whereismymoney.service.Pair;

/**
 * holds information of one's spending category report over a certain period of time
 * and is able to output a formatted text report.
 * @author Xinyi
 *
 */
public class SpendingCategoryReport implements Report {
	/**
	 * a list of spendings in the form of category and amount pair.
	 */
    private List<Pair<String, Double>> mySpendings = new ArrayList<Pair<String, Double>>();
    
    /**
     * date bound of the report.
     */
    private Date start, end;
    
    /**
     * initialize the spending category report with a list of spendings,
     * starting date and end date.
     * 
     * @param spendings a list of spendings in the form of category and amount pair.
     * @param startDate starting date of the record
     * @param endDate endind date of the record
     */
    public SpendingCategoryReport(List<Pair<String, Double>> spendings, Date startDate, Date endDate) {
        mySpendings = spendings;
        start = startDate;
        end = endDate;
    }
    
    /**
     * output a formatted spending category report.
     * 
     * @return a formatted spending category report
     */
    @Override
    public String toString() {
        String report = "Spending Category Report\n"
                        + start.toString() + " - " + end.toString() + "\n";
        
        if (mySpendings != null) {
            for (Pair<String, Double> spending : mySpendings) {
                report += spending.getItem1() + "     " + spending.getItem2() + "\n"; 
            }
        }
        
        return report;
    }
}
