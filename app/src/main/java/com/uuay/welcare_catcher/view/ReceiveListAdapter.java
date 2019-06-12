package com.uuay.welcare_catcher.view;

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
import com.uuay.welcare_catcher.util.LocalCookie;
import com.uuay.welcare_catcher.util.api.APIRequester;
import com.uuay.welcare_catcher.view.welfareList.WelfareListAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReceiveListAdapter extends BaseAdapter {
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
            convertView = inflater.inflate(R.layout.item_receive, parent, false);
        }

        /* 커스텀 리스트뷰 xml에 있는 속성값들을 정의 */
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);


        /* 데이터를 담는 그릇 정의 */
        final WelfareService item = getItem(position);

        /* 해당 그릇에 담긴 정보들을 커스텀 리스트뷰 xml의 각 TextView에 뿌려줌 */
        tvName.setText(item.getName());

        return convertView;
    }

    /* 네이버 블로그 검색 중, 제목, 내용, 블로거이름, 포스팅 일자, 포스트 링크를 그릇에 담음 */
    public void addItem(Long serviceId, String name) {

        WelfareService item = new WelfareService();

        item.setId(serviceId);
        item.setName(name);

        /* 데이터그릇 mItem에 담음 */
        items.add(item);

    }
}
