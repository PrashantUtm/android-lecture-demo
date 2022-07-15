package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button incrementButton;
    Button navigateButton;
    TextView counterTextView;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incrementButton = findViewById(R.id.increment_button);
        navigateButton = findViewById(R.id.navigate_button);
        counterTextView = findViewById(R.id.count_textview);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                counterTextView.setText(Integer.toString(counter));
            }
        });

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navigateIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(navigateIntent);
            }
        });
    }
}