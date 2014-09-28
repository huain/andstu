/**
 * 
 */
package com.example.andstu.fragment;

import com.example.andstu.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




/**
 * @author hjin1987
 *
 */
public class FragmentB extends Fragment {
	private final String TAG = "FragmentB";

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v(TAG, "===onCreateView");
		return inflater.inflate(R.layout.fragment_item_b, container,false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.v(TAG, "===onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		Log.v(TAG, "===onAttach");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.v(TAG, "===onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroy() {
		Log.v(TAG, "===onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		Log.v(TAG, "===onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		Log.v(TAG, "===onDetach");
		super.onDetach();
	}

	@Override
	public void onPause() {
		Log.v(TAG, "===onPause");
		super.onPause();
	}

	@Override
	public void onResume() {
		Log.v(TAG, "===onResume");
		super.onResume();
	}

	@Override
	public void onStart() {
		Log.v(TAG, "===onStart");
		super.onStart();
	}

	@Override
	public void onStop() {
		Log.v(TAG, "===onStop");
		super.onStop();
	}
	
	
	
	
	

}
