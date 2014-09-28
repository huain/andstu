/**
 * 
 */
package com.example.andstu.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.andstu.R;

/**
 * @author hjin1987
 *
 */
public class BActivity extends Activity {
	
	private final String TAG = "BActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitylifecycle_b_activity);
		
		Log.d(TAG, "B=onCreate");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "B=onDestroy");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "B=onPause");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "B=onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "B=onResume");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "B=onStart");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "B=onStop");
	}
	
	
	

}
