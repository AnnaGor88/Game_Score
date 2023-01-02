package com.goriacheva.gamescore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;
    private int score2 = 0;
    private TextView textViewScore1;
    private TextView textViewScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Warn", "Start creating");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewScore1 = findViewById(R.id.team1Score);
        textViewScore2 = findViewById(R.id.team2Score);

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }


        updateScore1();
        updateScore2();

        textViewScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Warn", "Clicked textViewScore1");
                score1++;
                updateScore1();
            }
        });
        textViewScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Warn", "Clicked textViewScore2");
                score2++;
                updateScore2();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Warn", "Start onStart method");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Warn", "Start onStop method");
    }

    private void updateScore1() {
        textViewScore1.setText(String.valueOf(score1));
    }

    private void updateScore2() {
        textViewScore2.setText(String.valueOf(score2));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("Warn", "Start onSave method");
        super.onSaveInstanceState(outState);
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }

    @Override
    protected void onDestroy() {
        Log.d("Warn", "Start Destroying");
        super.onDestroy();
    }
}

