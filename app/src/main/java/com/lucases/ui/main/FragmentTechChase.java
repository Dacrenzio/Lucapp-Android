package com.lucases.ui.main;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.lucases.DataShowActivity;
import com.lucases.R;

public class FragmentTechChase extends Fragment {

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
        View root = inflater.inflate(R.layout.fragment_tech_chase, container, true);
        placeData(root);
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
