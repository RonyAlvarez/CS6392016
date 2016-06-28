package com.ronyalvarez.midterm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Input, button, and result
        inputEditText = (EditText) findViewById(R.id.inputEditText);
        convertButton = (Button) findViewById(R.id.convertButton);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        // Set resultTextView's visibility to invisible
        resultTextView.setVisibility(View.INVISIBLE);

        assert convertButton != null;
        convertButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get input string, convert it to int and assign it to miles
                int miles = Integer.parseInt(inputEditText.getText().toString());

                // Convert the input to kilometers and assign it to kilometers
                double kilometers = miles * 1.609344;

                // Change the result text and set the visibility to visible
                resultTextView.setText(miles + "mi = " + kilometers + "km");
                resultTextView.setVisibility(View.VISIBLE);

            }
        });

    }

}
