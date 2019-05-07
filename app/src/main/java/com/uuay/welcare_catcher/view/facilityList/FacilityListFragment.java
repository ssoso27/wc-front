package com.uuay.welcare_catcher.view.facilityList;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.model.Facility;
import com.uuay.welcare_catcher.model.MapButtonStatus;
import com.uuay.welcare_catcher.util.PermissionChecker;
import com.uuay.welcare_catcher.util.api.APIRequester;

import net.daum.mf.map.api.MapView;

import java.util.List;

import static com.uuay.welcare_catcher.model.MapButtonStatus.*;
import static com.uuay.welcare_catcher.view.facilityList.ScreenName.*;
import static net.daum.mf.map.api.MapView.CurrentLocationTrackingMode.*;

public class FacilityListFragment extends Fragment {

    private Activity activity;
    private FrameLayout frameBtn;
    private Button btnFixed;
    private Button btnCurrent;
    private Button btnStop;

    private View view;
    private MapView mapView;
    private ListView listView;
    private EditText etSearch;

    private APIRequester apiRequester;
    private PermissionChecker permissionChecker;

    private int size, page;

    class SearchAsyncTask extends AsyncTask<Object, Object, Object> {
        @Override
        protected void onPreExecute() {
            Log.d("비동기", "시작쓰");
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            String keyword = (String) objects[0];
            int size = (int) objects[1];
            int page = (int) objects[2];

            Log.d("비동기", "가져온당");
            apiRequester.findFacilities(keyword, size, page);

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            Log.d("비동기", "끗");

            listViewDataAdd(apiRequester.getFacilities());
        }
    }

    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_show_map :
                    changeScreen(KakaoMap);
                    break;

                case R.id.btn_show_list:
                    changeScreen(FacilityList);
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

                case R.id.btn_search:
                    String keyword = etSearch.getText().toString();
                    Log.d("키워드", keyword);
                    new SearchAsyncTask().execute(keyword, size, page);

                default:
                    break;
            }
        }
    }

    public FacilityListFragment() {
        apiRequester = new APIRequester();
        size = 10;
        page = 1;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity)
            activity = (Activity) context;

        permissionChecker = new PermissionChecker(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_facility_list, container, false);

        new SearchAsyncTask().execute("", size, page);

        initViews();
        initMap();
        changeScreen(KakaoMap);
        setEventListener();

        return view;
    }

    private void initMap() {
        mapView = new MapView(activity);

        ViewGroup mapViewContainer = (ViewGroup) view.findViewById(R.id.kakao_map);
        mapViewContainer.addView(mapView);

        if (permissionChecker.isPermit()) {
            mapView.setCurrentLocationTrackingMode(TrackingModeOnWithHeading);
        }

        frameBtn.removeAllViews();
        frameBtn.addView(btnFixed);
    }

    private void initViews() {
        frameBtn = view.findViewById(R.id.frame_map_btn);

        btnFixed = view.findViewById(R.id.btn_fixed_direction);
        btnCurrent = view.findViewById(R.id.btn_current_direction);
        btnStop = view.findViewById(R.id.btn_stop_location);

        listView = view.findViewById(R.id.lv_facilities);
        etSearch = view.findViewById(R.id.et_search);
    }

    private void setEventListener() {
        BtnOnClickListener listener = new BtnOnClickListener();

        view.findViewById(R.id.btn_search).setOnClickListener(listener);
        view.findViewById(R.id.btn_show_map).setOnClickListener(listener);
        view.findViewById(R.id.btn_show_list).setOnClickListener(listener);
        btnFixed.setOnClickListener(listener);
        btnCurrent.setOnClickListener(listener);
        btnStop.setOnClickListener(listener);
    }

    private void changeScreen(ScreenName screenName) {
        View mapView = view.findViewById(R.id.kakao_map);
        View listView = view.findViewById(R.id.lv_facilities);

        switch (screenName) {
            case KakaoMap:
                mapView.setVisibility(View.VISIBLE);
                frameBtn.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                break;

            case FacilityList:
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
//
//    private void search(String keyword, int size, int page) {
//        apiRequester.findFacilities(keyword, size, page);
//        listViewDataAdd();
//    }

    private void listViewDataAdd(List<Facility> list) {
        FacilityListAdapter adapter = new FacilityListAdapter();

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
