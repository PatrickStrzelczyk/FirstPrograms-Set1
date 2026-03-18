package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText input = findViewById(R.id.inputName);
        TextView output = findViewById(R.id.outputText);
        Button button = findViewById(R.id.buttonWitaj);

        button.setOnClickListener(v -> {
            String text = input.getText().toString().trim();

            if(!text.isEmpty()) {
                output.setText("Witaj " + text);
            } else {
                output.setText("Przedstaw się.");
            }
        });

    }
}