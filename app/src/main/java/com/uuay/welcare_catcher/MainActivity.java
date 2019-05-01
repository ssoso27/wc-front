package com.uuay.welcare_catcher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.uuay.welcare_catcher.util.PermissionChecker;
import com.uuay.welcare_catcher.view.AccountFragmentInfo;
import com.uuay.welcare_catcher.view.facilityList.FacilityListFragment;
import com.uuay.welcare_catcher.view.HomeFragment;
import com.uuay.welcare_catcher.view.SettingFragment;
import com.uuay.welcare_catcher.view.welfareList.WelfareListFragment;

public class MainActivity extends AppCompatActivity {
    class SelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fg = new HomeFragment();

            switch (menuItem.getItemId()) {
                case R.id.menu_home :
                    fg = new HomeFragment();
//                    menuTitle = getString(R.string.home);
                    break;

                case R.id.menu_facility :
                    fg = new FacilityListFragment();
//                    menuTitle = getString(R.string.facility);
                    break;

                case R.id.menu_account :
                    fg = new AccountFragmentInfo();
//                    menuTitle = getString(R.string.account);
                    break;

                case R.id.menu_setting :
                    fg = new SettingFragment();
//                    menuTitle = getString(R.string.setting);
                    break;

                case R.id.menu_welfare :
                    fg = new WelfareListFragment();
//                    menuTitle = getString(R.string.welfare);
                    break;

                default:
                    break;
            }

            setFragment(fg);
            return true;
        }
    }

    private static final long RIPPLE_DURATION = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SelectedListener listener = new SelectedListener();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
        setFragment(new HomeFragment());

        PermissionChecker permissionChecker = new PermissionChecker(this);
        permissionChecker.permissionCheck();
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragment);
        fragmentTransaction.commit();
    }
}
