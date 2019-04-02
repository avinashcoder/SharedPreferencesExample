package com.example.sharedpreferencesexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edName,edContact,edEmail;
    Button btnSave,btnNext;
    SharedPreferences sharedPreferences;
    static final String myPreferences="myPref";
    static final String Name="nameKey";
    static final String Contact="contactKey";
    static final String Email="emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName=findViewById(R.id.name);
        edContact=findViewById(R.id.contact);
        edEmail=findViewById(R.id.email);
        btnSave=findViewById(R.id.save);
        btnNext=findViewById(R.id.btn_next);
        retrive();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edName.getText().toString();
                String contact=edContact.getText().toString();
                String email=edEmail.getText().toString();
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(Name,name);
                editor.putString(Contact,contact);
                editor.putString(Email,email);
                editor.commit();
            }
        });
    }

    public void retrive(){
        sharedPreferences=getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Name)){
            edName.setText(sharedPreferences.getString(Name,""));
        }
        if(sharedPreferences.contains(Contact)){
            edContact.setText(sharedPreferences.getString(Contact,""));
        }
        if(sharedPreferences.contains(Email))
        {
            edEmail.setText(sharedPreferences.getString(Email,""));
        }
    }
}
