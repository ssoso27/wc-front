package com.uuay.welcare_catcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class WelfareList extends Fragment {

    public WelfareList() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.welfare_list, null) ;

        WelfareListAdapter adapter = new WelfareListAdapter();

        ListView listview = (ListView) view.findViewById(R.id.listView) ;
        listview.setAdapter(adapter) ;

        // 첫 번째 아이템 추가.
        adapter.addItem("Box", "Account Box Black 36dp", "", "", "") ;
        // 두 번째 아이템 추가.
        adapter.addItem("Box", "Account Box Black 36dp", "", "", "") ;
        // 세 번째 아이템 추가.
        adapter.addItem("Box", "Account Box Black 36dp", "", "", "") ;

        return view;
        
//        btnOnClickListener btnonClickListener = new btnOnClickListener();
//
//        Button btn1, btn2, btn3, btn4;
//        btn1 = (Button) view.findViewById(R.id.btn1);
//        btn1.setOnClickListener(btnonClickListener);
//        btn1.set
//        btn2 = (Button) view.findViewById(R.id.btn2);
//        btn2.setOnClickListener(btnonClickListener);
//        btn3 = (Button) view.findViewById(R.id.btn3);
//        btn3.setOnClickListener(btnonClickListener);
//        btn4 = (Button) view.findViewById(R.id.btn4);
//        btn4.setOnClickListener(btnonClickListener);

    }

//    class btnOnClickListener {
//         button 클릭 시 리스트 호출
//        @Override
//        public void btnOnClickListener() {
//
//        }
//    }
}
