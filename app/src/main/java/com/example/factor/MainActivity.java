package com.example.factor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText num;
    Button enter;
    Button option1;
    Button option2;
    Button option3;
    Button next;
    long a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.text);
        enter = findViewById(R.id.Enter);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        next =findViewById(R.id.option4);

        num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String number = num.getText().toString();
                enter.setEnabled(!number.isEmpty());



                option1.setBackgroundColor(Color.WHITE);
                option2.setBackgroundColor(Color.WHITE);
                option3.setBackgroundColor(Color.WHITE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                option2.setEnabled(false);
                option3.setEnabled(false);
                option1.setBackgroundColor(Color.GREEN);
                num.setEnabled(false);
                enter.setEnabled(false);
                next.setEnabled(true);

            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                option1.setEnabled(false);
                option3.setEnabled(false);
                option1.setBackgroundColor(Color.GREEN);
                option2.setBackgroundColor(Color.RED);
                num.setEnabled(false);
                enter.setEnabled(false);
                next.setEnabled(true);

            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                option1.setEnabled(false);
                option2.setEnabled(false);
                option1.setBackgroundColor(Color.GREEN);
                option3.setBackgroundColor(Color.RED);
                num.setEnabled(false);
                enter.setEnabled(false);
                next.setEnabled(true);

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                enter.setEnabled(false);
                num.setEnabled(true);
                option1.setText("");
                option2.setText("");
                option3.setText("");
                num.setText("");
            }
        });


    }

    public void factor(View v) {
        long result1 = 1;
        long result2 = 1;
        long result3 = 1;
        long n = Long.parseLong(num.getText().toString());
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        next.setEnabled(false);

        for (long i = 1; i < 30; i++) {
            if (n % i == 0) {
                result1 = i;
            }
            option1.setText(String.valueOf(result1));

            if (n % i != 0) {
                result2 = i;
            } else {
                result2 = n + i + 1;
            }
            result3 = n + i + 13;


            option2.setText(String.valueOf(result2));
            option3.setText(String.valueOf(result3));
            i++;

            continue;


        }
        if(n==0){
            String s ="There are no factors for zero";


            result2=2;
            result3=3;
            option1.setText(String.valueOf(s));
            option2.setText(String.valueOf(result2));
            option3.setText(String.valueOf(result3));
        }


        a = result1;


    }


    }


