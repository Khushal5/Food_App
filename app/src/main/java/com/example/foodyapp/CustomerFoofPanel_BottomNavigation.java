package com.example.foodyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodyapp.customerFoodPanel.CustomerCartFragment;
import com.example.foodyapp.customerFoodPanel.CustomerHomeFragment;
import com.example.foodyapp.customerFoodPanel.CustomerOrdersFragment;
import com.example.foodyapp.customerFoodPanel.CustomerProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class CustomerFoofPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    EditText dateEditText, timeEditText, guestsEditText, nameEditText;
    Button bookTableButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_foof_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        dateEditText = findViewById(R.id.dateEditText);
        nameEditText= findViewById(R.id.nameEditText);
        timeEditText = findViewById(R.id.timeEditText);
        guestsEditText = findViewById(R.id.guestsEditText);
        bookTableButton = findViewById(R.id.bookTableButton);

        bookTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate input
                if (validateInput()) {
                    // If input is valid, book the table
                    bookTable();
                }
            }
        });




    }
    private boolean validateInput() {
        String date = dateEditText.getText().toString().trim();
        String time = timeEditText.getText().toString().trim();
        String guests = guestsEditText.getText().toString().trim();

        if (date.isEmpty() || time.isEmpty() || guests.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


    private void bookTable() {

        Intent intent = new Intent(CustomerFoofPanel_BottomNavigation.this, ConfirmationActivity.class);
        startActivity(intent);
        finish(); // Finish current activity to prevent going back to it using back button
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.cust_Home) {
            fragment = new CustomerHomeFragment();
        } else if (itemId == R.id.cart) {
            fragment = new CustomerCartFragment();
        } else if (itemId == R.id.Cust_order) {
            fragment = new CustomerOrdersFragment();
        }
        return loadcheffragment(fragment);
    }

    private boolean loadcheffragment(Fragment fragment) {

        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;
    }
}