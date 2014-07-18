package com.example.andstu.vedio;

import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;
import android.widget.ProgressBar;

public class VedioPlayer implements OnBufferingUpdateListener,
		OnCompletionListener, OnErrorListener, OnPreparedListener, Callback {

	private final String TAG = "vedio_VedioPlayer";
	
	public MediaPlayer mMediaPalyer;
	
	private Context mContext;
	
	private SurfaceView mSurfaceView;
	
	private SurfaceHolder mSurfaceHolder;
	
	private ProgressBar mProgressBar;
	
	private VedioPlayer.VedioPlayerListener mListener;
	
	public VedioPlayer(Context context, SurfaceView surfaceView,ProgressBar myProgressBar,VedioPlayer.VedioPlayerListener listener){
		mContext = context;
		mSurfaceView = surfaceView;
		mProgressBar = myProgressBar;
		mListener = listener;
		mMediaPalyer = new MediaPlayer();
		mMediaPalyer.setOnBufferingUpdateListener(this);
		mMediaPalyer.setOnCompletionListener(this);
		mMediaPalyer.setOnErrorListener(this);
		mMediaPalyer.setOnPreparedListener(this);
	    mSurfaceHolder = mSurfaceView.getHolder();
//	    mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	    mSurfaceHolder.addCallback(this);
	}
	
	private void play(){
		if(mMediaPalyer != null){
			mMediaPalyer.start();
		}
	}
	
	public void palyUrl(String url, VedioBean vedioBean){
		if(url == null || vedioBean == null){
			return;
		}
		if(mMediaPalyer == null){
			mMediaPalyer = new MediaPlayer();
			mMediaPalyer.setOnBufferingUpdateListener(this);
			mMediaPalyer.setOnCompletionListener(this);
			mMediaPalyer.setOnErrorListener(this);
			mMediaPalyer.setOnPreparedListener(this);
		}
		try {
			mMediaPalyer.reset();
			mMediaPalyer.setDataSource(url);
			mMediaPalyer.setDisplay(mSurfaceHolder);
//			mMediaPalyer.prepareAsync();
			mMediaPalyer.prepare();
			mMediaPalyer.start();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		play();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		mSurfaceView.setBackgroundColor(0);
		mp.start();
	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onBufferingUpdate(MediaPlayer mp, int percent) {
		// TODO Auto-generated method stub

	}
	
	
	
	public interface VedioPlayerListener{
		public void bufferComple();
		
	    public boolean isBufferComplete();

	    public void videoPlay(int current, int paramInt2);

	    public void videoPlayComple();

	    public void videoPrepared(int paramInt);
	}

}
