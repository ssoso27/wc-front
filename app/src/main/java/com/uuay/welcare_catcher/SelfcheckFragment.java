package com.uuay.welcare_catcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uuay.welcare_catcher.R;

public class SelfcheckFragment extends Fragment {
    public SelfcheckFragment() {

    }

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
        Button secondBtn3 = (Button) view.findViewById(R.id.second_btn3);

        TextView thirdTextView = (TextView) view.findViewById(R.id.third_textView1);
        Button thirdBtn1 = (Button) view.findViewById(R.id.third_btn1);
        Button thirdBtn2 = (Button) view.findViewById(R.id.third_btn2);
        Button thirdBtn3 = (Button) view.findViewById(R.id.third_btn3);

        firstTextView.setText("1. 문항 ");
        firstBtn1.setText("선택문항");
        firstBtn2.setText("선택문항");
        firstBtn3.setText("선택문항");

        secondTextView.setText("2. 문항");
        secondBtn1.setText("선택문항");
        secondBtn2.setText("선택문항");
        secondBtn3.setText("선택문항");

        thirdTextView.setText("2. 문항");
        thirdBtn1.setText("선택문항");
        thirdBtn2.setText("선택문항");
        thirdBtn3.setText("선택문항");
        return view;
    }
}
