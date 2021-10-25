package com.lucapp.ui.main.RecyclerView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStateAdapter {
    public SectionsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int)
        Bundle args = new Bundle();
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new FragmentMiscInfo();
                args.putInt(FragmentMiscInfo.ARG_SECTION_NUMBER, position + 1);
                break;
            case 1:
                fragment = new FragmentTechChase();
                args.putInt(FragmentTechChase.ARG_SECTION_NUMBER, position + 1);
                break;
            default:
                fragment = new FragmentKillConfirm();
                args.putInt(FragmentKillConfirm.ARG_SECTION_NUMBER, position + 1);
        }
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getItemCount() {
        return 3;
    }
}