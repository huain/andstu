/**
 * 
 */
package com.example.andstu.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author hjin1987
 *
 */
public class DBHelper extends SQLiteOpenHelper {
	
	private static final String TAG = "DBHelper";
	
	private static final String DB_NAME = "test.db";
	private static final int VERSION = 1;
	
	
	private static final String SQL_USER = "CREATE TABLE \"user\" (\"_id\"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\"name\"  TEXT(20),\"pass\"  TEXT(20));";
	
	public SQLiteDatabase mDb = null;
	
	public DBHelper(Context context){
		super(context, DB_NAME, null, VERSION);
		Log.d(TAG, "===DBHelper");
		
	}
	
	
	

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		this.mDb = db;
		Log.d(TAG, "===onCreate");
		db.execSQL(SQL_USER);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		Log.d(TAG, "onUpgrade:from version:"+arg1+" to version:"+arg2);
	}

}
