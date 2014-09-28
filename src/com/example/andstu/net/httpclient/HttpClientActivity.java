/**
 * 
 */
package com.example.andstu.net.httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.andstu.R;

/**
 * @author huangjin
 * 2014-8-6
 */
public class HttpClientActivity extends Activity {
	
	private final String TAG = "HttpClientActivity";
	
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
			mTextView.setText("正在读取。。。。");
		}break;
		default:
			break;
		}
		
	}
	
	private class DownLoadTask extends AsyncTask<String, Void, String>{
		@Override
		protected String doInBackground(String... url) {
			try {
				Log.d(TAG, "===get："+httpGet(url[0]));
				Log.d(TAG, "===post："+httpPost(url[0]));
				return "读取完成";
			} catch (IOException e) {
				e.printStackTrace();
				return "读取失败";
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
		
		private String httpGet(String url) throws ClientProtocolException, IOException{
			HttpGet req = new HttpGet(url);
			HttpParams params = new BasicHttpParams();
			ConnManagerParams.setTimeout(params, 1000);
			HttpConnectionParams.setConnectionTimeout(params, 3000);  
            HttpConnectionParams.setSoTimeout(params, 5000);  
            req.setParams(params);
            
            HttpResponse res = new DefaultHttpClient().execute(req);
            int statusCode = res.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
            	String result = EntityUtils.toString(res.getEntity(),HTTP.UTF_8);
            	return result;
            }else{
            	return null;
            }
		}
		
		private String httpPost(String url) throws ClientProtocolException, IOException{
			HttpPost req = new HttpPost(url);
			HttpParams params = new BasicHttpParams();
			//从连接池中获取连接的超时时间
			ConnManagerParams.setTimeout(params, 1000);
			//通过网络与服务器建立连接的超时时间
			HttpConnectionParams.setConnectionTimeout(params, 3000); 
			//读响应数据的超时时间
            HttpConnectionParams.setSoTimeout(params, 5000);
            req.setParams(params);
            
            List<BasicNameValuePair> paramsList = new ArrayList<BasicNameValuePair>();  
            paramsList.add(new BasicNameValuePair("key1", "value1"));  
            paramsList.add(new BasicNameValuePair("key2", "value2")); 
            UrlEncodedFormEntity urlEncodeFormEntity = new UrlEncodedFormEntity(paramsList,HTTP.UTF_8);  
            req.setEntity(urlEncodeFormEntity);
            
            HttpResponse res = new DefaultHttpClient().execute(req);
            int statusCode = res.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
            	String result = EntityUtils.toString(res.getEntity(),HTTP.UTF_8);
            	return result;
            }else{
            	return null;
            }
		}
		
	}
	

}
