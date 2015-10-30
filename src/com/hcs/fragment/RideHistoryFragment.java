package com.hcs.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hcs.activities.R;

public class RideHistoryFragment extends Fragment {

	private Toolbar toolbar;
	private TabLayout tabLayout;
	private ViewPager viewPager;

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_ride_history,
				container, false);

		viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
		setupViewPager(viewPager);
		tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
		tabLayout.setupWithViewPager(viewPager);

		// Inflate the layout for this fragment
		return rootView;
	}

	private void setupViewPager(ViewPager viewPager) {
		ViewPagerAdapter adapter = new ViewPagerAdapter(
				getFragmentManager());
		adapter.addFragment(new AllRides(), "ALL RIDES");
		adapter.addFragment(new UpComing(), "UPCOMING");
		adapter.addFragment(new Completed(), "COMPLETED");
		viewPager.setAdapter(adapter);
		
		
	}

	class ViewPagerAdapter extends FragmentPagerAdapter {
		private final List<Fragment> mFragmentList = new ArrayList<>();
		private final List<String> mFragmentTitleList = new ArrayList<>();

		public ViewPagerAdapter(FragmentManager manager) {
			super(manager);
		}

		@Override
		public Fragment getItem(int position) {
			return mFragmentList.get(position);
		}

		@Override
		public int getCount() {
			return mFragmentList.size();
		}

		public void addFragment(Fragment fragment, String title) {
			mFragmentList.add(fragment);
			mFragmentTitleList.add(title);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mFragmentTitleList.get(position);
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
