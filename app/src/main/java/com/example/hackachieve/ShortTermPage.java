package com.example.hackachieve;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShortTermPage extends AppCompatActivity {

    private LinearLayout cardSelected;
    private TextView titleSelected;
    private TextView contentSelected;
    private TextView dateSelected;
    private Boolean cardClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_term_page);

        //        Defining Cards

        cardSelected = (LinearLayout) findViewById(R.id.shortGoalClicked);
        titleSelected = (TextView) findViewById(R.id.shortTermTitleCard);
        contentSelected = (TextView) findViewById(R.id.shortTermDescriptionCard);
        dateSelected = (TextView) findViewById(R.id.shortTearmDeadlineCard);

        //        Add Click listener to the cards
        cardSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardClicked == false){
                    changeBackgroundSelected();
                    cardClicked = true;

                } else {
                    changeBackgroundUnselected();
                    cardClicked = false;
                }
            }
        });
    }

    public void changeBackgroundSelected() {
        cardSelected.setBackgroundColor(Color.parseColor("#FFD58B"));
        titleSelected.setTextColor(Color.parseColor("#374FCA"));
        contentSelected.setTextColor(Color.parseColor("#909CDA"));
        dateSelected.setTextColor(Color.parseColor("#FF4B8D"));
    }
    public void changeBackgroundUnselected() {

        cardSelected.setBackgroundColor(Color.parseColor("#EFEFEF"));
        titleSelected.setTextColor(Color.BLACK);
        contentSelected.setTextColor(Color.BLACK);
        dateSelected.setTextColor(Color.BLACK);
    }
}
