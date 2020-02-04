package com.example.myjsondatafetchingapplication;

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

public class fetchData extends AsyncTask<Void,Void,Void> {
String data = "";
String dataParsed = "";
String singleParsed = "";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
//Background Thread
    @Override
    protected Void doInBackground(Void... voids) {
        //https://api.myjson.com/bins/ocbq6 - json url

        try {
            URL url = new URL("https://api.myjson.com/bins/ocbq6");
        //create a connection
            HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();//create a connection
            //now we have to get an input stream
            InputStream inputStream = httpURLConnection.getInputStream();
            //Buffered reader is going to read data from the input stream
            BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line ="";
            while(line != null){

                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for (int i = 0; i<JA.length();i++){

                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "Name:" + JO.get("first_name") + "\n" +
                               "Age:" + JO.get("age") + "\n" +
                               "Email:" + JO.get("email") + "\n";
                dataParsed = dataParsed + singleParsed;

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
//UI Thread
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.dataParsed);
    }
}
