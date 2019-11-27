package com.miguelcr.a03_tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etPlayer1, etPlayer2;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlayer1 = findViewById(R.id.editTextPlayer1);
        etPlayer2 = findViewById(R.id.editTextPlayer2);
        btnStart = findViewById(R.id.buttonStartGame);

        // Click event
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p1Name = etPlayer1.getText().toString();
                String p2Name = etPlayer2.getText().toString();

                if(p1Name.isEmpty() || p2Name.isEmpty()) {
                    etPlayer1.setError("Error");
                } else {
                    // Start the game
                    Intent i = new Intent(MainActivity.this, GameActivity.class);
                    i.putExtra("nick1", p1Name);
                    i.putExtra("nick2", p2Name);

                    startActivity(i);
                }
            }
        });
    }

}
