package com.uuay.welcare_catcher.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uuay.welcare_catcher.GlobalApplication;
import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.model.Account;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
ProfileFragment ??
클래스명을 추천받습니다.
 */
public class ProfileFragment extends Fragment {
    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_profile, container, false);
        final Account account = GlobalApplication.getCurrentAccount();

        TextView tv_nickname = (TextView) view.findViewById(R.id.tv_nickname);
        TextView tv_disability = (TextView) view.findViewById(R.id.tv_disability);
        TextView tv_email = (TextView) view.findViewById(R.id.tv_email);
//        final Bitmap[] bitmap = new Bitmap[1];

        tv_nickname.setText(account.getNickname());
        tv_email.setText(account.getEmail());
        tv_disability.setText(account.getDisability_type() + "장애 " + account.getDisability_grade());

//        if (current != null) {
//            bringProfileImg(current, img_profile, bitmap);
//        }
        return view;
    }

    private void bringProfileImg(final Account current, ImageView imageView, final Bitmap[] bitmap) {
        Thread mThread = new Thread() {

            @Override
            public void run() {

                try {
                    URL url = new URL(current.getProfile_img()); // URL 주소를 이용해서 URL 객체 생성

                    //  아래 코드는 웹에서 이미지를 가져온 뒤
                    //  이미지 뷰에 지정할 Bitmap을 생성하는 과정

                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream is = conn.getInputStream();
                    bitmap[0] = BitmapFactory.decodeStream(is);

                } catch(IOException ex) {

                }
            }
        };

        mThread.start(); // 웹에서 이미지를 가져오는 작업 스레드 실행.

        try {

            //  메인 스레드는 작업 스레드가 이미지 작업을 가져올 때까지
            //  대기해야 하므로 작업스레드의 join() 메소드를 호출해서
            //  메인 스레드가 작업 스레드가 종료될 까지 기다리도록 합니다.

            mThread.join();

            //  이제 작업 스레드에서 이미지를 불러오는 작업을 완료했기에
            //  UI 작업을 할 수 있는 메인스레드에서 이미지뷰에 이미지를 지정합니다.

            imageView.setImageBitmap(bitmap[0]);
        } catch (InterruptedException e) {

        }
    }
}