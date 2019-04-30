package com.uuay.welcare_catcher.view.facilityList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uuay.welcare_catcher.R;
import com.uuay.welcare_catcher.model.Facility;

import java.util.ArrayList;

public class FacilityListAdapter extends BaseAdapter {
    /* 데이터 그릇들의 집합을 정의 */
    private ArrayList<Facility> items = new ArrayList<>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Facility getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        // 커스텀 리스트뷰의 xml을 inflate
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_facility, parent, false);
        }

        /* 커스텀 리스트뷰 xml에 있는 속성값들을 정의 */
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_facility_name);
        TextView tvType = (TextView) convertView.findViewById(R.id.tv_facility_type);
        TextView tvAddress = (TextView) convertView.findViewById(R.id.tv_facility_address);
        TextView tvTel = (TextView) convertView.findViewById(R.id.tv_facility_tel);


        /* 데이터를 담는 그릇 정의 */
        Facility item = getItem(position);

        /* 해당 그릇에 담긴 정보들을 커스텀 리스트뷰 xml의 각 TextView에 뿌려줌 */
        tvName.setText(item.getName());
        tvType.setText(item.getType());
        tvAddress.setText(item.getAddress());
        tvTel.setText(item.getTelNumber());

        return convertView;
    }

    /* 네이버 블로그 검색 중, 제목, 내용, 블로거이름, 포스팅 일자, 포스트 링크를 그릇에 담음 */
    public void addItem(String name, String type, String address, String tel) {

        Facility item = new Facility();

        item.setName(name);
        item.setType(type);
        item.setAddress(address);
        item.setTelNumber(tel);

        /* 데이터그릇 mItem에 담음 */
        items.add(item);

    }
}
