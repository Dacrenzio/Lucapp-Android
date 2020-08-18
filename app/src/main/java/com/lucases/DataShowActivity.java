package com.lucases;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lucases.ui.main.SectionsPagerAdapter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DataShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_data_show);
        // TextView playerString = findViewById(R.id.textPlayer);
        //playerString.setText(intent.getStringExtra(CardView.NomePG));
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this);
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        new TabLayoutMediator(tabs, viewPager,
                (tab, position) -> tab.setText("OBJECT " + (position + 1))
        ).attach();
        FloatingActionButton fab = findViewById(R.id.fab);
        String[] charDatas = fetchDatas(intent.getStringExtra(CardView.NomePG));
        if (charDatas[1].equals("Squirtle")) {
            findViewById(R.id.fab).setVisibility(View.VISIBLE);
            findViewById(R.id.fab).setClickable(true);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public String[] fetchDatas(String charName) {
        InputStream input = getResources().openRawResource(R.raw.datas);
        Scanner scanner = new Scanner(input);
        scanner.nextLine();
        scanner.nextLine();
        ArrayList<String> righe = new ArrayList<>();
        while (scanner.hasNextLine()) {
            righe.add(scanner.nextLine());
        }
        int l = 0, r = righe.size() - 1;
        if (charName.equals("Pokemon Trainer")) {
            return righe.get(73).split(";");
        } else {
            while (l <= r) {
                int m = (l + r) / 2;
                int res = charName.toLowerCase().compareTo(righe.get(m).substring(0, righe.get(m).indexOf(';')).toLowerCase());
                if (res == 0)
                    return righe.get(m).split(";");
                if (res > 0)
                    l = m + 1;
                else
                    r = m - 1;
            }
        }
        return new String[]{"not found"};
    }
}