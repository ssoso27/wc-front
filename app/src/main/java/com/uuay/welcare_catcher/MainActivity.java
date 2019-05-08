package com.uuay.welcare_catcher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.uuay.welcare_catcher.util.PermissionChecker;
import com.uuay.welcare_catcher.view.AccountFragmentInfo;
import com.uuay.welcare_catcher.view.facilityList.FacilityListFragment;
import com.uuay.welcare_catcher.view.HomeFragment;
import com.uuay.welcare_catcher.view.SettingFragment;
import com.uuay.welcare_catcher.view.welfareList.WelfareListFragment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private Toolbar tb;

    class SelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fg = new HomeFragment();

            switch (menuItem.getItemId()) {
                case R.id.menu_home :
                    fg = new HomeFragment();
                    tb.setTitle(R.string.app_name);
                    break;

                case R.id.menu_facility :
                    fg = new FacilityListFragment();
                    tb.setTitle(R.string.facility);
                    break;

                case R.id.menu_welfare :
                    fg = new WelfareListFragment();
                    tb.setTitle(R.string.welfare);
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

        PermissionChecker permissionChecker = new PermissionChecker(this);
        permissionChecker.permissionCheck();

        initToolbar();
        initBottomNav();
        setFragment(new HomeFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu) ;

        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_account :
                // TODO : 로그인 여부에 따라 회원가입창 or 계정관리창 띄우기
                setFragment(new AccountFragmentInfo());
                tb.setTitle(R.string.account);
                return true;

            case R.id.menu_settings:
                setFragment(new SettingFragment());
                tb.setTitle(R.string.setting);
                return true;
            default :
                return super.onOptionsItemSelected(item) ;
        }
    }

    private void initToolbar() {
        tb = findViewById(R.id.app_toolbar);
        setSupportActionBar(tb);
    }

    private void initBottomNav() {
        SelectedListener listener = new SelectedListener();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragment);
        fragmentTransaction.commit();
    }
}
