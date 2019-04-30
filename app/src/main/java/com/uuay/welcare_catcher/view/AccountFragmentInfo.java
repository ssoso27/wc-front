package com.uuay.welcare_catcher.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.uuay.welcare_catcher.R;

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

        // 카카오 api
        String nickname = "가붕이";   //닉네임
        String mail_address = "메일주소는 여기";   // 메일주소
        String dis_type = "유형";   // 장애유형
        String dis_rate = "등급";   // 장애등급

        textView1.setText(nickname);
        textView2.setText(dis_type + " " + dis_rate);
        textView3.setText(mail_address);
        textView4.setText("받는 중인 혜택");
        textView5.setText("받는 중인 혜택 중 하나 외 N개");

        return view;
    }
}
