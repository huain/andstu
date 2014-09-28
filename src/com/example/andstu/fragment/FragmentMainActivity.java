/**
 * 
 */
package com.example.andstu.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.andstu.R;
import com.example.andstu.fragment.FragmentA.AListener;

/**
 * @author hjin1987
 *
 */
public class FragmentMainActivity extends FragmentActivity implements AListener{
	
	private final String TAG = "FragmentMainActivity";

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		Log.v(TAG, "======onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_activity);
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.add(R.id.fragmentHeader, new FragmentHeader(),"header");
		ft.add(R.id.fragmentBody, new FragmentA());
		ft.commit();
		
	}
	
	
	public void mainClick(View view){
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		switch(view.getId()){
	    	case R.id.fragmentABtn:{
	    		ft.replace(R.id.fragmentBody, new FragmentA());
	    	}break;
	    	case R.id.fragmentBBtn:{
	    		ft.replace(R.id.fragmentBody, new FragmentB());
	    	}break;
	    	case R.id.fragmentCBtn:{
	    		//ft.addToBackStack("");
	    		ft.replace(R.id.fragmentBody, new FragmentC());
	    	}break;
	    	default:;
		}
		ft.commit();
	}


	@Override
	public void onBtnClick(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}


	@Override
	protected void onDestroy() {
		Log.v(TAG, "======onDestroy");
		super.onDestroy();
	}


	@Override
	protected void onPause() {
		Log.v(TAG, "======onPause");
		super.onPause();
	}


	@Override
	protected void onResume() {
		Log.v(TAG, "======onResume");
		super.onResume();
	}


	@Override
	protected void onStart() {
		Log.v(TAG, "======onStart");
		super.onStart();
	}


	@Override
	protected void onStop() {
		Log.v(TAG, "======onStop");
		super.onStop();
	}
	
	
	
	
	
	
	

}
