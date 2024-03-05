package com.example.flagquizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ImageView flagImageView;
    private RadioGroup optionsRadioGroup;
    private Button nextButton;
    private ProgressBar progressBar;
    private TextView resultTextView;
    private int currentQuestion = 1;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flagImageView = findViewById(R.id.flagImageView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        nextButton = findViewById(R.id.nextButton);
        progressBar = findViewById(R.id.progressBar);
        resultTextView = findViewById(R.id.resultTextView);

        updateFlagImage();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                currentQuestion++;

                if (currentQuestion <= 10) {
                    updateFlagImage();
                    optionsRadioGroup.clearCheck();
                    progressBar.setProgress(currentQuestion);
                    resultTextView.setText(""); // Clear result text
                } else {
                    // Show result
                    showResult();
                }
            }
        });
    }

    private void updateFlagImage() {
        int imageResourceId;
        ArrayList<String> optionsList = new ArrayList<>();

        switch (currentQuestion) {
            case 1:
                imageResourceId = R.drawable.pakistan_flag;
                optionsList.add("Pakistan");
                optionsList.add("India");
                optionsList.add("United Kingdom");
                optionsList.add("China");
                break;
            case 2:
                imageResourceId = R.drawable.india_flag;
                optionsList.add("India");
                optionsList.add("Pakistan");
                optionsList.add("United Kingdom");
                optionsList.add("China");
                break;
            case 3:
                imageResourceId = R.drawable.london;
                optionsList.add("United Kingdom");
                optionsList.add("Pakistan");
                optionsList.add("India");
                optionsList.add("China");
                break;
            case 4:
                imageResourceId = R.drawable.china;
                optionsList.add("China");
                optionsList.add("Pakistan");
                optionsList.add("India");
                optionsList.add("United Kingdom");
                break;
            case 5:
                imageResourceId = R.drawable.turkey;
                optionsList.add("Turkey");
                optionsList.add("Pakistan");
                optionsList.add("India");
                optionsList.add("United Kingdom");
                break;
            case 6:
                imageResourceId = R.drawable.germany_flag;
                optionsList.add("Germany");
                optionsList.add("Pakistan");
                optionsList.add("India");
                optionsList.add("United Kingdom");
                break;
            case 7:
                imageResourceId = R.drawable.ireland;
                optionsList.add("Ireland");
                optionsList.add("Pakistan");
                optionsList.add("India");
                optionsList.add("United Kingdom");
                break;
            case 8:
                imageResourceId = R.drawable.italy;
                optionsList.add("Italy");
                optionsList.add("Pakistan");
                optionsList.add("India");
                optionsList.add("United Kingdom");
                break;
            case 9:
                imageResourceId = R.drawable.norway;
                optionsList.add("Norway");
                optionsList.add("Pakistan");
                optionsList.add("India");
                optionsList.add("United Kingdom");
                break;
            case 10:
                imageResourceId = R.drawable.sweden;
                optionsList.add("Sweden");
                optionsList.add("Pakistan");
                optionsList.add("India");
                optionsList.add("United Kingdom");
                break;
            default:
                return;
        }

        // Shuffle the options
        Collections.shuffle(optionsList);

        // Set the shuffled options
        setOptions(optionsList.get(0), optionsList.get(1), optionsList.get(2), optionsList.get(3));
        flagImageView.setImageResource(imageResourceId);
    }

    private void setOptions(String option1, String option2, String option3, String option4) {
        RadioButton radioButton1 = findViewById(R.id.option1);
        RadioButton radioButton2 = findViewById(R.id.option2);
        RadioButton radioButton3 = findViewById(R.id.option3);
        RadioButton radioButton4 = findViewById(R.id.option4);

        radioButton1.setText(option1);
        radioButton2.setText(option2);
        radioButton3.setText(option3);
        radioButton4.setText(option4);
    }

    private void checkAnswer() {
        int selectedRadioButtonId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedOption = selectedRadioButton.getText().toString();
            if (selectedOption.equals(getCorrectAnswer())) {
                score++;
            }
        }
    }

    private String getCorrectAnswer() {
        switch (currentQuestion) {
            case 1:
                return "Pakistan";
            case 2:
                return "India";
            case 3:
                return "United Kingdom";
            case 4:
                return "China";
            case 5:
                return "Turkey";
            case 6:
                return "Germany";
            case 7:
                return "Ireland";
            case 8:
                return "Italy";
            case 9:
                return "Norway";
            case 10:
                return "Sweden";
            default:
                return "";
        }
    }

    private void showResult() {
        // Create an Intent to start the ResultActivity
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);

        // Pass the score to the ResultActivity
        intent.putExtra("score", score);

        // Start the ResultActivity
        startActivity(intent);

        // Finish the current activity (optional, based on your app's flow)
        finish();
    }


}


