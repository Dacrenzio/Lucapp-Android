package com.lucapp.ui.main.RecyclerView;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.lucapp.DataShowActivity;
import com.lucapp.R;

public class FragmentMiscInfo extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_misc_info, container, false);
        //Place all data
        placeData(root);
        return root;
    }

    private void placeData(View root) {
        TableRow[] rows = {root.findViewById(R.id.uAirOOSRow), root.findViewById(R.id.zairUAirRow), root.findViewById(R.id.dashAttackRow)};
        TableRow newRow;
        TextView text;
        TableLayout table;
        int i = 1;
        for (TableRow nRow : rows) {
            text = getTextView(nRow, 1f);
            text.setText(DataShowActivity.charData[i]);
            switch (DataShowActivity. charData[i]) {
                case "Yes":
                    text.setBackgroundColor(Color.parseColor("#6CF324"));
                    break;
                case "No":
                    text.setBackgroundColor(Color.parseColor("#EC1932"));
                    break;
                default:
                    text.setBackgroundColor(Color.parseColor("#DAB851"));
            }
            nRow.addView(text);
            if (!DataShowActivity.charData[i].equals("No") && i == 3) {
                table = root.findViewById(R.id.dashAttack);
                newRow = getTableRow(table, "#FFF6A6");
                text = getTextView(newRow, 3f);
                text.setText("Kill percentage: ");
                text.setGravity(Gravity.LEFT);
                int dpl = Math.round(9 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
                text.setPadding(dpl, 3, 3, 3);
                newRow.addView(text);
                text = getTextView(newRow, 1f);
                text.setText(DataShowActivity.charData[++i]);
                newRow.addView(text);
                table.addView(newRow);
            } else if(i==3){
                i++;
            }
            i++;
        }

        //aggiungo le mosse assorbibili
        table = root.findViewById(R.id.absorbMoves);
        if (DataShowActivity.charData[5].equals(""))
            table.setVisibility(View.GONE);
        else {
            for (; i < 26; i++) {
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