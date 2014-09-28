/**
 * 
 */
package com.example.andstu.thread;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.andstu.R;

/**
 * @author huangjin
 * 2014-9-11
 */
public class ThreadActivity extends Activity {
	
	private final String TAG = "ThreadActivity";
	
	private Button mBtn;
	
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:{
				Log.d(TAG, "handleMessage:thread-id:"+Thread.currentThread().getId());
				mBtn.setText(msg.getData().getCharSequence("1"));
			}break;
			default:break;
			}
			
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common);
//		synchronized (this) {
//			try {
//				wait(20000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		mBtn = (Button)findViewById(R.id.commonBtn);
	}
	
	
	public void mainClick(View v){
		switch (v.getId()) {
		case R.id.commonBtn:{
			Log.d(TAG, "thread-id:"+Thread.currentThread().getId());
			synchronized (this) {
				try {
					wait(20000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}break;
		case R.id.commonBtn2:{
			new Thread(new Runnable() {
				@Override
				public void run() {
					Log.d(TAG, "thread-id:"+Thread.currentThread().getId()+"====begin");
					synchronized (this) {
						try {
							wait(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					Log.d(TAG, "thread-id:"+Thread.currentThread().getId()+"====end");
					
					Message msg = mHandler.obtainMessage();
					msg.what = 1;
					msg.getData().putCharSequence("1", "123");
					msg.sendToTarget();
						
				}
			}).start();
		}break;
		case R.id.commonBtn3:{
			new MyTask().execute("1111","2222");
		}break;
		default:break;
		}
	}
	
	class MyTask extends AsyncTask<String, Integer, String>{

		@Override
		protected String doInBackground(String... params) {
			Log.d(TAG, "===MyTask:doInBackground:paramsLength:"+params.length+"||"+params[0]);
			Log.d(TAG, "===MyTask:doInBackground:thread-id:"+Thread.currentThread().getId());
			synchronized (this) {
				try {
					wait(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			publishProgress(100);
			
			return "ok";
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			Log.d(TAG, "===MyTask:onPreExecute:thread-id:"+Thread.currentThread().getId());
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Log.d(TAG, "===MyTask:onPostExecute:"+result);
			Log.d(TAG, "===MyTask:onPostExecute:thread-id:"+Thread.currentThread().getId());
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			Log.d(TAG, "==="+values[0]);
		}

		@Override
		protected void onCancelled(String result) {
			super.onCancelled(result);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}
		
	}

	
}
