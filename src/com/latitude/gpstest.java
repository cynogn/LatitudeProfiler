package com.latitude;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.latitude.R;

import android.os.Bundle;

public class gpstest extends MapActivity {
	MapView mp;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testpge);
        mp=(MapView)findViewById(R.id.mapview);
        mp.setClickable(true);
        mp.setBuiltInZoomControls(true);
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
    
}