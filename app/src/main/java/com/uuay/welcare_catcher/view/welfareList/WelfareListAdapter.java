package com.uuay.welcare_catcher.view.welfareList;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.uuay.welcare_catcher.GlobalApplication;
import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.model.Account;
import com.uuay.welcare_catcher.model.WelfareService;
import com.uuay.welcare_catcher.util.api.APIRequester;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WelfareListAdapter extends BaseAdapter {
    /* 데이터 그릇들의 집합을 정의 */
    private ArrayList<WelfareService> items = new ArrayList<>();
    private Context context;

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public WelfareService getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        context = parent.getContext();

        // 커스텀 리스트뷰의 xml을 inflate
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.welfare_list_item, parent, false);
        }

        /* 커스텀 리스트뷰 xml에 있는 속성값들을 정의 */
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvAgency = (TextView) convertView.findViewById(R.id.tv_agency);
        TextView tvMethod = (TextView) convertView.findViewById(R.id.tv_method);
        TextView tvRegistedAt = (TextView) convertView.findViewById(R.id.tv_registedAt);
        Button btnToggle = convertView.findViewById(R.id.btn_toggle);


        /* 데이터를 담는 그릇 정의 */
        final WelfareService item = getItem(position);

        /* 해당 그릇에 담긴 정보들을 커스텀 리스트뷰 xml의 각 TextView에 뿌려줌 */
        tvName.setText(item.getName());
        tvAgency.setText(item.getApplication_agency());
        tvMethod.setText(item.getApplication_method());
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY.MM.DD");
        tvRegistedAt.setText(dateFormat.format(item.getRegistedAt()));
        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account account = GlobalApplication.getCurrentAccount();
                new ToggleAsync().execute(account.getId(), item.getId());
            }
        });

        return convertView;
    }

    /* 네이버 블로그 검색 중, 제목, 내용, 블로거이름, 포스팅 일자, 포스트 링크를 그릇에 담음 */
    public void addItem(Long serviceId, String name, String agency, String method, Date registedAt) {

        WelfareService item = new WelfareService();

        item.setId(serviceId);
        item.setName(name);
        item.setApplication_agency(agency);
        item.setApplication_method(method);
        item.setRegistedAt(registedAt);

        /* 데이터그릇 mItem에 담음 */
        items.add(item);

    }

    class ToggleAsync extends AsyncTask<Object, Object, Boolean> {
        @Override
        protected Boolean doInBackground(Object[] objects) {
            APIRequester apiRequester = new APIRequester();
            Long accountId = (Long) objects[0];
            Long serviceId = (Long) objects[1];

            Boolean isReceive = apiRequester.toggle(accountId, serviceId);

            return isReceive;
        }

        @Override
        protected void onPostExecute(Boolean isReceive) {
            Toast.makeText(context, isReceive+"", Toast.LENGTH_SHORT).show();
        }
    }
}
