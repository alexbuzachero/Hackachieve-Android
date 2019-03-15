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
private ArrayList<String> CardTitle = new ArrayList<>();
    private ArrayList<String> GoalsCompleted = new ArrayList<>();
    private ArrayList<String> TotalGoals = new ArrayList<>();
    private ArrayList<String> DataCompleted = new ArrayList<>();
    private ArrayList<Integer> Board_id = new ArrayList<Integer>();

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


    //    Initialzing the variables with the user content
    public void initGoals(){

        CardTitle.add("Lost 5 kilos");
        GoalsCompleted.add("3");
        TotalGoals.add("9");
        DataCompleted.add("2019-01-14T16:36:25.019Z");
        Board_id.add(1);


        CardTitle.add("Invest money in Bitcoins");
        GoalsCompleted.add("3");
        TotalGoals.add("9");
        DataCompleted.add("2019-02-14T16:36:25.019Z");
        Board_id.add(2);


        CardTitle.add("Updtate my Linkdin Account");
        GoalsCompleted.add("1");
        TotalGoals.add("8");
        DataCompleted.add("2019-05-14T16:36:25.019Z");
        Board_id.add(3);


        CardTitle.add("Learn Snowboard");
        GoalsCompleted.add("2");
        TotalGoals.add("7");
        DataCompleted.add("2019-08-14T16:36:25.019Z");
        Board_id.add(4);


        CardTitle.add("Learn VR concept");
        GoalsCompleted.add("5");
        TotalGoals.add("6");
        DataCompleted.add("2019-04-14T16:36:25.019Z");
        Board_id.add(5);


        CardTitle.add("Learn Indu Lessons");
        GoalsCompleted.add("3");
        TotalGoals.add("9");
        DataCompleted.add("2019-04-14T16:36:25.019Z");
        Board_id.add(6);

    }

    //    Initialzing the variables with the user content
    public void initGoalsCompleted(){

        CardTitle.add("Prepare to Marathom");
        GoalsCompleted.add("7");
        TotalGoals.add("7");
        DataCompleted.add("2019-01-14T16:36:25.019Z");
        Board_id.add(1);

        CardTitle.add("Invest in Bank Account");
        GoalsCompleted.add("4");
        TotalGoals.add("4");
        DataCompleted.add("2019-02-14T16:36:25.019Z");
        Board_id.add(3);

        CardTitle.add("Learn Bitcoins Investments");
        GoalsCompleted.add("3");
        TotalGoals.add("3");
        DataCompleted.add("2019-05-14T16:36:25.019Z");
        Board_id.add(3);

        CardTitle.add("Study Game of Thrones Teory");
        GoalsCompleted.add("2");
        TotalGoals.add("2");
        DataCompleted.add("2019-08-14T16:36:25.019Z");
        Board_id.add(4);
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
