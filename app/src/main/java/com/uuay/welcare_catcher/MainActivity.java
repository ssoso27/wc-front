package com.uuay.welcare_catcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.uuay.welcare_catcher.util.PermissionChecker;
import com.uuay.welcare_catcher.view.AccountFragmentInfo;
import com.uuay.welcare_catcher.view.facilityList.FacilityListFragment;
import com.uuay.welcare_catcher.view.HomeFragment;
import com.uuay.welcare_catcher.view.SettingFragment;
import com.uuay.welcare_catcher.view.welfareList.WelfareListFragment;
import com.yalantis.guillotine.animation.GuillotineAnimation;

public class MainActivity extends AppCompatActivity {
    private CanaroTextView toolbarText;

    class TVOnClickListener implements CanaroTextView.OnClickListener {
        @Override
        public void onClick(View view) {
            Fragment fg = new HomeFragment();
            String menuTitle = getString(R.string.app_name);

            switch (view.getId()) {
                case R.id.menu_home :
                    fg = new HomeFragment();
                    menuTitle = getString(R.string.home);
                    break;

                case R.id.menu_facility :
                    fg = new FacilityListFragment();
                    menuTitle = getString(R.string.facility);
                    break;

                case R.id.menu_account :
                    fg = new AccountFragmentInfo();
                    menuTitle = getString(R.string.account);
                    break;

                case R.id.menu_setting :
                    fg = new SettingFragment();
                    menuTitle = getString(R.string.setting);
                    break;

                case R.id.menu_welfare :
                    fg = new WelfareListFragment();
                    menuTitle = getString(R.string.welfare);
                    break;

                default:
                    break;
            }

            toolbarText.setText(menuTitle);
            setFragment(fg);
        }
    }

    private static final long RIPPLE_DURATION = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setToolbar();
        setFragment(new HomeFragment());
        setEventListener();

        PermissionChecker permissionChecker = new PermissionChecker(this);
        permissionChecker.permissionCheck();
    }

    private void setEventListener() {
        TVOnClickListener tvOnClickListener = new TVOnClickListener();

        findViewById(R.id.menu_home).setOnClickListener(tvOnClickListener);
        findViewById(R.id.menu_account).setOnClickListener(tvOnClickListener);
        findViewById(R.id.menu_facility).setOnClickListener(tvOnClickListener);
        findViewById(R.id.menu_setting).setOnClickListener(tvOnClickListener);
        findViewById(R.id.menu_welfare).setOnClickListener(tvOnClickListener);
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        FrameLayout root = findViewById(R.id.root);
        View contentHamburger = findViewById(R.id.content_hamburger);
        toolbarText = findViewById(R.id.tv_toolbar);

//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setTitle(null);
//        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
        toolbarText.setText(getString(R.string.app_name));
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragment);
        fragmentTransaction.commit();
    }
}
