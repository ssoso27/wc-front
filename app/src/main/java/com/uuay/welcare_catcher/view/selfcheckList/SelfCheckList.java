package com.uuay.welcare_catcher.view.selfcheckList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.model.WelfareService;
import com.uuay.welcare_catcher.util.api.APIRequester;
import com.uuay.welcare_catcher.view.welfareList.WelfareListAdapter;

import java.util.ArrayList;
import java.util.List;

public class SelfCheckList extends Fragment {

    private ListView lvServices;
    private APIRequester apiRequester;

    public SelfCheckList() {
        apiRequester = new APIRequester();
    }

    TextView tvUserInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_selfcheck_list, container, false);
        if (getArguments() != null) {
            String agegroup = getArguments().getString("agegroup");
            String type = getArguments().getString("type");
            String grade = getArguments().getString("grade");

            new ServiceListAsync().execute(grade, agegroup, type);
        }
        WelfareListAdapter adapter = new WelfareListAdapter();

        lvServices = (ListView) view.findViewById(R.id.lv_selfcheck);
        lvServices.setAdapter(adapter);

        return view;
    }

    private void listViewDataAdd(List<WelfareService> list) {
        WelfareListAdapter adapter = new WelfareListAdapter();

        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                WelfareService service = list.get(i);
                adapter.addItem(
                        service.getId(),
                        service.getName(),
                        service.getApplication_agency(),
                        service.getApplication_method(),
                        service.getRegistedAt()
                );
            }
        }

        lvServices.setAdapter(adapter);
    }

    class ServiceListAsync extends AsyncTask<Object, Object, List<WelfareService>> {
        @Override
        protected List<WelfareService> doInBackground(Object[] objects) {
            ArrayList<WelfareService> list;
            String grade = (String) objects[0];
            String agegroup = (String) objects[1];
            String type = (String) objects[2];

            list = apiRequester.finda(grade, agegroup, type);

            return list;
        }

        @Override
        protected void onPostExecute(List<WelfareService> list) {
            listViewDataAdd(list);
        }
    }
}
