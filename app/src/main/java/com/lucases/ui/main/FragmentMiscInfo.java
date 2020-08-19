package com.lucases.ui.main;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.lucases.DataShowActivity;
import com.lucases.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentMiscInfo extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_misc_info, container, false);
        placeData(root);
        return root;
    }

    private void placeData(View root) {
        //adding Up-Air OOS row
        TableRow row = root.findViewById(R.id.uAirOOSRow);
        TextView text = getTextView(row, 1f);
        text.setText(DataShowActivity.charData[1]);
        switch (DataShowActivity.charData[1]) {
            case "Yes":
                text.setBackgroundColor(Color.parseColor("#6CF324"));
                break;
            case "No":
                text.setBackgroundColor(Color.parseColor("#EC1932"));
                break;
            default:
                text.setBackgroundColor(Color.parseColor("#DAB851"));
        }
        System.out.println(text);
        row.addView(text);

        //adding DashAttck at ledge row
        row = root.findViewById(R.id.zairUAirRow);
        text = getTextView(row, 1f);
        text.setText(DataShowActivity.charData[2]);
        switch (DataShowActivity.charData[2]) {
            case "Yes":
                text.setBackgroundColor(Color.parseColor("#6CF324"));
                break;
            case "No":
                text.setBackgroundColor(Color.parseColor("#EC1932"));
                break;
            default:
                text.setBackgroundColor(Color.parseColor("#DAB851"));
        }
        row.addView(text);

        //adding DashAttack on Ledge
        row = root.findViewById(R.id.dashAttackRow);
        text = getTextView(row, 1f);
        text.setText(DataShowActivity.charData[3]);
        switch (DataShowActivity.charData[3]) {
            case "Yes":
                text.setBackgroundColor(Color.parseColor("#6CF324"));
                break;
            case "No":
                text.setBackgroundColor(Color.parseColor("#EC1932"));
                break;
            default:
                text.setBackgroundColor(Color.parseColor("#DAB851"));
        }
        row.addView(text);
        TableLayout table;
        TableRow newRow;
        if (!text.getText().equals("No")) {
            table = root.findViewById(R.id.dashAttack);
            newRow = getTableRow(table, "#FFF6A6");
            text = getTextView(newRow, 3f);
            text.setText("Kill percentage: ");
            text.setGravity(Gravity.LEFT);
            newRow.addView(text);
            text = getTextView(newRow, 1f);
            text.setText(DataShowActivity.charData[4]);
            newRow.addView(text);
            table.addView(newRow);
        }

        //aggiungo le mosse assorbibili
        table = root.findViewById(R.id.absorbMoves);
        if (DataShowActivity.charData[5].equals(""))
            table.setVisibility(View.GONE);
        else {
            for (int i = 5; i < 26; i++) {
                if (((i + 1) / 2) % 2 == 0)
                    newRow = getTableRow(table, "#75FFC4");
                else
                    newRow = getTableRow(table, "#FFF6A6");
                text = getTextView(newRow, 1f);
                text.setText(DataShowActivity.charData[i++]);
                newRow.addView(text);
                text = getTextView(newRow, 1f);
                text.setText(DataShowActivity.charData[i]);
                newRow.addView(text);
                table.addView(newRow);
                if (DataShowActivity.charData[i + 1].equals(""))
                    break;
            }
        }
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
}