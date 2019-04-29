package com.uuay.welcare_catcher.view.facilityList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.uuay.welcare_catcher.R;

import net.daum.mf.map.api.MapView;


public class FacilityListFragment extends Fragment {

    private View view;
    private Activity activity;

    public FacilityListFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity)
            activity = (Activity) context;
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

        MapView mapView = new MapView(activity);

        ViewGroup mapViewContainer = (ViewGroup) view.findViewById(R.id.kakao_map);
        mapViewContainer.addView(mapView);

        changeView(0);

        return view;
    }

    private void changeView(int index) {
        View mapView = view.findViewById(R.id.kakao_map);
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
