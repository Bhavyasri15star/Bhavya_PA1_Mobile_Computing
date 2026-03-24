package com.example.campuscompanion;
import androidx.annotation.NonNull;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText etName;
    MaterialButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        etName = findViewById(R.id.etName);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> {
            String name = etName.getText().toString();

            if(name.isEmpty()){
                Toast.makeText(this, getString(R.string.enter_name_error), Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, TaskListActivity.class);
                intent.putExtra("username", name);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("username", String.valueOf(etName.getText()));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        etName.setText(savedInstanceState.getString("username"));
    }
}