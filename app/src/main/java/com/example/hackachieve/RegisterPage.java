package com.example.hackachieve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        Button registerButton = (Button) findViewById(R.id.registerConfirmButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategoryScreen();
            }
        });
    }
    public void openCategoryScreen(){
        Intent intent = new Intent(this, InitialCategoryScreen.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_up, R.anim.static_position);
    }
}
