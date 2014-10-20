package com.playfun.lineonline;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.playfun.lineonline.util.Debugger;

public class HomePage extends Activity implements OnClickListener {
	
	private ArrayList<Button> navigators = new ArrayList<Button>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);
		
		navigators.add((Button) findViewById(R.id.twoDScanMenuItem));
		navigators.add((Button) findViewById(R.id.groundSearchMenuItem));
		
		for (Button i : navigators)
			i.setOnClickListener(this);
		
		EditText mEditText = (EditText) findViewById(R.id.playgroundSearch);
		Drawable img = getResources().getDrawable(R.drawable.search);
		System.out.println(mEditText.getHeight());
		img.setBounds(0, 0, (int)mEditText.getTextSize(), (int)mEditText.getTextSize());
		mEditText.setCompoundDrawables(img, null, null, null);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		else if (id == R.id.exit) {
			HomePage.this.finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intentr=new Intent(HomePage.this, MainFrame.class);
        HomePage.this.startActivity(intentr);
        overridePendingTransition(R.anim.in_from_bottom, 0);
//		HomePage.this.finish();
	}
}
