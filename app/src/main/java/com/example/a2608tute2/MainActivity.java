package com.example.a2608tute2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "lol";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button launchDetailActivityBtn = findViewById(R.id.launchDetailActivityBtn) ;

        launchDetailActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sendMessage(v);

            }

            });

        }


    public void sendMessage (View view){
        Intent intent = new Intent(this, DetailActivity.class);
        TextView textView = findViewById(R.id.textView);
        String message = "BTC";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    }



