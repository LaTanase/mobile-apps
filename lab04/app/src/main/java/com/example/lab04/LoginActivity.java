package com.example.lab04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        Button button = findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkUserPass()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Incorrect User/Password",Toast.LENGTH_SHORT).show();
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
