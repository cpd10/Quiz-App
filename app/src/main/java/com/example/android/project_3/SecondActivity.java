package com.example.android.project_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dhook_000 on 6/15/2017.
 */

public class SecondActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        int score = getIntent().getIntExtra("TEST_SCORE",0);
        int incorrect = getIntent().getIntExtra("INCORRECT",0);

        Toast.makeText(this, "Your score is: " + score + "/5", Toast.LENGTH_LONG).show();

        TextView scoreView = (TextView) findViewById(R.id.testScore);
        scoreView.setText(String.valueOf(score));

        TextView incorrectView = (TextView) findViewById(R.id.incorrectScore);
        incorrectView.setText(String.valueOf(incorrect));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void backToQuiz(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
