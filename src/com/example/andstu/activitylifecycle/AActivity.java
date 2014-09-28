/**
 * 
 */
package com.example.andstu.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.andstu.R;

/**
 * @author hjin1987
 *
 */
public class AActivity extends Activity {
	
	private final String TAG = "AActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitylifecycle_a_activity);
		
		findViewById(R.id.activityLifeCycleA2BBtn);
		Log.d(TAG, "A=onCreate");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "A=onDestroy");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "A=onPause");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "A=onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "A=onResume");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "A=onStart");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "A=onStop");
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == Activity.RESULT_OK){
			switch(requestCode){
				case 1:{
					Log.d(TAG, "A=onActivityResult:"+data.getStringExtra("key"));
				}
			}
		}
		
	}

	public void btnClick(View v){
		switch(v.getId()){
		case R.id.activityLifeCycleA2BBtn:{
			Intent intent = new Intent();
			Bundle b = new Bundle();
    		intent.setClass(getApplicationContext(), BActivity.class);
    		startActivity(intent);
    		
			break;
		}
		case R.id.activityLifeCycleA2CBtn:{
			Intent intent = new Intent();
    		intent.setClass(getApplicationContext(), CActivity.class);
    		//startActivity(intent);
    		startActivityForResult(intent, 1);
			break;
		}
		default:break;
		}
	}
	
	

}
