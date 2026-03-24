package com.example.campuscompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskListActivity extends AppCompatActivity {

    ListView listView;

    String[] tasks = {
            "Assignment Submission",
            "Attend Lecture",
            "Group Meeting",
            "Lab Work",
            "Project Research",
            "Exam Preparation",
            "Library Study",
            "Presentation Practice"
    };

    String[] descriptions = {
            "Submit assignment before deadline",
            "Attend scheduled lecture",
            "Meet group members",
            "Complete lab exercises",
            "Work on project research",
            "Prepare for exams",
            "Study in library",
            "Practice presentation"
    };

    String[] priorities = {
            "High", "Medium", "Medium", "High",
            "Low", "High", "Low", "Medium"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        listView = findViewById(R.id.listViewTasks);

        String name = getIntent().getStringExtra("username");
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
        android.util.Log.d("Lifecycle", "onStart called");
    }
}