/**
 * 
 */
package com.example.andstu.db;

import com.example.andstu.R;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * @author hjin1987
 *
 */
public class DbActivity extends Activity {
	
	private static final String TAG = "DbActivity";
	
	private DBHelper mDBHelper;
	
	private SQLiteDatabase mDb;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_activity);
		
		
		this.mDBHelper = new DBHelper(this);
	}
	
	
	
	
	public void btnClick(View v){
		
		switch(v.getId()){
			case R.id.dbDelBtn : {
				Log.d(TAG, "===btnClick:dbDelBtn");
				mDb = mDBHelper.getWritableDatabase();
				mDb.delete("user", "name=?", new String[]{"huangjin"});
			};break;
			case R.id.dbGetBtn : {
				Log.d(TAG, "===btnClick:dbGetBtn");
				mDb = mDBHelper.getReadableDatabase();
				Cursor c = mDb.query("user", new String[]{"name","pass"}, null, null, null, null, null);
				Log.d(TAG, "===btnClick:dbGetBtn:total:"+c.getCount());
				if(c.moveToFirst()){
					int nameIndex = c.getColumnIndex("name");
					int passIndex = c.getColumnIndex("pass");
					do{
						Log.d(TAG,"===btnClick_dbGetBtn:name:"+c.getString(nameIndex)+";pass:"+c.getString(passIndex));
					}while(c.moveToNext());
				}
			};break;
			case R.id.dbInsertBtn : {
				Log.d(TAG, "===btnClick:dbInsertBtn");
				ContentValues values = new ContentValues();
				values.put("name", "huangjin");
				values.put("pass", "123456");
				mDb = mDBHelper.getWritableDatabase();
				mDb.insert("user", null, values);
			};break;
			case R.id.dbUpdateBtn : {
				Log.d(TAG, "===btnClick:dbUpdateBtn");
				ContentValues values = new ContentValues();
				values.put("name", "huangjin");
				values.put("pass", "111111");
				mDb = mDBHelper.getWritableDatabase();
				mDb.update("user", values, "name=?", new String[]{"huangjin"});
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
		if(mDb != null){
			mDb.close();
		}
		if(mDBHelper != null){
			mDBHelper.close();
		}
	}
	
	

}
