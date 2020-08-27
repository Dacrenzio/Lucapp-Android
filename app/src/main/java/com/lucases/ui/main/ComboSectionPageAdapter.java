package com.lucases.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ComboSectionPageAdapter extends FragmentStateAdapter {
    public ComboSectionPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int)
        Bundle args = new Bundle();
        Fragment fragment = new ComboViewFragment();
        args.putInt(ComboViewFragment.ARG_SECTION_NUMBER, position + 1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getItemCount() {
        return 4;
    }
}
