package com.example.android.SlovakianQuiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void letsStart(View v) {
        Intent start = new Intent(MainActivity.this, questions.class);
        startActivity(start);

        EditText name = findViewById(R.id.enteredName);
        String nameString = name.getText().toString();
        Intent intent = new Intent(getApplicationContext(), questions.class);
        intent.putExtra("name", nameString);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", nameString);
        editor.apply();
        startActivity(intent);
    }
}