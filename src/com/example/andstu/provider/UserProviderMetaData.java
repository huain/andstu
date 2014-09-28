/**
 * 
 */
package com.example.andstu.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author hjin1987
 *
 */
public class UserProviderMetaData {
	
	public static final String AUTHORITY = "com.example.andstu.provider.UserProvider";
	
	public static final String DATABASE_NAME = "test.db";
	public static final int DATABASE_VERSION = 1;
	public static final String USER_TABLE_NAME = "user";
	public static final String SQL_USER = "CREATE TABLE \"user\" (\"_id\"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\"name\"  TEXT(20),\"pass\"  TEXT(20));";
	
	private UserProviderMetaData(){}
	
	public static final class UserTableMetaData implements BaseColumns{
		private UserTableMetaData(){}
		
		
		public static final String TABLE_NAME = "user";
		
		public static final Uri CONTENT_URI = Uri.parse("content://"+ AUTHORITY + "/users");
		
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.andstu.user";
		
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.andstu.user";
	
		public static final String USER_NAME = "name";
		
		public static final String USER_PASS = "pass";
	}

}
