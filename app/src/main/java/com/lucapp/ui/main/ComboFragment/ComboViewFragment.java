package com.lucapp.ui.main.ComboFragment;

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

import com.lucapp.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class ComboViewFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";
    private String[] dataRows;
    private String[] percent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        switch(index) {
            case 1:
                dataRows = ComboNavMenuPrincipal.datasRowLow;
                percent = new String[]{"0% Combo"};
                break;
            case 2:
                dataRows = ComboNavMenuPrincipal.datasRowMedium;
                percent = new String[]{"30% Combo"};
                break;
            case 3:
                dataRows = ComboNavMenuPrincipal.datasRowMedHigh;
                percent = new String[]{"50% combo", "75% Combo"};
                break;
            default:
                dataRows = ComboNavMenuPrincipal.datasRowHigh;
                percent = new String[]{"100% Combo", "150% Combo"};
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_combo, container, false);
        placeData(root);
        return root;
    }

    private void placeData(View root) {
        LinearLayout page = root.findViewById(R.id.comboLinearLayout);
        TableLayout newTableRoot;
        TableRow newRow;
        TextView newText;

        boolean first = true;
        int c = 0;
        for(String row: dataRows) {
            String[] datas = row.split(";");
            if (c < 1 && percent.length != 1 && datas[0].contains(percent[c + 1])) {
                c++;
                continue;
            }
            //step 1: creating base table
            newTableRoot = new TableLayout(root.getContext());
            TableLayout.LayoutParams params = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
            if (first) {
                params.setMargins(getDP(30, root), getDP(50, root), getDP(30, root), getDP(50, root));
                first = false;
            } else
                params.setMargins(getDP(30, root), 0, getDP(30, root), getDP(50, root));
            newTableRoot.setPadding(getDP(1, root), getDP(1, root), getDP(1, root), getDP(1, root));
            newTableRoot.setLayoutParams(params);
            newTableRoot.setBackgroundColor(Color.parseColor("#FFFFFF"));

            //step 2: create a new row and add text "n% Combo"
            newRow = getTableRow(newTableRoot, "#5efcff", 12);
            newText = getTextView(newRow, 1f);
            newText.setGravity(Gravity.LEFT);
            newText.setText(percent[c]);
            newText.setTypeface(null, Typeface.BOLD);
            newRow.addView(newText);
            newTableRoot.addView(newRow);

            //step 3: adding a new row and add the combo starter
            newRow = getTableRow(newTableRoot, "#38491A", 8);
            newText = getTextView(newRow, 1f);
            newText.setText(datas[0]);
            newText.setTextColor(Color.parseColor("#FFFFFF"));
            newRow.addView(newText);
            newTableRoot.addView(newRow);

            //step 4.0: create a table that has a row that has 2 tables
            TableLayout newTable = getTable(newTableRoot, 0);
            //step 4.1: create the row that has 2 tables
            newRow = getTableRow(newTable, "#38491A", 0);
            newRow.setBackgroundColor(Color.TRANSPARENT);
            //step 4.2: create 2 tables. table Combo
            TableLayout tableIntern = getTable(newRow, 0);
            tableIntern.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 3f));

            for (int i = 1; i < 7; i++) {
                //adding all the combo execution rows
                if (datas[i].equals("")) {
                    break;
                }
                TableRow comboRow;
                if (i % 2 == 1) {
                    comboRow = getTableRow(tableIntern, "#FFF6A6", 8);
                } else {
                    comboRow = getTableRow(tableIntern, "#75FFC4", 8);
                }
                newText = getTextView(comboRow, 1f);
                newText.setGravity(Gravity.LEFT);
                newText.setText(datas[i]);
                comboRow.addView(newText);
                tableIntern.addView(comboRow);
            }
            newRow.addView(tableIntern);

            //step 4.3: creating table where write total Damage
            tableIntern = getTable(newRow, 8);
            tableIntern.setBackgroundColor(Color.parseColor("#FFF6A6"));
            TableRow damageRow = getTableRow(tableIntern, "#FFF6A6", 0);
            tableIntern.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1f));
            newText = getTextView(damageRow, 1f);
            newText.setText("Damage: " + datas[7] + "%");
            damageRow.addView(newText);
            tableIntern.addView(damageRow);
            newRow.addView(tableIntern);
            newTable.addView(newRow);
            newTableRoot.addView(newTable);

            //step 5.0: create a table for videoView & notes
            newTable = getTable(newTableRoot, 0);

            //step 5.1: create the row for the videoView
            newRow = getTableRow(newTable, "#FFF6A6", 4);

            //step 5.2: create the YoutubePlayerView
            YouTubePlayerView videoView = new YouTubePlayerView(newRow.getContext());
            videoView.setEnableAutomaticInitialization(false);
            videoView.initialize(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(YouTubePlayer youTubePlayer) {
                    youTubePlayer.cueVideo(datas[9], 0);
                }
            }, true);

            videoView.getPlayerUiController().showFullscreenButton(false).showVideoTitle(false).showMenuButton(false);
            videoView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));

            newRow.addView(videoView);
            newTable.addView(newRow);

            if (!datas[8].equals("")) {
                //step 5.3: create the row for the Note text
                newRow = getTableRow(newTable, "#38491A", 8);
                newText = getTextView(newRow, 1f);
                newText.setText("Note:");
                newText.setTextColor(Color.parseColor("#FFFFFF"));
                newRow.addView(newText);
                newTable.addView(newRow);

                //step 5.4: create the row for the Note data
                newRow = getTableRow(newTable, "#FFF6A6", 8);
                newText = getTextView(newRow, 1f);
                newText.setText(datas[8]);
                newRow.addView(newText);
                newTable.addView(newRow);
            }

            newTableRoot.addView(newTable);
            page.addView(newTableRoot);
        }
    }

    //this method create a tableView
    private TableLayout getTable(View page, int paddingDP) {
        TableLayout newTable = new TableLayout(page.getContext());
        newTable.setPadding(getDP(paddingDP, page), getDP(paddingDP, page), getDP(paddingDP, page), getDP(paddingDP, page));
        newTable.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        return newTable;
    }

    //this method create a row with a set padding and color
    private TableRow getTableRow(TableLayout table, String color, int dp) {
        TableRow newRow = new TableRow(table.getContext());
        newRow.setPadding(getDP(dp, table), getDP(dp, table), getDP(dp, table), getDP(dp, table));
        newRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        newRow.setBackgroundColor(Color.parseColor(color));
        return newRow;
    }

    //this method create a textView with a weight w
    private TextView getTextView(TableRow row, float w) {
        TextView text = new TextView(row.getContext());
        text.setTypeface(Typeface.DEFAULT_BOLD);
        text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, w));
        text.setGravity(Gravity.CENTER);
        return text;
    }

    //this method calculate the dense pixel in pixel for each phone
    private int getDP(int dp, View root) {
        return Math.round(dp * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}