package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    Button back;
    EditText setUsername;
    Button save;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        save = findViewById(R.id.save);
        setUsername = findViewById(R.id.setUsername);
        preferences = getSharedPreferences(("preferences"), MODE_PRIVATE);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", setUsername.getText().toString());
                editor.apply();
            }
        });
    }
}