/**
 * 
 */
package com.example.andstu.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

/**
 * @author hjin1987
 *
 */
public class UserProvider extends ContentProvider {
	
	private SQLiteDatabase mDb;
	
	private DatabaseHelper mDatabaseHelper;
	
	
	private static class DatabaseHelper extends SQLiteOpenHelper{
		
		public DatabaseHelper(Context context){
			super(context, UserProviderMetaData.DATABASE_NAME, null, UserProviderMetaData.DATABASE_VERSION);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(UserProviderMetaData.SQL_USER);
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		}
		
	}

	private static final UriMatcher sUriMatcher;
	
	static{
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI(UserProviderMetaData.AUTHORITY, "users", 1);
		sUriMatcher.addURI(UserProviderMetaData.AUTHORITY, "users/#", 2);
	}
	
	@Override
	public int delete(Uri uri, String whereClause, String[] whereArgs) {
		int count =0;
		mDb = mDatabaseHelper.getWritableDatabase();
		switch(sUriMatcher.match(uri)){
		case 1:{
			count = mDb.delete(UserProviderMetaData.USER_TABLE_NAME, whereClause, whereArgs);
			break;
		}
		case 2:{
			String rowid = uri.getPathSegments().get(1);
			if(whereClause != null && !"".equals(whereClause)){
				whereClause = UserProviderMetaData.UserTableMetaData._ID + "=" + rowid + " AND " + whereClause;
			}else{
				whereClause =  UserProviderMetaData.UserTableMetaData._ID + "=" + rowid;
			}
			count = mDb.delete(UserProviderMetaData.USER_TABLE_NAME, whereClause, whereArgs);
			break;
		}
		default:
			throw new IllegalArgumentException("Unknow Uri:"+uri);
		};
		return count;
	}

	@Override
	public String getType(Uri uri) {
		switch(sUriMatcher.match(uri)){
		case 1: return UserProviderMetaData.UserTableMetaData.CONTENT_TYPE;
		case 2:return UserProviderMetaData.UserTableMetaData.CONTENT_ITEM_TYPE;
		default:throw new IllegalArgumentException("Unknow Uri:"+uri);
		}
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider#insert(android.net.Uri, android.content.ContentValues)
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		return null;
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider#onCreate()
	 */
	@Override
	public boolean onCreate() {
		mDatabaseHelper = new DatabaseHelper(this.getContext());
		return true;
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider#query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String)
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
			String orderBy) {
		mDb = mDatabaseHelper.getReadableDatabase();
		Cursor c = null;
		switch(sUriMatcher.match(uri)){
		case 1:{
			c = mDb.query(UserProviderMetaData.USER_TABLE_NAME, projection, selection, selectionArgs, null, null, orderBy);
			break;
		}
		case 2:{
			String rowid = uri.getPathSegments().get(1);
			if(selection != null && !"".equals(selection)){
				selection = UserProviderMetaData.UserTableMetaData._ID + "=" + rowid + " AND " + selection;
			}else{
				selection =  UserProviderMetaData.UserTableMetaData._ID + "=" + rowid;
			}
			c = mDb.query(UserProviderMetaData.USER_TABLE_NAME, projection, selection, selectionArgs, null, null, orderBy);
			break;
		}
		default:
			throw new IllegalArgumentException("Unknow Uri:"+uri);
		};
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String whereClause, String[] whereArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
