package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button buttonSpeak;
    private Button buttonListen;
    private TextView textView;
    private Fragment frag1, frag2;
    public boolean state = true;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_SPEECH_INPUT && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            textView.setText(spokenText);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = new Fragment1();
        frag2 = new Fragment2();
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, frag1);
        fragmentTransaction.commit();
        final TextToSpeech ttobj=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
            }
        });
        ttobj.setLanguage(Locale.ENGLISH);
        textView = findViewById(R.id.textView);
        buttonSpeak = View.inflate( this , R.layout.frag1, null).findViewById(R.id.buttonSpeak);
        buttonListen = View.inflate( this , R.layout.frag1, null).findViewById(R.id.buttonListen);

        Button buttonSwitch = findViewById(R.id.buttonSwitch);
        buttonSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr;

                if(state) {
                    fr = frag2;

                }else {
                    fr = frag1;
                }
                state = !state;
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fr);
                fragmentTransaction.commit();

                if(buttonSpeak != null){
                    buttonSpeak.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ttobj.speak(textView.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                        }
                    });
                }

            }
        });

        if(buttonListen != null) {
            buttonListen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-En");
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speak something");
                    // Start the activity, the intent will be populated with the speech text
                    startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
                }
            });
        }
    }
}