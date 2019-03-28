package com.example.hackachieve;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        Category = extras.getInt("CATEGORY");
        Title = extras.getString("PAGETITLE");

        Log.d("CategoryPage", String.valueOf(Category));
        Log.d("CategoryPage", Title );


        if (Category == 1){
            Log.d("ENTER", "01" );
            categoryLabel.setText("HEALTH");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.health_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#5DC8E2"));

            data.initShortGoalsHealth();
        }
        if (Category == 2){
            Log.d("ENTER", "02" );
            categoryLabel.setText("FINANCES");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.finances_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#F89767"));

            data.initShortGoalsFinances();
        }
        if (Category == 3){
            Log.d("ENTER", "03" );
            categoryLabel.setText("CAREER");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.career_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#354AA4"));

            data.initShortGoalsCareer();
        }
        if (Category == 4){
            categoryLabel.setText("FUN AND RECREATION");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.fun_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#17E09D"));

            data.initShortGoalsFun();
        }
        if (Category == 5){
            categoryLabel.setText("PERSONAL DEVELOPMENT");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.personal_dev_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#F15864"));

            data.initShortGoalsPersonal();
        }
        if (Category == 6){
            categoryLabel.setText("SPIRITUAL");
            pageTitle.setText(Title);
            headerIcon.setImageResource(R.drawable.spiritual_icon);
            headerBackground.setBackgroundColor(Color.parseColor("#796DB6"));

            data.initShortGoalsSpiritual();
        }

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
}
