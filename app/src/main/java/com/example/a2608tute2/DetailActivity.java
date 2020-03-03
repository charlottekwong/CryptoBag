package com.example.a2608tute2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.SearchView;
import android.widget.TextView;



public class DetailActivity extends AppCompatActivity {

    String message1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent btc = getIntent();
        String message = btc.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Coin myCoin = Coin.searchCoin(message);

        TextView currency = findViewById(R.id.currency);
        currency.setText(myCoin.getName());

        TextView initial = findViewById(R.id.currencyInitial);
        initial.setText(myCoin.getSymbol());

        TextView valueField = findViewById(R.id.valueField);
        valueField.setText(Double.toString(myCoin.getValue()));

        TextView oneHour = findViewById(R.id.oneHour);
        oneHour.setText(Double.toString(myCoin.getChange1h()));

        TextView twentyFourHr = findViewById(R.id.twentyFourHr);
        twentyFourHr.setText(Double.toString(myCoin.getChange24h()));

        TextView sevenDays = findViewById(R.id.sevenDays);
        sevenDays.setText(Double.toString(myCoin.getChange7d()));

        TextView volumeField = findViewById(R.id.volumeField);
        volumeField.setText(Double.toString(myCoin.getVolume()));

        TextView marketCapField = findViewById(R.id.marketCapField);
        marketCapField.setText(Double.toString(myCoin.getMarketcap()));

        Button search = findViewById(R.id.search) ;
        search.setText("Search");

        message1 = message;

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                googleSearch(v);

            }

        });

    }


    public void googleSearch(View v){
        Uri uri = Uri.parse("https://www.google.com.au/search?q=" + message1);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);


        try {
            DetailActivity.this.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
        }

        }




    }





