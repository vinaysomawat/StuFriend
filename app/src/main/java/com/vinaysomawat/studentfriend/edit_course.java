package com.vinaysomawat.studentfriend;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class edit_course extends AppCompatActivity {

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);
        Button b = (Button) findViewById(R.id.delete_course_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete_button_clicked();
            }
        });

        String info =  getIntent().getStringExtra("id");
        Log.d("delete_","intent string : "+info);
        EditText id_text =(EditText) findViewById(R.id.edit_course_name);
        id_text.setText(info);
        id = Integer.parseInt(info);
    }

    public void delete_button_clicked()
    {
       // EditText id_text =(EditText) findViewById(R.id.edit_course_name);
        //int id = Integer.parseInt(id_text.toString());
        DatabaseHelper dh = new DatabaseHelper(this);
        //Log.d("delete_","deleting here "+Integer.toString(id));
        dh.delete(id);
        Log.d("delete_","deleted from function");

    }
}
