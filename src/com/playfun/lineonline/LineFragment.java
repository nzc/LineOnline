package com.playfun.lineonline;
import java.util.ArrayList;

import com.playfun.lineonline.widget.LvAdapter;
import com.playfun.lineonline.widget.MyListView;
import com.playfun.lineonline.widget.MyListView.OnRefreshListener;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
 
public class LineFragment extends Fragment {
	
	private ArrayList<View> mLineList = new ArrayList<View>();
	private LvAdapter mAdapter;
	private MyListView mListView;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.line_main, container, false);
        
        EditText mEditText = (EditText)(rootView.findViewById(R.id.playgroundProjectSearch));
		Drawable img = getResources().getDrawable(R.drawable.search);
		img.setBounds(0, 0, (int) mEditText.getTextSize(), (int) mEditText.getTextSize());
		mEditText.setCompoundDrawables(img, null, null, null);
		
		mListView = (MyListView) rootView.findViewById(R.id.lineListView);
		
		for (int index = 0; index < 5; index++) {
			View listItemView = inflater.inflate(R.layout.line_list_item, mListView, false);
			if (index == 0) {
				listItemView.setPadding(listItemView.getPaddingLeft(),
									    0,
									    listItemView.getPaddingRight(),
									    listItemView.getPaddingBottom());
			}
			mLineList.add(listItemView);
		}
		
		mAdapter = new LvAdapter(getActivity(), mLineList);
		mListView.setAdapter(mAdapter);
        
		mListView.setOnRefreshListener(new OnRefreshListener() {

			public void onRefresh() {
				new AsyncTask<Void, Void, Void>() {
					protected Void doInBackground(Void... params) {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						return null;
					}
					
					protected void onPostExecute(Void result) {
						mAdapter.notifyDataSetChanged();
						mListView.onRefreshComplete();
					}
				}.execute(null, null, null);
				
			}
			
		});
		
		rootView.findViewById(R.id.lineHeader).bringToFront();
		
        return rootView;
    }
}