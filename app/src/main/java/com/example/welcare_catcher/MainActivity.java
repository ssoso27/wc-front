package com.example.welcare_catcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_facility_list :
                        Intent intent = new Intent(MainActivity.this, FacilityListActivity.class) ;
                        startActivity(intent) ;
                        break;

                    default:
                        break;
                }
            }
        };

        findViewById(R.id.btn_facility_list).setOnClickListener(onClickListener);
    }
}
