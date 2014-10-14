package com.playfun.lineonline;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
 
public class CommentFragment extends Fragment {
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.comment_main, container, false);
        
        LinearLayout commentLayout = (LinearLayout) (rootView.findViewById(R.id.commentListView));
        
        for (int mIndex = 0; mIndex < 20; mIndex++) {
        	TextView textView = new TextView(getActivity());
        	textView.setText("Text " + mIndex);
        	textView.setWidth(LayoutParams.MATCH_PARENT);
        	textView.setHeight(100);
        	textView.setTextColor(Color.BLACK);
        	textView.setBackgroundResource(R.drawable.textborders);
        	commentLayout.addView(textView);
        }
         
        return rootView;
    }
 
}