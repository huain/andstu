/**
 * 
 */
package com.example.andstu.net.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.andstu.R;

/**
 * @author huangjin
 * 2014-8-7
 */
public class SocketActivity extends Activity {
	
	private EditText mEditText;
	
	private Button mSendBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.net_socket_activity);
		
		mEditText = (EditText)findViewById(R.id.netSocketMsgText);
		mSendBtn = (Button)findViewById(R.id.netSocketSendBtn);
		
		mSendBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						sendMsg(mEditText.getText().toString());
					}
				}).start();
				
			}
		});
	}
	
	
	
	
	private void sendMsg(String msg){
		OutputStream ous = null;
		try {
			Socket socket = new Socket("172.27.35.1",9999);
			ous = socket.getOutputStream();
			ous.write((msg + "===" + System.currentTimeMillis()).getBytes("UTF-8"));
			ous.flush();
			ous.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
