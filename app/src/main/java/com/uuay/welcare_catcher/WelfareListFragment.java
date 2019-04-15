package com.uuay.welcare_catcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class WelfareListFragment extends Fragment {
    public WelfareListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fv =  inflater.inflate(R.layout.frag_welfare_list, container, false);

        btnOnClickListener btnonClickListener = new btnOnClickListener();

        Button btn1, btn2, btn3, btn4;
        btn1 = (Button) fv.findViewById(R.id.btn1);
        btn1.setOnClickListener(btnonClickListener);
        btn2 = (Button) fv.findViewById(R.id.btn2);
        btn2.setOnClickListener(btnonClickListener);
        btn3 = (Button) fv.findViewById(R.id.btn3);
        btn3.setOnClickListener(btnonClickListener);
        btn4 = (Button) fv.findViewById(R.id.btn4);
        btn4.setOnClickListener(btnonClickListener
        );

        return fv;
    }

    class btnOnClickListener implements CanaroTextView.OnClickListener {
        @Override
        public void onClick(View view) {
            Fragment fg = new WelfareListFragment();;

            switch (view.getId()) {

                case R.id.btn1:
                    fg = new WelfareListTotal();
                    break;

                case R.id.btn2:
                    fg = new WelfareListLife();
                    break;

                case R.id.btn3:
                    fg = new WelfareListEdu();
                    break;

                case R.id.btn4:
                    fg = new WelfareListPrivate();
                    break;
            }

            setFragment(fg);
        }
    }


    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.in_fragment_place, fragment);
        ft.commit();
    }

}
