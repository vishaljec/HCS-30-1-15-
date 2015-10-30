package com.hcs.fragment;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hcs.activities.R;
import com.hcs.activities.SearchActivity;
import com.hcs.beans.HomeBean;
import com.hcs.services.GPSTracker;

public class HomeFragment extends Fragment implements OnClickListener{
	private GoogleMap map;
    private LinearLayout hatchBack,sedan,suv,auto,more;
    private EditText locationEdittext;
    
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home, container,
				false);

		hatchBack=(LinearLayout) rootView.findViewById(R.id.hatchback);
		sedan=(LinearLayout) rootView.findViewById(R.id.sedan);
		suv=(LinearLayout) rootView.findViewById(R.id.suv);
		auto=(LinearLayout) rootView.findViewById(R.id.auto);
		more=(LinearLayout) rootView.findViewById(R.id.more);
		locationEdittext=(EditText) rootView.findViewById(R.id.locationEditText);
		
		hatchBack.setOnClickListener(this);
		sedan.setOnClickListener(this);
		suv.setOnClickListener(this);
		auto.setOnClickListener(this);
		more.setOnClickListener(this);
		locationEdittext.setOnClickListener(this);
		
		//locationEdittext.setKeyListener(null);
		map = ((SupportMapFragment) this.getChildFragmentManager()
				.findFragmentById(R.id.map)).getMap();
		//map.setMyLocationEnabled(true);

		GPSTracker gpsTracker = new GPSTracker(getActivity());

		

		ArrayList<HomeBean> arrayList = new ArrayList<HomeBean>();
		HomeBean bean = new HomeBean();
		bean.setLatitude(String.valueOf(gpsTracker.getLatitude()));
		bean.setLongitude(String.valueOf(gpsTracker.getLongitude()));
		bean.setMyLocation(true);
		arrayList.add(bean);

		HomeBean bean1 = new HomeBean();
		bean1.setLatitude("28.6629");
		bean1.setLongitude("77.2100");
		bean1.setMyLocation(false);
		arrayList.add(bean1);

		HomeBean bean2 = new HomeBean();
		bean2.setLatitude("28.6139");
		bean2.setLongitude("77.2090");
		bean2.setMyLocation(false);
		arrayList.add(bean2);

		HomeBean bean3 = new HomeBean();
		bean3.setLatitude("28.560323");
		bean3.setLongitude("77.1617281");
		bean3.setMyLocation(false);
		arrayList.add(bean3);

		HomeBean bean4 = new HomeBean();
		bean4.setLatitude("28.5494489");
		bean4.setLongitude(" 77.2001368");
		bean4.setMyLocation(false);
		arrayList.add(bean4);

		HomeBean bean5 = new HomeBean();
		bean5.setLatitude("28.673751");
		bean5.setLongitude("77.1273376");
		bean5.setMyLocation(false);
		arrayList.add(bean5);

		HomeBean bean6 = new HomeBean();
		bean6.setLatitude("28.7158727");
		bean6.setLongitude("77.1910738");
		bean6.setMyLocation(false);
		arrayList.add(bean6);

		HomeBean bean7 = new HomeBean();
		bean7.setLatitude("28.6544346");
		bean7.setLongitude("77.16888");
		bean7.setMyLocation(false);
		arrayList.add(bean7);

		HomeBean bean9 = new HomeBean();
		bean9.setLatitude("28.5086497");
		bean9.setLongitude("77.2175223");
		bean9.setMyLocation(false);
		arrayList.add(bean9);

		HomeBean bean8 = new HomeBean();
		bean8.setLatitude("28.6814284");
		bean8.setLongitude("77.2226866");
		bean8.setMyLocation(false);
		arrayList.add(bean8);

		HomeBean bean10 = new HomeBean();
		bean10.setLatitude("28.6698997");
		bean10.setLongitude("77.2666465");
		bean10.setMyLocation(false);
		arrayList.add(bean10);
		
		drawMarker(arrayList);

		// Inflate the layout for this fragment
		
		
		return rootView;
	}

	private void drawMarker(ArrayList<HomeBean> arrayList) {
		// Creating an instance of MarkerOptions

		for (int i = 0; i < arrayList.size(); i++) {
			MarkerOptions markerOptions = new MarkerOptions();

			// Setting latitude and longitude for the marker
			markerOptions.position(new LatLng(Double.parseDouble(arrayList.get(
					i).getLatitude()), Double.parseDouble(arrayList.get(i)
					.getLongitude())));
			if (arrayList.get(i).isMyLocation()) {
				markerOptions.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.current));
				map.addMarker(markerOptions);
				map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
						Double.parseDouble(arrayList.get(i).getLatitude()),
						Double.parseDouble(arrayList.get(i).getLongitude())),
						16.0f));
			} else {
				markerOptions.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.car));
				map.addMarker(markerOptions);
			}

			// Adding marker on the Google Map

		}

	}
	
	public void showDilog()
	{
		AlertDialog.Builder builder =
			       new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle);
			      
		 builder.setView(R.layout.fare_dilog);
			           /* builder.setPositiveButton("OK", null);
			            builder.setNegativeButton("Cancel", null);*/
			            builder.show();
			           
	}
	
	
	
	@Override
	public void onClick(View v) {

	    switch (v.getId()) {

	    case R.id.hatchback:
	        // do your code
	    	
	    	showDilog();
	        break;

	    case R.id.sedan:
	        // do your code
	    	showDilog();
	        break;

	    case R.id.suv:
	        // do your code
	    	showDilog();
	        break;
	        

	    case R.id.auto:
	        // do your code
	    	showDilog();
	        break;
	        

	    case R.id.more:
	        // do your code
	        break;
	        
	    case R.id.locationEditText:
	        // do your code
	    	Intent intent=new Intent(getActivity(),SearchActivity.class);
	    	startActivity(intent);
	        break;

	    default:
	        break;
	    }

	}
	
	


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}
}