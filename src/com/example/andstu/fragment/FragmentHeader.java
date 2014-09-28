/**
 * 
 */
package com.example.andstu.fragment;

import com.example.andstu.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;




/**
 * @author hjin1987
 *
 */
public class FragmentHeader extends Fragment {
	

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_item_header, container,false);
	}
	
	public void receiveMsg(String msg){
		Button btn = (Button)getView().findViewById(R.id.fragmentABtn);
		btn.setText(msg);
	}
	

}
