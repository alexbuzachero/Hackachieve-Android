package com.example.hackachieve;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterMainGoal extends AppCompatActivity {

    private EditText goalTitle;
    private EditText goalCategory;
    private EditText goalDueDate;
    private Button createGoalButton;

    FetchData data = new FetchData();



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_main_goal);

        goalTitle = (EditText) findViewById(R.id.goalTitle);
        goalCategory = (EditText) findViewById(R.id.goalCategory);
        goalDueDate = (EditText) findViewById(R.id.goalDueDate);
        createGoalButton = (Button) findViewById(R.id.createGoalButton);

        createGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerGoal();
            }
        });
    }
    public void registerGoal(){

//        data.setCardTitle(goalTitle.getText().toString());
//        data.setBoard_id(1);
//        data.setDataCompleted(goalDueDate.getText().toString());
//        data.setGoalsCompleted("0");
//        data.setTotalGoals("0");
//        Log.d("title", goalTitle.getText().toString());

        Intent intent = new Intent(this, LongTermPage.class);
        startActivity(intent);
//        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
    }
}
