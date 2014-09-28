/**
 * 
 */
package com.example.andstu.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.andstu.R;
import com.example.andstu.helloworld.MainActivity;

/**
 * @author huangjin
 * 2014-8-25
 */
public class MyIntentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common);
	}
	
	public void mainClick(View v){
		switch(v.getId()){
			case R.id.commonBtn:{
				Intent i = new Intent();
				//i.setComponent(new ComponentName(this, MainActivity.class));
				
				i.setClass(this, MainActivity.class);
				startActivity(i);
			}break;
			
			case R.id.commonBtn2:{
				Intent i = new Intent();
				i.setAction("com.example.andstu.action");
				i.addCategory(Intent.CATEGORY_APP_BROWSER);
				startActivity(i);
			}break;
			
			case R.id.commonBtn3:{
				Intent i = new Intent();
				//i.setAction(Intent.ACTION_VIEW);
				Uri u = Uri.parse("tel:123");
				Log.d("uri", "====Authority:"+u.getAuthority());
				Log.d("uri", "====Scheme:"+u.getScheme());
				Log.d("uri", "====Path:"+u.getPath());
				Log.d("uri", "====Host:"+u.getHost());
				Log.d("uri", "====Port:"+u.getPort());
				u.getScheme();
				
				i.setData(Uri.parse("http://www.baidu.com"));
//				i.setData(u);
				startActivity(i);
			}break;
			
			default:;
		}
		
	}
	
	

}
