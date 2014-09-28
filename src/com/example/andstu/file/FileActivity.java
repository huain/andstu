/**
 * 
 */
package com.example.andstu.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.andstu.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.view.View;

/**
 * @author huangjin
 * 2014-8-1
 */
public class FileActivity extends Activity {
	private final String TAG = "FileActivity";
	
	
	
	/*
	 * 
	 * Storage Options  
	 * from http://developer.android.com/guide/topics/data/data-storage.html
	 * ==============================================
	 * Using the Internal Storage
	 * You can save files directly on the device's internal storage. 
	 * By default, files saved to the internal storage are private to your application and other applications cannot access them (nor can the user). 
	 * When the user uninstalls your application, these files are removed.
	 * 
	 * Tip: 
	 * If you want to save a static file in your application at compile time, 
	 * save the file in your project res/raw/ directory. 
	 * You can open it with openRawResource(), 
	 * passing the R.raw.<filename> resource ID. 
	 * This method returns an InputStream that you can use to read the file (but you cannot write to the original file).
	 * 
	 * 
	 * Saving cache files 
	 * If you'd like to cache some data, 
	 * rather than store it persistently, 
	 * you should use getCacheDir() to open a File that represents the internal directory where your application should save temporary cache files.
	 * When the device is low on internal storage space,
	 * Android may delete these cache files to recover space. 
	 * However, you should not rely on the system to clean up these files for you. 
	 * You should always maintain the cache files yourself and stay within a reasonable limit of space consumed, 
	 * such as 1MB. When the user uninstalls your application, these files are removed.
	 * 
	 * ==============================================
	 * Using the External Storage
	 * Every Android-compatible device supports a shared "external storage" that you can use to save files. 
	 * This can be a removable storage media (such as an SD card) or an internal (non-removable) storage. 
	 * Files saved to the external storage are world-readable and can be modified by the user when they enable USB mass storage to transfer files on a computer.
	 * 
	 * Caution: 
	 * External storage can become unavailable if the user mounts the external storage on a computer or removes the media, 
	 * and there's no security enforced upon files you save to the external storage. 
	 * All applications can read and write files placed on the external storage and the user can remove them.
	 * 
	 * 
	 * Saving files that can be shared with other apps
     * To get a File representing the appropriate public directory, 
	 * call getExternalStoragePublicDirectory(), 
	 * passing it the type of directory you want, 
	 * such as DIRECTORY_MUSIC, DIRECTORY_PICTURES, DIRECTORY_RINGTONES, or others. 
	 * By saving your files to the corresponding media-type directory, 
	 * the system's media scanner can properly categorize your files in the system 
	 * (for instance, ringtones appear in system settings as ringtones, not as music).
	 * 
	 * 
	 * Saving files that are app-private
	 * If you are handling files that are not intended for other apps to use (such as graphic textures or sound effects used by only your app), 
	 * you should use a private storage directory on the external storage by calling getExternalFilesDir(). 
	 * This method also takes a type argument to specify the type of subdirectory (such as DIRECTORY_MOVIES). 
	 * If you don't need a specific media directory, 
	 * pass null to receive the root directory of your app's private directory.
	 * Beginning with Android 4.4, 
	 * reading or writing files in your app's private directories does not require the READ_EXTERNAL_STORAGE or WRITE_EXTERNAL_STORAGE permissions. 
	 * So you can declare the permission should be requested only on the lower versions of Android by adding the maxSdkVersion attribute:
	 *     <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" android:maxSdkVersion="18" />
	 * Note: 
	 * When the user uninstalls your application, 
	 * this directory and all its contents are deleted. 
	 * Also, the system media scanner does not read files in these directories, 
	 * so they are not accessible from the MediaStore content provider. 
	 * As such, you should not use these directories for media that ultimately belongs to the user, 
	 * such as photos captured or edited with your app, 
	 * or music the user has purchased with your app—those files should be saved in the public directories.
	 * 
	 * Sometimes, a device that has allocated a partition of the internal memory for use as the external storage may also offer an SD card slot. 
	 * When such a device is running Android 4.3 and lower, 
	 * the getExternalFilesDir() method provides access to only the internal partition and your app cannot read or write to the SD card. 
	 * Beginning with Android 4.4, however, 
	 * you can access both locations by calling getExternalFilesDirs(), 
	 * which returns a File array with entries each location. 
	 * The first entry in the array is considered the primary external storage and you should use that location unless it's full or unavailable. 
	 * If you'd like to access both possible locations while also supporting Android 4.3 and lower, 
	 * use the support library's static method, ContextCompat.getExternalFilesDirs(). 
	 * This also returns a File array, 
	 * but always includes only one entry on Android 4.3 and lower.
	 * 
	 * Caution 
	 * Although the directories provided by getExternalFilesDir() and getExternalFilesDirs() are not accessible by the MediaStore content provider, 
	 * other apps with the READ_EXTERNAL_STORAGE permission can access all files on the external storage, 
	 * including these. 
	 * If you need to completely restrict access for your files, 
	 * you should instead write your files to the internal storage.
	 * 
	 * 
	 * Saving cache files
	 * To open a File that represents the external storage directory where you should save cache files, 
	 * call getExternalCacheDir(). 
	 * If the user uninstalls your application, 
	 * these files will be automatically deleted.
	 * Similar to ContextCompat.getExternalFilesDirs(), 
	 * mentioned above, 
	 * you can also access a cache directory on a secondary external storage (if available) by calling ContextCompat.getExternalCacheDirs().
	 * 
	 * Tip: 
	 * To preserve file space and maintain your app's performance, 
	 * it's important that you carefully manage your cache files and remove those that aren't needed anymore throughout your app's lifecycle.
	 * 
	 */
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common);
	}
	
	public void mainClick(View v){
		switch (v.getId()) {
		case R.id.commonBtn:{
			logPath();
		};break;
		case R.id.commonBtn2:{
			logSize();
		};break;
		case R.id.commonBtn3:{
			
		};break;
		default:
			break;
		}
	}
	
	public void logPath(){
		Log.d(TAG, "===getFilesDir:"+getFilesDir());
		Log.d(TAG, "===getExternalFilesDir:"+getExternalFilesDir("test"));
		Log.d(TAG, "===getExternalStorageDirectory:"+Environment.getExternalStorageDirectory());
		Log.d(TAG, "===getExternalStoragePublicDirectory:"+Environment.getExternalStoragePublicDirectory("Android/data/com.example.andstu/files/test"));
	}
	
	public void logSize(){
		File root = Environment.getExternalStorageDirectory();
		StatFs sf = new StatFs(root.getPath());
		long blockSize = sf.getBlockSize();
		long blockCount = sf.getBlockCount();
		long availCount = sf.getAvailableBlocks();
		Log.d(TAG , "ExternalStorage:block大小:" + blockSize+ ",block数目:" + blockCount+ ",总大小:" +blockSize*blockCount/ 1024 + "KB" );
		Log.d(TAG , "ExternalStorage:可用的block数目：:" + availCount+ ",可用大小:" + availCount*blockSize/ 1024 + "KB" );
		File root2 = getFilesDir();
		StatFs sf2 = new StatFs(root2.getPath());
		long blockSize2 = sf2.getBlockSize();
		long blockCount2 = sf2.getBlockCount();
		long availCount2 = sf2.getAvailableBlocks();
		Log.d(TAG , "InternalStorage:block大小:" + blockSize2+ ",block数目:" + blockCount2+ ",总大小:" +blockSize2*blockCount2/ 1024 + "KB" );
		Log.d(TAG , "InternalStorage:可用的block数目：:" + availCount2+ ",可用大小:" + availCount2*blockSize2/ 1024 + "KB" );
		
	}

	// 内部文件相关
	/**
	 * 关于内部文件操作的几个有用的方法
	 */
	public void fileOP(){
		Log.d(TAG, "=========useful methods");
		// Gets the absolute path to the filesystem directory where your internal files are saved.
		@SuppressWarnings("unused")
		File f = getFilesDir();
		
		// Creates (or opens an existing) directory within your internal storage space.
		f = getDir("file",Context.MODE_PRIVATE);
		
		// Deletes a file saved on the internal storage.
		deleteFile("file");
		
		// Returns an array of files currently saved by your application.
		@SuppressWarnings("unused")
		String[] list = fileList();
		
	}
	
	/**
	 * 内部文件复制
	 */
	public void copyInterFile(){
		try {
			FileInputStream fis = openFileInput("hello1");
			FileOutputStream fos = openFileOutput("hello", Context.MODE_PRIVATE);
			byte[] buffer = new byte[1024];
		    int length = -1;
		    while((length = fis.read(buffer)) != -1 ){
		    	fos.write(buffer, 0, length);
		    }
		    fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// 外部文件相关
	/* Checks if external storage is available for read and write */
	public boolean isExternalStorageWritable() {
	    String state = Environment.getExternalStorageState();
	    if (Environment.MEDIA_MOUNTED.equals(state)) {
	        return true;
	    }
	    return false;
	}

	/* Checks if external storage is available to at least read */
	public boolean isExternalStorageReadable() {
	    String state = Environment.getExternalStorageState();
	    if (Environment.MEDIA_MOUNTED.equals(state) ||
	        Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
	        return true;
	    }
	    return false;
	}
	
	/**
	 * creates a directory for a new photo album in the public pictures directory
	 * @param albumName
	 * @return
	 */
	public File getAlbumStorageDir(String albumName) {
	    // Get the directory for the user's public pictures directory.
		/*
		 * To get a File representing the appropriate public directory, 
		 * call getExternalStoragePublicDirectory(), 
		 * passing it the type of directory you want, 
		 * such as DIRECTORY_MUSIC, DIRECTORY_PICTURES, DIRECTORY_RINGTONES, or others. 
		 * By saving your files to the corresponding media-type directory, 
		 * the system's media scanner can properly categorize your files in the system 
		 * (for instance, ringtones appear in system settings as ringtones, not as music).
		 */
	    File file = new File(Environment.getExternalStoragePublicDirectory(
	            Environment.DIRECTORY_PICTURES), albumName);
	    if (!file.mkdirs()) {
	        Log.e(TAG, "Directory not created");
	    }
	    return file;
	}

}
