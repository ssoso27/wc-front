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
<<<<<<< HEAD
=======
import android.widget.Spinner;
>>>>>>> feature/F-18
import android.widget.TextView;
import android.widget.Toast;

import com.uuay.welcare_catcher.R;

public class SelfcheckFragment extends Fragment {
<<<<<<< HEAD
    private boolean mProtectFromCheckedChange = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_selfcheck, container, false);

        TextView firstTextView = (TextView) view.findViewById(R.id.first_textView1);
        RadioButton firstBtn1 = (RadioButton) view.findViewById(R.id.first_btn1);
        RadioButton firstBtn2 = (RadioButton) view.findViewById(R.id.first_btn2);
        RadioButton firstBtn3 = (RadioButton) view.findViewById(R.id.first_btn3);

        firstTextView.setText("1. 대상자와 관계가 어떻게 되시나요? ");
        firstBtn1.setText("본인");
        firstBtn2.setText("자녀");
        firstBtn3.setText("부모");


        TextView secondTextView = (TextView) view.findViewById(R.id.second_textView1);
        RadioButton secondBtn1 = (RadioButton) view.findViewById(R.id.second_btn1);
        RadioButton secondBtn2 = (RadioButton) view.findViewById(R.id.second_btn2);

        secondTextView.setText("2. 대상자의 성별을 선택해 주세요");
        secondBtn1.setText("남자");
        secondBtn2.setText("여자");


        TextView thirdTextView = (TextView) view.findViewById(R.id.third_textView1);
//        EditText thirdEditText = (EditText) view.findViewById(R.id.third_edittext1);

        thirdTextView.setText("3. 나이를 적어주세요");


        TextView fourthTextView = (TextView) view.findViewById(R.id.fourth_textView1);
        RadioGroup fourthrgp = (RadioGroup) view.findViewById(R.id.fourth_radio_group);
        final RadioButton fourthBtn1 = (RadioButton) view.findViewById(R.id.fourth_btn1);
        RadioButton fourthBtn2 = (RadioButton) view.findViewById(R.id.fourth_btn2);
        RadioButton fourthBtn3 = (RadioButton) view.findViewById(R.id.fourth_btn3);
        RadioButton fourthBtn4 = (RadioButton) view.findViewById(R.id.fourth_btn4);
        RadioButton fourthBtn5 = (RadioButton) view.findViewById(R.id.fourth_btn5);
        RadioButton fourthBtn6 = (RadioButton) view.findViewById(R.id.fourth_btn6);
        RadioButton fourthBtn7 = (RadioButton) view.findViewById(R.id.fourth_btn7);
        RadioButton fourthBtn8 = (RadioButton) view.findViewById(R.id.fourth_btn8);
        RadioButton fourthBtn9 = (RadioButton) view.findViewById(R.id.fourth_btn9);
        RadioButton fourthBtn10 = (RadioButton) view.findViewById(R.id.fourth_btn10);
        RadioButton fourthBtn11 = (RadioButton) view.findViewById(R.id.fourth_btn11);
        RadioButton fourthBtn12 = (RadioButton) view.findViewById(R.id.fourth_btn12);
        RadioButton fourthBtn13 = (RadioButton) view.findViewById(R.id.fourth_btn13);
        RadioButton fourthBtn14 = (RadioButton) view.findViewById(R.id.fourth_btn14);
        RadioButton fourthBtn15 = (RadioButton) view.findViewById(R.id.fourth_btn15);

        fourthTextView.setText("3. 어떤 장애를 가지고 계신가요?");
        fourthrgp.setOnCheckedChangeListener(mRadioCheck);

        fourthBtn1.setText("지체");
        fourthBtn2.setText("뇌병변");
        fourthBtn3.setText("시각");
        fourthBtn4.setText("청각");
        fourthBtn5.setText("언어");
        fourthBtn6.setText("지적");
        fourthBtn7.setText("정신");
        fourthBtn8.setText("자폐성");
        fourthBtn9.setText("신장");
        fourthBtn10.setText("심장");
        fourthBtn11.setText("호흡기");
        fourthBtn12.setText("간");
        fourthBtn13.setText("안면");
        fourthBtn14.setText("간질");
        fourthBtn15.setText("장루, 요루");

        return view;
    }
    RadioGroup.OnCheckedChangeListener mRadioCheck =
            new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (group.getId() == R.id.fourth_radio_group) {
                        switch(checkedId) {
                            case R.id.fourth_btn1:
                                group.check(R.id.fourth_btn1);
                                break;
                            case R.id.fourth_btn2:
                                group.check(R.id.fourth_btn2);
                                break;
                            case R.id.fourth_btn3:
                                group.check(R.id.fourth_btn3);
                                break;
                            case R.id.fourth_btn4:
                                group.check(R.id.fourth_btn4);
                                break;
                            case R.id.fourth_btn5:
                                group.check(R.id.fourth_btn5);
                                break;
                            case R.id.fourth_btn6:
                                group.check(R.id.fourth_btn6);
                                break;
                            case R.id.fourth_btn7:
                                group.check(R.id.fourth_btn7);
                                break;
                            case R.id.fourth_btn8:
                                group.check(R.id.fourth_btn8);
                                break;
                            case R.id.fourth_btn9:
                                group.check(R.id.fourth_btn9);
                                break;
                            case R.id.fourth_btn10:
                                group.check(R.id.fourth_btn10);
                                break;
                            case R.id.fourth_btn11:
                                group.check(R.id.fourth_btn11);
                                break;
                            case R.id.fourth_btn12:
                                group.check(R.id.fourth_btn12);
                                break;
                            case R.id.fourth_btn13:
                                group.check(R.id.fourth_btn13);
                                break;
                            case R.id.fourth_btn14:
                                group.check(R.id.fourth_btn14);
                                break;
                            case R.id.fourth_btn15:
                                group.check(R.id.fourth_btn15);
                                break;
                            default:
                                break;

                        }
                    }
                }
            };
}
=======
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
>>>>>>> feature/F-18
