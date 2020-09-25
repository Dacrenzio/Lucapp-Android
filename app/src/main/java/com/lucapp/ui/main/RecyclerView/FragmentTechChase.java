package com.lucapp.ui.main.RecyclerView;

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

public class FragmentTechChase extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tech_chase, container, true);
        placeData(root);
        if (DataShowActivity.charData[0].equals("Squirtle") || DataShowActivity.charData[0].equals("Ivysaur") || DataShowActivity.charData[0].equals("Charizard")) {
            TableLayout.LayoutParams params = new TableLayout.LayoutParams();
            int dpl = Math.round(30 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
            int dp = Math.round(90 * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
            System.out.println(dpl);
            params.setMargins(dpl, 0, dpl, dp);
            root.findViewById(R.id.tableBairTechYHRows).setLayoutParams(params);
        }
        return root;
    }

    private void placeData(View root) {
        TableRow[] rows = {root.findViewById(R.id.sweetZair), root.findViewById(R.id.sourZair), root.findViewById(R.id.sourfair), root.findViewById(R.id.sourftilt), root.findViewById(R.id.sourbair)};
        int i = 27;
        for (TableRow row : rows) {
            for (int j = 0; j < 4; j++) {
                TextView text = getTextView(row, 1);
                text.setText(DataShowActivity.charData[i++]);
                row.addView(text);
            }
        }

        rows = new TableRow[]{root.findViewById(R.id.battlefieldRow), root.findViewById(R.id.yoshiRow), root.findViewById(R.id.townRow)};
        for (TableRow row : rows) {
            TextView text = getTextView(row, 1f);
            text.setText(DataShowActivity.charData[i++]);
            row.addView(text);
            if (i == 50) {
                text = getTextView(row, 3f);
                text.setText("Max Rage\n" + DataShowActivity.charData[i]);
                row.addView(text);
            }
        }

        i++;
        rows = new TableRow[]{root.findViewById(R.id.rowBairTechBF), root.findViewById(R.id.rowBairTechSV), root.findViewById(R.id.rowBairTechLYM), root.findViewById(R.id.rowBairTechLYS), root.findViewById(R.id.rowBairTechYH)};
        for (TableRow row : rows) {
            for (int j = 0; j < 4; j++) {
                TextView text = getTextView(row, 1);
                text.setText(DataShowActivity.charData[i++]);
                row.addView(text);
            }
        }
    }

    private TextView getTextView(TableRow row, float w) {
        TextView text = new TextView(row.getContext());
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        params.weight = w;
        text.setLayoutParams(params);
        text.setGravity(Gravity.CENTER);
        return text;
    }
}
