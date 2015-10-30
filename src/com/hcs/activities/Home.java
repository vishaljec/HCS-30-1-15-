package com.hcs.activities;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.hcs.fragment.AboutUsFragment;
import com.hcs.fragment.EventBookingFragment;
import com.hcs.fragment.FragmentDrawer;
import com.hcs.fragment.HomeFragment;
import com.hcs.fragment.PaymentFragment;
import com.hcs.fragment.RateCardFragment;
import com.hcs.fragment.RideHistoryFragment;

public class Home extends ParentScreen implements
		FragmentDrawer.FragmentDrawerListener {


private TextView mTitle;
	private Toolbar mToolbar;
	private FragmentDrawer drawerFragment;
	private int REQUEST_PLACE_PICKER=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		mToolbar = (Toolbar) findViewById(R.id.toolbar);
	    mTitle = (TextView) mToolbar.findViewById(R.id.edit_text_heder);
		setSupportActionBar(mToolbar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);

		drawerFragment = (FragmentDrawer) getSupportFragmentManager()
				.findFragmentById(R.id.fragment_navigation_drawer);
		drawerFragment.setUp(R.id.fragment_navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
		drawerFragment.setDrawerListener(this);

		// display the first navigation drawer view on app launch
		displayView(0);
		
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater menuInflater = getMenuInflater();
	    menuInflater.inflate(R.menu.dashboard, menu);

	   
	        return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		

		return super.onOptionsItemSelected(item);
	}
	
	public void onPickButtonClick() {
	    // Construct an intent for the place picker
	    try {
	       Intent intent=new Intent(Home.this,SearchActivity.class);
	       startActivity(intent);
	    } catch (ExceptionInInitializerError e) {
	        // ...
	    }
	}

	

	@Override
	public void onDrawerItemSelected(View view, int position) {
		displayView(position);
	}

	private void displayView(int position) {
		Fragment fragment = null;
		String title = getString(R.string.app_name);
		switch (position) {
		case 0:
			mToolbar.setVisibility(View.GONE);
			fragment = new HomeFragment();
			title = getString(R.string.title_home);
			break;
		case 1:
			mToolbar.setVisibility(View.VISIBLE);
			fragment = new PaymentFragment();
			title = getString(R.string.title_messages_payment);
			break;
		case 2:
			mToolbar.setVisibility(View.VISIBLE);
			fragment = new RateCardFragment();
			title = getString(R.string.title_messages_rate_card);
			break;
		case 3:
			mToolbar.setVisibility(View.VISIBLE);
			fragment = new AboutUsFragment();
			title = getString(R.string.title_messages_about_us);
			break;

		case 4:
			mToolbar.setVisibility(View.VISIBLE);
			fragment = new RideHistoryFragment();
			title = getString(R.string.title_messages_ride_histoy);
			break;

		case 5:
			mToolbar.setVisibility(View.VISIBLE);
			fragment = new EventBookingFragment();
			title = getString(R.string.title_messages_Event_Booking);
			break;

		case 6:
			
			Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "8222873873"));
			startActivity(intent);
			

			break;
		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();
			fragmentTransaction.replace(R.id.container_body, fragment);
			fragmentTransaction.commit();
			mTitle.setText(title);
			getSupportActionBar().setTitle(title);
		}
	}

	@Override
	public Object getUiScreen() {
		// TODO Auto-generated method stub
		return null;
	}
}
