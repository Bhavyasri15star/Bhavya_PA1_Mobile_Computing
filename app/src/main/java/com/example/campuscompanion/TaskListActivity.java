package com.example.campuscompanion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskListActivity extends AppCompatActivity {

    ListView listView;

    String[] tasks;
    String[] descriptions;
    String[] priorities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Log.d("Lifecycle", "onCreate called");

        listView = findViewById(R.id.listViewTasks);

        tasks = getResources().getStringArray(R.array.task_titles);
        descriptions = getResources().getStringArray(R.array.task_descriptions);
        priorities = getResources().getStringArray(R.array.task_priorities);

        String name = getIntent().getStringExtra("username");
        if (name == null) {
            name = getString(R.string.default_user);
        }

        TextView tvWelcome = findViewById(R.id.tvWelcome);
        tvWelcome.setText(getString(R.string.welcome_message, name));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                tasks
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(TaskListActivity.this, TaskDetailActivity.class);

            intent.putExtra("title", tasks[position]);
            intent.putExtra("description", descriptions[position]);
            intent.putExtra("priority", priorities[position]);

            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "onResume called");
    }
}