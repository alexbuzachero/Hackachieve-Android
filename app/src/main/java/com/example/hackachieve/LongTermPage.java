package com.example.hackachieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;

public class LongTermPage extends AppCompatActivity{

//        Creating longTermCardVariable(one variable for each card)
    private CardView longTermFitness;
    private ImageView ongoingButton;
    private ImageView addButton;
    private ImageView completedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_term_page);

//        Defining Cards
        longTermFitness = (CardView) findViewById(R.id.longTermFitnessID);
        ongoingButton = (ImageView) findViewById(R.id.ongoingIcon);
        addButton = (ImageView) findViewById(R.id.addIcon);
        completedButton = (ImageView) findViewById(R.id.completedIcon);

        //        Add Click listener to the cards
        longTermFitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShortGoalsPage();
            }
        });
        completedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLongTermGoalsCompleted();
            }
        });

    }

        public void openShortGoalsPage(){
            Intent intent = new Intent(this, ShortTermPage.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        public void openLongTermGoalsCompleted(){
            Intent intent = new Intent(this, LongTermPageCompleted.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
}
