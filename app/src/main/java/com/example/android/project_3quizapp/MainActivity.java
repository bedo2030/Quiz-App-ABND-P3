package com.example.android.project_3quizapp;

import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    //Question #01 Variables
    @BindView(R.id.question_1_answer_et) TextInputEditText mQuestionOneAnswerEditText;
    private final String mQuestionOneCorrectAnswer = "one";
    private String mQuestionOneUserAnswer;

    //Question #02 Variables
    @BindView(R.id.question_2_correct_answer_rb) RadioButton mQuestionTwoCorrectAnswer;

    //Question #03 Variables
    @BindView(R.id.question_3_correct_answer_rb) RadioButton mQuestionThreeCorrectAnswer;

    //Question #04 Variables
    @BindView(R.id.question_4_correct_answer_1_cb) CheckBox mQuestionFourCorrectAnswer1;
    @BindView(R.id.question_4_correct_answer_2_cb) CheckBox mQuestionFourCorrectAnswer2;
    @BindView(R.id.question_4_wrong_answer_1_cb) CheckBox mQuestionFourWrongAnwer1;
    @BindView(R.id.question_4_wrong_answer_2_cb) CheckBox mQuestionFourWrongAnwer2;

    //Total Quiz score
    private int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Button submitButton = (Button) findViewById(R.id.submit_btn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               calculateTotalScore();
                if(totalScore == 4)
                    Toast.makeText(MainActivity.this, "Nice Job you scored "+ String.valueOf(totalScore)+ " out of 4", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Total Score = "+ String.valueOf(totalScore)+ " out of 4", Toast.LENGTH_LONG).show();
                totalScore = 0; //resetting score
            }
        });
    }

    public void calculateTotalScore(){
        //Check Question #01
        //rigth answer "one"
        mQuestionOneUserAnswer = mQuestionOneAnswerEditText.getText().toString().toLowerCase();
        if(mQuestionOneUserAnswer.equals(mQuestionOneCorrectAnswer)) totalScore++;

        //Check Question #02
        //rigth answer B
        if(mQuestionTwoCorrectAnswer.isChecked()) totalScore++;

        //Check Question #03
        //rigth answer C
        if(mQuestionThreeCorrectAnswer.isChecked()) totalScore++;

        //Check Question #03
        //rigth answer B,D
        if(mQuestionFourCorrectAnswer1.isChecked() && mQuestionFourCorrectAnswer2.isChecked()){
            if(!mQuestionFourWrongAnwer1.isChecked() && !mQuestionFourWrongAnwer2.isChecked()) totalScore++;
        }
    }
}
