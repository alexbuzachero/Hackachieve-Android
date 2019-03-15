package com.example.hackachieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;


public class LongTermPage extends AppCompatActivity{

    //        Creating longTermCardVariable(one variable for each card)
//    private CardView longTermFitness;
//    private CardView longTermFinance;
    private ImageView ongoingButton;
    private ImageView addButton;
    private ImageView completedButton;

    FetchData data = new FetchData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_term_page);

//        initVars();
        data.initGoals();
//        data.initGoalsCompleted();
        initRecyclerView();


//        Defining Cards
        // longTermFitness = (CardView) findViewById(R.id.longTermFitnessID);
        //  longTermFinance = (CardView) findViewById(R.id.financeID);
        ongoingButton = (ImageView) findViewById(R.id.ongoingIcon);
        addButton = (ImageView) findViewById(R.id.addIcon);
        completedButton = (ImageView) findViewById(R.id.completedIcon);

        //        Add Click listener to the cards
//        longTermFitness.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openShortGoalsPage();
//            }
//        });
//        longTermFinance.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openShortGoalsPageFinance();
//            }
//        });
        completedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLongTermGoalsCompleted();
            }
        });



    }

//        public void openShortGoalsPage(){
//            Intent intent = new Intent(this, ShortTermPageHealth.class);
//            startActivity(intent);
//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//        }
//
    public void openShortGoalsPageFinance(){
        Intent intent = new Intent(this, ShortTermPageFinance.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openLongTermGoalsCompleted(){
        Intent intent = new Intent(this, LongTermPageCompleted.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void initRecyclerView(){
//        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mCardTitle, mGoalsCompleted,mTotalGoals,mDataCompleted, mBoard_id);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, data.getCardTitle(), data.getGoalsCompleted(),data.getTotalGoals(),data.getDataCompleted(), data.getBoard_id());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
