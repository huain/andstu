/**
 * 
 */
package com.example.andstu.broadcast;

import com.example.andstu.R;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

/**
 * @author hjin1987
 *
 */
public class MyBroadcastActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broadcast_activity);
		IntentFilter filter = new IntentFilter("com.example.andstu.broadcast.testbroadcast");
		filter.setPriority(10000);
		registerReceiver(new MyReceiverC(), filter);
	}
	
	
	public void mainClick(View view){
		switch(view.getId()){
		case R.id.broadcastBtn:{
			Intent intent = new Intent("com.example.andstu.broadcast.testbroadcast");
			intent.putExtra("content", "hello broadcast!");
			sendBroadcast(intent);
			//sendOrderedBroadcast(intent,null);
		}break;
		case R.id.broadcastBtn2:{
			Intent intent = new Intent("com.example.andstu.broadcast.testbroadcast");
			intent.putExtra("content", "hello broadcast!");
			sendOrderedBroadcast(intent,null);
		}break;
		default:break;
		}
	}
	
	

}
