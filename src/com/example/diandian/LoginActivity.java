package com.example.diandian;

import com.example.diandian.R.id;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private EditText etLoginName,etLoginPsw;
	private Button btnLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		etLoginName=(EditText) findViewById(id.etLoginName);
		etLoginPsw=(EditText) findViewById(id.etLoginPsw);
		btnLogin=(Button) findViewById(id.btnLogin);
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					//登陆验证模块
					if(etLoginName.getText().toString().equals("qf")&&etLoginPsw.getText().toString().equals("123"))
					{
							SharedPreferences sharepf=getSharedPreferences("Login",MODE_PRIVATE);
							Editor edit=sharepf.edit();
							edit.putString("login_state", "yes");
							edit.commit();
							Intent intent=new Intent(LoginActivity.this,MineActivity.class);
							startActivity(intent);
							finish();
					} else {
						Toast.makeText(LoginActivity.this, "登录名或密码错", Toast.LENGTH_SHORT).show();
					}
				} catch (Exception e) {
					System.out.println("fail");
				}
			}
		});
	}
}
