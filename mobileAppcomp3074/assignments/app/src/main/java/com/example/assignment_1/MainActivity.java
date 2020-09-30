package com.example.assignment_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayPay;
    private TextView displayOvertimePay;
    private TextView displayTotalPay;
    private TextView displayTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText hoursWorked = findViewById(R.id.inputWorkedHours);
        final EditText hourlyWage = findViewById(R.id.inputHourlyRate);

        displayPay = findViewById(R.id.lblPay);
        displayOvertimePay = findViewById(R.id.lblOvertimePay);
        displayTotalPay = findViewById(R.id.lblTotalPay);
        displayTax = findViewById(R.id.lblTax);

        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calculatePay(hoursWorked, hourlyWage);
            }
        });
    }

    /**Called when the user presses the about button**/
    public void openAbout(){
        //display about layout
        Intent start = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(start);
    }

    /**Start calculating the pay values**/
    public void calculatePay(EditText hoursWorked, EditText hourlyWage){
        double hours = Double.parseDouble(hoursWorked.getText().toString());
        double wage = Double.parseDouble(hourlyWage.getText().toString());
        double pay, payOvertime, payTotal, payTax;

        if (hours <= 40) {
            pay = calculateRegularPay(hours, wage);
            payOvertime = 0;
            payTax = calculateTax(pay);
            payTotal = pay - payTax;
            displayPayView(pay, payOvertime, payTax, payTotal);
        } else if(hours > 40) {
            pay = calculateRegularPay(40.0, wage);
            payOvertime = calculateOvertimePay(hours, wage) - pay;
            payTax = calculateTax(payOvertime + pay);
            payTotal = (pay+payOvertime) - payTax;
            displayPayView(pay, payOvertime, payTax, payTotal);
        }


    }

    /**Calculate regular pay**/
    public double calculateRegularPay(double hours, double wage) {
        return hours * wage;
    }

    /**Calculate overtime pay**/
    public double calculateOvertimePay(double hours, double wage) {
        return (hours - 40) * wage * 1.5 + 40 * wage;
    }

    /**Calculate tax**/
    public double calculateTax(double pay) {
        return pay * .18;
    }

    /**Update text with calculated values**/
    public void displayPayView(double pay, double payOvertime, double payTax, double payTotal) {
        displayPay.setText(String.valueOf(pay));
        displayOvertimePay.setText(String.valueOf(payOvertime));
        displayTax.setText(String.valueOf(payTax));
        displayTotalPay.setText(String.valueOf(payTotal));
    }
    //inflate menu to display
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.main_menu, menu);
        return true;
    }

    //open about activity on click
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId() == R.id.menu_about) {
            openAbout();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}