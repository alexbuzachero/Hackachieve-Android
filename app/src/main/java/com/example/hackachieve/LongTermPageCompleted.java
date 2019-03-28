package com.example.hackachieve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LongTermPageCompleted extends AppCompatActivity {

    //        Creating longTermCardVariable(one variable for each card)
    private ImageView ongoingButton;
    private ImageView addButton;
    private TextView pageTitle;

    FetchData data = new FetchData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_term_page_completed);

        data.initGoalsCompleted();
        initRecyclerView();

        //        Adding ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        TextView pageTitle = (TextView) findViewById(R.id.pageTitle);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
//        pageTitle.setText("Main Goals Completed");
//        ----------------

        ongoingButton = (ImageView) findViewById(R.id.ongoingIcon);
        ongoingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLongTermGoals();
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

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
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
