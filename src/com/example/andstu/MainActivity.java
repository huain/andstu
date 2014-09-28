package com.example.andstu;

import com.example.andstu.activitylifecycle.AActivity;
import com.example.andstu.broadcast.MyBroadcastActivity;
import com.example.andstu.db.DbActivity;
import com.example.andstu.file.FileActivity;
import com.example.andstu.fragment.FragmentMainActivity;
import com.example.andstu.intent.MyIntentActivity;
import com.example.andstu.layout.Layout;
import com.example.andstu.listview.ListViewActivity;
import com.example.andstu.net.netmanager.NetManagerActivity;
import com.example.andstu.png9.Png9Activity;
import com.example.andstu.provider.ProviderActivity;
import com.example.andstu.service.MyServiceActivity;
import com.example.andstu.sharedpreferences.SharedPreferencesActivity;
import com.example.andstu.thread.ThreadActivity;
import com.example.andstu.vedio.VedioTestActivity;
import com.example.andstu.xml.XmlActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void mainClick(View view){
    	switch(view.getId()){
	    	case R.id.mainVedioBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), VedioTestActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainDbBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), DbActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainProviderBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), ProviderActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainSharedPreferencesBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), SharedPreferencesActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainActivityLifeCycleBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), AActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainListViewBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), ListViewActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainFragmentBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), FragmentMainActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainServiceBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), MyServiceActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainBroadcastBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), MyBroadcastActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainNetBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), NetManagerActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainXmlBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), XmlActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainIntentBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), MyIntentActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainLayoutBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), Layout.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainThreadBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), ThreadActivity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainPngBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), Png9Activity.class);
	    		startActivity(intent);
	    	}break;
	    	case R.id.mainFileBtn:{
	    		Intent intent = new Intent();
	    		intent.setClass(getApplicationContext(), FileActivity.class);
	    		startActivity(intent);
	    	}break;
	    	default:;
    	}
    }
    
}
