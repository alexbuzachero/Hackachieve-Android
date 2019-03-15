package com.example.hackachieve;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.content.Context;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;


import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> CardTitle = new ArrayList<>();
    private ArrayList<String> GoalsCompleted = new ArrayList<>();
    private ArrayList<String> TotalGoals = new ArrayList<>();
    private ArrayList<String> DataCompleted = new ArrayList<>();
    private ArrayList<Integer> mBoard_id = new ArrayList<Integer>();
    private Context mContext;

   private ProgressBar progress;
//    private String iconCard;


    public RecyclerViewAdapter(LongTermPage longTermPage, ArrayList<String> cardTitle, ArrayList<String> goalsCompleted, ArrayList<String> totalGoals, ArrayList<String> dataCompleted, ArrayList<Integer> mBoard_id) {
        CardTitle = cardTitle;
        GoalsCompleted = goalsCompleted;
        TotalGoals = totalGoals;
        DataCompleted = dataCompleted;
        this.mBoard_id = mBoard_id;
        mContext = longTermPage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {



        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_long_term_card, viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

//        Taking the goals overall to insert in the progress bar
        Double gCompleted = Double.parseDouble(GoalsCompleted.get(position));
        Double tGoals = Double.parseDouble(TotalGoals.get(position));
        Double goalsResult = gCompleted / tGoals * 100;
        Integer progressCard = Integer.valueOf(goalsResult.intValue());

            viewHolder.cardTitle.setText(CardTitle.get(position));
            viewHolder.goalsCompleted.setText(GoalsCompleted.get(position));
            viewHolder.totalGoals.setText(TotalGoals.get(position));
            viewHolder.dateComplete.setText(DataCompleted.get(position));
            ViewHolder.progressBar.setProgress(progressCard);
            Log.d("ProgressCard", String.valueOf(progressCard));

        if(mBoard_id.get(position) == 1) {

            viewHolder.categoryLabel.setText("HEALTH");
            viewHolder.backgroundHeader.setBackgroundColor(Color.parseColor("#5DC8E2"));
            viewHolder.iconCard.setImageResource(R.drawable.health_icon_color);
            viewHolder.categoryLabel.setTextColor(Color.parseColor("#5DC8E2"));

            viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openShortGoalsPageHealth();
                }
            });
        }
        if(mBoard_id.get(position) == 2) {

            viewHolder.categoryLabel.setText("FINANCES");
            viewHolder.backgroundHeader.setBackgroundColor(Color.parseColor("#F89767"));
            viewHolder.iconCard.setImageResource(R.drawable.finances_icon_color);
            viewHolder.categoryLabel.setTextColor(Color.parseColor("#F89767"));

            viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openShortGoalsPageFinance();
                }
            });

        }
        if(mBoard_id.get(position) == 3) {

            viewHolder.categoryLabel.setText("CAREER");
            viewHolder.backgroundHeader.setBackgroundColor(Color.parseColor("#354AA4"));
            viewHolder.iconCard.setImageResource(R.drawable.career_icon_color);
            viewHolder.categoryLabel.setTextColor(Color.parseColor("#354AA4"));

            viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openShortGoalsPageCareer();
                }
            });
        }
        if(mBoard_id.get(position) == 4) {

            viewHolder.categoryLabel.setText("FUN AND RECREATION");
            viewHolder.backgroundHeader.setBackgroundColor(Color.parseColor("#17E09D"));
            viewHolder.iconCard.setImageResource(R.drawable.fun_icon_color);
            viewHolder.categoryLabel.setTextColor(Color.parseColor("#17E09D"));

            viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openShortGoalsPageFun();
                }
            });
        }
        if(mBoard_id.get(position) == 5) {

            viewHolder.categoryLabel.setText("PERSONAL DEVELOPMENT");
            viewHolder.backgroundHeader.setBackgroundColor(Color.parseColor("#F15864"));
            viewHolder.iconCard.setImageResource(R.drawable.personal_dev_icon_color);
            viewHolder.categoryLabel.setTextColor(Color.parseColor("#F15864"));

            viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openShortGoalsPagePersonalDev();
                }
            });
        }
        if(mBoard_id.get(position) == 6) {

            viewHolder.categoryLabel.setText("SPIRITUAL");
            viewHolder.backgroundHeader.setBackgroundColor(Color.parseColor("#796DB6"));
            viewHolder.iconCard.setImageResource(R.drawable.spiritual_icon_color);
            viewHolder.categoryLabel.setTextColor(Color.parseColor("#796DB6"));

            viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openShortGoalsPageSpiritual();
                }
            });
        }

//       Add card listener Holder
    }

    @Override
    public int getItemCount() {
        return CardTitle.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public static ProgressBar progressBar;
        TextView cardTitle;
        TextView goalsCompleted;
        TextView totalGoals;
        TextView dateComplete;
        ImageView iconCard;
        GridLayout backgroundHeader;
        TextView categoryLabel;
        LinearLayout parentLayout;



        //        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            cardTitle = itemView.findViewById(R.id.cardTitle);
            goalsCompleted = itemView.findViewById(R.id.goalsCompleted);
            totalGoals = itemView.findViewById(R.id.totalGoals);
            dateComplete = itemView.findViewById(R.id.dateComplete);
            iconCard = itemView.findViewById(R.id.iconCard);
            backgroundHeader = itemView.findViewById(R.id.backgroundHeader);
            categoryLabel = itemView.findViewById(R.id.categoryLabel);
            progressBar = itemView.findViewById(R.id.progressBar);

            parentLayout = itemView.findViewById(R.id.longTermCardHealth);
        }
    }

            public void openShortGoalsPageHealth(){
            Intent intent = new Intent(mContext, ShortTermPageHealth.class);
            mContext.startActivity(intent);
//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

    public void openShortGoalsPageFinance(){
        Intent intent = new Intent(mContext, ShortTermPageFinance.class);
        mContext.startActivity(intent);
//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openShortGoalsPageFun(){
        Intent intent = new Intent(mContext, ShortTermPageFun.class);
        mContext.startActivity(intent);
//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openShortGoalsPageCareer(){
        Intent intent = new Intent(mContext, ShortTermPageCareer.class);
        mContext.startActivity(intent);
//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openShortGoalsPagePersonalDev(){
        Intent intent = new Intent(mContext, ShortTermPagePersonalDev.class);
        mContext.startActivity(intent);
//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openShortGoalsPageSpiritual(){
        Intent intent = new Intent(mContext, ShortTermPageSpiritual.class);
        mContext.startActivity(intent);
//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
