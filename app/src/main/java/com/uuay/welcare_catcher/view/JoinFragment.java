package com.uuay.welcare_catcher.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.util.api.APIRequester;

public class JoinFragment extends Fragment {
    private String agegroup = null;
    private String disability_grade = null;
    private String disability_type = null;
    private APIRequester apiRequester = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_join, container, false);

        apiRequester = new APIRequester();

        final EditText et_email = view.findViewById(R.id.et_email);
        final EditText et_password = view.findViewById(R.id.et_password);
        final EditText et_nickname = view.findViewById(R.id.et_nickname);
        Spinner spinner_agegroup = (Spinner) view.findViewById(R.id.spinner_agegroup);
        Spinner spinner_disability_grade = (Spinner) view.findViewById(R.id.spinner_disability_grade);
        Spinner spinner_disability_type = (Spinner) view.findViewById(R.id.spinner_disability_type);

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
                Toast.makeText(getContext(), apiRequester.duplicateEmail(email) + "", Toast.LENGTH_SHORT).show();
                // 회원가입
            }
        });

        return view;
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
}
