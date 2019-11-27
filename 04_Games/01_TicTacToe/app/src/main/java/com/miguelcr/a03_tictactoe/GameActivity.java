package com.miguelcr.a03_tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv0, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8;
    boolean isPlayingPlayerOne = true;
    boolean gameOver = false;
    Button btnRestart;
    TextView tv1, tv2;

    //                     0 1 2 3 4 5 6 7 8
    int[] selectedCells = {0,0,0,0,0,0,0,0,0};

    //   0 1 2 3 4 5 6 7 8
    // [ 0 0 0 0 0 0 0 0 0 ] >>> all the cells have 0 value

    // First case: Player 1 selects imageView0
    // We're going to save this information in the array

    //   0 1 2 3 4 5 6 7 8
    // [ 1 0 0 0 0 0 0 0 0 ]

    // Second case: Player 2 selects imageView4

    //   0 1 2 3 4 5 6 7 8
    // [ 1 0 0 0 2 0 0 0 0 ]

    // If we draw the array like this...

    /*
        0 | 0 | 0
       -----------
        0 | 0 | 0
       -----------
        0 | 0 | 0

        And the positions are...

        0 | 1 | 2
       -----------
        3 | 4 | 5
       -----------
        6 | 7 | 8
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        iv0 = findViewById(R.id.imageView0);
        iv1 = findViewById(R.id.imageView1);
        iv2 = findViewById(R.id.imageView2);
        iv3 = findViewById(R.id.imageView3);
        iv4 = findViewById(R.id.imageView4);
        iv5 = findViewById(R.id.imageView5);
        iv6 = findViewById(R.id.imageView6);
        iv7 = findViewById(R.id.imageView7);
        iv8 = findViewById(R.id.imageView8);
        btnRestart = findViewById(R.id.buttonRestart);
        tv1 = findViewById(R.id.textViewPlayer1);
        tv2 = findViewById(R.id.textViewPlayer2);

        // Get the player names from the Intent
        Bundle extras = getIntent().getExtras();
        String p1Name = extras.getString("nick1");
        String p2Name = extras.getString("nick2");

        tv1.setText(p1Name);
        tv2.setText(p2Name);

        // Click events
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
            }
        });

        iv0.setOnClickListener(this);
        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
        iv5.setOnClickListener(this);
        iv6.setOnClickListener(this);
        iv7.setOnClickListener(this);
        iv8.setOnClickListener(this);


    }

    private void restartGame() {
        // Restore the selectedCells array to zero
        for(int i=0; i < 9; i++) {
            selectedCells[i] = 0;
        }

        // Restore some boolean vars
        gameOver = false;
        isPlayingPlayerOne = true;

        // Restore the empty cells images
        iv0.setImageResource(R.drawable.ic_blank_check_box);
        iv1.setImageResource(R.drawable.ic_blank_check_box);
        iv2.setImageResource(R.drawable.ic_blank_check_box);
        iv3.setImageResource(R.drawable.ic_blank_check_box);
        iv4.setImageResource(R.drawable.ic_blank_check_box);
        iv5.setImageResource(R.drawable.ic_blank_check_box);
        iv6.setImageResource(R.drawable.ic_blank_check_box);
        iv7.setImageResource(R.drawable.ic_blank_check_box);
        iv8.setImageResource(R.drawable.ic_blank_check_box);

    }

    @Override
    public void onClick(View v) {

        if(gameOver) {
            Toast.makeText(this, "The game is over", Toast.LENGTH_SHORT).show();
        } else {

            int id = v.getId();
            ImageView imageViewSelected = null;
            int position = 0;

            if (id == R.id.imageView0) {
                imageViewSelected = iv0;
                position = 0;
            } else if (id == R.id.imageView1) {
                imageViewSelected = iv1;
                position = 1;
            } else if (id == R.id.imageView2) {
                imageViewSelected = iv2;
                position = 2;
            } else if (id == R.id.imageView3) {
                imageViewSelected = iv3;
                position = 3;
            } else if (id == R.id.imageView4) {
                imageViewSelected = iv4;
                position = 4;
            } else if (id == R.id.imageView5) {
                imageViewSelected = iv5;
                position = 5;
            } else if (id == R.id.imageView6) {
                imageViewSelected = iv6;
                position = 6;
            } else if (id == R.id.imageView7) {
                imageViewSelected = iv7;
                position = 7;
            } else if (id == R.id.imageView8) {
                imageViewSelected = iv8;
                position = 8;
            }

            if (selectedCells[position] == 0) { // empty
                if (isPlayingPlayerOne) {
                    imageViewSelected.setImageResource(R.drawable.ic_player_one);
                    selectedCells[position] = 1;
                } else {
                    imageViewSelected.setImageResource(R.drawable.ic_player_two);

                    selectedCells[position] = 2;
                }


                if (checkSolution()) {
                    gameOver = true;

                    if (isPlayingPlayerOne) {
                        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
                    }
                } else { // if we don't have a solution...
                    isPlayingPlayerOne = !isPlayingPlayerOne;
                }


            } else {
                Toast.makeText(this, "The cell is not empty", Toast.LENGTH_SHORT).show();
            }

        }

    }

    /*

        0 | 1 | 2
       -----------
        3 | 4 | 5
       -----------
        6 | 7 | 8

        0,1,2
        3,4,5
        6,7,8
        0,3,6
        1,4,7
        2,5,8
        0,4,8
        2,4,6
     */

    boolean checkSolution() {
        boolean existSolution = false;

        if(selectedCells[0] == selectedCells[1]
                && selectedCells[1] == selectedCells[2]
                && selectedCells[2] != 0){ // 0,1,2
            existSolution = true;
        } else if(selectedCells[3] == selectedCells[4]
                && selectedCells[4] == selectedCells[5]
                && selectedCells[5] != 0) { // 3,4,5
            existSolution = true;
        } else if(selectedCells[6] == selectedCells[7]
                && selectedCells[7] == selectedCells[8]
                && selectedCells[8] != 0) { // 6,7,8
            existSolution = true;
        } else if(selectedCells[0] == selectedCells[3]
                && selectedCells[3] == selectedCells[6]
                && selectedCells[6] != 0) { // 0,3,6
            existSolution = true;
        } else if(selectedCells[1] == selectedCells[4]
                && selectedCells[4] == selectedCells[7]
                && selectedCells[7] != 0) { // 1,4,7
            existSolution = true;
        } else if(selectedCells[2] == selectedCells[5]
                && selectedCells[5] == selectedCells[8]
                && selectedCells[8] != 0) { // 2,5,8
            existSolution = true;
        } else if(selectedCells[0] == selectedCells[4]
                && selectedCells[4] == selectedCells[8]
                && selectedCells[8] != 0) { // 0,4,8
            existSolution = true;
        } else if(selectedCells[2] == selectedCells[4]
                && selectedCells[4] == selectedCells[6]
                && selectedCells[6] != 0) { // 2,4,6
            existSolution = true;
        }

        return existSolution;
    }
}
