package com.example.diandian;

import com.example.diandian.R.id;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MineActivity extends Activity {
	private Button btnLogOut;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mine);
		btnLogOut=(Button) findViewById(id.btnLogOut);
		btnLogOut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				SharedPreferences sharepf=getSharedPreferences("Login", MODE_PRIVATE);
				Editor editor=sharepf.edit();
				editor.remove("login_state");
				editor.commit();
				finish();
			}
		});
	}
}
