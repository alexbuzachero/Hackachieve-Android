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

    //        Creating longTermCardVariable(one variable for each card)
//    private CardView longTermFitness;
//    private CardView longTermFinance;
    private ImageView ongoingButton;
    private ImageView addButton;
    private ImageView completedButton;

    //vars
    private ArrayList<String> mCardTitle = new ArrayList<>();
    private ArrayList<String> mGoalsCompleted = new ArrayList<>();
    private ArrayList<String> mTotalGoals = new ArrayList<>();
    private ArrayList<String> mDataCompleted = new ArrayList<>();
    private ArrayList<Integer> mBoard_id = new ArrayList<Integer>();



//    public void writeJSON() {
//        JSONObject card1 = new JSONObject();
//        try {
//            card1.put("days_to_complete", 8);
//            card1.put("user_id", 1);
//            card1.put("deadline", "2019-03-14T16:36:25.019Z");
//            card1.put("total_completed_goals", 3);
//            card1.put("name", "Jack Hack");
//            card1.put("id", "Lose 10kg in 20 days");
//            card1.put("total_goals", 1);
//            card1.put("board_description", "Goals to get in shape until the summer");
//            card1.put("board_id", 2);
//            card1.put("board_name", "Health");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//
//        JSONObject card2 = new JSONObject();
//        try {
//            card2.put("days_to_complete", 8);
//            card2.put("user_id", 1);
//            card2.put("deadline", "2019-03-14T16:36:25.019Z");
//            card2.put("total_completed_goals", 3);
//            card2.put("name", "Jack Hack");
//            card2.put("id", "Lose 10kg in 20 days");
//            card2.put("total_goals", 1);
//            card2.put("board_description", "Goals to get in shape until the summer");
//            card2.put("board_id", 2);
//            card2.put("board_name", "Health");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        JSONArray jsonArray = new JSONArray();
//
//        jsonArray.put(card1);
//        jsonArray.put(card2);
//    }

//    String json_string =
//            "[{\n" +
//            "  \"days_to_complete\":8,\n" +
//            "  \"user_id\":1,\n" +
//            "    \"deadline\":\"2019-03-14T16:36:25.019Z\"\n" +
//            "  \"total_completed_goals\":3,\n" +
//            "    \"name\":\"Lose 10kg in 20 days\"\n" +
//            "  \"id\":1,\n" +
//            "  \"total_goals\":5,\n" +
//            "    \"board_description\":\"Goals to get in shape until the summer\"\n" +
//            "  \"board_id\":2,\n" +
//            "    \"board_name\":\"Health\"\n" +
//            "    },\n" +
//            "{\n" +
//            "  \"days_to_complete\":8,\n" +
//            "  \"user_id\":1,\n" +
//            "    \"deadline\":\"2019-03-14T16:36:25.019Z\"\n" +
//            "  \"total_completed_goals\":3,\n" +
//            "    \"name\":\"Lose 10kg in 20 days\"\n" +
//            "  \"id\":1,\n" +
//            "  \"total_goals\":5,\n" +
//            "    \"board_description\":\"Goals to get in shape until the summer\"\n" +
//            "  \"board_id\":2,\n" +
//            "    \"board_name\":\"Health\"\n" +
//            "}]";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_term_page);

        initVars();

//        JSONObject card1 = new JSONObject();
//        try {
//            card1.put("days_to_complete", 8);
//            card1.put("user_id", 1);
//            card1.put("deadline", "2019-03-14T16:36:25.019Z");
//            card1.put("total_completed_goals", 3);
//            card1.put("name", "Jack Hack");
//            card1.put("id", "Lose 10kg in 20 days");
//            card1.put("total_goals", 1);
//            card1.put("board_description", "Goals to get in shape until the summer");
//            card1.put("board_id", 2);
//            card1.put("board_name", "Health");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        JSONObject card2 = new JSONObject();
//        try {
//            card2.put("days_to_complete", 8);
//            card2.put("user_id", 1);
//            card2.put("deadline", "2019-03-14T16:36:25.019Z");
//            card2.put("total_completed_goals", 3);
//            card2.put("name", "Jack Hack");
//            card2.put("id", "Lose 10kg in 20 days");
//            card2.put("total_goals", 1);
//            card2.put("board_description", "Goals to get in shape until the summer");
//            card2.put("board_id", 2);
//            card2.put("board_name", "Health");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.put(card1);
//        jsonArray.put(card2);




//        Defining Cards
        // longTermFitness = (CardView) findViewById(R.id.longTermFitnessID);
        //  longTermFinance = (CardView) findViewById(R.id.financeID);
        ongoingButton = (ImageView) findViewById(R.id.ongoingIcon);
        addButton = (ImageView) findViewById(R.id.addIcon);
        completedButton = (ImageView) findViewById(R.id.completedIcon);

        //        Add Click listener to the cards
//        longTermFitness.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openShortGoalsPage();
//            }
//        });
//        longTermFinance.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openShortGoalsPageFinance();
//            }
//        });
        completedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLongTermGoalsCompleted();
            }
        });



    }

//        public void openShortGoalsPage(){
//            Intent intent = new Intent(this, ShortTermPageHealth.class);
//            startActivity(intent);
//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//        }
//
//    public void openShortGoalsPageFinance(){
//        Intent intent = new Intent(this, ShortTermPageFinance.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//    }

    public void openLongTermGoalsCompleted(){
        Intent intent = new Intent(this, LongTermPageCompleted.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void initVars(){
//        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mCardTitle.add("Lost 5 kilos");
        mGoalsCompleted.add("3");
        mTotalGoals.add("9");
        mDataCompleted.add("2019-01-14T16:36:25.019Z");
        mBoard_id.add(1);

        mCardTitle.add("Invest money in Bitcoins");
        mGoalsCompleted.add("3");
        mTotalGoals.add("9");
        mDataCompleted.add("2019-02-14T16:36:25.019Z");
        mBoard_id.add(2);

        mCardTitle.add("Updtate my Linkdin Account");
        mGoalsCompleted.add("1");
        mTotalGoals.add("8");
        mDataCompleted.add("2019-05-14T16:36:25.019Z");
        mBoard_id.add(3);

        mCardTitle.add("Learn Snowboard");
        mGoalsCompleted.add("2");
        mTotalGoals.add("7");
        mDataCompleted.add("2019-08-14T16:36:25.019Z");
        mBoard_id.add(4);

        mCardTitle.add("Learn VR concept");
        mGoalsCompleted.add("5");
        mTotalGoals.add("6");
        mDataCompleted.add("2019-04-14T16:36:25.019Z");
        mBoard_id.add(5);

        mCardTitle.add("Learn Indu Lessons");
        mGoalsCompleted.add("3");
        mTotalGoals.add("9");
        mDataCompleted.add("2019-04-14T16:36:25.019Z");
        mBoard_id.add(6);

        initRecyclerView();
    }

    private void initRecyclerView(){
//        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mCardTitle, mGoalsCompleted,mTotalGoals,mDataCompleted, mBoard_id);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
