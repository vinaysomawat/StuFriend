package com.vinaysomawat.studentfriend;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vinay Somawat on 06-01-2018.
 */

public class time_table_adapter extends BaseAdapter {

    Activity activity;
    List<Course> data;
    LayoutInflater inflater;
    public time_table_adapter(Activity a, List<Course> all_courses)
    {
        //super(a,R.layout.simple_list_item,all_courses);
        Log.d("mylist",Integer.toString(all_courses.size()));
        activity = a;
        data = all_courses;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d("mylist","service started");
    }

    public int getCount()
    {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return this.data.get(i);
    }

    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        Log.d("mylist","starting of get View");
        View vi = convertView;
        if(convertView == null)
            vi = inflater.inflate(R.layout.simple_list_item,null);

        TextView course_name = (TextView) vi.findViewById(R.id.course_text_view);
        TextView bunk = (TextView) vi.findViewById(R.id.bunk_text_view);
        TextView time = (TextView) vi.findViewById(R.id.time_text_view);
        TextView id = (TextView) vi.findViewById(R.id.id_view);

        //course_name.setText(data.get(position).course_name);
        course_name.setText(data.get(position).course_name);
        bunk.setText(Integer.toString(data.get(position).bunk_count));
        time.setText(Integer.toString(data.get(position).lec_time));
        id.setText(Integer.toString(data.get(position).id));
        Log.d("mylist","view returned");
        return vi;

//        LayoutInflater inflater = activity.getLayoutInflater();
//        View rowView = inflater.inflate(R.layout.simple_list_item,null,true);
//        TextView t = (TextView) rowView.findViewById(R.id.course_text_view);
//
//        t.setText("Hello");
//
//        return rowView;

    }
}
