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

public class RecyclerViewShortTermGoals extends RecyclerView.Adapter<RecyclerViewShortTermGoals.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<Integer> ParentGoalID = new ArrayList<Integer>();
    private ArrayList<String> ShortGoalTitle = new ArrayList<>();
    private ArrayList<String> ShortGoalDescription = new ArrayList<>();
    private ArrayList<String> ShortGoalDeadline = new ArrayList<>();
    private ArrayList<Integer> ShortGoalstatus = new ArrayList<Integer>();
    private Integer Category;

    FetchData data = new FetchData();

    public RecyclerViewShortTermGoals(ShortTermPage shortTermPage, Integer mCategory,ArrayList<Integer> parentGoalID, ArrayList<String> shortGoalTitle, ArrayList<String> shortGoalDescription, ArrayList<String> shortGoalDeadline, ArrayList<Integer> shortGoalstatus) {
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

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_short_term_card, viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        data.initShortGoalsFinances();

        viewHolder.ShortGoalTitle.setText(ShortGoalTitle.get(position));
        viewHolder.ShortGoalDescription.setText(ShortGoalDescription.get(position));
        viewHolder.ShortGoalDeadline.setText(ShortGoalDeadline.get(position));

//            Changing background color, StarIcon Image, and calendar Icon in case the card is Active and Health Category
        if(Category == 1 && ShortGoalstatus.get(position) == 0) {

            data.initShortGoalsHealth();

            viewHolder.ShortGoalstatus.setText("ON GOING");
            viewHolder.shortTermCardBackground.setBackgroundColor(Color.parseColor("#5DC8E2"));
            viewHolder.starIcon.setImageResource(R.drawable.star_active);
            viewHolder.calendarIcon.setImageResource(R.drawable.calelndar_icon_light);
        }
        //            Changing background color, StarIcon Image, and calendar Icon in case the card is Active and Finances Category
        if(Category == 2 && ShortGoalstatus.get(position) == 0) {
//            data.initShortGoalsFinances();

            viewHolder.ShortGoalstatus.setText("ON GOING");
            viewHolder.shortTermCardBackground.setBackgroundColor(Color.parseColor("#F89767"));
            viewHolder.starIcon.setImageResource(R.drawable.star_active);
            viewHolder.calendarIcon.setImageResource(R.drawable.calelndar_icon_light);
        }
        //            Changing background color, StarIcon Image, and calendar Icon in case the card is Active and Career Category
        if(Category == 3 && ShortGoalstatus.get(position) == 0) {

            viewHolder.ShortGoalstatus.setText("ON GOING");
            viewHolder.shortTermCardBackground.setBackgroundColor(Color.parseColor("#354AA4"));
            viewHolder.starIcon.setImageResource(R.drawable.star_active);
            viewHolder.calendarIcon.setImageResource(R.drawable.calelndar_icon_light);
        }
        //            Changing background color, StarIcon Image, and calendar Icon in case the card is Active and Fun and Recreaton Category
        if(Category == 4 && ShortGoalstatus.get(position) == 0) {

            viewHolder.ShortGoalstatus.setText("ON GOING");
            viewHolder.shortTermCardBackground.setBackgroundColor(Color.parseColor("#17E09D"));
            viewHolder.starIcon.setImageResource(R.drawable.star_active);
            viewHolder.calendarIcon.setImageResource(R.drawable.calelndar_icon_light);
        }
        //            Changing background color, StarIcon Image, and calendar Icon in case the card is Active and Personal Category
        if(Category == 5 && ShortGoalstatus.get(position) == 0) {

            viewHolder.ShortGoalstatus.setText("ON GOING");
            viewHolder.shortTermCardBackground.setBackgroundColor(Color.parseColor("#F15864"));
            viewHolder.starIcon.setImageResource(R.drawable.star_active);
            viewHolder.calendarIcon.setImageResource(R.drawable.calelndar_icon_light);
        }
        //            Changing background color, StarIcon Image, and calendar Icon in case the card is Active and Spiritual Category
        if(Category == 6 && ShortGoalstatus.get(position) == 0) {

            viewHolder.ShortGoalstatus.setText("ON GOING");
            viewHolder.shortTermCardBackground.setBackgroundColor(Color.parseColor("#796DB6"));
            viewHolder.starIcon.setImageResource(R.drawable.star_active);
            viewHolder.calendarIcon.setImageResource(R.drawable.calelndar_icon_light);
        }
//            Changing background color, StarIcon Image, and calendar Icon in case the card is Not Active
        if(ShortGoalstatus.get(position) == 1) {

            viewHolder.ShortGoalTitle.setTextColor(Color.parseColor("#54575D"));
            viewHolder.ShortGoalDescription.setTextColor(Color.parseColor("#54575D"));
            viewHolder.ShortGoalDeadline.setTextColor(Color.parseColor("#54575D"));
            viewHolder.ShortGoalstatus.setTextColor(Color.parseColor("#F4F4FC"));
            viewHolder.shortTermCardBackground.setBackgroundColor(Color.parseColor("#F4F4FC"));
            viewHolder.starIcon.setImageResource(R.drawable.star_icon);
        }
    }

    @Override
    public int getItemCount() {
        return ShortGoalTitle.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView ShortGoalTitle;
        TextView ShortGoalDescription;
        TextView ShortGoalDeadline;
        TextView ShortGoalstatus;
        ImageView starIcon;
        ImageView calendarIcon;
        LinearLayout shortTermCardBackground;

        public ViewHolder(View itemView) {
            super(itemView);

            ShortGoalTitle = itemView.findViewById(R.id.shortTermTitleCard);
            ShortGoalDescription = itemView.findViewById(R.id.shortTermDescriptionCard);
            ShortGoalDeadline = itemView.findViewById(R.id.shortTearmDeadlineCard);
            ShortGoalstatus = itemView.findViewById(R.id.statusCard);
            starIcon = itemView.findViewById(R.id.starIcon);
            calendarIcon = itemView.findViewById(R.id.calendarIcon);
            shortTermCardBackground = itemView.findViewById(R.id.shortTermCardBackground);
        }
    }
}


