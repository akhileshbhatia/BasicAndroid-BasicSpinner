package com.example.mukesh.basicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CalculationActivity extends AppCompatActivity {
    private String [] currencyNames = {"EUR","USD","UKP","CNY","INR","RON"};
    private double [] currencyRates = {1, 1.23 , 0.92 , 8.2 , 85 ,4.7};
    private int[] currencyImageIds =
            {   R.drawable.euro,
                R.drawable.dollar,
                R.drawable.pound,
                R.drawable.yuan,
                R.drawable.yuan,
                R.drawable.yuan};

    private Spinner fromSpinner = null, toSpinner = null;
    private EditText fromEditText = null, toEditText = null;
    private Button clearButton = null, convertButton = null;

    private ArrayAdapter<String> adapter = null;

    private int fromPosition = 0, toPosition=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        //wire objects with widgets
        fromSpinner = findViewById(R.id.fromSpinner);
        toSpinner = findViewById(R.id.toSpinner);

        fromEditText = findViewById(R.id.fromText);
        toEditText = findViewById(R.id.toText);

        clearButton = findViewById(R.id.clearBtn);
        convertButton = findViewById(R.id.convertBtn);

        //make the spinners
        //adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,currencyNames);
        adapter = new ImageAdapter(this,R.layout.row_layout,currencyNames,currencyImageIds);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                fromPosition = 0;
            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                toPosition = 0;
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromEditText.setText("");
                toEditText.setText("");
                //reset the spinner
                fromSpinner.setAdapter(adapter);
                toSpinner.setAdapter(adapter);
            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double fromAmount = Double.parseDouble(fromEditText.getText().toString());
                double rate = currencyRates[toPosition]/currencyRates[fromPosition];
                double toAmount = fromAmount * rate;

                toEditText.setText(String.valueOf(toAmount));
            }
        });
    }
}
