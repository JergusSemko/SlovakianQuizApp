package com.example.android.SlovakianQuiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class submitWindow extends AppCompatActivity {

    String message;
    String message2 = "Your score is: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.submit_window);

        int totalPoints = getIntent().getIntExtra("points", 0);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String name = pref.getString("name", "");

        if (totalPoints <= 2) {
            message = "Wikipedia might help";
        } else if (totalPoints <= 4) {
            message = "Could be worse";
        } else if (totalPoints <= 6) {
            message = "Not bad";
        } else {
            message = "Great job";
        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .6), (int) (height * .3));

        displayScore(name, message2, message, totalPoints);
    }

    public void displayScore(String name, String message, String message2, int score) {

        TextView orderSummaryView = findViewById(R.id.final1);
        orderSummaryView.setText(getString(R.string.final1, name));
        TextView orderSummaryView2 = findViewById(R.id.final2);
        orderSummaryView2.setText(message2);
        TextView orderSummaryView3 = findViewById(R.id.screen);
        orderSummaryView3.setText(String.valueOf(message));
        TextView orderSummaryView4 = findViewById(R.id.screen2);
        orderSummaryView4.setText(String.valueOf(score));
    }
}