package com.lucases.ui.main;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.lucases.R;

public class ComboViewFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_combo, container, false);
        return root;
    }

    private TableLayout getTableRow(LinearLayout page, String color, int paddingDP) {
        TableLayout newTable = new TableLayout(page.getContext());
        newTable.setPadding(getDP(paddingDP, page), getDP(paddingDP, page), getDP(paddingDP, page), getDP(paddingDP, page));
        newTable.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        newTable.setBackgroundColor(Color.parseColor(color));
        return newTable;
    }

    private TableRow getTableRow(TableLayout table, String color) {
        TableRow newRow = new TableRow(table.getContext());
        newRow.setPadding(10, 10, 10, 10);
        newRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        newRow.setBackgroundColor(Color.parseColor(color));
        return newRow;
    }

    private TextView getTextView(TableRow row, float w) {
        TextView text = new TextView(row.getContext());
        text.setTypeface(Typeface.DEFAULT_BOLD);
        text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, w));
        text.setPadding(3, 3, 3, 3);
        text.setGravity(Gravity.CENTER);
        return text;
    }

    private int getDP(int dp, View root) {
        return Math.round(dp * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
