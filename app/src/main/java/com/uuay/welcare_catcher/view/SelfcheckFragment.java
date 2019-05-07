package com.uuay.welcare_catcher.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.uuay.welcare_catcher.R;

public class SelfcheckFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_selfcheck, container, false);

        TextView firstTextView = (TextView) view.findViewById(R.id.first_textView1);
        Button firstBtn1 = (Button) view.findViewById(R.id.first_btn1);
        Button firstBtn2 = (Button) view.findViewById(R.id.first_btn2);
        Button firstBtn3 = (Button) view.findViewById(R.id.first_btn3);

        TextView secondTextView = (TextView) view.findViewById(R.id.second_textView1);
        Button secondBtn1 = (Button) view.findViewById(R.id.second_btn1);
        Button secondBtn2 = (Button) view.findViewById(R.id.second_btn2);

        TextView thirdTextView = (TextView) view.findViewById(R.id.third_textView1);
        EditText thirdEditText = (EditText) view.findViewById(R.id.third_edittext1);

        firstTextView.setText("1. 대상자와 관계가 어떻게 되시나요? ");
        firstBtn1.setText("본인");
        firstBtn2.setText("자녀");
        firstBtn3.setText("부모");

        secondTextView.setText("2. 대상자의 성별을 선택해 주세요");
        secondBtn1.setText("남자");
        secondBtn2.setText("여자");

        thirdTextView.setText("3. 나이를 적어주세요");

        return view;
    }
}