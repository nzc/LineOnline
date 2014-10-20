package com.playfun.lineonline.util;

import android.content.Context;
import android.widget.Toast;

public class Debugger {
	public static void DisplayToast(Context context, String str) {
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}
}
