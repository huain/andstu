/**
 * 
 */
package com.example.andstu.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author hjin1987
 *
 */
public class MyReceiverA extends BroadcastReceiver {
	
	private final String TAG = "MyReceiverA";

	/* (non-Javadoc)
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		String content = intent.getStringExtra("content");
		Log.d(TAG, "===onReceive:content:"+content);
	}

}
