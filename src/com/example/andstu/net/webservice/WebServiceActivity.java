/**
 * 
 */
package com.example.andstu.net.webservice;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.example.andstu.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * @author huangjin
 * 2014-8-7
 */
public class WebServiceActivity extends Activity {
	
	private final String TAG = "WebServiceActivity";
	
	private final String SERVICE_NS = "http://WebXml.com.cn/";
	
	private final String SERVICE_URL = "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.net_httpurlconn_activity);
	}
	
	public void mainClick(View view){
		switch (view.getId()) {
		case R.id.netHttpUrlConnDownBtn:{
			getData();
		}break;
		default:break;
		}
	}
	
	private String getData(){
		final String methodName = "getRegionCountry";
		
		final HttpTransportSE htse = new HttpTransportSE(SERVICE_URL);
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);
		//soapObject.addProperty("args0", "²ÎÊý");
		envelope.bodyOut = soapObject;
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					htse.call(SERVICE_NS + methodName, envelope);
					if(envelope.getResponse() != null){
						SoapObject soapIn = (SoapObject)envelope.bodyIn;
						String result = soapIn.getPropertyAsString(0);
						Log.d(TAG, "==="+result);
					}
				} catch (HttpResponseException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		return null;
	}
	
	
	// https://code.google.com/p/ksoap2-android/wiki/HowToUse?tm=2
	

}
