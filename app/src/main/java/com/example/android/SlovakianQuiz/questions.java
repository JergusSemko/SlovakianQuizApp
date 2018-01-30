package com.example.android.SlovakianQuiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class questions extends AppCompatActivity {

    int points;
    RadioButton q1Answer1;
    RadioButton q2Answer3;
    RadioButton q3Answer1;
    RadioButton q4Answer1;
    RadioButton q5Answer3;
    EditText answerQ7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        answerQ7 = findViewById(R.id.answer_edit_text_7);

        Toast.makeText(getApplicationContext(), "Lets start", Toast.LENGTH_SHORT).show();
    }

    public void submit(View view) {

        Intent myIntent = new Intent(questions.this, submitWindow.class);
        int totalPoints = countPoints();
        myIntent.putExtra("points", totalPoints);
        startActivity(myIntent);
    }

    public int countPoints() {
        points = 0;

        q1Answer1 = findViewById(R.id.q1_answer1);
        q2Answer3 = findViewById(R.id.q2_answer3);
        q3Answer1 = findViewById(R.id.q3_answer1);
        q4Answer1 = findViewById(R.id.q4_answer1);
        q5Answer3 = findViewById(R.id.q5_answer3);

        CheckBox q6Answer1 = findViewById(R.id.q6_answer1);
        boolean hasQ6Option1 = q6Answer1.isChecked();
        Log.v("MainActivity", "Correct q6Option1: " + hasQ6Option1);

        CheckBox q6Answer2 = findViewById(R.id.q6_answer2);
        boolean hasQ6Option2 = q6Answer2.isChecked();
        Log.v("MainActivity", "Correct q6Option2: " + hasQ6Option2);

        CheckBox q6Answer3 = findViewById(R.id.q6_answer3);
        boolean hasQ6Option3 = q6Answer3.isChecked();
        Log.v("MainActivity", "Correct q6Option3: " + hasQ6Option3);

        if (q1Answer1.isChecked()) {
            points += 1;
        }
        if (q2Answer3.isChecked()) {
            points += 1;
        }
        if (q3Answer1.isChecked()) {
            points += 1;
        }
        if (q4Answer1.isChecked()) {
            points += 1;
        }
        if (q5Answer3.isChecked()) {
            points += 1;
        }
        if (hasQ6Option2 && hasQ6Option3 && !hasQ6Option1) {
            points += 1;
        }
        if (answerQ7.getText().toString().trim().equalsIgnoreCase(getString(R.string.texta))) {
            points += 1;

        } else if (!answerQ7.getText().toString().trim().equals("")) {
            points -= 1;
        }
        return points;
    }
}