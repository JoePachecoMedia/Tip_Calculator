package com.example.josestipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TipCalculator tipCalculator;
    public NumberFormat money = NumberFormat.getCurrencyInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipCalculator = new TipCalculator(0,.15,0);

    }

    public void calculate (View v) {
        EditText billEditText = findViewById(R.id.amount_bill);
        String billString = billEditText.getText().toString();
        double billAmount = Double.parseDouble(billString);

        EditText tipEditText = findViewById(R.id.amount_tip_percent);
        String tipString = tipEditText.getText().toString();
        double tipAmount = Double.parseDouble(tipString);

        EditText peopleEditText = findViewById(R.id.amount_people);
        String peopleString = peopleEditText.getText().toString();
        int peopleAmount = Integer.parseInt(peopleString);

        /***
        EditText taxEditText = findViewById(R.id.amount_tax);
        String taxString = tipEditText.getText().toString();
        double taxAmount = Double.parseDouble(taxString);
        ***/


        TextView taxTextView = findViewById(R.id.amount_tax);
        TextView tipTextView = findViewById(R.id.amount_tip);
        TextView totalTextView = findViewById(R.id.amount_total);

        //TextView taxTextView = "8.13%";

        tipCalculator.setBill(billAmount);
        //tipCalculator.setTax();
        tipCalculator.setTip(tipAmount* .01);
        tipCalculator.setTax(8.13);
        tipCalculator.setPeople(peopleAmount);
        //tipCalculator.setTax(taxAmount*.01);

        double tip = tipCalculator.tipAmount();
        double tipEach = tipCalculator.tipAmountEach();

        double total =tipCalculator.totalAmount();
        double totalEach =tipCalculator.totalAmountEach();



        int people = tipCalculator.getPeople();
        double tax = tipCalculator.getTax();

        tipTextView.setText(money.format(tipEach));
        totalTextView.setText(money.format(totalEach));
        taxTextView.setText(money.format(tax));


    }
}