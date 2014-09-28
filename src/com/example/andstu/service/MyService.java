/**
 * 
 */
package com.example.andstu.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.example.andstu.R;

/**
 * @author hjin1987
 *
 */
public class MyService extends Service {
	
	private final String TAG = "MyService";
	
	private NotificationManager mNotificationManager;
	
	private Notification mNotification;
	
	private Context mContext;
	
	private int mCounter;;
	
	private ThreadGroup mThreads = new ThreadGroup("service");
	
	private Messenger mActivityMessenger;
	

	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see android.app.Service#onCreate()
	 */
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.d(TAG, "===onCreate");
		mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		displayNotificationMessage("Count Service Start");
		mContext = this;
		
	}

	/* (non-Javadoc)
	 * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		mCounter = intent.getExtras().getInt("counter");
		mActivityMessenger = intent.getExtras().getParcelable("messenger");
		
		new Thread(mThreads, new Runnable() {
			@Override
			public void run() {
				while(true){
					mCounter++;
					try {
						mNotification.setLatestEventInfo(mContext, TAG, "Count:"+mCounter, mNotification.contentIntent);
						mNotificationManager.notify(0, mNotification);
						Message msg = Message.obtain();
						msg.arg1 = mCounter;
						// 发送消息给activity的handler
						mActivityMessenger.send(msg);
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						break;
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}
		},"thread").start();
		return START_STICKY;
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see android.app.Service#onDestroy()
	 */
	@Override
	public void onDestroy() {
		mNotificationManager.cancelAll();
		mThreads.interrupt();
		super.onDestroy();
	}

	private void displayNotificationMessage(String message){
		mNotification = new Notification(R.drawable.ic_launcher,message,System.currentTimeMillis());
		
		mNotification.flags = Notification.FLAG_NO_CLEAR;
				
		
		PendingIntent contentIntent = PendingIntent.getActivity(this, 
				0, 
				new Intent(this, MyServiceActivity.class), 
				0);
		
		mNotification.setLatestEventInfo(this, TAG, message, contentIntent);
//		Notification notification = new Notification.Builder(this)
//		.setContentTitle(TAG)
//		.setContentText(message)
//		.setSmallIcon(R.drawable.ic_launcher)
//		.setContentIntent(contentIntent)
//		.build();
		mNotificationManager.notify(0, mNotification);
		
	}
	
	
	
	

}
