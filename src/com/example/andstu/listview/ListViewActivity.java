/**
 * 
 */
package com.example.andstu.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.andstu.R;

/**
 * @author huangjin
 * 2014-7-30
 */
public class ListViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_activity);
	}
	
	
	public void mainClick(View view){
    	switch(view.getId()){
	    	case R.id.listviewSimpleBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), ListViewSimpleActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.listviewComplexBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), ListViewComplexActivity.class);
	    		startActivity(intent);
	    	}break;
	    	default:;
    	}
    }
	

}
