package com.latitude;

import java.util.Locale;

import com.latitude.R;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TabHost;
import android.widget.Toast;

public class main_activity extends TabActivity {
    /** Called when the activity is first created. */
	SQLiteDatabase db;
	int tab=0;
	int flg=0;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablay);

        db=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);
        try
        {
        db.execSQL("create table time(time TEXT PRIMARY KEY,pname TEXT,priority INTEGER,enable INTEGER,criteria TEXT,lat TEXT,lon TEXT,location TEXT)");
        }
        catch(SQLException e)
        {}
     
        try
        {
        db.execSQL("create table profiles(pname TEXT PRIMARY KEY,silent integer,vibration integer,keysound integer,mediavol integer,ringvol integer,alarmvol integer,notivol integer)");
        }
        catch(SQLException e)
        {}
        
       startService(new Intent(gpservice.class.getName())); 
        
        TabHost tabHost = getTabHost();
        
        tabHost.addTab(tabHost.newTabSpec("tab1")
        .setIndicator("Profile")
        .setContent(new Intent(this, selectprofile.class)));

        tabHost.addTab(tabHost.newTabSpec("tab2")
        .setIndicator("Time")
        .setContent(new Intent(this, selecttime.class)));
        
        tabHost.addTab(tabHost.newTabSpec("tab3")
        .setIndicator("GPS")
        .setContent(new Intent(this, selectgps.class)));

        

      //  tabHost.addTab(tabHost.newTabSpec("tab4")
      //  .setIndicator("Settings")
        //.setContent(new Intent(this,setting_class.class)));
        
        if(flg>0)
        {
        	  Bundle bundle = this.getIntent().getExtras();
              tab = bundle.getInt("curtab");
        }
        flg=1;
        tabHost.setCurrentTab(tab);
    }
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        menu.add(1,1,menu.FIRST,"Exit");
        
        return super.onCreateOptionsMenu(menu);
      }
    public boolean onOptionsItemSelected(MenuItem item)
    {    
    	switch (item.getItemId())
    	{   
    	case 1:
    		flg=0;
			finish();
    		break;    
    	} 
    	return true;
    	}
  
}