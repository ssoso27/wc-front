package com.uuay.welcare_catcher.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.kakao.network.ApiRequest;
import com.uuay.welcare_catcher.GlobalApplication;
import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.model.Account;
import com.uuay.welcare_catcher.model.WelfareService;
import com.uuay.welcare_catcher.util.FragmentChanger;
import com.uuay.welcare_catcher.util.LocalCookie;
import com.uuay.welcare_catcher.util.api.APIRequester;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    SelfcheckFragment sf = new SelfcheckFragment();
    Fragment testF = new TestFragment();
    TextView tvDefault;
    ListView lvReceive;
    int size, page;

    public HomeFragment() {
        size = 5;
        page = 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false) ;


        Button btn = (Button) view.findViewById(R.id.btn_home_to_sc);
        tvDefault = view.findViewById(R.id.tv_default);
        lvReceive = view.findViewById(R.id.lv_services);

        LocalCookie localCookie = LocalCookie.getInstance();
        if (!localCookie.isEmpty()) {
            tvDefault.setVisibility(View.GONE);
            lvReceive.setVisibility(View.VISIBLE);

            Account account = GlobalApplication.getCurrentAccount();
            new ReceivedListAsync().execute(account.getId(), size, page);
        } else {
            lvReceive.setVisibility(View.GONE);
            tvDefault.setVisibility(View.VISIBLE);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentChanger.setFragment((AppCompatActivity) getActivity(), sf);
            }
        });

        return view ;
    }

    private void listViewDataAdd(List<WelfareService> list) {
        ReceiveListAdapter adapter = new ReceiveListAdapter();

        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                WelfareService service = list.get(i);
                adapter.addItem(
                        service.getId(),
                        service.getName()
                );
            }
        }

        lvReceive.setAdapter(adapter);
    }

    class ReceivedListAsync extends AsyncTask<Object, Object, List<WelfareService>> {
        @Override
        protected List<WelfareService> doInBackground(Object[] objects) {
            APIRequester apiRequester = new APIRequester();

            ArrayList<WelfareService> list;
            Long accountId = (Long) objects[0];
            int size = (int) objects[1];
            int page = (int) objects[2];

            list = (ArrayList<WelfareService>) apiRequester.receivedList(accountId, size, page);

            return list;
        }

        @Override
        protected void onPostExecute(List<WelfareService> list) {
            listViewDataAdd(list);
        }
    }
}
