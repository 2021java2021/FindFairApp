package com.example.findfair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyJourney extends AppCompatActivity {

    private Button PreviousPlacebtn;
    private Button UpcomingEventbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_journey);

        PreviousPlacebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreviousPlacebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MyJourney.this, UpcomingPlace.class);
                        startActivity(intent);
                    }
                });
            }
        });

        UpcomingEventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpcomingEventbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MyJourney.this, UpcomingPlace.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}