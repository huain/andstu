/**
 * 
 */
package com.example.andstu.provider;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.andstu.R;

/**
 * @author hjin1987
 *
 */
public class ProviderActivity extends Activity {
	
	private static final String TAG = "ProviderActivity";
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.provider_activity);
		
	}
	
	
	public void btnClick(View v){
		switch(v.getId()){
			case R.id.providerDelBtn : {
				Log.d(TAG, "===btnClick:providerDelBtn");
				getContentResolver().delete(UserProviderMetaData.UserTableMetaData.CONTENT_URI, 
						"name=?", new String[]{"huangjin"});
			};break;
			case R.id.providerGetBtn : {
				Log.d(TAG, "===btnClick:providerGetBtn   ");
				Cursor c = getContentResolver().query(UserProviderMetaData.UserTableMetaData.CONTENT_URI, 
						new String[]{"name","pass"}, null, null, null);
				Log.d(TAG, "===btnClick:providerGetBtn:total:"+c.getCount());
				if(c.moveToFirst()){
					int nameIndex = c.getColumnIndex("name");
					int passIndex = c.getColumnIndex("pass");
					do{
						Log.d(TAG,"===btnClick_providerGetBtn:name:"+c.getString(nameIndex)+";pass:"+c.getString(passIndex));
					}while(c.moveToNext());
				}
			};break;
			case R.id.providerInsertBtn : {
				Log.d(TAG, "===btnClick:providerInsertBtn");
			};break;
			case R.id.providerUpdateBtn : {
				Log.d(TAG, "===btnClick:providerUpdateBtn");
			};break;
			default:break;
		}
	}




	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	

}
