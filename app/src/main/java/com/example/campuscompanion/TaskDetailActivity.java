package com.example.campuscompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.button.MaterialButton;

public class TaskDetailActivity extends AppCompatActivity {

    TextView tvTitle, tvDescription, tvPriority;
    MaterialButton btnComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        tvPriority = findViewById(R.id.tvPriority);
        btnComplete = findViewById(R.id.btnComplete);

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("description");
        String priority = intent.getStringExtra("priority");

        if(title == null) title = "No Title";
        if(desc == null) desc = "No Description";
        if(priority == null) priority = "No Priority";

        tvTitle.setText(title);
        tvDescription.setText(desc);
        tvPriority.setText(getString(R.string.priority_label, priority));

        btnComplete = findViewById(R.id.btnComplete);

        btnComplete.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.confirm_title))
                    .setMessage(getString(R.string.confirm_message))
                    .setPositiveButton(getString(R.string.yes), (dialog, which) -> {
                        Toast.makeText(this, getString(R.string.task_completed), Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton(getString(R.string.no), null)
                    .show();
        });
    }
}