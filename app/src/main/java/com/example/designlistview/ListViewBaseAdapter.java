package com.example.designlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewBaseAdapter extends BaseAdapter {
    public ArrayList<ListViewBean> arraylistListener;
    private List<ListViewBean> mListenerList;
    Context mContext;

    public ListViewBaseAdapter(List<ListViewBean> mListenerList, Context context) {

        mContext = context;
        this.mListenerList = mListenerList;
        this.arraylistListener = new ArrayList<ListViewBean>();
        this.arraylistListener.addAll(mListenerList);

    }

    public class ViewHolder {
        ImageView mItemPic;
        TextView mLangName;
        TextView mStadium;
    }

    @Override
    public int getCount() {
        return mListenerList.size();
    }

    @Override
    public Object getItem(int position) {
        return mListenerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.row_listview, null);
            holder = new ViewHolder();
            holder.mItemPic = (ImageView) view.findViewById(R.id.image_avatar);
            holder.mLangName=(TextView) view.findViewById(R.id.tvName);
            holder.mStadium=(TextView) view.findViewById(R.id.tv_stadium);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();

        }
        try {
            int image = mListenerList.get(position).getImage();
            holder.mItemPic.setImageResource(image);
            holder.mLangName.setText(mListenerList.get(position).getLangName());
            holder.mStadium.setText(mListenerList.get(position).getStadium());
        }catch (Exception ex){

        }

        return view;
    }

}