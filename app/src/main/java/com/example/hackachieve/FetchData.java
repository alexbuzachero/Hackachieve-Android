package com.example.hackachieve;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

//Video Tutorial: https://www.youtube.com/watch?v=Vcn4OuV4Ixg

public class FetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataParsec = "";
    String singleParsed = "";

//    Database Data

    //Long Term Goals Variables
    private ArrayList<String> CardTitle = new ArrayList<>();
    private ArrayList<String> GoalsCompleted = new ArrayList<>();
    private ArrayList<String> TotalGoals = new ArrayList<>();
    private ArrayList<String> DataCompleted = new ArrayList<>();
    private ArrayList<Integer> Board_id = new ArrayList<Integer>();

    //Short Term Goals Variables

    private ArrayList<Integer> ParentGoalID = new ArrayList<Integer>();
    private ArrayList<String> ShortGoalTitle = new ArrayList<>();
    private ArrayList<String> ShortGoalDescription = new ArrayList<>();
    private ArrayList<String> ShortGoalDeadline = new ArrayList<>();
    private ArrayList<Integer> ShortGoalstatus = new ArrayList<Integer>();

//    Getting Long Term goals variables content

    public ArrayList<String> getCardTitle() {
        return CardTitle;
    }
    public ArrayList<String> getGoalsCompleted() {
        return GoalsCompleted;
    }
    public ArrayList<String> getTotalGoals() {
        return TotalGoals;
    }
    public ArrayList<String> getDataCompleted() {
        return DataCompleted;
    }
    public ArrayList<Integer> getBoard_id() {
        return Board_id;
    }

    //    Getting Short Term goals variables content


    public ArrayList<Integer> getParentGoalID() {
        return ParentGoalID;
    }

    public ArrayList<String> getShortGoalTitle() {
        return ShortGoalTitle;
    }

    public ArrayList<String> getShortGoalDescription() {
        return ShortGoalDescription;
    }

    public ArrayList<String> getShortGoalDeadline() {
        return ShortGoalDeadline;
    }

    public ArrayList<Integer> getShortGoalstatus() {
        return ShortGoalstatus;
    }

//    Getters Long Term Goals Variables


    public void setCardTitle(String cardTitle) {
        CardTitle.add(cardTitle);
    }

    public void setGoalsCompleted(String goalsCompleted) {
        GoalsCompleted.add(goalsCompleted);
    }

    public void setTotalGoals(String totalGoals) {
        TotalGoals.add(totalGoals);
    }

    public void setDataCompleted(String dataCompleted) {
        DataCompleted.add(dataCompleted);
    }

    public void setBoard_id(Integer board_id) {
        Board_id.add(board_id);
    }


    //    Initialzing the variables with the user content
    public void initGoals(){

        CardTitle.add("Loose Weight until fall");
        GoalsCompleted.add("2");
        TotalGoals.add("7");
        DataCompleted.add("September 01");
        Board_id.add(1);


        CardTitle.add("Invest in Bitcoins");
        GoalsCompleted.add("1");
        TotalGoals.add("6");
        DataCompleted.add("August 15");
        Board_id.add(2);


        CardTitle.add("Updtate my Resume");
        GoalsCompleted.add("3");
        TotalGoals.add("8");
        DataCompleted.add("April 29");
        Board_id.add(3);


        CardTitle.add("Learn Snowboard");
        GoalsCompleted.add("1");
        TotalGoals.add("6");
        DataCompleted.add("November 02");
        Board_id.add(4);


        CardTitle.add("Learn Javascript");
        GoalsCompleted.add("3");
        TotalGoals.add("5");
        DataCompleted.add("June 01");
        Board_id.add(5);


        CardTitle.add("Learn Indu Lessons");
        GoalsCompleted.add("1");
        TotalGoals.add("6");
        DataCompleted.add("May 28");
        Board_id.add(6);

    }

    //    Initialzing the variables with the user content
    public void initGoalsCompleted(){

        CardTitle.add("Prepare to Marathom");
        GoalsCompleted.add("7");
        TotalGoals.add("7");
        DataCompleted.add("February 02");
        Board_id.add(1);

        CardTitle.add("Invest in Bank Account");
        GoalsCompleted.add("4");
        TotalGoals.add("4");
        DataCompleted.add("January 30");
        Board_id.add(3);

        CardTitle.add("Invest in Bitcoins");
        GoalsCompleted.add("3");
        TotalGoals.add("3");
        DataCompleted.add("February 28");
        Board_id.add(3);

        CardTitle.add("Study React");
        GoalsCompleted.add("2");
        TotalGoals.add("2");
        DataCompleted.add("March 10");
        Board_id.add(4);
    }

    //    Initialzing the variables with the user content

    public void initShortGoalsHealth(){

        ParentGoalID.add(1);
        ShortGoalTitle.add("Work out during the week");
        ShortGoalDescription.add("Work out at least 3 times during the week");
        ShortGoalDeadline.add("August 29");
        ShortGoalstatus.add(0);

        ParentGoalID.add(1);
        ShortGoalTitle.add("Drink vegetables juice");
        ShortGoalDescription.add("Every breakfast drink vegetables juice to help to loose weight");
        ShortGoalDeadline.add("August 29");
        ShortGoalstatus.add(0);

        ParentGoalID.add(1);
        ShortGoalTitle.add("Walk to job");
        ShortGoalDescription.add("Go to job walking at least twince per week");
        ShortGoalDeadline.add("September 01");
        ShortGoalstatus.add(0);

        ParentGoalID.add(1);
        ShortGoalTitle.add("Buy a bike");
        ShortGoalDescription.add("Buy a new bike to exercise during the evening");
        ShortGoalDeadline.add("June 10");
        ShortGoalstatus.add(1);

        ParentGoalID.add(1);
        ShortGoalTitle.add("Check-up Exam");
        ShortGoalDescription.add("Do a check-up exam after I started workout");
        ShortGoalDeadline.add("May 1");
        ShortGoalstatus.add(1);

    }

    public void initShortGoalsFinances(){

        ParentGoalID.add(2);
        ShortGoalTitle.add("Buy Bitcoins");
        ShortGoalDescription.add("Buy new Bitcoins every week from different places");
        ShortGoalDeadline.add("August 15");
        ShortGoalstatus.add(0);

        ParentGoalID.add(2);
        ShortGoalTitle.add("Sell Bitcoins");
        ShortGoalDescription.add("Sell Bitcoins when the valur is better then I bought");
        ShortGoalDeadline.add("July 15");
        ShortGoalstatus.add(0);

        ParentGoalID.add(2);
        ShortGoalTitle.add("Learn how invest Bitcoins");
        ShortGoalDescription.add("Learn about the different way to invest Bitcoins");
        ShortGoalDeadline.add("July 25");
        ShortGoalstatus.add(1);

        ParentGoalID.add(2);
        ShortGoalTitle.add("Find where buy Bitcoins");
        ShortGoalDescription.add("Search a safety place to buy Bitcoins");
        ShortGoalDeadline.add("June 10");
        ShortGoalstatus.add(1);

        ParentGoalID.add(2);
        ShortGoalTitle.add("Learn about Bitcoins");
        ShortGoalDescription.add("Study the basis about Bitcoins and how it works");
        ShortGoalDeadline.add("May 01");
        ShortGoalstatus.add(1);

    }

    public void initShortGoalsCareer(){

        ParentGoalID.add(3);
        ShortGoalTitle.add("Update my LinkdIn");
        ShortGoalDescription.add("Update my LinkdIn profile accordly with my resume");
        ShortGoalDeadline.add("April 06");
        ShortGoalstatus.add(0);

        ParentGoalID.add(3);
        ShortGoalTitle.add("Change the Resume layout");
        ShortGoalDescription.add("Modify my resume layout following the canada resumes");
        ShortGoalDeadline.add("April 20");
        ShortGoalstatus.add(0);

        ParentGoalID.add(3);
        ShortGoalTitle.add("Change my Skills");
        ShortGoalDescription.add("Update my skills sections putting my IT skills in evidence");
        ShortGoalDeadline.add("April 07");
        ShortGoalstatus.add(1);

        ParentGoalID.add(3);
        ShortGoalTitle.add("Clear redundant information");
        ShortGoalDescription.add("Analize all resume and delete any redundant information");
        ShortGoalDeadline.add("April 28");
        ShortGoalstatus.add(1);

        ParentGoalID.add(3);
        ShortGoalTitle.add("Add Education");
        ShortGoalDescription.add("Update my Education with my last graduation");
        ShortGoalDeadline.add("April 29");
        ShortGoalstatus.add(1);

    }

    public void initShortGoalsFun(){

        ParentGoalID.add(4);
        ShortGoalTitle.add("Learn Carving");
        ShortGoalDescription.add("Learn how to do carving to control the speed and direction");
        ShortGoalDeadline.add("August 05");
        ShortGoalstatus.add(0);

        ParentGoalID.add(4);
        ShortGoalTitle.add("Learn Jumps");
        ShortGoalDescription.add("Learn how to do small jumps and dont loose the snowboard control");
        ShortGoalDeadline.add("November 01");
        ShortGoalstatus.add(0);

        ParentGoalID.add(4);
        ShortGoalTitle.add("Training speedy");
        ShortGoalDescription.add("Learn how to control the speedy in diferent directions");
        ShortGoalDeadline.add("July 02");
        ShortGoalstatus.add(0);

        ParentGoalID.add(4);
        ShortGoalTitle.add("Controling the directions");
        ShortGoalDescription.add("Learn how to move in both sides using the body weight");
        ShortGoalDeadline.add("May 28");
        ShortGoalstatus.add(0);

        ParentGoalID.add(4);
        ShortGoalTitle.add("Learn how to fall");
        ShortGoalDescription.add("Learn and practcing all fall without hurt yourself");
        ShortGoalDeadline.add("May 02");
        ShortGoalstatus.add(1);

    }

    public void initShortGoalsPersonal(){

        ParentGoalID.add(5);
        ShortGoalTitle.add("Learn about functions");
        ShortGoalDescription.add("Understand all call functions and interact with variables");
        ShortGoalDeadline.add("May 28");
        ShortGoalstatus.add(0);

        ParentGoalID.add(5);
        ShortGoalTitle.add("Understanding Libraries");
        ShortGoalDescription.add("Learn about the main libraries and how using them can facilitade the developer work");
        ShortGoalDeadline.add("June 01");
        ShortGoalstatus.add(1);
    }

    public void initShortGoalsSpiritual(){

        ParentGoalID.add(6);
        ShortGoalTitle.add("Study the main concepts");
        ShortGoalDescription.add("Learn the main concepts about Indu");
        ShortGoalDeadline.add("April 26");
        ShortGoalstatus.add(0);

        ParentGoalID.add(6);
        ShortGoalTitle.add("Aplying the fundaments");
        ShortGoalDescription.add("Use the main points of Induism to equalize my personal life");
        ShortGoalDeadline.add("April 15");
        ShortGoalstatus.add(0);

        ParentGoalID.add(6);
        ShortGoalTitle.add("Study about the Induism story");
        ShortGoalDescription.add("Understand how this religion started and the benefities");
        ShortGoalDeadline.add("May 03");
        ShortGoalstatus.add(0);

        ParentGoalID.add(6);
        ShortGoalTitle.add("Equalizing the life");
        ShortGoalDescription.add("How to use the Indu practice to find the interior peace");
        ShortGoalDeadline.add("May 15");
        ShortGoalstatus.add(1);

        ParentGoalID.add(6);
        ShortGoalTitle.add("Visit Indu temple");
        ShortGoalDescription.add("Search the main Indu temples around the world and choose one to visit");
        ShortGoalDeadline.add("May 28");
        ShortGoalstatus.add(1);

    }

//    Short Goals completed Data

    public void initShortGoalsCompletedHealth(){

        ParentGoalID.add(1);
        ShortGoalTitle.add("Buy gym shoes");
        ShortGoalDescription.add("Buy a new shoes to workout and to run outside");
        ShortGoalDeadline.add("March 01");
        ShortGoalstatus.add(0);

        ParentGoalID.add(1);
        ShortGoalTitle.add("Enroll in the gym");
        ShortGoalDescription.add("Enroll in the gym to start work out activities");
        ShortGoalDeadline.add("March 05");
        ShortGoalstatus.add(0);
    }

    public void initShortGoalsCompletedFinances(){

        ParentGoalID.add(2);
        ShortGoalTitle.add("Buy first Bitcoins");
        ShortGoalDescription.add("Ask help to Brad about how buy Bitcoins and purchase my first virtual coins");
        ShortGoalDeadline.add("March 20");
        ShortGoalstatus.add(0);
    }

    public void initShortGoalsCompletedCareer(){

        ParentGoalID.add(3);
        ShortGoalTitle.add("Contract a Resume review");
        ShortGoalDescription.add("Contract a sercie to review my resume and show me the main points to change");
        ShortGoalDeadline.add("February 02");
        ShortGoalstatus.add(0);

        ParentGoalID.add(3);
        ShortGoalTitle.add("Remove Resume picture");
        ShortGoalDescription.add("Remove my resume picture following the Canada good practices");
        ShortGoalDeadline.add("February 28");
        ShortGoalstatus.add(0);

        ParentGoalID.add(3);
        ShortGoalTitle.add("Create a LinkdIn account");
        ShortGoalDescription.add("Create a LinkdIn account to insert my data and create my online resume");
        ShortGoalDeadline.add("March 22");
        ShortGoalstatus.add(1);
    }

    public void initShortGoalsCompletedFun(){

        ParentGoalID.add(4);
        ShortGoalTitle.add("Buy a snowboard");
        ShortGoalDescription.add("Research and buy a beginer snowboard to start the snowboard lessons");
        ShortGoalDeadline.add("February 26");
        ShortGoalstatus.add(0);
    }

    public void initShortGoalsCompletedPersonal(){

        ParentGoalID.add(5);
        ShortGoalTitle.add("Learn Javascript basis");
        ShortGoalDescription.add("Understanding the basis about the language");
        ShortGoalDeadline.add("February 02");
        ShortGoalstatus.add(0);

        ParentGoalID.add(5);
        ShortGoalTitle.add("How use variables");
        ShortGoalDescription.add("How declare variables in Javascript and update them");
        ShortGoalDeadline.add("March 02");
        ShortGoalstatus.add(1);

        ParentGoalID.add(5);
        ShortGoalTitle.add("Inserting external libraries");
        ShortGoalDescription.add("How to insert external libraries in Javascript");
        ShortGoalDeadline.add("March 06");
        ShortGoalstatus.add(1);
    }

    public void initShortGoalsCompletedSpiritual(){

        ParentGoalID.add(6);
        ShortGoalTitle.add("Buy Indu books");
        ShortGoalDescription.add("Buy Indu books to understand the main principles about Induism");
        ShortGoalDeadline.add("February 20");
        ShortGoalstatus.add(0);
    }


    //    Getting data from the API
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("http://13.57.134.199:8000/api/token/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while (line != null){
                line = bufferedReader.readLine();
                data += line;
            }

            JSONArray JsonData = new JSONArray(data);
            for(int i = 0 ; i < JsonData.length() ; i++){
                JSONObject JsonObject = (JSONObject) JsonData.get(i);
            }

        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MenuPage.data.setText(this.data);
    }

}
