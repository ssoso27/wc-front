package com.uuay.welcare_catcher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WelfareListAdapter extends BaseAdapter {
    private ArrayList<WelfareListItem> listItemList = new ArrayList<WelfareListItem>() ;

    public WelfareListAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listItemList.size() ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.welfare_list_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView titleTextView  = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView descTextView   = (TextView) convertView.findViewById(R.id.textView2) ;
        TextView periodTextView = (TextView) convertView.findViewById(R.id.textView3) ;
        TextView ratingTextView = (TextView) convertView.findViewById(R.id.textView4) ;
        TextView typeTextView   = (TextView) convertView.findViewById(R.id.textView5) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        WelfareListItem listViewItem = listItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());
        periodTextView.setText(listViewItem.getPeriod());
        ratingTextView.setText(listViewItem.getRating());
        typeTextView.setText(listViewItem.getType());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listItemList.get(position) ;
    }

    public void addItem(String title, String desc, String period, String rating, String type) {
        WelfareListItem item = new WelfareListItem();

        item.setTitle(title);
        item.setDesc(desc);
        item.setPeriod(period);
        item.setRating(rating);
        item.setType(type);

        listItemList.add(item);
    }
}
