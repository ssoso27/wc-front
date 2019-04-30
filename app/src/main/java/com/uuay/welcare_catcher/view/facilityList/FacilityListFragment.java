package com.uuay.welcare_catcher.view.facilityList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.model.Facility;
import com.uuay.welcare_catcher.util.PermissionChecker;
import com.uuay.welcare_catcher.util.api.APIRequester;

import net.daum.mf.map.api.MapView;

import java.util.List;

import static com.uuay.welcare_catcher.view.facilityList.MapButtonStatus.ToCurrentLocation;
import static com.uuay.welcare_catcher.view.facilityList.MapButtonStatus.ToFixtedDirection;
import static com.uuay.welcare_catcher.view.facilityList.MapButtonStatus.ToStopLocation;
import static net.daum.mf.map.api.MapView.CurrentLocationTrackingMode.TrackingModeOff;
import static net.daum.mf.map.api.MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading;
import static net.daum.mf.map.api.MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading;


public class FacilityListFragment extends Fragment {

    private FrameLayout frameBtn;
    private Button btnFixed;
    private Button btnCurrent;
    private Button btnStop;
    private MapView mapView;
    private ListView listView;
    private APIRequester apiRequester;

    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            PermissionChecker permissionChecker = new PermissionChecker(activity);

            switch (v.getId()) {
                case R.id.btn_show_map :
                    changeView(0);
                    break;

                case R.id.btn_show_list:
                    changeView(1);
                    break;

                case R.id.btn_fixed_direction:
                    if (permissionChecker.isPermit()) {
                        mapView.setCurrentLocationTrackingMode(TrackingModeOnWithHeading);
                        changeButton(ToCurrentLocation);
                    } else {
                        permissionChecker.permissionCheck();
                    }
                    break;

                case R.id.btn_current_direction:
                    if (permissionChecker.isPermit()) {
                        mapView.setCurrentLocationTrackingMode(TrackingModeOff);
                        changeButton(ToStopLocation);
                    } else {
                        permissionChecker.permissionCheck();
                    }
                    break;

                case R.id.btn_stop_location:
                    if (permissionChecker.isPermit()) {
                        mapView.setCurrentLocationTrackingMode(TrackingModeOnWithoutHeading);
                        changeButton(ToFixtedDirection);
                    } else {
                        permissionChecker.permissionCheck();
                    }
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

        apiRequester = new APIRequester();
        apiRequester.findFacilities("%", 10, 1);

        mapView = new MapView(activity);

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

        listView = view.findViewById(R.id.lv_facilities);
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
                listViewDataAdd();
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

    public void listViewDataAdd() {
        FacilityListAdapter adapter = new FacilityListAdapter();
        List<Facility> list = apiRequester.getFacilities();

        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Facility facility = list.get(i);
                adapter.addItem(
                        facility.getName(),
                        facility.getType().equals("resident") ? "공공기관" : "복지시설",
                        facility.getAddress(),
                        facility.getTelNumber());
            }
        }

        // set adapter on listView
        listView.setAdapter(adapter);

    }
}
