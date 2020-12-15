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

import com.lucapp.R;

public class FragmentMiscInfo extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.data_fragment_misc_info, container, false);
        placeData(root);

        //adding more margin if the FABs are visible
        if (DataShowActivity.charData[0].equals("Squirtle") || DataShowActivity.charData[0].equals("Ivysaur") || DataShowActivity.charData[0].equals("Charizard")) {
            TableLayout.LayoutParams params = new TableLayout.LayoutParams();
            int dpl = Math.round(60 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
            int dp = Math.round(90 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));

            //if the pressure note is visible
            if(root.findViewById(R.id.pressure_notes).getVisibility() == View.VISIBLE){
                params.setMargins(dpl, 0, dpl, dp);
                root.findViewById(R.id.pressure_notes).setLayoutParams(params);

            } else if(root.findViewById(R.id.shield_pressure_options).getVisibility() == View.VISIBLE){
                //if the notes are invisible but the pressure options are not
                params.setMargins(dpl, 0, dpl, dp);
                root.findViewById(R.id.shield_pressure_options).setLayoutParams(params);

            } else{
                //if only the table is visible add margin to that
                int dpt =  Math.round(30 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
                params.setMargins(dpl, dpt, dpl, dp);
                root.findViewById(R.id.shield_pressure_table).setLayoutParams(params);
            }

        }


        return root;
    }

    private void placeData(View root) {
        TableRow[] rows = {root.findViewById(R.id.uAirOOSRow),
                root.findViewById(R.id.zairUAirRow),
                root.findViewById(R.id.dashAttackRow)};

        TableRow newRow;
        TextView text;
        TableLayout table;
        int i = 1;//starting point of misc Info datas
        for (TableRow nRow : rows) {
            text = getTextView(nRow, 1f);
            text.setText(DataShowActivity.charData[i]);
            switch (DataShowActivity. charData[i]) {//setting color of text
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
                //if it can be hit by dash attack, show the kill%

                table = root.findViewById(R.id.dashAttack);
                newRow = getTableRow(table, "#FFF6A6");
                text = getTextView(newRow, 3f);
                text.setText("Kill percentage: ");
                text.setGravity(Gravity.LEFT);

                //calculating the dense pixels for each phone
                int dpl = Math.round(9 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));

                //getting the kill%
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

        //adding absorb moves
        table = root.findViewById(R.id.absorbMoves);
        if (DataShowActivity.charData[5].equals(""))
            table.setVisibility(View.GONE);
        else {
            for (; i < 26; i++) {
                if (((i+1)/2) % 2 == 0)
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

        //adding shield pressure options
        i = 110;//starting point of shield pressure datas
        if(!DataShowActivity.charData[i++].equals("Yes")){
            table = root.findViewById(R.id.shield_pressure_options);
            table.setVisibility(View.VISIBLE);
            for(; i<115; i++) {
                if (!DataShowActivity.charData[i].equals("")) {
                    String color = "";
                    String trade = "";
                    switch(i){
                        case 111:
                            color = "#75FFC4";
                            trade = "Good Trade: ";
                            break;
                        case 112:
                            color =  "#DB7979";
                            trade = "Bad Trade: ";
                            break;
                        case 113:
                            color = "#FF8A8A";
                            trade = "Loses: ";
                            break;
                        case 114:
                            color = "#75FFC4";
                            trade = "Can N-Airdodge";
                    }

                    newRow = getTableRow(table, color);
                    text = getTextView(newRow, 2f);
                    text.setText(trade);
                    newRow.addView(text);
                    text = getTextView(newRow, 1f);
                    text.setText(DataShowActivity.charData[i]);
                    if(i == 114){//coloring the texts
                        if(DataShowActivity.charData[i].equals("Yes")){
                            text.setBackgroundColor(Color.parseColor("#6CF324"));
                        } else{
                            text.setBackgroundColor(Color.parseColor("#EC1932"));
                        }
                    }
                    newRow.addView(text);
                    table.addView(newRow);
                }
            }
        }else{
            TableRow row = root.findViewById(R.id.shield_pressure);
            text = getTextView(row, 1f);
            text.setText("Yes");
            text.setBackgroundColor(Color.parseColor("#6CF324"));
            row.addView(text);
        }
        i = 115;//adding pressure notes
        if(!DataShowActivity.charData[i].equals("")){
            table = root.findViewById(R.id.pressure_notes);
            table.setVisibility(View.VISIBLE);
            newRow = getTableRow(table, "#FFF6A6");
            text = getTextView(newRow, 1f);
            text.setText(DataShowActivity.charData[i]);
            newRow.addView(text);
            table.addView(newRow);
        }

        //adding margin if notesRow is invisible or if notesRow and optionsRow are invisible
        TableLayout.LayoutParams params = new TableLayout.LayoutParams();
        int dpl = Math.round(60 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        int dp = Math.round(50 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));

        if(root.findViewById(R.id.pressure_notes).getVisibility() != View.VISIBLE) {
            if (root.findViewById(R.id.shield_pressure_options).getVisibility() == View.VISIBLE) {
                params.setMargins(dpl, 0, dpl, dp);
                root.findViewById(R.id.shield_pressure_options).setLayoutParams(params);
            } else {
                int dpt = Math.round(30 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
                params.setMargins(dpl, dpt, dpl, dp);
                root.findViewById(R.id.shield_pressure_table).setLayoutParams(params);
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