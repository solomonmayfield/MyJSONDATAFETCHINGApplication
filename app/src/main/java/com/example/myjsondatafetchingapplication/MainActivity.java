package com.example.myjsondatafetchingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/***
 *JSON DATA FETCHING AND PARSING FROM URL ANDROID STUDIO
 *https://www.youtube.com/watch?v=Vcn4OuV4Ixg
 *
 * @Author Solomon Mayfield
 *
 */

public class MainActivity extends AppCompatActivity {


    Button click;
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button)findViewById(R.id.button);
        data =(TextView) findViewById(R.id.fetcheddata);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData process = new fetchData();
                process.execute();
            }
        });



    }
}
