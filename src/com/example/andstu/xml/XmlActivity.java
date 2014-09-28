/**
 * 
 */
package com.example.andstu.xml;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.example.andstu.R;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * @author huangjin
 * 2014-8-8
 */
public class XmlActivity extends Activity {
	
	private final String TAG = "XmlActivity";
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common);
	}
	
	public void mainClick(View view){
		switch (view.getId()) {
		case R.id.commonBtn:{
			parseXml();
		}break;

		default:
			break;
		}
	}




	private void parseXml(){
		// 解析原始xml资源
		//XmlResourceParser xrp = getResources().getXml(R.xml.andstu);
		
		// 解析任意xml流
		XmlPullParserFactory factory;
		XmlPullParser xrp = null;;
		try {
			factory = XmlPullParserFactory.newInstance();
			xrp = factory.newPullParser();
			xrp.setInput(getResources().openRawResource(R.raw.andstu), "UTF-8");
		} catch (XmlPullParserException e1) {
			e1.printStackTrace();
			return;
		}
		
		try {
			while(xrp.getEventType() != XmlResourceParser.END_DOCUMENT){
				String tagName = xrp.getName();
				if("name".equals(tagName) || "age".equals(tagName) || "sex".equals(tagName) || "level".equals(tagName))
					Log.d(TAG, "======"+xrp.getName()+":"+xrp.nextText()+":"+xrp.getDepth()+":"+xrp.getAttributeCount()+":"+xrp.getEventType());
				else if("user".equals(tagName)){
					Log.d(TAG, "************" + tagName + "************");
					Log.d(TAG, xrp.getDepth()+":"+xrp.getAttributeCount()+":"+xrp.getEventType());
				}else if("school".equals(tagName))
					Log.d(TAG, "===" + tagName+":"+xrp.getDepth()+":"+xrp.getAttributeCount()+":"+xrp.getEventType());
				xrp.next();
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
