package com.example.findfair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UpcomingPlace extends AppCompatActivity {
    private EditText placeName;
    private EditText eventName;
    private EditText location;
    private EditText date;
    private Button saveEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_place);

        placeName = (EditText) findViewById(R.id.placeName);
        eventName = (EditText) findViewById(R.id.eventName);
        location = (EditText) findViewById(R.id.location);
        date = (EditText) findViewById(R.id.date);
        saveEvent = (Button) findViewById(R.id.saveEvent);
        saveEvent.setOnClickListener(new View.OnClickListener() {@Override

        public void onClick(View v) {
            String place = placeName.getText().toString();
            String event = eventName.getText().toString();
            String loc = location.getText().toString();
            String eventDate = date.getText().toString();

            saveEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String place = placeName.getText().toString();
                    String event = eventName.getText().toString();
                    String loc = location.getText().toString();
                    String eventDate = date.getText().toString();

                    // Create a calendar object with the input date
                    Calendar calendar = Calendar.getInstance();
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                        calendar.setTime(sdf.parse(eventDate));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    // Create an intent for the notification
                    Intent intent = new Intent(UpcomingPlace.this, UpcomingPlace.class);
                    intent.putExtra("place", place);
                    intent.putExtra("event", event);
                    intent.putExtra("location", loc);
                    PendingIntent pendingIntent = PendingIntent.getActivity(UpcomingPlace.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    // Create the notification
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(UpcomingPlace.this)
                            .setSmallIcon(R.drawable.ic_upcoming_place)
                            .setContentTitle(event)
                            .setContentText("Event at " + place + " on " + eventDate)
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true);

                    // Set the reminder
                    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                    // Display the notification
                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(UpcomingPlace.this);
                    notificationManager.notify(0, builder.build());

                    Toast.makeText(UpcomingPlace.this, "Your event has been planned", Toast.LENGTH_SHORT).show();
                }
            });

        }



    });
}}