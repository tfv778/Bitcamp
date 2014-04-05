package com.whereismymoney.activity;

import java.util.Calendar;

import com.whereismymoney.R;
import com.whereismymoney.model.CurrentUser;
import com.whereismymoney.model.Report;
import com.whereismymoney.service.Date;
import com.whereismymoney.model.ReportGenerator;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

/**
 * UI class to generate a report for a user-defined period of time.
 * 
 * @author cxy
 * 
 */
public class ViewReport extends FragmentActivity implements
        DatePickerDialog.OnDateSetListener {

    private Date startDate, endDate;
    private TextView startDateTxt, endDateTxt, reportTxt;
    private Button generateReport;
    private View currentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
    	getActionBar().setTitle("");
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);

        reportTxt = (TextView) findViewById(R.id.text_view_report_body);
        startDateTxt = (TextView) findViewById(R.id.text_view_report_start_date);
        endDateTxt = (TextView) findViewById(R.id.text_view_report_end_date);
        startDate = new Date();
        endDate = new Date();

        // set up today as the default date
        startDateTxt.setText("From: " + startDate.toString());
        endDateTxt.setText("To:  " + endDate.toString());

        // enable date selection by making text clickable
        startDateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                showDatePickerDialog(arg0);
            }
        });

        endDateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                showDatePickerDialog(arg0);
            }
        });

        generateReport = (Button) findViewById(R.id.button_generate_report);
        generateReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ReportGenerator generator = new ReportGenerator();
                Report report = generator.generateSpendingCategoryReport(
                        CurrentUser.getCurrentUser().getUserName(), startDate,
                        endDate);
                reportTxt.setText(report.toString());
            }
        });
    }

    // reference
    // http://developer.android.com/guide/topics/ui/controls/pickers.html
    public static class DatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(),
                    (OnDateSetListener) getActivity(), year, month, day);
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
        currentView = v;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
            int dayOfMonth) {
        if (currentView.getId() == startDateTxt.getId()) {
            startDate.setYear(year);
            startDate.setMonth(monthOfYear);
            startDate.setDay(dayOfMonth);
            startDateTxt.setText("From: " + startDate.toString());
        } else if (currentView.getId() == endDateTxt.getId()) {
            endDate.setYear(year);
            endDate.setMonth(monthOfYear);
            endDate.setDay(dayOfMonth);
            endDateTxt.setText("To: " + endDate.toString());
        }
    }
    
    //creates the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}