package com.playfun.lineonline;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainTabsAdapter extends FragmentPagerAdapter {
	
	public MainTabsAdapter(FragmentManager fm) {
        super(fm);
    }

	@Override
	public Fragment getItem(int index) {
		
		switch(index) {
		case 0:
			return new LineFragment();
		case 1:
			return new MapFragment();
		case 2:
			return new CommentFragment();
		case 3:
			return new ShareFragment();
		}
		
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}

}
