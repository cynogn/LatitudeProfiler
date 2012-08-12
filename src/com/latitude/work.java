package com.latitude;

import java.util.List;
import java.util.Locale;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MapView.LayoutParams;
import com.google.android.maps.Overlay;
import com.latitude.R;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class work extends MapActivity {
	MapView mapView,mp;
	double lat,lon;
	int count;
	String location,profile,value;
	SQLiteDatabase db;
	Cursor cur;
	 class MapOverlay extends com.google.android.maps.Overlay
	{
	        @Override
	        public boolean draw(Canvas canvas, MapView mapView, 
	        boolean shadow, long when) 
	        {
				return shadow;
	        }
	 
	        @Override
	        public boolean onTouchEvent(MotionEvent event, MapView mapView) 
	        {   
	            //---when user lifts his finger---
	if (event.getAction() == 1) 
	{                
	             GeoPoint p = mapView.getProjection().fromPixels(
	              (int) event.getX(),
	              (int) event.getY());
	               lat=p.getLatitudeE6()/1E6;
	               lon=p.getLongitudeE6()/1E6;
	               Toast.makeText(getBaseContext(),lat+ "," +lon,Toast.LENGTH_SHORT).show();
	             
		/*	Intent in=new Intent(work.this,gps_class.class);
			Bundle bundle = new Bundle();
			bundle.putString("lat",lat+"");
			bundle.putString("lon",lon+"");
			bundle.putString("wrkloc",location);
			bundle.putString("wrklpro",profile);
			bundle.putInt("wrklcnt",count);
			bundle.putString("wrklval",value);
			in.putExtras(bundle);
			startActivity(in);*/
	}
	            return false;	            
	        }        
	    }
	
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testpge);

       /* Bundle bundle = this.getIntent().getExtras();
        location=bundle.getString("wrkloc");
		profile=bundle.getString("wrklpro");
		count=bundle.getInt("wrklcnt");
		value=bundle.getString("wrklval");
		*/
        mp=(MapView)findViewById(R.id.mapview);
        mp.setClickable(true);
        mp.setBuiltInZoomControls(true);
        
        MapOverlay mapOverlay = new MapOverlay();
        List<Overlay> listOfOverlays = mp.getOverlays();
        listOfOverlays.clear();
        listOfOverlays.add(mapOverlay);
        
        Button b3;
      	 b3 = (Button) findViewById(R.id.button1);
   	     b3.setOnClickListener(new View.OnClickListener() 
   	     {
   	    	 public void onClick(View v) 
   	    	 {
   	    	 db=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
   	         db.setVersion(1);
   	         db.setLocale(Locale.getDefault());
   	         db.setLockingEnabled(true);
   	      ContentValues values=new ContentValues();
   	      try
          {
   	    	db.execSQL("create table tmp(location TEXT,pname TEXT,priority INTEGER,lat TEXT ,lon TEXT)");
          }
          catch(SQLException e)
          {}
        //  db.execSQL("delete from table tmp");
  			values.put("lat", lat);
  			values.put("lon", lon);
  			db.update("tmp", values,null, null);
   	    		 
  			 cur = db.query("tmp", new String[]{"pname"}, null,null, null, null, null, null);
  	     	//Cursor cur = db.query("profiles",new String[]{"silent"},"pname like office", null, null, null, null); 
  	     	cur.moveToFirst();
  	     	Intent in=new Intent(work.this,gps_class.class);
  	     	Bundle bundle = new Bundle();
			bundle.putString("val",cur.getString(0));
			bundle.putInt("ifmap",1);
			in.putExtras(bundle);
		startActivity(in);
		finish();
   	    	 }
   	     });
    }
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}