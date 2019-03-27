package com.example.hackachieve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class InitialCategoryScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_category_screen);

        LinearLayout registerCategory = (LinearLayout) findViewById(R.id.categoryContainer);

        registerCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterScreen();
            }
        });
    }
    public void openRegisterScreen(){
        Intent intent = new Intent(this, RegisterMainGoal.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_up, R.anim.static_position);
    }
}
