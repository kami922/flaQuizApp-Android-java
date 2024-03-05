// ResultActivity.java
package com.example.flagquizapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageView resultBackgroundImageView = findViewById(R.id.resultBackgroundImageView);
        TextView resultTextView = findViewById(R.id.resultTextView);

        // Get the score from the intent
        int score = getIntent().getIntExtra("score", 0);

        // Set the result text
        resultTextView.setText("Quiz Completed! Your score: " + score);

        // Set the same background image
        resultBackgroundImageView.setImageResource(R.drawable.background);
    }
}
