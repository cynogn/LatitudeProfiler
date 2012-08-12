package com.latitude;

import com.latitude.R;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class tabview extends TabActivity {
    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablay);
        TabHost tabHost = getTabHost();

        tabHost.addTab(tabHost.newTabSpec("tab1")
        .setIndicator("Time")
        .setContent(new Intent(this, time_class.class)));
        

        tabHost.addTab(tabHost.newTabSpec("tab2")
        .setIndicator("GPS")
        .setContent(new Intent(this, main_activity.class)));

       
    }
}