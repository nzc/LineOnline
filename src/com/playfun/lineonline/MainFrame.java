package com.playfun.lineonline;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainFrame extends FragmentActivity implements OnClickListener {
	
	private ViewPager viewPager;
    private MainTabsAdapter mAdapter;
    private List<TextView> tabNavigators = new ArrayList<TextView>();
    
    private int currentPosition = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_frame);
		
		//Initialization
		viewPager = (ViewPager) findViewById(R.id.pager);
	    mAdapter = new MainTabsAdapter(getSupportFragmentManager());
	    tabNavigators.add((TextView) findViewById(R.id.lineMenuButton));
	    tabNavigators.add((TextView) findViewById(R.id.mapMenuButton));
	    tabNavigators.add((TextView) findViewById(R.id.commMenuButton));
	    tabNavigators.add((TextView) findViewById(R.id.shareMenuButton));
	    
	    for (TextView navigator : tabNavigators) {
	    	navigator.setOnClickListener(this);
	    }
	    
	    viewPager.setAdapter(mAdapter);
	    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
	    	public void onPageSelected(int position) {
	        // on changing the page
	        // make respected tab selected
	    		setSelected(position);
	        }
	    	
	    	public void onPageScrolled(int arg0, float arg1, int arg2) {}
	 
	        public void onPageScrollStateChanged(int arg0) {}
	    });
	    
	    setSelected(0);
	}
	
	public boolean onCreateOptionMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_frame, menu);
		return true;
	}
	
	
	
	public boolean onOptionsItemSelected(MenuItem item) {
		int item_id = item.getItemId();
		
		switch (item_id) {
		case R.id.exit:
			MainFrame.this.finish();
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	protected void setSelected(int position) {
		/*
		Toast toast = Toast.makeText(getBaseContext(),
				                     "The last position is: " + currentPosition
				                     + "\n The new position is: " + position,
				                     Toast.LENGTH_SHORT);
		toast.show();
		*/
		TextView lastSelection = tabNavigators.get(currentPosition);
		lastSelection.setBackgroundColor(Color.parseColor(getString(R.string.unselectedTabBackground)));
		lastSelection.setTextColor(Color.parseColor(getString(R.string.unselectedTabTextColor)));
		
		TextView newSelection = tabNavigators.get(position);
		newSelection.setBackgroundColor(Color.parseColor(getString(R.string.selectedTabBackground)));
		newSelection.setTextColor(Color.parseColor(getString(R.string.selectedTabTextColor)));
		
		currentPosition = position;
		viewPager.setCurrentItem(position);
	}

	public void onClick(View v) {
		setSelected(tabNavigators.indexOf((TextView) v));
	}
}
