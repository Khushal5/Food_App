package com.example.foodyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        TextView confirmationTextView = findViewById(R.id.confirmationTextView);
        confirmationTextView.setText("     Booking Confirmed!\n     Thank you for choosing our   \n      restaurant.");
    }
}