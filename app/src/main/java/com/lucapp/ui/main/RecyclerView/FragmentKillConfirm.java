package com.lucapp.ui.main.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.lucapp.R;

public class FragmentKillConfirm extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.data_fragment_kill_confirm, container, false);
        placeData(root);

        //adding more bottom margin when the FAB is visible
        if (DataShowActivity.charData[0].equals("Squirtle") || DataShowActivity.charData[0].equals("Ivysaur") || DataShowActivity.charData[0].equals("Charizard")) {
            TableLayout.LayoutParams params = new TableLayout.LayoutParams();
            int dpl = Math.round(30 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
            int dp = Math.round(90 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
            params.setMargins(dpl, 0, dpl, dp);
            root.findViewById(R.id.tablebairTobairKill).setLayoutParams(params);
        }

        return root;
    }

    private void placeData(View root) {
        //array with the table I need to add 4 elements (4 numbers with the kill %)
        TableLayout[] tables = {root.findViewById(R.id.tableupthrowkill),
                root.findViewById(R.id.tableupsmashkill),
                root.findViewById(R.id.tableDairLoopKill),
                root.findViewById(R.id.tablebairTobairKill)};

        int i = 71; //starting point of the datas for the kill confirm
        for (TableLayout table : tables) {//for each table

            //create a row
            TableRow row = new TableRow(table.getContext());
            row.setBackgroundColor(Color.parseColor("#FFF6A6"));

            //add the 4 datas in the row
            for (int j = 0; j < 4; j++) {
                TextView text = getTextView(row, 1);
                text.setText(DataShowActivity.charData[i++]);
                row.addView(text);
            }
            //add the row
            table.addView(row);

            //the dair loop is an exception of the rule
            if (i == 83) {
                row = new TableRow(root.findViewById(R.id.tableDairLoopSide).getContext());
                row.setBackgroundColor(Color.parseColor("#FFF6A6"));
                TextView text = getTextView(row, 1);
                text.setText(DataShowActivity.charData[i++]);
                //added the front text(yes, no ,but)
                row.addView(text);
                text = getTextView(row, 1);

                //added the back text (yes, no, but)
                text.setText(DataShowActivity.charData[i++]);
                row.addView(text);
                TableLayout t = root.findViewById(R.id.tableDairLoopSide);
                t.addView(row);

                //if the dair loop has a note populate the note row and make it visible
                if (!DataShowActivity.charData[i].equals("")) {
                    row = new TableRow(root.findViewById(R.id.rowDairLoopNote).getContext());
                    row.setBackgroundColor(Color.parseColor("#FFF6A6"));
                    text = getTextView(row, 1);
                    text.setText(DataShowActivity.charData[i]);
                    row.addView(text);
                    t = root.findViewById(R.id.tableDairLoopNote);
                    t.setVisibility(View.VISIBLE);
                    t.addView(row);
                }
                i++;
            }
        }
    }

    private TextView getTextView(TableRow row, float w) {
        //creates a textView with a weight w
        TextView text = new TextView(row.getContext());
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        params.weight = w;
        text.setLayoutParams(params);
        text.setGravity(Gravity.CENTER);
        return text;
    }
}
