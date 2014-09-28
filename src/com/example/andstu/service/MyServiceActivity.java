/**
 * 
 */
package com.example.andstu.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.andstu.R;
import com.example.andstu.service.IAidl.Stub;

/**
 * @author hjin1987
 *
 */
public class MyServiceActivity extends Activity {
	
	private final String TAG = "MyServiceActivity";
	
	private TextView mTv;
	
	private int mCounter = 0;
	
	private Button mStartBtn;
	
	private Button mStopBtn;
	
	
	private ServiceConnection conn = new ServiceConnection() {
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d(TAG, "===:onServiceDisconnected==="+name);
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d(TAG, "===:onServiceConnected==="+name);
		}
	};
	
	private ServiceConnection conn2 = new ServiceConnection() {
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d(TAG, "===:onServiceDisconnected==="+name);
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			try {
				Log.d(TAG, "===:onServiceConnected==="+IAidl.Stub.asInterface(service).getData());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	};
	
	
	
	public Handler mHandler = new Handler(){

		/* (non-Javadoc)
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@Override
		public void handleMessage(Message msg) {
			Log.d(TAG, "===handleMessage:"+msg.arg1);
			mCounter = msg.arg1;
			mTv.setText("" + mCounter);
		}
		
	};
	
	// 消息传送对象，通过此对象将消息传送给当前handler
	public Messenger mActivityMessenger = new Messenger(mHandler);
	
	

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myservice_activity);
		
		mTv = (TextView)findViewById(R.id.myserviceText);
		mTv.setText("" + mCounter);
		
		mStartBtn = (Button)findViewById(R.id.myserviceStartBtn);
		mStopBtn = (Button)findViewById(R.id.myserviceStopBtn);
		
	}
	
	public void mainClick(View view){
		switch(view.getId()){
		case R.id.myserviceStartBtn:{
			mStartBtn.setEnabled(false);
			mStopBtn.setEnabled(true);
			Intent intent = new Intent(this,MyService.class);
			intent.putExtra("counter", mCounter);
			intent.putExtra("messenger", mActivityMessenger);
			startService(intent);
			break;
		}
		case R.id.myserviceStopBtn:{
			mStartBtn.setEnabled(true);
			mStopBtn.setEnabled(false);
			Intent intent = new Intent(this,MyService.class);
			intent.putExtra("counter", mCounter);
			stopService(intent);
			break;
		}
		case R.id.myserviceBaseStartBtn:{
			Intent intent = new Intent(this,MyServiceBase.class);
//			intent.putExtra("counter", mCounter);
//			intent.putExtra("messenger", mActivityMessenger);
			startService(intent);
			break;
		}
		case R.id.myserviceBaseStopBtn:{
			Intent intent = new Intent(this,MyServiceBase.class);
//			intent.putExtra("counter", mCounter);
			stopService(intent);
			break;
		}
		case R.id.myserviceBaseBindBtn:{
			Intent intent = new Intent(this,MyServiceBase.class);
			bindService(intent, conn, BIND_AUTO_CREATE);
			break;
		}
		case R.id.myserviceBaseUnBindBtn:{
//			Intent intent = new Intent(this,MyServiceBase.class);
			unbindService(conn);
			break;
		}
		case R.id.myintentserviceStartBtn:{
			Intent intent = new Intent(this,MyIntentService.class);
//			intent.putExtra("counter", mCounter);
//			intent.putExtra("messenger", mActivityMessenger);
			startService(intent);
			break;
		}
		case R.id.myintentserviceStopBtn:{
			Intent intent = new Intent(this,MyIntentService.class);
//			intent.putExtra("counter", mCounter);
			stopService(intent);
			break;
		}
		case R.id.myaidlserviceStartBtn:{
			Intent intent = new Intent(this,MyAidlService.class);
//			intent.putExtra("counter", mCounter);
			bindService(intent, conn2, BIND_AUTO_CREATE);
			break;
		}
		case R.id.myaidlserviceStopBtn:{
//			Intent intent = new Intent(this,MyIntentService.class);
//			intent.putExtra("counter", mCounter);
			unbindService(conn2);
			break;
		}
		default:break;
		}
		
	}

}
