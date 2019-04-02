package com.example.hackachieve;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewShortTermGoalsCompleted extends RecyclerView.Adapter<RecyclerViewShortTermGoalsCompleted.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<Integer> ParentGoalID = new ArrayList<Integer>();
    private ArrayList<String> ShortGoalTitle = new ArrayList<>();
    private ArrayList<String> ShortGoalDescription = new ArrayList<>();
    private ArrayList<String> ShortGoalDeadline = new ArrayList<>();
    private ArrayList<Integer> ShortGoalstatus = new ArrayList<Integer>();
    private Integer Category;

    FetchData data = new FetchData();

    public RecyclerViewShortTermGoalsCompleted(ShortTermPageCompleted shortTermPage, Integer mCategory, ArrayList<Integer> parentGoalID, ArrayList<String> shortGoalTitle, ArrayList<String> shortGoalDescription, ArrayList<String> shortGoalDeadline, ArrayList<Integer> shortGoalstatus) {
        ParentGoalID = parentGoalID;
        ShortGoalTitle = shortGoalTitle;
        ShortGoalDescription = shortGoalDescription;
        ShortGoalDeadline = shortGoalDeadline;
        ShortGoalstatus = shortGoalstatus;
        Category = mCategory;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_short_term_card_completed, viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.ShortGoalTitle.setText(ShortGoalTitle.get(position));
        viewHolder.ShortGoalDescription.setText(ShortGoalDescription.get(position));
        viewHolder.ShortGoalDeadline.setText(ShortGoalDeadline.get(position));
    }

    @Override
    public int getItemCount() {
        return ShortGoalTitle.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView ShortGoalTitle;
        TextView ShortGoalDescription;
        TextView ShortGoalDeadline;

        public ViewHolder(View itemView) {
            super(itemView);

            ShortGoalTitle = itemView.findViewById(R.id.shortTermTitleCard);
            ShortGoalDescription = itemView.findViewById(R.id.shortTermDescriptionCard);
            ShortGoalDeadline = itemView.findViewById(R.id.shortTearmDeadlineCard);
        }
    }
}


