package com.example.hackachieve;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private Button regButton;
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Button to forward to LongTermGoals page
        loginButton = (Button) findViewById(R.id.loginButton);
//      Button to forward to registration page
        regButton = (Button) findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLongTermGoals();
            }
        });



//    ======================================================================================================================================================
//        Using ION - Source: https://stackoverflow.com/questions/28549315/login-example-in-android-using-post-method-using-rest-api
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Ion.with(getApplicationContext())
//                        .load("http://13.57.134.199:8000/api/token/")
//                        .setBodyParameter("email", "joaopaulofurtado@live.com")
//                        .setBodyParameter("password", "123")
//                        .asString()
//                        .setCallback(new FutureCallback<String>() {
//                            @Override
//                            public void onCompleted(Exception e, String result) {
//                                try {
//
//                                    JSONObject json = new JSONObject(result);    // Converts the string "result" to a JSONObject
//                                    String json_result = null; // Get the string "result" inside the Json-object
//                                    try {
//                                        json_result = json.getString("result");
//                                    } catch (JSONException e1) {
//                                        e1.printStackTrace();
//                                    }
//                                    if (json_result.equalsIgnoreCase("ok")){ // Checks if the "result"-string is equals to "ok"
//                                        // Result is "OK"
////                                        int customer_id = json.getInt("customer_id"); // Get the int customer_id
////                                        String customer_email = json.getString("customer_email"); // I don't need to explain this one, right?
//                                        openLongTermGoals();
//
//                                    } else {
//                                        // Result is NOT "OK"
//                                        String error = json.getString("error");
//                                        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show(); // This will show the user what went wrong with a toast
//                                        Intent to_main = new Intent(getApplicationContext(), MainActivity.class); // New intent to MainActivity
//                                        startActivity(to_main); // Starts MainActivity
//                                        finish(); // Add this to prevent the user to go back to this activity when pressing the back button after we've opened MainActivity
//                                    }
//                                } catch (JSONException f){
//                                    // This method will run if something goes wrong with the json, like a typo to the json-key or a broken JSON.
////                                    Log.e(TAG, f.getMessage());
////                                    Toast.makeText(getApplicationContext(), "Please check your internet connection.", Toast.LENGTH_LONG).show();
//                                }
//                            }
//                        });
//            }
//        });
//     ========================================================================================================================================================================================


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterPage();
            }
        });
    }

    public void openRegisterPage(){
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }
    public void openLongTermGoals(){
        Intent intent = new Intent(this, LongTermPage.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

}
