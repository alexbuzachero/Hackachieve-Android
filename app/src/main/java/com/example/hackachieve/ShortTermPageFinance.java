package com.example.hackachieve;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShortTermPageFinance extends AppCompatActivity {

    FetchData data = new FetchData();

    private ImageView ongoingButton;
    private ImageView addButton;
    private ImageView completedButton;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_term_page_finance);

        data.initShortGoalsHealth();

        initRecyclerView();

        ongoingButton = (ImageView) findViewById(R.id.ongoingIcon);
        addButton = (ImageView) findViewById(R.id.addIcon);
        completedButton = (ImageView) findViewById(R.id.completedIcon);
        backButton = (ImageView) findViewById(R.id.backButton);

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
    private void initRecyclerView(){
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        RecyclerViewShortTermGoals adapter = new RecyclerViewShortTermGoals(this, data.getParentGoalID(), data.getShortGoalTitle(),data.getShortGoalDescription(),data.getShortGoalDeadline(), data.getShortGoalstatus());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
