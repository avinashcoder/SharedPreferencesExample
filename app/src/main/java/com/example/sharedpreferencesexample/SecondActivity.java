package com.example.sharedpreferencesexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.sharedpreferencesexample.MainActivity.Contact;
import static com.example.sharedpreferencesexample.MainActivity.Email;
import static com.example.sharedpreferencesexample.MainActivity.Name;
import static com.example.sharedpreferencesexample.MainActivity.myPreferences;

public class SecondActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        output=findViewById(R.id.text_output);
        retrive();

    }

    public void retrive(){
        sharedPreferences=getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Name)){
            output.setText(sharedPreferences.getString(Name,""));
        }
        if(sharedPreferences.contains(Contact)){
            output.setText(output.getText()+sharedPreferences.getString(Contact,""));
        }
        if(sharedPreferences.contains(Email))
        {
            output.setText(output.getText()+sharedPreferences.getString(Email,""));
        }
    }
}
