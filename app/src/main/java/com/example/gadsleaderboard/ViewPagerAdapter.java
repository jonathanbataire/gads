package com.example.gadsleaderboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private static final int CARD_ITEM_SIZE = 2;
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if (position == 0){
            fragment = new LearningLeadersFragment();
        } else {
            fragment = new SkillIQFragment();
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return CARD_ITEM_SIZE;
    }
}
