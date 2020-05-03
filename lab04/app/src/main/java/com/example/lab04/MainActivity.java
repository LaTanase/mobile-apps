package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0 = x, 1 = o
    int activePlayer = 0;
    boolean gameIsActive = true;
    // 2 unplayed
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        // get the current Image View (counter tag)
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        LinearLayout linlay = findViewById(R.id.linlay0);
        TextView text1 = findViewById(R.id.text1);

        //if the space is empty(is 2) and the game is not over
        if (gameState[tappedCounter] == 2 && gameIsActive) {
            //set the current player
            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0) {
                // setImageResource for counter as x
                counter.setImageResource(R.drawable.x);
                gameState[tappedCounter] = 0;
                // change the player's turn
                activePlayer = 1;
            } else {
                // setImageResource for counter as zero
                gameState[tappedCounter] = 1;
                counter.setImageResource(R.drawable.o);
                activePlayer = 0;
            }
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    // Someone has won!
                    gameIsActive = false;
                    String winner = "Player 0";

                    if (gameState[winningPosition[0]] == 0) {
                        winner = "Player  x";
                    }
                    // Make a toast with the messaje winner + " has won!"
                    text1.setText(winner + " has won");
                    linlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Congrats! " + winner + " has won", Toast.LENGTH_SHORT).show();
                } else {
                    boolean gameIsOver = true;

                    for (int counterState : gameState) {
                        if (counterState == 2)
                            gameIsOver = false;
                    }
                    if (gameIsOver) {
                        // Make a toast with the messaje "It's a draw!"
                        text1.setText("It's a draw");
                        linlay.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "It's a draw!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    public void playAgain(View view){
        activePlayer = 0;
        gameIsActive = true;
        gameState = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
        LinearLayout linearLayout = findViewById(R.id.linlay0);
        linearLayout.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        for (int i = 0; i< gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }
}
