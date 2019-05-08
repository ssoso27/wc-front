package com.uuay.welcare_catcher.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.uuay.welcare_catcher.R;

public class SelfcheckFragment extends Fragment {
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