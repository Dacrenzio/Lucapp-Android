package com.lucases;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class DataShow extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.data_show);
        TextView playerString = (TextView) findViewById(R.id.textPlayer);
        playerString.setText(intent.getStringExtra(CardView.NomePG));
        int a = 6;
    }
}
