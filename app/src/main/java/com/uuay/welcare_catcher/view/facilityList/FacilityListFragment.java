package com.uuay.welcare_catcher.view.facilityList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uuay.welcare_catcher.R;


public class FacilityListFragment extends Fragment {
    public FacilityListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_facility_list, container, false);

        return view;
    }
}
