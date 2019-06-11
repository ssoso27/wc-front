package com.uuay.welcare_catcher.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kakao.auth.Session;
import com.kakao.usermgmt.LoginButton;
import com.uuay.welcare_catcher.MainActivity;
import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.util.FragmentChanger;
import com.uuay.welcare_catcher.util.api.APIRequester;
import com.uuay.welcare_catcher.util.kakao.SessionCallback;

public class LoginFragment extends Fragment {
    private SessionCallback callback;

    private EditText etEmail;
    private EditText etPassword;

    public LoginFragment() {

    }

    /*
     * 로그인 버튼을 클릭 했을시 access token을 요청하도록 설정한다.
     *
     * @param savedInstanceState 기존 session 정보가 저장된 객체
     */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_login, container, false);

        LoginButton loginButton = view.findViewById(R.id.com_kakao_login);
        loginButton.setSuportFragment(this); // set fragment for LoginButton

        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);

        ClickListener listener = new ClickListener();
        view.findViewById(R.id.btn_joinpage).setOnClickListener(listener);
        view.findViewById(R.id.btn_login).setOnClickListener(listener);

        etEmail = view.findViewById(R.id.et_email);
        etPassword = view.findViewById(R.id.et_password);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Session.getCurrentSession().removeCallback(callback);
    }

    class ClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_joinpage:
                    FragmentChanger.setFragment((AppCompatActivity) getActivity(), new JoinFragment());
                    break;

                case R.id.btn_login:
                    String email = etEmail.getText().toString();
                    String password = etPassword.getText().toString();
                    new LoginAsync().execute(email, password);
                    break;

                default:
                    break;
            }
        }
    }

    class LoginAsync extends AsyncTask<Object, Object, Boolean> {

        @Override
        protected Boolean doInBackground(Object... objects) {
            APIRequester apiRequester = new APIRequester();
            String email = (String) objects[0];
            String password = (String) objects[1];

            return apiRequester.login(email, password);
        }

        @Override
        protected void onPostExecute(Boolean isLogin) {
            if (isLogin) {
                Toast.makeText(getContext(), "로그인이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                FragmentChanger.setFragment((AppCompatActivity) getActivity(), new HomeFragment());
            } else {
                Toast.makeText(getContext(), "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
