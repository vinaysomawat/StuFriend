package com.vinaysomawat.studentfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class new_course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_course);
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
        Button b =  findViewById(R.id.new_course_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_button_clicked();
            }
        });
    }

    private void add_button_clicked()
    {
        EditText course_name = findViewById(R.id.new_course_name);
        EditText course_time = findViewById(R.id.new_course_time);
        EditText bunk_time = findViewById(R.id.new_bunk_time);

        DatabaseHelper dh = new DatabaseHelper(this);
        String s = course_time.getText().toString();
        Log.d("new_course","goint to insert");
        dh.insert(course_name.getText().toString(),0, Integer.parseInt(s));
        Log.d("new_course","inserted : ) ");

    }

}
