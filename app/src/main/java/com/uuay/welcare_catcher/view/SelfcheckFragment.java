package com.uuay.welcare_catcher.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.uuay.welcare_catcher.R;

public class SelfcheckFragment extends Fragment {
    String gender, val, type, grade, area;
    int age;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_selfcheck, container, false);

        Spinner typeSpinner = (Spinner) view.findViewById(R.id.spinner_disability_type);
        ArrayAdapter typeAdapter = setSpinner(typeSpinner);

        Spinner gradeSpinner = (Spinner) view.findViewById(R.id.spinner_disability_grade);
        ArrayAdapter gradeAdapter = setSpinner(gradeSpinner);

        Spinner areaSpinner = (Spinner) view.findViewById(R.id.spinner_area);
        ArrayAdapter areaAdapter = setSpinner(areaSpinner);

        RadioGroup rgGender = (RadioGroup) view.findViewById(R.id.rg_gender);

        rgGenderClick(rgGender);

        EditText etAge = (EditText) view.findViewById(R.id.et_age);

        etAgeClick(etAge);

        typeSelected(typeSpinner);
        gradeSelected(gradeSpinner);
        areaSelected(areaSpinner);
//        Button btnAddQuestion = (Button) view.findViewById(R.id.btn_add_question);
//        btnAddQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        Button btnEnd = (Button) view.findViewById(R.id.btn_selfcheck_end);
        btnClick(btnEnd);

        return view;
    }

    public void rgGenderClick(RadioGroup radioGroup) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) getView().findViewById(checkedId);
                gender = radioButton.getText().toString();
                Toast.makeText(SelfcheckFragment.super.getContext(), "성별 : " + gender,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void etAgeClick(EditText editText) {
        final EditText fEditText = editText;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    age = Integer.valueOf(fEditText.getText().toString());
                    Toast.makeText(SelfcheckFragment.super.getContext(), "나이 : " + age,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }

    public void typeSelected(Spinner spinner) {
            final Spinner fSpinner = spinner;
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    type = fSpinner.getSelectedItem().toString();
                    Toast.makeText(SelfcheckFragment.super.getContext(), "장애유형 : " + type,
                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
    }

    public void gradeSelected(Spinner spinner) {
        final Spinner fSpinner = spinner;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grade = fSpinner.getSelectedItem().toString();
                Toast.makeText(SelfcheckFragment.super.getContext(), "장애등급 : " + grade,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void areaSelected(Spinner spinner) {
        final Spinner fSpinner = spinner;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                area = fSpinner.getSelectedItem().toString();
                Toast.makeText(SelfcheckFragment.super.getContext(), "거주지역 : " + area,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    // 클래스명 짓는 거 ...
    public void btnClick(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
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

            default:
                return arrAdapter;
        }
    }
}
