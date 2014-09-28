/**
 * 
 */
package com.example.andstu.activitylifecycle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.andstu.R;

/**
 * @author hjin1987
 *
 */
public class CActivity extends Activity {
	
	private final String TAG = "CActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitylifecycle_c_activity);
		Log.d(TAG, "C=onCreate");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "C=onDestroy");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "C=onPause");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "C=onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "C=onResume");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "C=onStart");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "C=onStop");
	}
	
	
	
	public void btnClick(View v){
		switch(v.getId()){
		case R.id.activityLifeCycleC2ABtn:{
			Intent intent = new Intent();
    		intent.putExtra("key", "123");
    		setResult(RESULT_OK, intent);
    		finish();
			
    		
		}break;
		default:break;
		}
	}
	
	

}
