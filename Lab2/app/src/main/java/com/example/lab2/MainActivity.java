package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.mybutton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                myFancyMethod(v);
                Toast.makeText(MainActivity.this,"You pushed the button from on create. Theodora is the best", Toast.LENGTH_LONG).show();
            }
        });
    }

//    public void myFancyMethod(View view) {
//        Toast.makeText(MainActivity.this,"You pushed the button from on create", Toast.LENGTH_LONG).show();
//    }

    public void push(View view) {
        Toast.makeText(this, "You pushed the button from push function", Toast.LENGTH_SHORT).show();
    }

    protected void onStart() {
        super.onStart();
        Log.e("Start", "Application started");
    }

    protected void onRestart() {

        super.onRestart();

        Log.e("Restart", "Application restarted");
    }

    protected void onResume() {

        super.onResume();

        Log.d("Resume", "Application resumed");
    }

    protected void onPause() {

        super.onPause();

        Log.d("Pause", "Application paused");
    }

    protected void onStop() {

        super.onStop();

        Log.d("Stop", "Application stopped");
    }

    protected void onDestroy() {

        super.onDestroy();

        Log.d("Destroy", "Application destroyed");
    }
}
