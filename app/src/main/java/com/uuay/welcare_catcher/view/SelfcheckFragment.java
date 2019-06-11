package com.uuay.welcare_catcher.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.uuay.welcare_catcher.R;

public class SelfcheckFragment extends Fragment {
    String gender, lifecycle, type, grade, area;
    private AppCompatActivity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_selfcheck, container, false);

        Spinner typeSpinner = (Spinner) view.findViewById(R.id.spinner_disability_type);
        Spinner gradeSpinner = (Spinner) view.findViewById(R.id.spinner_disability_grade);
        Spinner areaSpinner = (Spinner) view.findViewById(R.id.spinner_area);
        Spinner lifecycleSpinner = (Spinner) view.findViewById(R.id.spinner_agegroup);
        RadioGroup rgGender = (RadioGroup) view.findViewById(R.id.rg_gender);
        Button btnEnd = (Button) view.findViewById(R.id.btn_selfcheck_end);
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        ArrayAdapter typeAdapter = setSpinner(typeSpinner);
        ArrayAdapter gradeAdapter = setSpinner(gradeSpinner);
        ArrayAdapter areaAdapter = setSpinner(areaSpinner);
        ArrayAdapter lifecycleAdapter = setSpinner(lifecycleSpinner);
        setAlert(alert);

        rgGenderClick(rgGender);
        typeSelected(typeSpinner);
        gradeSelected(gradeSpinner);
        areaSelected(areaSpinner);
        ageSelected(lifecycleSpinner);

        btnClick(btnEnd, alert);

        return view;
    }

    public void rgGenderClick(RadioGroup radioGroup) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) getView().findViewById(checkedId);
                gender = radioButton.getText().toString();
            }
        });
    }

    public void typeSelected(Spinner spinner) {
        final Spinner fSpinner = spinner;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = fSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    public void gradeSelected(Spinner spinner) {
        final Spinner fSpinner = spinner;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grade = fSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    public void areaSelected(Spinner spinner) {
        final Spinner fSpinner = spinner;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                area = fSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    public void ageSelected(Spinner spinner) {
        final Spinner fSpinner = spinner;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lifecycle = fSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    public ArrayAdapter setSpinner(Spinner spinner) {
        ArrayAdapter arrAdapter = null;
        switch(spinner.getId()) {
            case R.id.spinner_disability_type:
                arrAdapter = ArrayAdapter.createFromResource(getContext(),
                        R.array.sc_question4, android.R.layout.simple_spinner_item);
                arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrAdapter);
                return arrAdapter;

            case R.id.spinner_disability_grade:
                arrAdapter = ArrayAdapter.createFromResource(getContext(),
                        R.array.sc_question5, android.R.layout.simple_spinner_item);
                arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrAdapter);
                return arrAdapter;

            case R.id.spinner_area:
                arrAdapter = ArrayAdapter.createFromResource(getContext(),
                        R.array.sc_question6, android.R.layout.simple_spinner_item);
                arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrAdapter);
                return arrAdapter;

            case R.id.spinner_agegroup:
                arrAdapter = ArrayAdapter.createFromResource(getContext(),
                        R.array.agegroup, android.R.layout.simple_spinner_item);
                arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrAdapter);
                return arrAdapter;

            default:
                return arrAdapter;
        }
    }

    // 클래스명 짓는 거 ...
    public void btnClick(Button btn, AlertDialog.Builder a) {
        final AlertDialog.Builder alert = a;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.setMessage(
                                "성별 " + gender + '\n' +
                                "연령대 " + lifecycle + '\n' +
                                "장애유형 " + type + '\n' +
                                "장애등급 " + grade + '\n' +
                                "거주지역 " + area);
                alert.show();
                ((setCategoryItemListener)activity).setCategoryItem(gender, lifecycle, type, grade, area);
            }
        });
    }

    public void setAlert(AlertDialog.Builder a) {
        a.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

    public interface setCategoryItemListener {
        void setCategoryItem(String gender, String lifecycle, String type, String grade, String area);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context != null && context instanceof AppCompatActivity) {
            this.activity = (AppCompatActivity)context;
        }
    }
}