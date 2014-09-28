/**
 * 
 */
package com.example.andstu.sharedpreferences;

import com.example.andstu.R;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author hjin1987
 *
 */
public class SharedPreferencesActivity extends Activity {
	
	private static final String TAG = "SharedPreferencesActivity";
	
	private EditText mKey;
	
	private EditText mValue;
	
	private TextView mKeyShow;
	
	private TextView mValueShow;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences_activity);
		
		mKey = (EditText)findViewById(R.id.sharedPreferencesKey);
		mValue = (EditText)findViewById(R.id.sharedPreferencesValue);
		mKeyShow = (TextView)findViewById(R.id.sharedPreferencesKeyShow);
		mValueShow = (TextView)findViewById(R.id.sharedPreferencesValueShow);
		
	}
	
	
	
	
	public void btnClick(View v){
		SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
		switch(v.getId()){
			case R.id.sharedPreferencesDelBtn : {
				String key = mKey.getText().toString();
				if("".equals(key.trim())){
					Toast.makeText(this, "请输入需要删除的preference的key！", Toast.LENGTH_SHORT).show();
					return;
				}
				Editor ed = sp.edit();
				ed.remove(key);
				ed.commit();
				Log.d(TAG, "===spDel:key:"+key);
			};break;
			case R.id.sharedPreferencesGetBtn : {
				String key = mKey.getText().toString();
				if("".equals(key.trim())){
					Toast.makeText(this, "请输入需要查看的preference的key！", Toast.LENGTH_SHORT).show();
					return;
				}
				mKeyShow.setText("key:"+key);
				mValueShow.setText("value:"+sp.getString(key, "===默认值"));
				Log.d(TAG, "===spGet:key:"+key+";value:"+sp.getString(key, "===默认值"));
			};break;
			case R.id.sharedPreferencesInsertBtn : {
				String key = mKey.getText().toString();
				String value = mValue.getText().toString();
				if("".equals(key.trim())){
					Toast.makeText(this, "请输入需要添加的preference的key！", Toast.LENGTH_SHORT).show();
					return;
				}
				if("".equals(value.trim())){
					Toast.makeText(this, "请输入需要添加的preference的value！", Toast.LENGTH_SHORT).show();
					return;
				}
				Editor ed = sp.edit();
				ed.putString(key, value);
				ed.commit();
				Log.d(TAG, "===spInsert:key:"+key+";value:"+value);
			};break;
			default:break;
		}
	}

	

}
