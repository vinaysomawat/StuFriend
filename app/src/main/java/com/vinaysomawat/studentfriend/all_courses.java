package com.vinaysomawat.studentfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class all_courses extends AppCompatActivity {

    private ListView list_view;
    Course[] all_courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_courses);
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

        DatabaseHelper dh = new DatabaseHelper(this);
        all_courses = dh.get_all();

        list_view = (ListView)findViewById(R.id.list);

//        String[] values = {"Android List View","Adapter Information"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.simple_list_item,R.id.course_text_view,values);
//
//        list_view.setAdapter(adapter);
        List<Course> l = Arrays.asList(all_courses);
        ListAdapter adapter = new ListAdapter(this,l);
        adapter.notifyDataSetChanged();
        Log.d("list","adapter is set");
        list_view.setAdapter(adapter);


        list_view.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
               // String yourData = temparr.get(position);
                Log.d("delete_","clicked");
                Course c = (Course) parent.getItemAtPosition(position);
                removeItemFromList(c);
            }
        });
    }

    private void removeItemFromList(Course c)
    {
        Log.d("delete_","came in");
        Log.d("delete_","before dh");
        DatabaseHelper dh = new DatabaseHelper(this);
        //dh.delete(e.getText());
        Log.d("delete_",c.course_name+" "+c.id);

        Intent it = new Intent(this,edit_course.class);
        it.putExtra("id",Integer.toString(c.id));
        startActivity(it);
    }

}
