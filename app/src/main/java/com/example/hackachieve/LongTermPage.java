package com.example.hackachieve;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;

import android.support.v7.widget.Toolbar;

public class LongTermPage extends AppCompatActivity{

    private ImageView ongoingButton;
    private ImageView addButton;
    private ImageView completedButton;

    FetchData data = new FetchData();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_term_page);

        data.initGoals();
        initRecyclerView();

//        Adding ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

//        ----------------

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

//    ToolBar Function
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        logout();
        return super.onOptionsItemSelected(item);
    }


//    ----------------------------------------------------------


public void logout(){
    Intent intent = new Intent(this, MenuPage.class);
    startActivity(intent);
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
