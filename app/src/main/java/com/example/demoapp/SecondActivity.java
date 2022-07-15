package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText firstNameEditText;
    EditText lastNameEditText;
    Button concatenateButton;
    TextView fullNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firstNameEditText = findViewById(R.id.firstName_editText);
        lastNameEditText = findViewById(R.id.lastName_editText);
        concatenateButton = findViewById(R.id.concatenate_button);
        fullNameTextView = findViewById(R.id.fullName_textView);

        concatenateButton.setOnClickListener(view -> {
            concatenateNamesAndDisplay();
        });
    }

    private void concatenateNamesAndDisplay() {
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        fullNameTextView.setText(firstName + ' ' + lastName);
    }
}