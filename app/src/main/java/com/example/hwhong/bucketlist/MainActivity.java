package com.example.hwhong.bucketlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity{
    ListView listView;
    ArrayList<String> todo;
    int[] images = {R.drawable.red, R.drawable.orange, R.drawable.yellow, R.drawable.green,
            R.drawable.blue, R.drawable.purple, R.drawable.black,
            R.drawable.grey, R.drawable.brown};

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] initialTodo = {"Climb mount.Fiji", "Live in New York", "Travel around"};
        todo = new ArrayList<>(Arrays.asList(initialTodo));

        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.add);
        editText = (EditText) findViewById(R.id.editText);

        final Adapter adapter = new Adapter(this, todo, images);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newTodo = editText.getText().toString();
                todo.add(newTodo);
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                todo.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
