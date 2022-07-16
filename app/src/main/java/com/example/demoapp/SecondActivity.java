package com.example.demoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
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
            shareMessage();
        });
    }

    private void concatenateNamesAndDisplay() {
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        fullNameTextView.setText(firstName + ' ' + lastName);
    }

    private void shareMessage() {
        String fullName = fullNameTextView.getText().toString();
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, fullName);
        sendIntent.setType("text/plain");

        AlertDialog alertDialog =  new AlertDialog.Builder(SecondActivity.this).create();
        alertDialog.setTitle("Send Message");
        alertDialog.setMessage(fullName);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
                            startActivity(sendIntent);
                        } catch (ActivityNotFoundException e) {

                        }
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.dismiss();
                    }
                });
        alertDialog.show();

    }
}