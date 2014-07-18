/**
 * 
 */
package com.example.andstu.vedio;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * @author huangjin
 * 2014-7-18
 */
public class MyProgressBar extends ProgressBar {
	
	private final String TAG = "vedio_MyProgressBar";

	/**
	 * @param context
	 */
	public MyProgressBar(Context context) {
		super(context);
//		init();
	}
	
	
	
	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public MyProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param context
	 * @param attrs
	 */
	public MyProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}



	private void init(){
		Log.v(TAG, "inti");
	}
	
}
