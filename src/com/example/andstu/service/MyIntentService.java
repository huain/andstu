/**
 * 
 */
package com.example.andstu.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * @author huangjin
 * 2014-8-12
 */
public class MyIntentService extends IntentService {
	
	private final String TAG = "MyIntentService";

	/**
	 * @param name
	 */
	public MyIntentService() {
		super("MyIntentService");
	}

	/* (non-Javadoc)
	 * @see android.app.IntentService#onHandleIntent(android.content.Intent)
	 */
	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d(TAG, "===onHandleIntent£º¿ªÊ¼");
		synchronized (this) {
			try {
				wait(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Log.d(TAG, "===onHandleIntent:½áÊø");
	}

}
