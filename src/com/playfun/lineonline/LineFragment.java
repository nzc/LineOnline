package com.playfun.lineonline;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
 
public class LineFragment extends Fragment {
	
	private LinearLayout mLineList;
	private LayoutInflater mInflater;
	private ViewGroup mViewGroup;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
    	mInflater = inflater;
    	mViewGroup = container;
        View rootView = inflater.inflate(R.layout.line_main, container, false);
        
        EditText mEditText = (EditText) rootView.findViewById(R.id.playgroundProjectSearch);
		Drawable img = getResources().getDrawable(R.drawable.search);
		img.setBounds(0, 0, (int) mEditText.getTextSize(), (int) mEditText.getTextSize());
		mEditText.setCompoundDrawables(img, null, null, null);
		
		mLineList = (LinearLayout) rootView.findViewById(R.id.lineListView);
		
		for (int index = 0; index < 5; index++)
			lineListItemInsert(R.drawable.u_slide_board, "UÐÍ»¬°å", "XX:XX");
        
        return rootView;
    }
    
    public void lineListItemInsert(int imgID, String pName, String cTime) {
    	
    	View listItemView = mInflater.inflate(R.layout.line_list_item, mViewGroup, false);
    	mLineList.addView(listItemView);
    }
}