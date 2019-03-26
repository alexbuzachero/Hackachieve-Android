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

    private ImageView ongoingButton;
    private ImageView addButton;
    private ImageView completedButton;

    FetchData data = new FetchData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_term_page);

        data.initGoals();
        initRecyclerView();


        ongoingButton = (ImageView) findViewById(R.id.ongoingIcon);
        addButton = (ImageView) findViewById(R.id.addIcon);
        completedButton = (ImageView) findViewById(R.id.completedIcon);

        completedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLongTermGoalsCompleted();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterMainGoal();
            }
        });

    }

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

    public void openRegisterMainGoal(){
        Intent intent = new Intent(this, RegisterMainGoal.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_up, R.anim.static_position);
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data.getCardTitle(), data.getGoalsCompleted(), data.getTotalGoals(), data.getDataCompleted(), data.getBoard_id(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
