package com.uuay.welcare_catcher.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uuay.welcare_catcher.R;

public class TestFragment extends Fragment {
    TextView tvAgegroup, tvType, tvGrade;
    String agegroup, type, grade;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        if(getArguments() != null) {
            agegroup = getArguments().getString("agegroup");
            type = getArguments().getString("type");
            grade = getArguments().getString("grade");
        }

        tvAgegroup = (TextView) view.findViewById(R.id.tv_test_agegroup);
        tvType = (TextView) view.findViewById(R.id.tv_test_type);
        tvGrade = (TextView) view.findViewById(R.id.tv_test_grade);

        tvAgegroup.setText(agegroup);
        tvType.setText(type);
        tvGrade.setText(grade);
        return view;
    }
//    public void showMessage(String agegroup, String type, String grade) {
//        tvAgegroup.setText(agegroup);
//        tvType.setText(type);
//        tvGrade.setText(grade);
//    }
}
