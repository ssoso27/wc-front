package com.uuay.welcare_catcher.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.util.FragmentChanger;
import com.uuay.welcare_catcher.view.selfcheckList.SelfCheckList;

public class HomeFragment extends Fragment {
    SelfcheckFragment sf = new SelfcheckFragment();
    Fragment testF = new SelfCheckList();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false) ;

        Button btn = (Button) view.findViewById(R.id.btn_home_to_sc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentChanger.setFragment((AppCompatActivity) getActivity(), sf);
            }
        });

        return view ;
    }
}
