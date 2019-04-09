package com.example.welcare_catcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.yalantis.guillotine.animation.GuillotineAnimation;

public class MainActivity extends AppCompatActivity {
    private static final long RIPPLE_DURATION = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        FrameLayout root = findViewById(R.id.root);
        View contentHamburger = findViewById(R.id.content_hamburger);

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
//
//        Button.OnClickListener onClickListener = new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()) {
//                    case R.id.btn_facility_list :
//                        Intent intent = new Intent(MainActivity.this, FacilityListActivity.class) ;
//                        startActivity(intent) ;
//                        break;
//
//                    default:
//                        break;
//                }
//            }
//        };
//
//        findViewById(R.id.btn_facility_list).setOnClickListener(onClickListener);
    }
}
