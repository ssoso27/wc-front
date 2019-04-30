package com.uuay.welcare_catcher.view.welfareList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.view.welfareList.WelfareListAdapter;

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
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_welfare_list, null) ;

        WelfareListAdapter adapter = new WelfareListAdapter();

        ListView listview = (ListView) view.findViewById(R.id.listView) ;
        listview.setAdapter(adapter) ;
        listview.setOnItemClickListener(listViewClickListener);
        // 첫 번째 아이템 추가.
        adapter.addItem("장애청소년 운동선수지원사업 '점프'", "사회복지법인 밀알복지재단",
                "생활", "전체", "전체") ;
        // 두 번째 아이템 추가.
        adapter.addItem("저소득층을 위한 교육나눔", "주식회사 제이티비그룹", "교육", "전체", "전체") ;
        // 세 번째 아이템 추가.
        adapter.addItem("장애아동,발달장애인 지원", "한국장애인개발원", "생활", "전체", "발달장애") ;

        int count = adapter.getCount();
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText("총 " + count + "건");

        Button btn1, btn2, btn3, btn4;
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn1.setOnClickListener(btnOnClick);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn2.setOnClickListener(btnOnClick);
        btn3 = (Button) view.findViewById(R.id.btn3);
        btn3.setOnClickListener(btnOnClick);
        btn4 = (Button) view.findViewById(R.id.btn4);
        btn4.setOnClickListener(btnOnClick);
        return view;
    }
    AdapterView.OnItemClickListener listViewClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parentView, View clickedView, int position, long id) {

            // 임시로 Toast 메시지 출력
            String toastMessage = (String) " is selected. position is " + position + ", and id is " + id;
            Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
        }

    };
    Button.OnClickListener btnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String toastMessage;
            switch(getView().getId()) {
                case R.id.btn1:
                    //필터링 전체
                    toastMessage = (String) "Button Click Event";
                    Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn2:
                    //필터링 생활
                    toastMessage = (String) "Button Click Event";
                    Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn3:
                    //필터링 교육
                    toastMessage = (String) "Button Click Event";
                    Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn4:
                    //필터링 민간
                    toastMessage = (String) "Button Click Event";
                    Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

//      필터링 관련
//    @Override
//    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//    }
//
//    @Override
//    public void onTextChanged(CharSequence s, int start, int before, int count) {
//    }

//    class btnOnClickListener implements WelfareButton.OnClickListener {
//        @Override
//        public void onClick(View view) {
//            switch(view.getId()){
//                case R.id.btn1:
//
//            }
//        }
//    }
}
