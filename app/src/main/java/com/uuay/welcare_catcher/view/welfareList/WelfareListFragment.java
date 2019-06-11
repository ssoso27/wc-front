package com.uuay.welcare_catcher.view.welfareList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.model.Facility;
import com.uuay.welcare_catcher.model.WelfareService;
import com.uuay.welcare_catcher.util.api.APIRequester;
import com.uuay.welcare_catcher.view.welfareList.WelfareListAdapter;

import java.util.ArrayList;
import java.util.List;

public class WelfareListFragment extends Fragment {

    private ListView lvServices;
    private EditText etSearch;

    private APIRequester apiRequester;
    private String keyword;
    private int size;
    private int page;

    public WelfareListFragment() {
        apiRequester = new APIRequester();
        keyword = "";
        size = 10;
        page = 1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.frag_welfare_list, null) ;

        new ServiceListAsync().execute(keyword, size, page);

        WelfareListAdapter adapter = new WelfareListAdapter();
        lvServices = (ListView) view.findViewById(R.id.lv_services);
        lvServices.setAdapter(adapter);

        etSearch = view.findViewById(R.id.et_search);
        view.findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = etSearch.getText().toString();
                new ServiceListAsync().execute(keyword, size, page);
            }
        });

        return view;
    }

    private void listViewDataAdd(List<WelfareService> list) {
        WelfareListAdapter adapter = new WelfareListAdapter();

        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                WelfareService service = list.get(i);
                adapter.addItem(
                        service.getName(),
                        service.getApplication_agency(),
                        service.getApplication_method(),
                        service.getUrl(),
                        service.getRegistedAt());
            }
        }

        lvServices.setAdapter(adapter);
    }

    class ServiceListAsync extends AsyncTask<Object, Object, List<WelfareService>> {
        @Override
        protected List<WelfareService> doInBackground(Object[] objects) {
            ArrayList<WelfareService> list;
            String keyword = (String) objects[0];
            int size = (int) objects[1];
            int page = (int) objects[2];

            list = apiRequester.findServices(keyword, size, page);

            return list;
        }

        @Override
        protected void onPostExecute(List<WelfareService> list) {
            listViewDataAdd(list);
        }
    }
}
