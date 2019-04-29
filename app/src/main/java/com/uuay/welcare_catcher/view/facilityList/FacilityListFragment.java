package com.uuay.welcare_catcher.view.facilityList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.uuay.welcare_catcher.R;


public class FacilityListFragment extends Fragment {

    private View view;

    public FacilityListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_facility_list, container, false);

        Button btnMap = view.findViewById(R.id.btn_show_map);
        Button btnList = view.findViewById(R.id.btn_show_list);

        btnMap.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(0);
            }
        });
        btnList.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(1);
            }
        });

        changeView(0);

        return view;
    }

    private void changeView(int index) {
        View mapView = view.findViewById(R.id.testTextview);
        View listView = view.findViewById(R.id.lv_facilities);

        switch (index) {
            case 0:
                mapView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.INVISIBLE);
                break;

            case 1:
                mapView.setVisibility(View.INVISIBLE);
                listView.setVisibility(View.VISIBLE);
                break;

            default:
                break;

        }
    }
}
