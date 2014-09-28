/**
 * 
 */
package com.example.andstu.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.andstu.R;

/**
 * @author hjin1987
 *
 */
public class FragmentA extends Fragment {
	private final String TAG = "FragmentA";

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v(TAG, "===onCreateView");
		View v = inflater.inflate(R.layout.fragment_item_a, container,false);
		Button btn = (Button)v.findViewById(R.id.fragmentASendBtn);
		Button btn1 = (Button)v.findViewById(R.id.fragmentASendActivityBtn);
		
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentActivity a = (FragmentActivity)getActivity();
				FragmentHeader fh = (FragmentHeader)a.getSupportFragmentManager().findFragmentByTag("header");
				fh.receiveMsg("込込込");
			}
		});
		
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((AListener)getActivity()).onBtnClick("込込込込。。。。。");
			}
		});
		
		return v;
	}

	
	public interface AListener{
		public void onBtnClick(String msg);
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
