package com.example.hackachieve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class LongTermPageCompleted extends AppCompatActivity {

    //        Creating longTermCardVariable(one variable for each card)
    private ImageView ongoingButton;
    private ImageView addButton;

    FetchData data = new FetchData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_term_page_completed);

        data.initGoalsCompleted();
        initRecyclerView();

        ongoingButton = (ImageView) findViewById(R.id.ongoingIcon);
        ongoingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLongTermGoals();
            }
        });
    }

    private void initRecyclerView(){
//        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mCardTitle, mGoalsCompleted,mTotalGoals,mDataCompleted, mBoard_id);
        RecyclerViewGoalsCompleted adapter = new RecyclerViewGoalsCompleted(this, data.getCardTitle(), data.getGoalsCompleted(),data.getTotalGoals(),data.getDataCompleted(), data.getBoard_id());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void openLongTermGoals(){
        Intent intent = new Intent(this, LongTermPage.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
