/**
 * 
 */
package com.example.andstu.net.netmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * @author huangjin
 * 2014-8-6
 */
public class NetworkReceiver extends BroadcastReceiver {

	/* (non-Javadoc)
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		
		ConnectivityManager conn =  (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = conn.getActiveNetworkInfo();
		
		// 判断网络的连接状态
		
//		ConnectivityManager connMgr = (ConnectivityManager) 
//		        getSystemService(Context.CONNECTIVITY_SERVICE);
//		NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI); 
//		boolean isWifiConn = networkInfo.isConnected();
//		networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//		boolean isMobileConn = networkInfo.isConnected();
//		Log.d(DEBUG_TAG, "Wifi connected: " + isWifiConn);
//		Log.d(DEBUG_TAG, "Mobile connected: " + isMobileConn);
		
		
		
		if(networkInfo != null && networkInfo.isConnected()){
			Toast.makeText(context, networkInfo.getTypeName()+"已经连接！", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(context, "没有网络！", Toast.LENGTH_SHORT).show();
		}
		
		

	}

}
