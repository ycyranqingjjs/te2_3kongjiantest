package com.yixiaoqi.administrator.te2_3kongjiantest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button savebutton;
    EditText disdata;
    EditText data;
    Button display;
    Button sqldb;
    Button textViewtest;
    EditText sqldata;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        data=(EditText)findViewById(R.id.data);
        disdata=(EditText)findViewById(R.id.disdata);
        display=(Button)findViewById(R.id.display);
        button1=(Button)findViewById(R.id.textview);
        button2=(Button)findViewById(R.id.button);
        textViewtest=(Button)findViewById(R.id.textview);
        savebutton=(Button)findViewById(R.id.save);
        sqldb=(Button)findViewById(R.id.button);
        sqldata=(EditText)findViewById(R.id.sqldata);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "textView", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ZhuanActicity.class);
                String sdata=data.getText().toString();
                intent.putExtra("mydata",sdata);
                startActivity(intent);
            }
        });
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String data2=data.getText().toString();
                SharedPreferences sharedPreferences=getSharedPreferences("shpsave", MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("shpdata", data2);
                editor.commit();

            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("shpsave",MODE_PRIVATE);
                String sdata=sharedPreferences.getString("shpdata", null);
                disdata.setText(sdata);
            }
        });
        sqldb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        textViewtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, com.yixiaoqi.administrator.te2_3kongjiantest.textViewtest.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
