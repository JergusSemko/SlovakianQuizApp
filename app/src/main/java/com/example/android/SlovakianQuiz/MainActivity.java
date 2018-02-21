package com.example.android.SlovakianQuiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int points;
    RadioButton q1Answer1;
    RadioButton q2Answer2;
    RadioButton q3Answer1;
    RadioButton q4Answer1;
    RadioButton q5Answer3;
    EditText answerQ7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*The answer for the last question is ready from the beginning of the app
            A little hint, the answer is "5 million" but I am sure you can find it
            in the code anyway ;)
         */
        answerQ7 = findViewById(R.id.et_answer_edit_text_7);
    }

    public void submit(View view) {

        //This method takes care of pretty much everything
        points = 0;
        q1Answer1 = findViewById(R.id.rb_question1_answer1);
        q2Answer2 = findViewById(R.id.rb_question2_answer2);
        q3Answer1 = findViewById(R.id.rb_question3_answer1);
        q4Answer1 = findViewById(R.id.rb_question4_answer1);
        q5Answer3 = findViewById(R.id.rb_question5_answer3);

        //Here are the lines for question 6 concerning check box part of the app
        CheckBox q6Answer1 = findViewById(R.id.cb_question6_answer1);
        boolean hasQ6Option1 = q6Answer1.isChecked();
        Log.v("MainActivity", "Correct q6Option1: " + hasQ6Option1);

        CheckBox q6Answer2 = findViewById(R.id.cb_question6_answer2);
        boolean hasQ6Option2 = q6Answer2.isChecked();
        Log.v("MainActivity", "Correct q6Option2: " + hasQ6Option2);

        CheckBox q6Answer3 = findViewById(R.id.cb_question6_answer3);
        boolean hasQ6Option3 = q6Answer3.isChecked();
        Log.v("MainActivity", "Correct q6Option3: " + hasQ6Option3);

        //Final counting of all of the points happens on submit button click
        if (q1Answer1.isChecked()) {
            points += 1;
        }
        if (q2Answer2.isChecked()) {
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
        }
        if (points < 7){
            Toast.makeText(getApplicationContext(), "Some answers are wrong. Your score is " + points, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Great job. Your score is " + points, Toast.LENGTH_SHORT).show();
        }
    }
}