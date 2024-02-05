package ru.samsung.itschool.mdev.quadraticequationscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void solveEquation(View view) {
        double a = Double.parseDouble( ((EditText) findViewById(R.id.coefficient_a)).getText().toString() );
        double b = Double.parseDouble( ((EditText) findViewById(R.id.coefficient_b)).getText().toString() );
        double c = Double.parseDouble( ((EditText) findViewById(R.id.coefficient_c)).getText().toString() );

        TextView result = findViewById(R.id.answer);

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    result.setText(R.string.all_numbers);
                } else {
                    result.setText(R.string.no_roots);
                }
            } else {
                result.setText(String.valueOf(-c / b));
            }
        } else {
            double d = b * b - 4 * a * c;
            if (d < 0) {
                result.setText(R.string.no_roots);
            } else if (d == 0) {
                result.setText(String.valueOf(-b / (2 * a)));
            } else {
                String answer = ((-b - Math.sqrt(d)) / (2 * a)) + "; " + ((-b + Math.sqrt(d)) / (2 * a));
                result.setText(answer);
            }
        }
    }
}