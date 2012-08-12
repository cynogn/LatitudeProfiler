package com.latitude;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.latitude.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;

public class tmppge extends Activity {
    /** Called when the activity is first created. */
	 private String array_spinner[];
	 private String criteria_gps[];
	 private String criteria_time[];
	 SQLiteDatabase db;
	 Context con;
	 RadioButton gps11,time11;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       /* 
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, 17);
        cal.set(Calendar.MINUTE, 26);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,intent, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis() , pendingIntent);
        //Toast.makeText(this, "Alarm set", Toast.LENGTH_LONG).show();  
      */  //DATABASES connectivity
       
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
        
       Cursor cur = db.query("profiles",null, null, null, null, null, null);
       int listcnt=0;
       int yy;
if(cur.getCount()!=0)
{
       cur.moveToFirst();
       while (cur.isAfterLast() == false) 
     {
         cur.moveToNext();
        listcnt++;
     }
       
       array_spinner=new String[listcnt+2];
       array_spinner[0]="Choose a profile";
       array_spinner[listcnt+1]="new profile..";
       cur.moveToFirst();
       int move=1;
       while (cur.isAfterLast() == false) 
     {
        array_spinner[move]=cur.getString(0);
           cur.moveToNext();
           move++;
      }
    
    cur.close();
}
else
{
     array_spinner=new String[2];
     array_spinner[0]="Choose a profile";
     array_spinner[1]="new profile..";
}

final Spinner spinner = (Spinner) findViewById(R.id.spinner2);
////////////////////////////////////////////////////////////////////////////////////////////

cur = db.query("time", null, "criteria = ?", new String[]{"gps"}, null, null, null);
listcnt=0;
if(cur.getCount()!=0)
{
cur.moveToFirst();
while (cur.isAfterLast() == false) 
{
  cur.moveToNext();
 listcnt++;
}

criteria_gps=new String[listcnt+2];
criteria_gps[0]="Choose a position";
criteria_gps[listcnt+1]="New Position..";
cur.moveToFirst();
int move=1;
while (cur.isAfterLast() == false) 
{
	criteria_gps[move]=cur.getString(7);
    cur.moveToNext();
    move++;
}
cur.close();
}
else
{
	criteria_gps =new String[2];
	criteria_gps[0]="Choose a position";
	criteria_gps[1]="New Position..";
}

final ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, criteria_gps);
adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
OnClickListener radio0_listener = new OnClickListener()
{     
	public void onClick(View v)
	{         
		RadioButton rb = (RadioButton) v;
		if(rb.isChecked())
		{
		//	criteria_gps =new String[2];
		//	criteria_gps[0]="Choose a position";
		//	criteria_gps[1]="New Position..";
			 try
		        {
		        db.execSQL("create table time(time TEXT PRIMARY KEY,pname TEXT,priority INTEGER,enable INTEGER,criteria TEXT,lat TEXT,lon TEXT,location TEXT)");
		        }
		        catch(SQLException e)
		        {}
		    	spinner.setAdapter(adapter2);
		}
	} 
};
criteria_time =new String[2];
criteria_time[0]="Choose a time";
criteria_time[1]="New Time..";
final ArrayAdapter adapter3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, criteria_time);
adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);    
OnClickListener radio1_listener = new OnClickListener()
{     
	public void onClick(View v)
	{         
		RadioButton rb = (RadioButton) v;
		if(rb.isChecked())
		{
		//	criteria_time =new String[2];
		//	criteria_time[0]="Choose a time";
		//	criteria_time[1]="New Time..";
			 try
		        {
		        db.execSQL("create table time(time TEXT PRIMARY KEY,pname TEXT,priority INTEGER,enable INTEGER,criteria TEXT,lat TEXT,lon TEXT,location TEXT)");
		        }
		        catch(SQLException e)
		        {}
	   
	    spinner.setAdapter(adapter3);
		}
	} 
};
gps11=(RadioButton)findViewById(R.id.radio0);
gps11.setOnClickListener(radio0_listener);	
time11=(RadioButton)findViewById(R.id.radio1);
time11.setOnClickListener(radio1_listener);
try
{
db.execSQL("create table time(time TEXT PRIMARY KEY,pname TEXT,priority INTEGER,enable INTEGER,criteria TEXT,lat TEXT,lon TEXT,location TEXT)");
}
catch(SQLException e)
{}
spinner.setAdapter(adapter2);
		

	    
	       
 spinner.setOnItemSelectedListener(new OnItemSelectedListener()
        {       
        	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
        	{
        		if(!parent.getItemAtPosition(pos).toString().equals("Choose a position") && gps11.isChecked())
        		{
        		//	Toast.makeText(getApplicationContext(),"GPS",Toast.LENGTH_SHORT).show();
        			Intent in=new Intent(tmppge.this,gps_class.class);
        			Bundle bundle = new Bundle();
        			bundle.putString("val",parent.getItemAtPosition(pos).toString());
        			in.putExtras(bundle);
        			startActivity(in);
        			finish();
        		}   
        		else if(parent.getItemAtPosition(pos).toString().equals("New Time.."))
        		{
        			//Toast.makeText(getApplicationContext(),"GPS",Toast.LENGTH_SHORT).show();
        			Intent in=new Intent(tmppge.this,time_class.class);
        			startActivity(in);
        			finish();
        		}   
        	}
        	public void onNothingSelected(AdapterView<?> arg0)
        	{// TODO Auto-generated method stub
        	}
        });
        Spinner s = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, array_spinner);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);    
        s.setAdapter(adapter1);
       
        s.setOnItemSelectedListener(new OnItemSelectedListener()
        {       
        	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
        	{
        		if(!(parent.getItemAtPosition(pos).toString().equals("Choose a profile")))
        		{
        			Intent in=new Intent(tmppge.this,profile_class.class);
        			Bundle bundle = new Bundle();
        			bundle.putString("val1",parent.getItemAtPosition(pos).toString());
        			in.putExtras(bundle);
        			startActivity(in);
        			finish();
        		}
        	}
        	public void onNothingSelected(AdapterView<?> arg0)
        	{// TODO Auto-generated method stub
        	}
});

        Button bt1=(Button)findViewById(R.id.button1);
        bt1.setOnClickListener(new OnClickListener()
        {
         public void onClick(View v)
         {
        	Intent in=new Intent(tmppge.this,setting_class.class);
        	startActivity(in);
 			finish();
         }
        });
        
    }
}