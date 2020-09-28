package com.lucapp.ui.main.TutorialFragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lucapp.R;

public class TutorialViewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment_tutorial, container, false);

        View magnetButton = root.findViewById(R.id.button_psi_magnet);
        magnetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RelativeLayout tutorials = root.findViewById(R.id.magnet_tutorials);
                if(tutorials.getVisibility() == View.GONE)
                    tutorials.setVisibility(View.VISIBLE);
                else
                    tutorials.setVisibility(View.GONE);
            }
        });

        View thunderButton = root.findViewById(R.id.button_thunder);
        thunderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RelativeLayout tutorials = root.findViewById(R.id.thunder_tutorials);
                if(tutorials.getVisibility() == View.GONE)
                    tutorials.setVisibility(View.VISIBLE);
                else
                    tutorials.setVisibility(View.GONE);
            }
        });

        View dairButton = root.findViewById(R.id.button_dairLoop);
        dairButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RelativeLayout tutorials = root.findViewById(R.id.dair_loop_tutorials);
                if(tutorials.getVisibility() == View.GONE)
                    tutorials.setVisibility(View.VISIBLE);
                else
                    tutorials.setVisibility(View.GONE);
            }
        });

        View djczButton = root.findViewById(R.id.button_djcz);
        djczButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                RelativeLayout tutorials = root.findViewById(R.id.djcz_tutorials);
                if(tutorials.getVisibility() == View.GONE) {
                    params.setMargins(getDP(30, root),getDP(40, root),getDP(30, root),0);
                    tutorials.setVisibility(View.VISIBLE);
                }else {
                    params.setMargins(getDP(30, root),getDP(40, root),getDP(30, root),getDP(50, root));
                    tutorials.setVisibility(View.GONE);
                }
                djczButton.setLayoutParams(params);
            }
        });
        return root;
    }

    private int getDP(int dp, View root) {
        return Math.round(dp * ((float) root.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
