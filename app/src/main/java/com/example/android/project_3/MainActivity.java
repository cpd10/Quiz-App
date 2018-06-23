package com.example.android.project_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity
{
    int incorrect = 0;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void submitAnswers(View v)
    {
        checkedRadioButton();
        getEditText();
        getCheckedBox();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("TEST_SCORE", score);
        intent.putExtra("INCORRECT",incorrect);
        startActivity(intent);
    }

    public void checkedRadioButton()
    {
        RadioGroup radio1 = (RadioGroup) findViewById(R.id.questionOne);
        RadioGroup radio2 = (RadioGroup) findViewById(R.id.questionFour);

        int selected1 = radio1.getCheckedRadioButtonId();
        int selected2 = radio2.getCheckedRadioButtonId();

        RadioButton radioButton1 = (RadioButton) findViewById(selected1);
        RadioButton radioButton2 = (RadioButton) findViewById(selected2);

        String r1;
        String r2;

        if(radioButton1 != null)
        {
            r1 = radioButton1.getText().toString().trim();
            if (r1.equals(getString(R.string.answer1)))
                score++;
            else
                incorrect++;
        }
        else
            incorrect++;
        if(radioButton2 != null)
        {
            r2 = radioButton2.getText().toString().trim();
            if (r2.equals(getString(R.string.answer4)))
                score++;
            else
                incorrect++;
        }
        else
            incorrect++;
    }

    public void getEditText()
    {
        EditText text1 = (EditText) findViewById(R.id.questionTwo);
        EditText text2 = (EditText) findViewById(R.id.questionFive);

        String t1 = text1.getText().toString().trim();
        String t2 = text2.getText().toString().trim();

        if(!t1.isEmpty())
        {
            if (t1.equals(getString(R.string.answer2)))
                score++;
            else
                incorrect++;
        }

        else
            incorrect++;

        if(!t2.isEmpty())
        {
            if (t2.equals(getString(R.string.answer5)))
                score++;
            else
                incorrect++;
        }

        else
            incorrect++;
    }

    public void getCheckedBox()
    {
        CheckBox box1 = (CheckBox) findViewById(R.id.value1);
        CheckBox box2 = (CheckBox) findViewById(R.id.value2);
        CheckBox box3 = (CheckBox) findViewById(R.id.value3);
        CheckBox box4 = (CheckBox) findViewById(R.id.value4);

        if(!box1.isChecked() && box2.isChecked() && box3.isChecked() && box4.isChecked())
            score++;
        else
            incorrect++;

    }
}
