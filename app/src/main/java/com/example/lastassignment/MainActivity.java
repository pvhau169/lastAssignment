package com.example.lastassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private TextView mShowCountTextView;
    private Button countBtn;
    private Button resetBtn;
    private SharedPreferences sharedPreferences;

    final static String sharedPrefFile = "SETTING";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCountTextView = findViewById(R.id.count_textview);
        countBtn = findViewById(R.id.count_button);
        resetBtn = findViewById(R.id.reset_button);
        sharedPreferences = getSharedPreferences(MainActivity.sharedPrefFile,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count",1);
        editor.commit();
        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = sharedPreferences.getInt("count",1);
                int currentValue = Integer.parseInt(mShowCountTextView.getText().toString());
                currentValue += count;
                if (currentValue>=10)
                {
                    currentValue = 10;
                    Toast.makeText(MainActivity.this, "Maximum Count Reach", Toast.LENGTH_SHORT).show();
                }
                mShowCountTextView.setText(Integer.toString(currentValue));
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowCountTextView.setText(Integer.toString(0));

            }
        });
    }

    public void menuClick(MenuItem item) {
        startActivity (new Intent(this, SettingActivity.class ));
    }
}
