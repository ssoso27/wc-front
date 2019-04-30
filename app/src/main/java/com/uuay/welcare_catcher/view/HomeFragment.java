package com.uuay.welcare_catcher.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.uuay.welcare_catcher.R;

public class HomeFragment extends Fragment {
    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
        Button btn = (Button) view.findViewById(R.id.button2);

        btn.setOnClickListener(btnOnClick);


        return view;
    }
    Button.OnClickListener btnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String toastMessage;
            toastMessage = (String) "Button Click Event";
            Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
        }
    };
}