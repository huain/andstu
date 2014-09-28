/**
 * 
 */
package com.example.andstu.service;

import com.example.andstu.service.IAidl.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * @author huangjin
 * 2014-9-11
 */
public class MyAidlService extends Service {
	
	private final String TAG = "MyAidlService";
	

	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "===:onBind");
		return new AidlBinder();
	}
	
	public class AidlBinder extends Stub{
		@Override
		public String getData() throws RemoteException {
			return "Andstu:MyAidlService"+System.currentTimeMillis();
		}
		
	}
	
	
	@Override
	public void onCreate() {
		Log.d(TAG, "===:onCreate");
		super.onCreate();
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
