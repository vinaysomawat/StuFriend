package com.vinaysomawat.studentfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class time_table extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        ListView time_table_list = findViewById(R.id.time_table_list);
        DatabaseHelper dh = new DatabaseHelper(this);
        Course[] all_courses = dh.get_all();

        time_table_list = (ListView)findViewById(R.id.list);

//        String[] values = {"Android List View","Adapter Information"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.simple_list_item,R.id.course_text_view,values);
//
//        list_view.setAdapter(adapter);
        List<Course> l = Arrays.asList(all_courses);
        time_table_adapter adapter = new time_table_adapter(this,l);
        adapter.notifyDataSetChanged();
        Log.d("list","adapter is set to time_table list");
        time_table_list.setAdapter(adapter);
    }
}
