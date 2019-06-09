package com.uuay.welcare_catcher.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.util.api.APIRequester;

public class JoinFragment extends Fragment {
    private String agegroup = null;
    private String disability_grade = null;
    private String disability_type = null;

    private Boolean isDuplicate = true;

    private EditText et_email;
    private EditText et_password;
    private EditText et_nickname;
    private Spinner spinner_agegroup;
    private Spinner spinner_disability_grade;
    private Spinner spinner_disability_type;

    private APIRequester apiRequester = null;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag_join, container, false);

        apiRequester = new APIRequester();
        initViews();

        ItemListener itemListener = new ItemListener();
        spinner_agegroup.setOnItemSelectedListener(itemListener);
        spinner_disability_grade.setOnItemSelectedListener(itemListener);
        spinner_disability_type.setOnItemSelectedListener(itemListener);

        view.findViewById(R.id.btn_join).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 데이터들 가져오고
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                String nickname = et_nickname.getText().toString();

                // 이메일 검사 한 다음에
                new DuplicationCheckAsync().execute(email);

                // 회원가입
            }
        });

        return view;
    }

    private void initViews() {
        et_email = view.findViewById(R.id.et_email);
        et_password = view.findViewById(R.id.et_password);
        et_nickname = view.findViewById(R.id.et_nickname);
        spinner_agegroup = (Spinner) view.findViewById(R.id.spinner_agegroup);
        spinner_disability_grade = (Spinner) view.findViewById(R.id.spinner_disability_grade);
        spinner_disability_type = (Spinner) view.findViewById(R.id.spinner_disability_type);
    }

    class ItemListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (parent.getId()) {
                case R.id.spinner_agegroup:
                    agegroup = (String) parent.getItemAtPosition(position);
                    break;

                case R.id.spinner_disability_type:
                    disability_type = (String) parent.getItemAtPosition(position);
                    break;

                case R.id.spinner_disability_grade:
                    disability_grade = (String) parent.getItemAtPosition(position);
                    break;

                default:
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    class DuplicationCheckAsync extends AsyncTask<Object, Object, Boolean> {
        @Override
        protected Boolean doInBackground(Object[] objects) {
            String email = (String) objects[0];

            return apiRequester.duplicateEmail(email);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            isDuplicate = result;
            Toast.makeText(getContext(), isDuplicate + "", Toast.LENGTH_SHORT).show();
        }
    }

}
