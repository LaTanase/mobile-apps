package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkUserPass()) {
                    Intent intent = new Intent(MainActivity.this, FindTheNumberActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Incorrect User/Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean checkUserPass()
    {
        final EditText userText = findViewById(R.id.userText);
        final EditText passText = findViewById(R.id.passText);
        return (userText.getText().toString().equals("student") && passText.getText().toString().equals("student"));
    }
}
