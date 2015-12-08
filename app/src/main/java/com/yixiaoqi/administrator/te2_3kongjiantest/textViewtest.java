package com.yixiaoqi.administrator.te2_3kongjiantest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class textViewtest extends AppCompatActivity {

    Button landed;
    EditText name;
    EditText pass;
    CheckBox jaz;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_viewtest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        landed=(Button)findViewById(R.id.landed);
        name=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.pass);
        jaz =(CheckBox)findViewById(R.id.cb1);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        landed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(textViewtest.this,main_caidan.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("pass",pass.getText().toString());
                startActivity(intent);
            }
        });
        jaz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = openFileOutput("pass", MODE_PRIVATE);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    BufferedOutputStream stream = new BufferedOutputStream(fileOutputStream);
                    try {
                        stream.write(pass.getText().toString().getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            stream.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
    }

}
