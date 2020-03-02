package com.example.lab03;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class FindTheNumberActivity extends AppCompatActivity {

    int number_to_guess = 0;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_the_number);
        final EditText numberText = findViewById(R.id.numberButton);
        final Button submitButton = findViewById(R.id.submitButton);
        submitButton.setBackgroundColor(Color.RED);
        generateNumber();
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer guess;
                try{
                    guess = Integer.parseInt(numberText.getText().toString());
                } catch (Exception ex) {
                    guess = null;
                }
                if(guess == null) {
                    Toast.makeText(FindTheNumberActivity.this,"Please enter a valid integer!",Toast.LENGTH_SHORT).show();
                } else
                if(guess < number_to_guess) {
                    Toast.makeText(FindTheNumberActivity.this,"Higher",Toast.LENGTH_SHORT).show();
                } else
                if(guess > number_to_guess) {
                    Toast.makeText(FindTheNumberActivity.this,"Lower",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FindTheNumberActivity.this,"You won! Try again",Toast.LENGTH_SHORT).show();
                    generateNumber();
                }
                numberText.setText("");
                if(submitButton.getSolidColor() == Color.BLUE) {
                    submitButton.setBackgroundColor(Color.RED);
                } else {
                    submitButton.setBackgroundColor(Color.BLUE);
                }
            }
        });
    }
    private void generateNumber() {
        number_to_guess = random.nextInt(11);
    }
}
