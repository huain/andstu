/**
 * 
 */
package com.example.andstu.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * @author huangjin
 * 2014-8-12
 */
public class MyServiceBase extends Service {
	
	private final String TAG = "MyServiceBase";
	
	public class MyBinder extends Binder{
		public void getStatus(){
			Log.d(TAG, "===MyBinder:getStatus()");
		}
	}
	

	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "===:onBind");
		return new MyBinder();
	}

	@Override
	public void onCreate() {
		Log.d(TAG, "===:onCreate");
		super.onCreate();
	}

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		Log.d(TAG, "===:onStart");
		super.onStart(intent, startId);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "===:onStartCommand===flags:" + flags);
//		synchronized (this) {
//			try {
//				wait(20000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "===:onDestroy");
		super.onDestroy();
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d(TAG, "===:onUnbind");
		//return true;
		return super.onUnbind(intent);
	}

	@Override
	public void onRebind(Intent intent) {
		Log.d(TAG, "===:onRebind");
		super.onRebind(intent);
	}
	
	
}
