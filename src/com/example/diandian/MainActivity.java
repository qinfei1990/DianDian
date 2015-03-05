package com.example.diandian;

import com.example.diandian.R.id;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
	private Button btnMenu,btnMine,btnOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMenu=(Button) findViewById(id.btnMenu);
        btnOrder=(Button) findViewById(id.btnOrder);
        btnMine=(Button) findViewById(id.btnMine);
        btnMenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,MenuActivity.class);
				startActivity(intent);
			}
		});
        btnOrder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,OrderActivity.class);
				startActivity(intent);
			}
		});
        btnMine.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					SharedPreferences sharepf=getSharedPreferences("Login", MODE_PRIVATE);
					if(sharepf.getString("login_state", "")==null||sharepf.getString("login_state", "").length()==0 )
					{
						Intent intent=new Intent(MainActivity.this,LoginActivity.class);
						startActivity(intent);
					}
					else
					{
						Intent intent=new Intent(MainActivity.this,MineActivity.class);
					startActivity(intent);
					}
				} catch (Exception e) {
					
				}
			}
		});
    }
}
