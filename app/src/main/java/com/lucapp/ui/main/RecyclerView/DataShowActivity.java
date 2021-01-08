package com.lucapp.ui.main.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lucapp.CardView;
import com.lucapp.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DataShowActivity extends AppCompatActivity {
    public static final String charTrio = "com.lucases.MESSAGE";
    public static String[] charData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String messageCardView = intent.getStringExtra(CardView.NomePG);
        charData = fetchDatas(messageCardView);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);
        TextView charName = findViewById(R.id.charName);
        charName.setText(charData[0]);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this);

        //the ViewPager is the tab system in the dataShowActivity that shows fragments with the collaboration of the SectionPagerAdapter
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);

        new TabLayoutMediator(tabs, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Important");
                            break;
                        case 1:
                            tab.setText("Misc");
                            break;
                        case 2:
                            tab.setText("Tech chase");
                            break;
                        case 3:
                            tab.setText("Kill Confirm");
                    }
                }).attach();


        if (messageCardView != null && (messageCardView.equals("Pokemon Trainer") || messageCardView.equals("Squirtle") || messageCardView.equals("Ivysaur") || messageCardView.equals("Charizard"))) {
            fabManager(intent);
        }
    }

    private void fabManager(Intent intent) {
        //turning the first FAB visible and clickable when is one of the pokemon's pokemon Trainer
        FloatingActionButton fab = findViewById(R.id.fab);
        findViewById(R.id.tableFAB).setVisibility(View.VISIBLE);
        fab.setVisibility(View.VISIBLE);
        fab.setClickable(true);
        FloatingActionButton fabS = findViewById(R.id.fabSquirtle);
        FloatingActionButton fabI = findViewById(R.id.fabIvy);
        FloatingActionButton fabC = findViewById(R.id.fabChar);

        //turning the FABs visible or invisible
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fabS.getVisibility() != View.VISIBLE) {
                    findViewById(R.id.tableFAB).setBackgroundResource(R.drawable.round_corner_borderd);
                    fabS.show();
                    fabS.setClickable(true);
                    findViewById(R.id.squirlteTextView).setVisibility(View.VISIBLE);
                    fabI.show();
                    fabI.setClickable(true);
                    findViewById(R.id.ivyTextView).setVisibility(View.VISIBLE);
                    fabC.show();
                    fabC.setClickable(true);
                    findViewById(R.id.charTextView).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.tableFAB).setBackgroundColor(Color.TRANSPARENT);
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

        //recreating the Activity with the Name of the pokemon wanted by changing the intent
        fabS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(CardView.NomePG, "Squirtle");
                recreate();
            }
        });

        fabI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(CardView.NomePG, "Ivysaur");
                recreate();
            }
        });


        fabC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(CardView.NomePG, "Charizard");
                recreate();
            }
        });
    }

    private String[] fetchDatas(String charName) {
        InputStream input = getResources().openRawResource(R.raw.char_datas);
        Scanner scanner = new Scanner(input);

        //eliminating the first 2 rows cause useless
        scanner.nextLine();
        scanner.nextLine();
        ArrayList<String> righe = new ArrayList<>();
        while (scanner.hasNextLine()) {
            righe.add(scanner.nextLine());
        }
        int l = 0, r = righe.size() - 1;

        //if going to pokemon trainer get Squirtle
        if (charName.equals("Pokemon Trainer"))
            return righe.get(74).split(";");

        //else do binary search
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