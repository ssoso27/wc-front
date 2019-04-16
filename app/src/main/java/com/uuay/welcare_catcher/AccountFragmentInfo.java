package com.uuay.welcare_catcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/*
AccountFragmentInfo ??
클래스명을 추천받습니다.
 */
public class AccountFragmentInfo extends Fragment {
    public AccountFragmentInfo() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_account_info, container, false);

        TextView textView1 = (TextView) view.findViewById(R.id.textView1);
        TextView textView2 = (TextView) view.findViewById(R.id.textView2);
        TextView textView3 = (TextView) view.findViewById(R.id.textView3);
        TextView textView4 = (TextView) view.findViewById(R.id.textView4);
        TextView textView5 = (TextView) view.findViewById(R.id.textView5);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        ImageButton imagebtn = (ImageButton) view.findViewById(R.id.imageButton);

        textView1.setText("사용자 이름");
        textView2.setText("장애유형 장애등급");
        textView3.setText("거주지역");
        textView4.setText("받는 중인 혜택");
        textView5.setText("받는 중인 혜택 중 하나 외 N개");
        return view;
    }
}