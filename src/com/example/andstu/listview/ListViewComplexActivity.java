/**
 * 
 */
package com.example.andstu.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.andstu.R;

/**
 * @author huangjin
 * 2014-7-30
 */
public class ListViewComplexActivity extends Activity {
	
	private List<User> mData = new ArrayList<User>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_simple_activity);
		
		
		for(int i=0;i<10;i++){
			User user = new User();
			user.setName("username"+i);
			user.setPass("pass"+i);
			mData.add(user);
		}
		
		ListView lv = (ListView)findViewById(R.id.listviewSimple);
		lv.setAdapter(new MyListAdapter(this, mData));
	}
	
	
	
	
	

}
