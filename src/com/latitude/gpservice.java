package com.latitude;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import com.latitude.R;

//import com.lati.gpstest.MyLocationListener;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class gpservice extends Service
{   
	  Timer timer;
	  private static final String TAG = gpservice.class.getSimpleName();
	SQLiteDatabase db,db1;
	gpstest activity;
	double lat,lon;
	String profile,latlon,loc,Text1, h,m,time1;
	String val1,gpname,glat,glon,glocation;
	int listcnt=0;
	Cursor cur1,cur2;
	static int cnt=0;
	TextView tv;
	int sil,vib,keys,mvol,rvol,avol,nvol;
	AudioManager audMangr;
	Context context;
	Timer myTimer;
	String mins;
	WifiManager mWifi;
	private TimerTask task = new TimerTask() 
	  {      
		  public void run() 
	  	  {       
			  Log.i(TAG, "Timer task doing work"); 
			  timechk();
	  	  }   
	  }; 
	
	  public void timechk()
	  {
		    db=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
		    db.setVersion(1);
		    db.setLocale(Locale.getDefault());
		    db.setLockingEnabled(true);
		    int hr,min;
		    mWifi = (WifiManager)getBaseContext().getSystemService(Context.WIFI_SERVICE);   
		    Calendar c = Calendar.getInstance();  
		    hr = c.get(Calendar.HOUR_OF_DAY);
		    min=c.get(Calendar.MINUTE);
		    
        	
        	if(min<10)     
        	time1=hr+":"+"0"+min;
        	else
        	time1=hr+":"+min;
        	
        	if(hr>11)
        	time1=time1+" PM";
        	else
        	time1=time1+" AM";
        	
        	if(hr<10)
        		time1="0"+time1;	    
		   
		    cur2 = db.query("time", null, "criteria = ?", new String[]{"time"}, null, null, null);
		    cur2.moveToFirst();
		   while (cur2.isAfterLast() == false) 
	    	{
	    	  cnt++;
	    	  Log.i(TAG, "cursor :"+cur2.getString(0)+"   sys time:"+time1); 
	    	  if(cur2.getString(0).equals(time1) && cur2.getInt(3)==1)
	    	  {	
	    		  String ns = Context.NOTIFICATION_SERVICE;
	    	        NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
	    	       // audMangr.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	    	       
	    	        int icon = R.drawable.appname;
	    	        CharSequence tickerText = "Profile Updated: "+cur2.getString(1);
	    	        long when = System.currentTimeMillis();
	    	        Notification notification = new Notification(icon, tickerText, when);
	    	        Context context = getApplicationContext();
	    	        CharSequence contentTitle = "Profile Updated: "+cur2.getString(1);
	    	        CharSequence contentText = "Latitude Profiler";
	    	        Intent notificationIntent = new Intent(gpservice.this, main_activity.class);
	    	        Bundle bundle = new Bundle();
	    			bundle.putInt("curtab",0);
	    			notificationIntent.putExtras(bundle);
	    			
	    	        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
	    	        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
	    	        final int HELLO_ID = 1;
	    	        mNotificationManager.notify(HELLO_ID, notification);	  	    		  
	    	       
	    	        ///////////////////////////////////////////////////////////////////////////////////////////////    		  
		    		  audMangr= (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);
		    	    	 Cursor cur = db.query("profiles", new String[]{"silent","vibration","keysound","mediavol","ringvol","alarmvol","notivol"}, "pname = ?", new String[]{cur2.getString(1)} , null, null, null, null);
		    	    	//Cursor cur = db.query("profiles",new String[]{"silent"},"pname like office", null, null, null, null); 
		    	    	cur.moveToFirst();
		    	    	 //cur.getString(cur.getColumnIndex("silent"));
		    	    	
		    	    	sil=cur.getInt(0);
		    	    	vib=cur.getInt(1);
		    	    	keys=cur.getInt(2);
		    	    	mvol=cur.getInt(3);
		    	    	rvol=cur.getInt(4);
		    	    	avol=cur.getInt(5);
		    	    	nvol=cur.getInt(6);
		    	              
		    	        AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		    	       
		    	        int mvol1 = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
		    	        int rvol1 = audio.getStreamVolume(AudioManager.STREAM_RING);
		    	        int avol1 = audio.getStreamVolume(AudioManager.STREAM_ALARM);
		    	        int nvol1 = audio.getStreamVolume(AudioManager.STREAM_NOTIFICATION);
		    	        
		    	        // Adjust media volume
		    	   //     Toast.makeText(getApplicationContext(),"mvol "+mvol1,Toast.LENGTH_LONG).show();
		    	        int tmp;
		    	        tmp=mvol-mvol1;
		    	        if(mvol>mvol1)
		    	        {
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,                
		    	        	AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        else
		    	        {
		    	        	tmp*=-1;
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,                
		    	        	AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	      
		    	     //Adjust ringtone volume
		    	      
		    	        tmp=rvol-rvol1;
		    	        if(rvol>rvol1)
		    	        {
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_RING,                
		    	        	AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        else
		    	        {
		    	        	tmp*=-1;
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_RING,                
		    	        	AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	 
		    	        //Adjust alarm volume
		    	        tmp=avol-avol1;
		    	        if(avol>avol1)
		    	        {
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_ALARM,                
		    	        	AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        else
		    	        {
		    	        	tmp*=-1;
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_ALARM,                
		    	        	AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        avol1 = audio.getStreamVolume(AudioManager.STREAM_ALARM);  
		    	        
		    	        
		    	        //Adjust notification volume
		    	        tmp=nvol-nvol1;
		    	        if(nvol>nvol1)
		    	        {
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION,                
		    	        	AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        else
		    	        {
		    	        	tmp*=-1;
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION,                
		    	        	AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        nvol1 = audio.getStreamVolume(AudioManager.STREAM_NOTIFICATION);   
		    	            	         
		    	         if(sil==1)
		    	         {  	
		    	        	 audMangr.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		    	        }

		    	         if(vib==1)
		    	         {  	 
		    	        	 audMangr.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		    	        }
		    	         if(sil!=1 && vib!=1)
		    	         {
		    	        	 audMangr.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		    	        	// audMangr.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		    	        }
		    	         if(keys==1)
		    	         {  	            
		    	             mWifi.setWifiEnabled(true); 
		    	         }
		    	         else
		    	         {
		    	        	 mWifi.setWifiEnabled(false); 
		    	         }
		    	   	    		  
		    		/////////////////////////////////////////////////////////////////////////////////////
		    		 
	    	  }
	    	  cur2.moveToNext();
	    	}
	    	cur2.close();
	    	db.close();
	  }
	  public IBinder onBind(Intent intent)
	{     
		// TODO Auto-generated method stub     
		return null;   
	}

	 public void onCreate()
	 {    
		 super.onCreate();     
		 Log.i(TAG, "Service creating");
		 LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
	     LocationListener mlocListener = new MyLocationListener(); 
	     
	    mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener); 

	    db1=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
	    db1.setVersion(1);
	    db1.setLocale(Locale.getDefault());
	    db1.setLockingEnabled(true);
		 
		 
	//	 Toast.makeText(getApplicationContext(), "hey printing", Toast.LENGTH_LONG).show();
		 timer = new Timer("TweetCollectorTimer");     
		 timer.schedule(task, 5000, 40000);   
      }  

	 public void onDestroy() 
	 {     
		 super.onDestroy();     
		 Log.i(TAG, "Service destroying");      
	     timer.cancel();     
	     timer = null;   
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

			  lat=loc.getLatitude(); 
		      lon=loc.getLongitude(); 
		    mWifi = (WifiManager)getBaseContext().getSystemService(Context.WIFI_SERVICE);     
		  /*	tv=(TextView)findViewById(R.id.textView1);
		  	tv.setText(lat+"");
		  	tv=(TextView)findViewById(R.id.textView2);
		  	tv.setText(lon+"");*/
		      
		      cur1 = db1.query("time",null, null, null, null, null, null);
		      cur1.moveToFirst();
		      while (cur1.isAfterLast() == false) 
		    	{
		    	  cnt++;
		    	  if(cur1.getString(5).equals(lat+"") && cur1.getString(6).equals(lon+"") && cur1.getInt(3)==1)
		    	  {	
		    		  Toast.makeText(getApplicationContext(),"Location reached : "+cur1.getString(1),Toast.LENGTH_SHORT).show();		

		    		  String ns = Context.NOTIFICATION_SERVICE;
		    	        NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
		    	       // audMangr.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		    	        
		    	        int icon = R.drawable.appname;
		    	        CharSequence tickerText = "Profile Updated: "+cur1.getString(1);
		    	        long when = System.currentTimeMillis();
		    	        Notification notification = new Notification(icon, tickerText, when);
		    	        Context context = getApplicationContext();
		    	        CharSequence contentTitle = "Profile Updated: "+cur1.getString(1);
		    	        CharSequence contentText = "You have reached: "+cur1.getString(7);
		    	        Intent notificationIntent = new Intent(gpservice.this, main_activity.class);
		    	        Bundle bundle = new Bundle();
		    			bundle.putInt("curtab",0);
		    			notificationIntent.putExtras(bundle);
		    	        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
		    	        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		    	        final int HELLO_ID = 1;
		    	        mNotificationManager.notify(HELLO_ID, notification);
		    		  
		    		  
		    		  
		    		  ///////////////////////////////////////////////////////////////////////////////////////////////    		  
		    		  audMangr= (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);
		    	    	 Cursor cur = db1.query("profiles", new String[]{"silent","vibration","keysound","mediavol","ringvol","alarmvol","notivol"}, "pname = ?", new String[]{cur1.getString(1)} , null, null, null, null);
		    	    	//Cursor cur = db.query("profiles",new String[]{"silent"},"pname like office", null, null, null, null); 
		    	    	cur.moveToFirst();
		    	    	 //cur.getString(cur.getColumnIndex("silent"));
		    	    	
		    	    	sil=cur.getInt(0);
		    	    	vib=cur.getInt(1);
		    	    	keys=cur.getInt(2);
		    	    	mvol=cur.getInt(3);
		    	    	rvol=cur.getInt(4);
		    	    	avol=cur.getInt(5);
		    	    	nvol=cur.getInt(6);
		    	              
		    	        AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		    	       
		    	        int mvol1 = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
		    	        int rvol1 = audio.getStreamVolume(AudioManager.STREAM_RING);
		    	        int avol1 = audio.getStreamVolume(AudioManager.STREAM_ALARM);
		    	        int nvol1 = audio.getStreamVolume(AudioManager.STREAM_NOTIFICATION);
		    	        
		    	        // Adjust media volume
		    	   //     Toast.makeText(getApplicationContext(),"mvol "+mvol1,Toast.LENGTH_LONG).show();
		    	        int tmp;
		    	        tmp=mvol-mvol1;
		    	        if(mvol>mvol1)
		    	        {
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,                
		    	        	AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        else
		    	        {
		    	        	tmp*=-1;
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,                
		    	        	AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	      
		    	     //Adjust ringtone volume
		    	      
		    	        tmp=rvol-rvol1;
		    	        if(rvol>rvol1)
		    	        {
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_RING,                
		    	        	AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        else
		    	        {
		    	        	tmp*=-1;
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_RING,                
		    	        	AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	 
		    	        //Adjust alarm volume
		    	        tmp=avol-avol1;
		    	        if(avol>avol1)
		    	        {
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_ALARM,                
		    	        	AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        else
		    	        {
		    	        	tmp*=-1;
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_ALARM,                
		    	        	AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        avol1 = audio.getStreamVolume(AudioManager.STREAM_ALARM);  
		    	        
		    	        
		    	        //Adjust notification volume
		    	        tmp=nvol-nvol1;
		    	        if(nvol>nvol1)
		    	        {
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION,                
		    	        	AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        else
		    	        {
		    	        	tmp*=-1;
		    	        	while(tmp!=0)
		    	        	{
		    	        	audio.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION,                
		    	        	AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
		    	        	tmp--;
		    	        	}
		    	        }
		    	        nvol1 = audio.getStreamVolume(AudioManager.STREAM_NOTIFICATION);   
		    	            	         
		    	         if(sil==1)
		    	         {  	
		    	        	 audMangr.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		    	        }

		    	         if(vib==1)
		    	         {  	 
		    	        	 audMangr.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		    	        }
		    	         if(sil!=1 && vib!=1)
		    	         {
		    	        	 audMangr.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		    	        	// audMangr.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		    	        }
		    	         if(keys==1)
		    	         {  	            
		    	             mWifi.setWifiEnabled(true); 
		    	         }
		    	         else
		    	         {
		    	        	 mWifi.setWifiEnabled(false); 
		    	         }
		    	   	    		  
		    		/////////////////////////////////////////////////////////////////////////////////////
		    		  
		    	  }
		    		cur1.moveToNext();
		    	}
		    	cur1.close();
		} 
     }
};

