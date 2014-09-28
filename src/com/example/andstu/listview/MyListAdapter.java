/**
 * 
 */
package com.example.andstu.listview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.andstu.R;

/**
 * @author huangjin
 * 2014-7-30
 */
public class MyListAdapter extends BaseAdapter {
	
	private List<User> mData;
	
	private LayoutInflater mInflater;
	
	public MyListAdapter(Context context , List<User> data){
		this.mData = data;
		 mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return mData.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		return mData.get(position);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh;
		View v;
        if (convertView == null) {
            v = mInflater.inflate(R.layout.listview_simple_item, parent, false);
            vh = new ViewHolder();
            vh.title = (TextView)v.findViewById(R.id.listviewSimpleItem_title);
            vh.content = (TextView)v.findViewById(R.id.listviewSimpleItem_content);
            vh.btn = (Button)v.findViewById(R.id.listviewSimpleItem_btn);
            v.setTag(vh);
        } else {
            v = convertView;
            vh = (ViewHolder)v.getTag();
        }
        vh.title.setText(mData.get(position).getName());
        vh.content.setText(mData.get(position).getPass());
        vh.btn.setText(position+"");
		return v;
	}
	
	private class ViewHolder{
		TextView title;
		TextView content;
		Button btn;
	}
	
	

}
