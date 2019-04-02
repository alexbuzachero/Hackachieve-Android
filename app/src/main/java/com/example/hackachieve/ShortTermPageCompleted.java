package com.example.hackachieve;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ShortTermPageCompleted extends AppCompatActivity {

    FetchData data = new FetchData();

    private TextView categoryLabel;
    private TextView pageTitle;
    private ImageView headerIcon;
    private GridLayout headerBackground;

    private Integer Category;
    private String Title;

    private ImageView ongoingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_term_page_completed);

        categoryLabel = (TextView) findViewById(R.id.categoryLabel);
        pageTitle = (TextView) findViewById(R.id.cardTitle);
        headerIcon = (ImageView) findViewById(R.id.headerIcon);
        headerBackground = (GridLayout) findViewById(R.id.headerBackground);



        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        //        Getting the Category and Pagetitle information to passed my previous activity

        Category = extras.getInt("CATEGORY");
        Title = extras.getString("PAGETITLE");

        //            Changing Title, Subtitle, background color, Category Icon and loading the correspodent short term goals in case to be Health Category
        if (Category == 1){
            categoryLabel.setText("HEALTH");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.health_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#5DC8E2"));

            data.initShortGoalsCompletedHealth();
        }
        //            Changing Title, Subtitle, background color, Category Icon and loading the correspodent short term goals in case to be Finances Category
        if (Category == 2){
            categoryLabel.setText("FINANCES");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.finances_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#F89767"));

            data.initShortGoalsCompletedFinances();
        }
//            Changing Title, Subtitle, background color, Category Icon and loading the correspodent short term goals in case to be Career Category
        if (Category == 3){
            categoryLabel.setText("CAREER");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.career_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#354AA4"));

            data.initShortGoalsCompletedCareer();
        }
        //            Changing Title, Subtitle, background color, Category Icon and loading the correspodent short term goals in case to be Fun and Recreation Category
        if (Category == 4){
            categoryLabel.setText("FUN AND RECREATION");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.fun_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#17E09D"));

            data.initShortGoalsCompletedFun();
        }
        //            Changing Title, Subtitle, background color, Category Icon and loading the correspodent short term goals in case to be Personal Category
        if (Category == 5){
            categoryLabel.setText("PERSONAL DEVELOPMENT");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.personal_dev_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#F15864"));

            data.initShortGoalsCompletedPersonal();
        }
        //            Changing Title, Subtitle, background color, Category Icon and loading the correspodent short term goals in case to be Spiritual Category
        if (Category == 6){
            categoryLabel.setText("SPIRITUAL");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.spiritual_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#796DB6"));

            data.initShortGoalsCompletedSpiritual();
        }

        initRecyclerView();

        ongoingButton = (ImageView) findViewById(R.id.ongoingIcon);
        ongoingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewShortTermGoalsCompleted adapter = new RecyclerViewShortTermGoalsCompleted(this, Category, data.getParentGoalID(), data.getShortGoalTitle(),data.getShortGoalDescription(),data.getShortGoalDeadline(), data.getShortGoalstatus());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
