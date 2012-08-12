package com.latitude;

import java.util.Calendar;
import java.util.Locale;

import com.latitude.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class gps_class extends Activity {

	gps_class activity;
	SQLiteDatabase db;
	private String array_spinner[];
	String lat,lon;
	double tlat,tlon;
	String profile,latlon,loc,Text1;
	Button b2,b;
	TextView tv;
	String val1;
	String gpname,glat,glon,glocation;
	int listcnt=0,ifmap,gprio;
	Cursor num;
    public void onCreate(Bundle savedInstanceState)
    {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gps_layout);
        
    	/*b = (Button) findViewById(R.id.button1);
    	b.setOnClickListener(new View.OnClickListener() 
    	{ 	
    		public void onClick(View v)
    		{
    			//String ts;
    			tv=(TextView)findViewById(R.id.textView4);
    			lat=tlat+"";
    			lon=tlon+"";
    			Text1 = "Latitude =  "+lat +"  Longitud = " +lon; 
    			//ts="Latitude =  "+tlat +"  Longitud = " +tlon; 
    			tv.setText(Text1);
    			//Toast.makeText(getApplicationContext(), Text1, Toast.LENGTH_LONG).show();
    			//Toast.makeText(getApplicationContext(), ts, Toast.LENGTH_LONG).show();
    		}
    	});*/
    	EditText et=(EditText)findViewById(R.id.editText1);
	
        //Delete button
        Button bt9=(Button)findViewById(R.id.button4);
        bt9.setEnabled(true);
        //From map button
   	 Button b3;
   	 b3 = (Button) findViewById(R.id.button2);
   	b3.setClickable(true);
	     b3.setOnClickListener(new View.OnClickListener() 
	     {
	    	 public void onClick(View v) 
	    	 {
	    		 int count1;
	    		 num=db.query("time",null, null, null, null, null, null);
	    		
	    	    	if(num.getCount()!=0)
	    	    	{
	    	    	//count=num.getInt(0)+1;
	    	    		num.moveToLast();
	    	    		count1=num.getInt(2)+1;
	    	    	}
	    	    	else
	    	    	{
	    	    		count1 =1;
	    	    	}
	    	    	
		    			 db.execSQL("delete from tmp");
		    			 EditText et=(EditText)findViewById(R.id.editText1);
		    			 loc=et.getText().toString();
	    		ContentValues values1=new ContentValues();
	    		String time;
	     		values1.put("pname",profile);
	     		values1.put("priority",count1);
	     		values1.put("lat", "5");
	     		values1.put("lon", "6");
	     		values1.put("location",loc);
	     		db.insert("tmp", null, values1);
	    		Intent in=new Intent(gps_class.this,work.class);
	    		/*Bundle bundle = new Bundle();
     			bundle.putString("val1","New Profile..");
     			in.putExtras(bundle);*/
	    		startActivity(in);
   			finish();
	    	 }
	    });
	     
        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
        LocationListener mlocListener = new MyLocationListener(); 

        mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener); 

        db=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);
      
        try
        {
        db.execSQL("create table tmp(location TEXT,pname TEXT,priority INTEGER,lat TEXT ,lon TEXT)");
        }
        catch(SQLException e)
        {}
        
        Bundle bundle = this.getIntent().getExtras();
        val1 = bundle.getString("val");
        ifmap= bundle.getInt("ifmap");
        
        Cursor cur = db.query("profiles",null, null, null, null, null, null);
    	listcnt=0;

    	cur.moveToFirst();
    	while (cur.isAfterLast() == false) 
    	{
    		cur.moveToNext();
    		listcnt++;
    	}
    	array_spinner=new String[listcnt+1];
    	array_spinner[0]="Choose a profile";
    	cur.moveToFirst();
    	int move=1;
    	while (cur.isAfterLast() == false) 
    	{
    		array_spinner[move]=cur.getString(0);
    		cur.moveToNext();
    		move++;
    	}

    	cur.close();

    	Spinner s = (Spinner) findViewById(R.id.spinner1);
    	ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, array_spinner);
    	adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);    
    	s.setAdapter(adapter1);

    	s.setOnItemSelectedListener(new OnItemSelectedListener()
    	{       
    		public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    		{
    			profile=parent.getItemAtPosition(pos).toString(); 
    		}
    		public void onNothingSelected(AdapterView<?> arg0)
    		{// TODO Auto-generated method stub
    		}
    	});
   
        if(val1.equals("New Position.."))
        {
        	bt9.setEnabled(false);
        	    //Current Location
    
        	tv=(TextView)findViewById(R.id.textView4);
        
  
    //SAVE BUTTON
    
    b2 = (Button) findViewById(R.id.button3);
    b2.setOnClickListener(new View.OnClickListener() 
    {
    public void onClick(View v) 
    {
    	int count;
    	EditText et=(EditText)findViewById(R.id.editText1);
    	num=db.query("time",null, null, null, null, null, null);
    	if(num.getCount()!=0)
    	{
    	//count=num.getInt(0)+1;
    		num.moveToLast();
    		count=num.getInt(2)+1;
    	}
    	else
    	{
    		count =1;
    	}
    //	num=db.query("gps", null, null, null, null, null, null);
    //	count=count+num.getCount()+1;
    	
    	loc=et.getText().toString();
    	ContentValues values=new ContentValues();
    	if(latlon==""||profile=="Choose a profile"||loc=="")
    	{
    		Toast.makeText(getApplicationContext(),"Position or Profile is not set", Toast.LENGTH_SHORT).show();
    
    	}
    	else
    	{
    	//Toast.makeText(getApplicationContext(),"not set", Toast.LENGTH_SHORT).show();
    	num=db.query("time", null, "lat = ?", new String[]{lat+""}, null, null, null);
	int flg,flg1;
    	if(num.getCount()==0)
    	{    
    		num=db.query("time", null, "lon = ?", new String[]{lon+""}, null, null, null);
    		if(num.getCount()==0)
        	{
    		String time;
    		time="nt"+count;
    		values.put("time", time);
    		values.put("pname",profile);
    		values.put("priority",count);
    		values.put("enable", 1);
    		values.put("criteria","gps");
    		values.put("lat", lat);
    		values.put("lon", lon);
    		values.put("location",loc);
    		db.insert("time", null, values);
    		Toast.makeText(getApplicationContext(), "Setting saved successfully", Toast.LENGTH_SHORT).show();
    		Intent in=new Intent(gps_class.this,main_activity.class);
    		Bundle bundle = new Bundle();
			bundle.putInt("curtab",2);
			in.putExtras(bundle);
    		startActivity(in);
			finish();
        }
    	
    	else 
    	{
    		AlertDialog.Builder alertbox = new AlertDialog.Builder(activity); 
    		alertbox.setMessage("Profile has been already set for this Location.Do you want to update ?"); 
    		alertbox.setPositiveButton("Yes", new DialogInterface.OnClickListener() { 
    			public void onClick(DialogInterface arg0, int arg1) 
    			{     
    				ContentValues values=new ContentValues();
    				values.put("pname",profile);
            		db.update("time", values,"location = '"+loc+"'", null);
            		Toast.makeText(getApplicationContext(), "Setting updated successfully", Toast.LENGTH_SHORT).show();
            		Intent in=new Intent(gps_class.this,main_activity.class);
            		Bundle bundle = new Bundle();
        			bundle.putInt("curtab",2);
        			in.putExtras(bundle);
            		startActivity(in);
        			finish();
    			}             
    			});                         
    		alertbox.setNegativeButton("No", new DialogInterface.OnClickListener() 
    		{ 
    		public void onClick(DialogInterface arg0, int arg1)
    		{                    
    		//	Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();                 
    		}            
    		});                            
    		alertbox.show();     		
          }		
          }
    	}
    }
});
        }
        else
        {
        	if(ifmap==1)
        	{
            //	b = (Button) findViewById(R.id.button1);
            //	b.setEnabled(true);
            b3.setClickable(false);	
            	tv=(TextView)findViewById(R.id.textView4);
            	et=(EditText)findViewById(R.id.editText1);
           	 cur = db.query("tmp",null,null,null, null, null, null, null);
         	//Cursor cur = db.query("profiles",new String[]{"silent"},"pname like office", null, null, null, null); 
         	cur.moveToFirst();
         	if(cur.getCount() >0)
         	{
         	gpname=cur.getString(1);
         	gprio=cur.getInt(2);
        	glat=cur.getString(3);
        	glon=cur.getString(4);
        	glocation=cur.getString(0);
        		lat=glat;
        		lon=glon;
        	 Text1 = "Latitude =  "+lat +"\nLongitude = " +lon;
        	 tv.setText(Text1);
        	 
        	 int y;
        	 for(y=0;y<listcnt;y++)
        	 {
        		if(array_spinner[y].equals(gpname))
        			break;
        	 }
        	 
        	 s = (Spinner) findViewById(R.id.spinner1);
        	 s.setSelection(y); 
        	 et.setText(glocation);
        	 
        	//Delete button
        	   Button bt19=(Button)findViewById(R.id.button4);
             bt19.setEnabled(false);
        	 //Save button
        	 
        	 b2 = (Button) findViewById(R.id.button3);
        	    b2.setOnClickListener(new View.OnClickListener() 
        	    {
        	    public void onClick(View v) 
        	    {
        	    	int count;
        	    	EditText et=(EditText)findViewById(R.id.editText1);
        	    	num=db.query("time",null, null, null, null, null, null);
          
                		count =gprio;
             
        	    //	num=db.query("gps", null, null, null, null, null, null);
        	    //	count=count+num.getCount()+1;
        	    	
        	    	loc=et.getText().toString();
        	    	ContentValues values=new ContentValues();
        	    	if(latlon==""||profile=="Choose a profile"||loc=="")
        	    	{
        	    		Toast.makeText(getApplicationContext(),"Position or Profile is not set", Toast.LENGTH_SHORT).show();
        	    	}
        	    	else
        	    	{
        	    		String time;
        	    		time="nt"+count;
        	    		values.put("time", time);
        	    		if(gpname.equals("Choose a profile"))
        	    		{
        	    			values.put("pname",profile);
        	    		}
        	    		else
        	    		{
        	    		values.put("pname",gpname);
        	    		}
        	    		values.put("priority",gprio);
        	    		values.put("enable", 1);
        	    		values.put("criteria","gps");
        	    		values.put("lat", lat);
        	    		values.put("lon", lon);
        	    		if(glocation.equals(""))
        	    		{
        	    			 EditText et2=(EditText)findViewById(R.id.editText1);
    		    			 loc=et2.getText().toString();
        	    			values.put("location",loc);
        	    		}
        	    		else
        	    		{
        	    			values.put("location",glocation);
        	    		}
        	    		
        	    		db.insert("time", null, values);
        	        Toast.makeText(getApplicationContext(), "Setting saved successfully", Toast.LENGTH_SHORT).show();
        	        Intent in=new Intent(gps_class.this,main_activity.class);
        	    	Bundle bundle = new Bundle();
        			bundle.putInt("curtab",2);
        			in.putExtras(bundle);
        	        startActivity(in);
        			finish();
        	    	} 
        	    }
        	});
        	 
        	 
            }
        		
        		
        		
  ///////////////////////////////////////////////////////////////////////////////////////////////////
        	}
        	else
        	{
        		b3.setClickable(false);
        		
       // 	b = (Button) findViewById(R.id.button1);
       // 	b.setEnabled(false);
        	tv=(TextView)findViewById(R.id.textView4);
        	et=(EditText)findViewById(R.id.editText1);
       	 cur = db.query("time", new String[]{"pname","lat","lon","location"}, "location = ?", new String[]{val1} , null, null, null, null);
     	//Cursor cur = db.query("profiles",new String[]{"silent"},"pname like office", null, null, null, null); 
     	cur.moveToFirst();
     	if(cur.getCount() >0)
     	{
     	gpname=cur.getString(0);
    	glat=cur.getString(1);
    	glon=cur.getString(2);
    	glocation=cur.getString(3);
    		
    	 Text1 = "Latitude =  "+glat +"\nLongitude = " +glon;
    	 tv.setText(Text1);
    	 
    	 int y;
    	 for(y=0;y<listcnt;y++)
    	 {
    		if(array_spinner[y].equals(gpname))
    			break;
    	 }
    	 
    	 s = (Spinner) findViewById(R.id.spinner1);
    	 s.setSelection(y); 
    	 et.setText(val1);
    	 
    	//Delete button
    	   Button bt19=(Button)findViewById(R.id.button4);
           bt19.setOnClickListener(new OnClickListener()
           {
            public void onClick(View v)
            {   
          	  db.execSQL("delete from time where location = '"+val1+"'");
          	  Toast.makeText(getApplicationContext(), "Profile deleted", Toast.LENGTH_SHORT).show();
          	  Intent in=new Intent(gps_class.this,main_activity.class);
          	Bundle bundle = new Bundle();
			bundle.putInt("curtab",2);
			in.putExtras(bundle);
          	  startActivity(in);
    			finish();
            }
           });
    	 //Save button
    	 
    	 b2 = (Button) findViewById(R.id.button3);
    	    b2.setOnClickListener(new View.OnClickListener() 
    	    {
    	    public void onClick(View v) 
    	    {
    	    	int count;
    	    	EditText et=(EditText)findViewById(R.id.editText1);
    	    	num=db.query("time",null, null, null, null, null, null);
            	if(num.getCount()!=0)
            	{
            	//count=num.getInt(0)+1;
            		num.moveToLast();
            		count=num.getInt(2)+1;
            	}
            	else
            	{
            		count =1;
            	}
    	    //	num=db.query("gps", null, null, null, null, null, null);
    	    //	count=count+num.getCount()+1;
    	    	
    	    	loc=et.getText().toString();
    	    	ContentValues values=new ContentValues();
    	    	if(latlon==""||profile=="Choose a profile"||loc=="")
    	    	{
    	    		Toast.makeText(getApplicationContext(),"Position or Profile is not set", Toast.LENGTH_SHORT).show();
    	    	}
    	    	else
    	    	{
    	        values.put("pname",profile);	        
    	        db.update("time", values,"location = '"+loc+"'", null);
    	        Toast.makeText(getApplicationContext(), "Setting saved successfully", Toast.LENGTH_SHORT).show();
    	        Intent in=new Intent(gps_class.this,main_activity.class);
    	    	Bundle bundle = new Bundle();
    			bundle.putInt("curtab",2);
    			in.putExtras(bundle);
    	        startActivity(in);
    			finish();
    	    	} 
    	    }
    	});
    	 
    	 
        }
        }
      }
    } 
    
    
    
    
  /* Class My Location Listener */ 
        public class MyLocationListener implements LocationListener 
        { 
        public void onProviderDisabled(String provider) 
        { 
       Toast.makeText( getApplicationContext(),"Gps Disabled",Toast.LENGTH_SHORT ).show(); 
        } 

        public void onProviderEnabled(String provider) 
        { 
        Toast.makeText( getApplicationContext(),"Gps Enabled",Toast.LENGTH_SHORT).show(); 
        } 

        public void onStatusChanged(String provider, int status, Bundle extras) 
        {  }

		public void onLocationChanged(Location loc) 
		{
			  tlat=loc.getLatitude(); 
		      tlon=loc.getLongitude(); 
		      String ts;
		      ts="Latitude =  "+tlat +"  Longitud = " +tlon; 
		    // Toast.makeText( getApplicationContext(),ts,Toast.LENGTH_SHORT).show(); 	
		} 
        }
    
}