package com.playfun.lineonline;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.TabHost;

public class MainFrame extends FragmentActivity {
	
	private ViewPager viewPager;
    private MainTabsAdapter mAdapter;
    private TabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_frame);
		
		//Initialization

        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();

        viewPager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new MainTabsAdapter(this, mTabHost, viewPager);

        mAdapter.addTab(mTabHost.newTabSpec("1").setIndicator("[排队]"), LineFragment.class, null);
        mAdapter.addTab(mTabHost.newTabSpec("2").setIndicator("[地图]"), MapFragment.class, null);
        mAdapter.addTab(mTabHost.newTabSpec("3").setIndicator("[评价]"), CommentFragment.class, null);
        mAdapter.addTab(mTabHost.newTabSpec("4").setIndicator("[圈子]"), ShareFragment.class, null);

        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
        }
	}
}
