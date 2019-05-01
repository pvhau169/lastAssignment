package com.example.lastassignment;

import android.content.SharedPreferences;
import android.drm.DrmStore;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toolbar;

public class SettingActivity extends AppCompatActivity implements RadioButton.OnClickListener {
    SharedPreferences sharedPreferences;
    RadioButton countTwoBtn;
    RadioButton countFiveBtn;
    RadioButton countTenBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        countTwoBtn = findViewById(R.id.countTwoBtn);
        countFiveBtn = findViewById(R.id.countFiveBtn);
        countTenBtn = findViewById(R.id.countTenBtn);
        countTwoBtn.setOnClickListener(this);
        countFiveBtn.setOnClickListener(this);
        countTenBtn.setOnClickListener(this);
        sharedPreferences = getSharedPreferences(MainActivity.sharedPrefFile,MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        RadioButton clickedRadioBtn = (RadioButton) v;
        int count = Integer.parseInt((String) clickedRadioBtn.getTag());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count",count);
        editor.commit();
    }
}
