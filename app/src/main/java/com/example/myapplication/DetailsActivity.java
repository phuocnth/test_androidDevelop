package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {
    TextView tvDetailName, tvDetailAge, tvDetailSalary;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        InnitView();
        Intent i = getIntent();
        tvDetailName.setText(i.getStringExtra("name"));
        tvDetailAge.setText(i.getStringExtra("age"));
        tvDetailSalary.setText(i.getStringExtra("salary"));
        Glide.with(this)
                .load(i.getStringExtra("img"))
                .into(img);
    }

    public void InnitView() {
        tvDetailAge = findViewById(R.id.tvDetailAge);
        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailSalary = findViewById(R.id.tvDetailSalary);
        img = findViewById(R.id.imgPhoto);

    }
}
