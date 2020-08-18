package com.lucases;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this);
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);

        new TabLayoutMediator(tabs, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Misc Information");
                            break;
                        case 1:
                            tab.setText("Tech chase");
                            break;
                        case 2:
                            tab.setText("Kill Confirm");
                    }
                }).attach();

        if (intent.getStringExtra(CardView.NomePG).equals("Pokemon Trainer")) {
            fabManager(intent.getStringExtra(CardView.NomePG));
        } else {
            String[] charDatas = fetchDatas(intent.getStringExtra(CardView.NomePG));
        }

    }

    private void fabManager(String ch) {
        FloatingActionButton fab = findViewById(R.id.fab);
        findViewById(R.id.tableFAB).setVisibility(View.VISIBLE);
        fab.setVisibility(View.VISIBLE);
        fab.setClickable(true);
        FloatingActionButton fabS = findViewById(R.id.fabSquirtle);
        FloatingActionButton fabI = findViewById(R.id.fabIvy);
        FloatingActionButton fabC = findViewById(R.id.fabChar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fabS.getVisibility() != View.VISIBLE) {
                    fabS.show();
                    fabS.setClickable(true);
                    findViewById(R.id.squirlteTextView).setVisibility(View.VISIBLE);
                    fabI.show();
                    fabI.setClickable(true);
                    findViewById(R.id.ivyTextView).setVisibility(View.VISIBLE);
                    fabC.show();
                    fabC.setClickable(true);
                    findViewById(R.id.charTextView).setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "hai cliccato sull'icona", Toast.LENGTH_LONG).show();
                } else {
                    fabS.hide();
                    fabS.setClickable(false);
                    findViewById(R.id.squirlteTextView).setVisibility(View.INVISIBLE);
                    fabI.hide();
                    fabI.setClickable(false);
                    findViewById(R.id.ivyTextView).setVisibility(View.INVISIBLE);
                    fabC.hide();
                    fabC.setClickable(false);
                    findViewById(R.id.charTextView).setVisibility(View.INVISIBLE);
                }
            }
        });


        fabS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabS.hide();
                fabS.setClickable(false);
                findViewById(R.id.squirlteTextView).setVisibility(View.INVISIBLE);
                fabI.hide();
                fabI.setClickable(false);
                findViewById(R.id.ivyTextView).setVisibility(View.INVISIBLE);
                fabC.hide();
                fabC.setClickable(false);
                findViewById(R.id.charTextView).setVisibility(View.INVISIBLE);

                //TODO creare metodo statico che distribuisce i dati raccolti
                //componiTabelle(fetchDatas("Squirtle"));
            }
        });

        fabI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabS.hide();
                fabS.setClickable(false);
                findViewById(R.id.squirlteTextView).setVisibility(View.INVISIBLE);
                fabI.hide();
                fabI.setClickable(false);
                findViewById(R.id.ivyTextView).setVisibility(View.INVISIBLE);
                fabC.hide();
                fabC.setClickable(false);
                findViewById(R.id.charTextView).setVisibility(View.INVISIBLE);

                //TODO creare metodo statico che distribuisce i dati raccolti
                //componiTabelle(fetchDatas("Ivysaur"));
            }
        });


        fabC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabS.hide();
                fabS.setClickable(false);
                findViewById(R.id.squirlteTextView).setVisibility(View.INVISIBLE);
                fabI.hide();
                fabI.setClickable(false);
                findViewById(R.id.ivyTextView).setVisibility(View.INVISIBLE);
                fabC.hide();
                fabC.setClickable(false);
                findViewById(R.id.charTextView).setVisibility(View.INVISIBLE);

                //TODO creare metodo statico che distribuisce i dati raccolti
                //componiTabelle(fetchDatas("Charizard"));
            }
        });
    }

    private String[] fetchDatas(String charName) {
        InputStream input = getResources().openRawResource(R.raw.datas);
        Scanner scanner = new Scanner(input);
        scanner.nextLine();
        scanner.nextLine();
        ArrayList<String> righe = new ArrayList<>();
        while (scanner.hasNextLine()) {
            righe.add(scanner.nextLine());
        }
        int l = 0, r = righe.size() - 1;
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
        return new String[]{"not found"};
    }
}