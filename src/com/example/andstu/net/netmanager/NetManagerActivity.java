/**
 * 
 */
package com.example.andstu.net.netmanager;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;

import com.example.andstu.R;
import com.example.andstu.net.httpclient.HttpClientActivity;
import com.example.andstu.net.httpurlconn.HttpUrlConnActivity;
import com.example.andstu.net.socket.SocketActivity;
import com.example.andstu.net.webservice.WebServiceActivity;

/**
 * @author huangjin
 * 2014-8-6
 */
public class NetManagerActivity extends Activity {
	
	 private NetworkReceiver mReceiver = new NetworkReceiver();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.netmanager_activity);
		
		IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
		mReceiver = new NetworkReceiver();
		registerReceiver(mReceiver, filter);
		
	}
	
	
	
	
	@Override
	protected void onDestroy() {
		unregisterReceiver(mReceiver);
		super.onDestroy();
		
	}




	public void mainClick(View view){
		switch (view.getId()) {
		case R.id.netHttpUrlConnBtn:{
			Intent intent = new Intent();
    		intent.setClass(getApplicationContext(), HttpUrlConnActivity.class);
    		startActivity(intent);
		}break;
		case R.id.netHttpClientBtn:{
			Intent intent = new Intent();
    		intent.setClass(getApplicationContext(), HttpClientActivity.class);
    		startActivity(intent);
		}break;
		case R.id.netSocketBtn:{
			Intent intent = new Intent();
    		intent.setClass(getApplicationContext(), SocketActivity.class);
    		startActivity(intent);
		}break;
		case R.id.netWebServiceBtn:{
			Intent intent = new Intent();
    		intent.setClass(getApplicationContext(), WebServiceActivity.class);
    		startActivity(intent);
		}break;
		default:
			break;
		}
	}
	
	
	
	

}
