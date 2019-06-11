package com.uuay.welcare_catcher.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uuay.welcare_catcher.GlobalApplication;
import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.model.Account;
import com.uuay.welcare_catcher.util.FragmentChanger;
import com.uuay.welcare_catcher.util.LocalCookie;
import com.uuay.welcare_catcher.util.api.APIRequester;
import com.uuay.welcare_catcher.util.api.RestfulAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;

/*
ProfileFragment ??
클래스명을 추천받습니다.
 */
public class ProfileFragment extends Fragment {
    private TextView tvNickname, tvDisability, tvEmail, tvReceived, tvToReceive;

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_profile, container, false);
        final Account account = GlobalApplication.getCurrentAccount();

        tvNickname = (TextView) view.findViewById(R.id.tv_nickname);
        tvDisability = (TextView) view.findViewById(R.id.tv_disability);
        tvEmail = (TextView) view.findViewById(R.id.tv_email);
//        tvReceived = (TextView) view.findViewById(R.id.tv_account_received);
//        tvToReceive = (TextView) view.findViewById(R.id.tv_account_toreceive);
//        ImageView ivProfile = (ImageView) view.findViewById(R.id.iv_account_profile);
//        ImageButton imagebtn = (ImageButton) view.findViewById(R.id.imageButton);
//        final Bitmap[] bitmap = new Bitmap[1];

        tvNickname.setText(account.getNickname());
        tvEmail.setText(account.getEmail());
        tvDisability.setText(account.getDisability_type() + "장애 " + account.getDisability_grade());
//        tvReceived.setText("받는 중인 혜택");
//        tvToReceive.setText("받는 중인 혜택 중 하나 외 N개");

        view.findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CookieManager cookieManager = RestfulAdapter.getCookieManager();
                LocalCookie localCookie = LocalCookie.getInstance();

                GlobalApplication.setCurrentAccount(null);
                cookieManager.getCookieStore().removeAll();
                localCookie.clear();

                Toast.makeText(getContext(), "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                FragmentChanger.setFragment((AppCompatActivity) getActivity(), new HomeFragment());
            }
        });

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