package com.example.myapplication;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView output;
    Button button;

    Random random = new Random();
    int target;
    int attempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.inputGuess);
        output = findViewById(R.id.outputGame);
        button = findViewById(R.id.buttonGuess);

        startNewGame();

        button.setOnClickListener(v -> {
            String text = input.getText().toString().trim();

            // validation: empty
            if(text.isEmpty()){
                output.setText("Please enter an integer number.");
                return;
            }

            int guess;

            // validation: not integer
            try {
                guess = Integer.parseInt(text);
            } catch(Exception e){
                output.setText("Please enter an integer number.");
                return;
            }

            // validation: range
            if(guess < 1 || guess > 10){
                output.setText("Number must be in range 1..10.");
                return;
            }

            attempts++;

            if(guess < target){
                output.setText("Value too small");
            }
            else if(guess > target){
                output.setText("Value too large");
            }
            else {
                if(attempts == 2){
                    output.setText("Correct — achieved on the 2nd attempt");
                } else {
                    output.setText("Correct, but not on the 2nd attempt. Try again.");
                    startNewGame();
                }
            }
        });
    }

    void startNewGame(){
        target = random.nextInt(10) + 1;
        attempts = 0;
    }
}