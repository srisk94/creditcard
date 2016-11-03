package com.srima.creditcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button cal;
    EditText amount,mnth;
    TextView txt1;
    int rate = 10;
    int minimum_payment = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cal = (Button) findViewById(R.id.calculat);
        amount = (EditText) findViewById(R.id.bal);
        txt1 = (TextView) findViewById(R.id.text1);
        mnth=(EditText)findViewById(R.id.months);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calbal();
            }
        });

    }


    public void calbal() {
        int i;
        int principle = Integer.parseInt(amount.getText().toString());
        int count=Integer.parseInt(mnth.getText().toString());
        int monthlyBalance = 0;
        for (i = 1; i <= count; i++) {

            int monthlyfloatInterestPaid = Math.round((principle * (rate / (100 * 12))));
            int monthlyPrinciple = minimum_payment - monthlyfloatInterestPaid;
             monthlyBalance = principle - monthlyPrinciple;
            principle=monthlyBalance;

        }
        txt1.setText(Integer.toString(monthlyBalance));

    }
}
