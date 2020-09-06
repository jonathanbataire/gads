package com.example.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.util.TypedValue;
import android.view.Gravity;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    private Button toolbarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.main_title);
        setSupportActionBar(toolbar);
        addToolbarButton(toolbar);

        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab_layout);

        viewPager.setAdapter(createAdapter());
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText( position == 0 ? getString(R.string.learning_tab_title) : getString(R.string.skill_iq_tab_title));
                    }
                }).attach();
    }

    public void addToolbarButton(Toolbar toolbar){
        toolbarButton = new Button(this);
        toolbarButton.setText(getString(R.string.toolbar_button));
        toolbarButton.setTextSize(13);
        toolbarButton.setPadding(2,2,2,2);
        toolbarButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        toolbarButton.setBackground(getResources().getDrawable(R.drawable.button_shape));
        Toolbar.LayoutParams layoutParams =new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, 75);
        layoutParams.gravity= Gravity.END;
        layoutParams.rightMargin = 20;
        toolbarButton.setLayoutParams(layoutParams);
        toolbar.addView(toolbarButton);
        toolbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SubmitActivity.class);
                startActivity(intent);
            }
        });
    }

    private ViewPagerAdapter createAdapter() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        return viewPagerAdapter;
    }


}