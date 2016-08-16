package com.example.hwhong.bucketlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hwhong on 7/2/16.
 */
public class Adapter extends ArrayAdapter<String> {

    int[] images = {};
    ArrayList<String> todo;
    Context c;
    LayoutInflater inflater;

    public Adapter(Context context, ArrayList<String> todo, int[] images) {
        super(context, R.layout.countryview, todo);
        this.c = context;
        this.images = images;
        this.todo = todo;
    }

    public class ViewHolder {
        TextView todo;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.countryview, null);
        }

        final ViewHolder holder = new  ViewHolder();

        holder.todo = (TextView) convertView.findViewById(R.id.todo);
        holder.img = (ImageView) convertView.findViewById(R.id.imageView);

        holder.img.setImageResource(images[position]);
        holder.todo.setText(todo.get(position));

        return convertView;
    }
}
