package com.example.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    MySharedPreference mySharedPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mySharedPreference = new MySharedPreference(this);
        TextView txt = findViewById(R.id.textView3);
        txt.setText(mySharedPreference.getValue());

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            String extraText = extras.getString("preference");
            TextView txt2 = findViewById(R.id.textView4);
            txt2.setText(extraText);
        }

    }
}
