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

//Video Tutorial: https://www.youtube.com/watch?v=Vcn4OuV4Ixg

public class FetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataParsec = "";
    String singleParsed = "";

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
