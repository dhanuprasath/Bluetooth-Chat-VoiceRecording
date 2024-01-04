package com.matrix_maeny.bluetoothchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Header extends AppCompatActivity {

    private Spinner dropDownMenu;
    private Button selectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);


        dropDownMenu = findViewById(R.id.dropDownMenu);
        selectButton = findViewById(R.id.selectButton);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.dropdown_options, // Define an array resource in your strings.xml with values 4, 5, 6
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        dropDownMenu.setAdapter(adapter);

        // Set listener for item selection in the drop-down menu
        dropDownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection if needed
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle no item selected if needed
            }
        });
    }

    public void onSelectButtonClick(View view) {
        // Get selected value from the drop-down menu
        String selectedValue = dropDownMenu.getSelectedItem().toString();

        // Get the length of the selected value
        int selectedValueLength = selectedValue.length();

        // Display a toast message with the selected value and its length
        String toastMessage = selectedValue + " Bytes Selected for Header Size";
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Header.this, MainActivity2.class);
        intent.putExtra("selectedValue", selectedValue);
        startActivity(intent);
    }
 }
