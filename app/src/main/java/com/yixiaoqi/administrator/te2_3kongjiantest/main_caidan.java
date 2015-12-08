package com.yixiaoqi.administrator.te2_3kongjiantest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class main_caidan extends AppCompatActivity {
    EditText pname;
    EditText ppass;
    EditText ptime;
    Button getpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_caidan);
        pname=(EditText)findViewById(R.id.pname);
        ppass=(EditText)findViewById(R.id.ppass);
       // ptime=(EditText)findViewById(R.id.ptime);
        getpass=(Button)findViewById(R.id.getpass);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent intent=getIntent();
        pname.setText(intent.getExtras().toString());
       // ppass.setText(intent.getExtras().toString());
        getpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileInputStream fileInputStream=new FileInputStream("pass");
                    BufferedInputStream inputStream=new BufferedInputStream(fileInputStream);
                    try {
                        ppass.setText(String.valueOf(inputStream.read()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Toast.makeText(main_caidan.this,"dddd",Toast.LENGTH_SHORT).show();
            }
        });
}

}
