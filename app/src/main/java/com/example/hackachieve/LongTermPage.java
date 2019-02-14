package com.example.hackachieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.content.Intent;

    public class LongTermPage extends AppCompatActivity{

//        Creating longTermCardVariable(one variable for each card)
    private CardView longTermFitness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_term_page);

//        Defining Cards
        longTermFitness = (CardView) findViewById(R.id.longTermFitnessID);

        //        Add Click listener to the cards
        longTermFitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShortGoalsPage();
            }
        });

    }

        public void openShortGoalsPage(){
            Intent intent = new Intent(this, ShortTermPage.class);
            startActivity(intent);
        }
}
