/**
 * 
 */
package com.example.andstu.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * @author hjin1987
 *
 */
public class MyReceiverB extends BroadcastReceiver {
	
	private final String TAG = "MyReceiverB";

	/* (non-Javadoc)
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		String content = intent.getStringExtra("content");
		Log.d(TAG, "===onReceive:content:"+content);
		Bundle data = getResultExtras(true);
		if(data != null){
			Log.d(TAG, "===data:"+data.getString("a"));
		}
	}

}
