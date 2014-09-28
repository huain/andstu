/**
 * 
 */
package com.example.andstu.net.httpurlconn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.andstu.R;

/**
 * @author huangjin
 * 2014-8-6
 */
public class HttpUrlConnActivity extends Activity {
	
	private final String TAG = "HttpUrlConnActivity";
	
	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.net_httpurlconn_activity);
		
		mTextView = (TextView)findViewById(R.id.netHttpUrlConnText);
	}
	
	public void mainClick(View view){
		switch (view.getId()) {
		case R.id.netHttpUrlConnDownBtn:{
			new DownLoadTask().execute("http://www.baidu.com");
			mTextView.setText("正在下载。。。。");
		}break;
		default:
			break;
		}
		
	}
	
	private class DownLoadTask extends AsyncTask<String, Void, String>{
		@Override
		protected String doInBackground(String... url) {
			File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),"andstu.txt");
			Log.d(TAG, "==="+file.getAbsolutePath());
			try {
				return downLoadUrl(url[0], file);
			} catch (IOException e) {
				e.printStackTrace();
				return "下载失败";
			}
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			mTextView.setText(result);
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
		}
		
		private String downLoadUrl(String urlStr,File file) throws IOException{
			InputStream is = null;
			FileOutputStream fos = new FileOutputStream(file);
		    
			try {
				URL url = new URL(urlStr);
				HttpURLConnection  conn = (HttpURLConnection )url.openConnection();
				conn.setReadTimeout(10000 /* milliseconds */);
				conn.setConnectTimeout(15000 /* milliseconds */);
				conn.setRequestMethod("GET");
				conn.setDoInput(true);
				conn.connect();
				//int response = conn.getResponseCode();
				
				is = conn.getInputStream();
				//int len = is.available();
				//Reader reader = new InputStreamReader(is);
				byte[] buffer = new byte[1024];
				while(is.read(buffer) != -1){
					fos.write(buffer);
				}
			} finally{
				is.close();
		        fos.close();
			}
			return "下载成功："+urlStr;
		}
		
	}
	

}
