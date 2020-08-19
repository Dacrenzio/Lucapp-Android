package com.lucases.ui.main;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.lucases.DataShowActivity;
import com.lucases.R;

public class FragmentKillConfirm extends Fragment {
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
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_kill_confirm, container, false);
        placeData(root);
        return root;
    }

    private void placeData(View root) {
        TableLayout[] tables = {root.findViewById(R.id.tableupthrowkill), root.findViewById(R.id.tableupsmashkill), root.findViewById(R.id.tableDairLoopKill), root.findViewById(R.id.tablebairTobairKill)};
        int i = 51;
        for (TableLayout table : tables) {
            TableRow row = new TableRow(table.getContext());
            for (int j = 0; j < 4; j++) {
                TextView text = getTextView(row, 1);
                text.setText(DataShowActivity.charData[i++]);
                row.addView(text);
            }
            table.addView(row);
            if (i == 63) {
                row = new TableRow(root.findViewById(R.id.tableDairLoopSide).getContext());
                TextView text = getTextView(row, 1);
                text.setText(DataShowActivity.charData[i++]);
                row.addView(text);
                text = getTextView(row, 1);
                text.setText(DataShowActivity.charData[i++]);
                row.addView(text);
                TableLayout t = root.findViewById(R.id.tableDairLoopSide);
                t.addView(row);
                if (!DataShowActivity.charData[i].equals("")) {
                    row = new TableRow(root.findViewById(R.id.rowDairLoopNote).getContext());
                    text = getTextView(row, 1);
                    text.setText(DataShowActivity.charData[i++]);
                    row.addView(text);
                    t = root.findViewById(R.id.tableDairLoopNote);
                    t.setVisibility(View.VISIBLE);
                    t.addView(row);
                }
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
