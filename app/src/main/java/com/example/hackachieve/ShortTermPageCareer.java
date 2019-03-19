package com.example.hackachieve;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShortTermPageCareer extends AppCompatActivity {

//    private LinearLayout cardSelected;
//    private TextView titleSelected;
//    private TextView contentSelected;
//    private TextView dateSelected;
//    private Boolean cardClicked = false;

    private ImageView ongoingButton;
    private ImageView addButton;
    private ImageView completedButton;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_term_page_career);

        ongoingButton = (ImageView) findViewById(R.id.ongoingIcon);
        addButton = (ImageView) findViewById(R.id.addIcon);
        completedButton = (ImageView) findViewById(R.id.completedIcon);
        backButton = (ImageView) findViewById(R.id.backButton);

        //        Defining Cards

//        cardSelected = (LinearLayout) findViewById(R.id.shortGoalClicked);
//        titleSelected = (TextView) findViewById(R.id.shortTermTitleCard);
//        contentSelected = (TextView) findViewById(R.id.shortTermDescriptionCard);
//        dateSelected = (TextView) findViewById(R.id.shortTearmDeadlineCard);

        //        Add Click listener to the cards
//        cardSelected.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (cardClicked == false){
//                    changeBackgroundSelected();
//                    cardClicked = true;
//
//                } else {
//                    changeBackgroundUnselected();
//                    cardClicked = false;
//                }
//            }
//        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLongTermGoals();
            }
        });

        ongoingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLongTermGoals();
            }
        });


        completedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLongTermGoalsCompleted();
            }
        });
    }

//    public void changeBackgroundSelected() {
//        cardSelected.setBackgroundColor(Color.parseColor("#FFD58B"));
//        titleSelected.setTextColor(Color.parseColor("#374FCA"));
//        contentSelected.setTextColor(Color.parseColor("#909CDA"));
//        dateSelected.setTextColor(Color.parseColor("#FF4B8D"));
//    }
//    public void changeBackgroundUnselected() {
//
//        cardSelected.setBackgroundColor(Color.parseColor("#EFEFEF"));
//        titleSelected.setTextColor(Color.BLACK);
//        contentSelected.setTextColor(Color.BLACK);
//        dateSelected.setTextColor(Color.BLACK);
//    }

    public void openLongTermGoals(){
        Intent intent = new Intent(this, LongTermPage.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void openLongTermGoalsCompleted(){
        Intent intent = new Intent(this, ShortTermPageCompleted.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
