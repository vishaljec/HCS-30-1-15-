package com.hcs.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Login extends ParentScreen {
	private Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		mToolbar = (Toolbar) findViewById(R.id.toolbar);

		setSupportActionBar(mToolbar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		
		TextView name=(TextView) mToolbar.findViewById(R.id.edit_text_heder);
		name.setText("Login");
		init();
	}

	public void init() {
		TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.email_til);
		TextView registerNow=(TextView) findViewById(R.id.textView_register);
		registerNow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Login.this,Registration.class);
				startActivity(intent);
			}
		});
		/*
		 * inputLayout.setErrorEnabled(true);
		 * inputLayout.setError(getString(R.string.error_email));
		 */
	}
	
	
	
	public void signIn(View v)
	{
		Intent intent=new Intent(Login.this,Home.class);
		startActivity(intent);
	}

	@Override
	public Object getUiScreen() {
		// TODO Auto-generated method stub
		return null;
	}
}
