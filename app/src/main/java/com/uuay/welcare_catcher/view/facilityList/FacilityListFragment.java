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

import com.uuay.welcare_catcher.util.PermissionChecker;
import com.uuay.welcare_catcher.R;

import net.daum.mf.map.api.MapView;

import static com.uuay.welcare_catcher.view.facilityList.MapButtonStatus.*;
import static net.daum.mf.map.api.MapView.CurrentLocationTrackingMode.*;


public class FacilityListFragment extends Fragment {

    private FrameLayout frameBtn;
    private Button btnFixed;
    private Button btnCurrent;
    private Button btnStop;

    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_show_map :
                    changeView(0);
                    break;

                case R.id.btn_show_list:
                    changeView(1);
                    break;

                case R.id.btn_fixed_direction:
                    changeButton(ToCurrentLocation);
                    break;

                case R.id.btn_current_direction:
                    changeButton(ToStopLocation);
                    break;

                case R.id.btn_stop_location:
                    changeButton(ToFixtedDirection);
                    break;

                default:
                    break;
            }
        }
    }

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

        MapView mapView = new MapView(activity);

        ViewGroup mapViewContainer = (ViewGroup) view.findViewById(R.id.kakao_map);
        mapViewContainer.addView(mapView);

        PermissionChecker permissionChecker = new PermissionChecker(activity);
        if (permissionChecker.isPermit()) {
            mapView.setCurrentLocationTrackingMode(TrackingModeOnWithHeading);
        }

        initViews();
        frameBtn.removeAllViews();
        frameBtn.addView(btnFixed);
        changeView(0);
        setEventListener();

        return view;
    }

    private void initViews() {
        frameBtn = view.findViewById(R.id.frame_map_btn);

        btnFixed = view.findViewById(R.id.btn_fixed_direction);
        btnCurrent = view.findViewById(R.id.btn_current_direction);
        btnStop = view.findViewById(R.id.btn_stop_location);
    }

    private void setEventListener() {
        BtnOnClickListener listener = new BtnOnClickListener();


        view.findViewById(R.id.btn_show_map).setOnClickListener(listener);
        view.findViewById(R.id.btn_show_list).setOnClickListener(listener);
        btnFixed.setOnClickListener(listener);
        btnCurrent.setOnClickListener(listener);
        btnStop.setOnClickListener(listener);
    }

    private void changeView(int index) {
        View mapView = view.findViewById(R.id.kakao_map);
        View listView = view.findViewById(R.id.lv_facilities);

        switch (index) {
            case 0:
                mapView.setVisibility(View.VISIBLE);
                frameBtn.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                break;

            case 1:
                mapView.setVisibility(View.GONE);
                frameBtn.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                break;

            default:
                break;

        }
    }

    private void changeButton(MapButtonStatus status) {
        frameBtn.removeViewAt(0);

        switch (status) {
            case ToCurrentLocation:
                frameBtn.addView(btnCurrent);
                break;

            case ToStopLocation:
                frameBtn.addView(btnStop);
                break;

            case ToFixtedDirection:
                frameBtn.addView(btnFixed);
                break;

            default:
                break;
        }
    }
}
