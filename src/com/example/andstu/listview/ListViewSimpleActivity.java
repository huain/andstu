/**
 * 
 */
package com.example.andstu.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.andstu.R;

/**
 * @author huangjin
 * 2014-7-30
 */
public class ListViewSimpleActivity extends Activity {
	
	private List<Map<String,String>> mData = new ArrayList<Map<String,String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_simple_activity);
		
		
		for(int i=0;i<10;i++){
			Map<String,String> map = new HashMap<String,String>();
			map.put("title", "title:"+i);
			map.put("content", "SimpleListView:"+i);
			mData.add(map);
		}
		
		ListView lv = (ListView)findViewById(R.id.listviewSimple);
		lv.setAdapter(new SimpleAdapter(this,mData,
				R.layout.listview_simple_item,
				new String[]{"title","content"},
				new int[]{R.id.listviewSimpleItem_title,R.id.listviewSimpleItem_content}));
		
	}
	
	
	
	
	

}
