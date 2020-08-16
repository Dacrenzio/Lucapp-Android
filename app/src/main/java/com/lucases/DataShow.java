package com.lucases;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DataShow extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.data_show);
        TextView playerString = findViewById(R.id.textPlayer);
        playerString.setText(intent.getStringExtra(CardView.NomePG));
    }
}
