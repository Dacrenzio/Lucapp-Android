package com.lucases.ui.main.ComboFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lucases.R;

import java.io.InputStream;
import java.util.Scanner;

public class ComboNavMenuPrincipal extends Fragment {
    public static String[] datasRowLow = new String[12];
    public static String[] datasRowMedium = new String[12];
    public static String[] datasRowMedHigh = new String[14];
    public static String[] datasRowHigh = new String[12];

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_combo_principal, container, false);
        createDataRows();
        ComboSectionPageAdapter sectionsPagerAdapter = new ComboSectionPageAdapter((FragmentActivity)root.getContext());
        ViewPager2 viewPager = root.findViewById(R.id.view_pager_combo);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = root.findViewById(R.id.tabs_combo);

        new TabLayoutMediator(tabs, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("0%");
                            break;
                        case 1:
                            tab.setText("30%");
                            break;
                        case 2:
                            tab.setText("50-75%");
                            break;
                        default:
                            tab.setText(">100%");
                    }
                }).attach();
        return root;
    }

    private void createDataRows() {
        InputStream input = getResources().openRawResource(R.raw.combo_datas);
        Scanner scanner = new Scanner(input);
        scanner.nextLine();
        scanner.nextLine();

        for (int i = 0; i < 12; i++) {
            datasRowLow[i] = scanner.nextLine();
        }
        scanner.nextLine();

        for (int i = 0; i < 12; i++) {
            datasRowMedium[i] = scanner.nextLine();
        }
        scanner.nextLine();

        for (int i = 0; i < 14; i++) {
                datasRowMedHigh[i] = scanner.nextLine();
        }
        scanner.nextLine();

        for (int i = 0; i < 12; i++) {
                datasRowHigh[i] = scanner.nextLine();
        }
    }
}
