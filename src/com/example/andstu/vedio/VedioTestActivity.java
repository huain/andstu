package com.example.andstu.vedio;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;

import com.example.andstu.R;

public class VedioTestActivity extends Activity implements VedioPlayer.VedioPlayerListener{
	
	private WindowManager mWindowManager;
	
	private VedioPlayer mPlayer;
	
	private VedioBean mVedioBean;
	
//	private WindowManager.LayoutParams mLayoutParams;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vedio_activity_vediotest);
		mWindowManager = getWindowManager();
	}
	
	
	/**
	 * 播放视频按钮的事件，点击加载视频播放器并开始播放
	 * @param view
	 */
	public void showVedio(View view){
		
		WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
		DisplayMetrics metrics = new DisplayMetrics();
		mWindowManager.getDefaultDisplay().getMetrics(metrics);
		if(metrics.widthPixels <= metrics.heightPixels){
			float widthBase = metrics.widthPixels;
			layoutParams.height = (int)(widthBase*0.9*9/16);
			layoutParams.width = (int)(widthBase*0.9);
			layoutParams.gravity = Gravity.LEFT + Gravity.TOP;
			layoutParams.x = (int)(widthBase*0.05);
			layoutParams.y = 200;
		}else{
			float widthBase = metrics.heightPixels;
			layoutParams.width = metrics.widthPixels * 10/8;
			layoutParams.height = metrics.widthPixels * 10/8 *16/9;
			layoutParams.gravity = Gravity.LEFT + Gravity.TOP;
			layoutParams.x = (int)(widthBase*0.05);
			layoutParams.y = 200;
		}
		
		
		View v = View.inflate(getBaseContext(),R.layout.vedio_player, null);
		SurfaceView surfaceView = (SurfaceView)v.findViewById(R.id.mySurfaceView);
//		surfaceView.
		MyProgressBar myProgressBar = (MyProgressBar)v.findViewById(R.id.myProgressBar);
		
		mPlayer = new VedioPlayer(getApplicationContext(),surfaceView,myProgressBar,this);
		mWindowManager.addView(v, layoutParams);
		
		mVedioBean = new VedioBean();
//		mPlayer.palyUrl("file:///android_asset/demo.h264", mVedioBean);
		mPlayer.palyUrl("/storage/sdcard0/MIUI/Gallery/DemoVideo/XiaomiPhone.mp4", mVedioBean);
	}


	@Override
	public void bufferComple() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isBufferComplete() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void videoPlay(int current, int paramInt2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void videoPlayComple() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void videoPrepared(int paramInt) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
