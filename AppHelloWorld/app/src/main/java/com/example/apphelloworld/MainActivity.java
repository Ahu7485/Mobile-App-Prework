package com.example.apphelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mainText = ((TextView) findViewById(R.id.MainText));
        TextView background = ((TextView) findViewById(R.id.Background_color));
        TextView textcolor = ((TextView) findViewById(R.id.Text_color));

        //background color button
        textcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change Text Color
                mainText.setTextColor(getResources().getColor(R.color.white));
            }
        });
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.parent).setBackgroundColor(getResources().getColor(R.color.green));
            }
        });
        EditText text = ((EditText)   findViewById(R.id.custom_text));
        text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_DONE:
                        String Enteredtext = (((EditText)   findViewById(R.id.custom_text)).getText().toString());
                        if (Enteredtext.isEmpty()){
                            mainText.setText("Hello from Alan");
                        }
                        else {
                            mainText.setText(Enteredtext);
                        }
                        text.setText("");
                        break;
                }
                return false;
            }
        });
        findViewById(R.id.parent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mainText.setTextColor(getResources().getColor(R.color.black));
            mainText.setText("Hello from Alan");
            findViewById(R.id.parent).setBackgroundColor(getResources().getColor(R.color.light_blue));
            }
        });


    }
}