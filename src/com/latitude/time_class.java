package com.latitude;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.latitude.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class time_class extends Activity {
    /** Called when the activity is first created. */
	private Button b1,b2,bb;
	private time_class activity;
	static final int TIME_DIALOG_ID = 0;
	private String array_spinner[];
	int hr;
	int min;
	 Calendar cal = new GregorianCalendar();
	String profile,time;
	SQLiteDatabase db;
	OnTimeSetListener mTimeSetListener;
	String val1,gpname,gtime;
	Cursor num;
	public void onCreate(Bundle savedInstanceState)
    {
		activity=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_layout);     
        
        Bundle bundle = this.getIntent().getExtras();
        val1 = bundle.getString("val");
        
        b2 = (Button) findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() 
        {
        public void onClick(View v) 
        {
        	Intent in=new Intent(time_class.this,main_activity.class);
			startActivity(in);
			finish();
        }
        });

        db=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);
      
       Cursor cur = db.query("profiles",null, null, null, null, null, null);
       int listcnt=0;

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

           
        b1 = (Button) findViewById(R.id.button1);
        b1.setClickable(true);
        b1.setOnClickListener(new View.OnClickListener() 
        {
        public void onClick(View v) 
        {
        showDialog(TIME_DIALOG_ID);
        }
        });
   
        mTimeSetListener =new OnTimeSetListener() 
        {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) 
        {
        	hr=hourOfDay;
        	min=minute;
        	String mins;
        	if(min<10)     
        	time=hr+":"+"0"+min;
        	else
        	time=hr+":"+min;
        	
        	if(hr>11)
        	time=time+" PM";
        	else
        	time=time+" AM";
        	
        	if(hr<10)
        		time="0"+time;
        		
        		b1.setText(time);
        }
        };  
        
        if(val1.equals("New Time.."))
        {
        	bb = (Button) findViewById(R.id.button3);
        	bb.setEnabled(false);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() 
        {
        public void onClick(View v) 
        {
        	int count;

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
        	//num=db.query("gps", null, null, null, null, null, null);
        	//count=count+num.getCount()+1;

           
        	ContentValues values=new ContentValues();
        	if(time==null||profile=="Choose a profile")
        	{
        		Toast.makeText(getApplicationContext(),"Time or Profile is not set", Toast.LENGTH_SHORT).show();  
        	}
        	else
        	{
        	num=db.query("time", null, "time = ?", new String[]{time}, null, null, null);
        	if(num.getCount()==0)
        	{
        	values.put("time", time);
            values.put("pname",profile);
            values.put("priority",count);
            values.put("enable", 1);
            values.put("criteria","time");
            values.put("lat", "");
            values.put("lon", "");
            values.put("location","");
            
        	db.insert("time", null, values);
        	 
          /*    cal.setTimeInMillis(System.currentTimeMillis());
              cal.set(Calendar.HOUR_OF_DAY, hr);
              cal.set(Calendar.MINUTE, min);
              cal.set(Calendar.SECOND, 0);
              cal.set(Calendar.MILLISECOND, 0);

             Intent intent = new Intent(time_class.this, AlarmReceiver.class);
              intent.putExtra("msg",profile);

              PendingIntent pendingIntent = PendingIntent.getBroadcast(time_class.this, 0,intent, PendingIntent.FLAG_ONE_SHOT);
              AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
              alarmManager.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis() , pendingIntent);
   //   alarmManager.cancel(pendingIntent);*/
        	Toast.makeText(getApplicationContext(), "Setting saved successfully", Toast.LENGTH_SHORT).show();
        	  Intent in=new Intent(time_class.this,main_activity.class);
            	Bundle bundle = new Bundle();
  			bundle.putInt("curtab",1);
  			in.putExtras(bundle);
            	  startActivity(in);
      			finish();
        	}
        	else
        	{
        		AlertDialog.Builder alertbox = new AlertDialog.Builder(activity); 
        		alertbox.setMessage("Profile has been already set for this time.Do you want to update ?"); 
        		alertbox.setPositiveButton("Yes", new DialogInterface.OnClickListener() { 
        			public void onClick(DialogInterface arg0, int arg1) 
        			{     
        				ContentValues values=new ContentValues();
        				values.put("pname",profile);
                		db.update("time", values,"time = '"+time+"'", null);
                		Toast.makeText(getApplicationContext(), "Setting updated successfully", Toast.LENGTH_SHORT).show();
                		  Intent in=new Intent(time_class.this,main_activity.class);
                        	Bundle bundle = new Bundle();
              			bundle.putInt("curtab",1);
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
   });
        }////////////////////
        else
        {
        	b1.setClickable(false);
        	bb = (Button) findViewById(R.id.button3);
        	bb.setEnabled(true);
        	Button btv=(Button)findViewById(R.id.button1);
        cur = db.query("time", new String[]{"pname","time"}, "time = ?", new String[]{val1} , null, null, null, null);
     	//Cursor cur = db.query("profiles",new String[]{"silent"},"pname like office", null, null, null, null); 
     	cur.moveToFirst();
     	if(cur.getCount() >0)
     	{
     	gpname=cur.getString(0);
    	gtime=cur.getString(1);
    		
    	 btv.setText(gtime);
    	 
    	 int y;
    	 for(y=0;y<listcnt;y++)
    	 {
    		if(array_spinner[y].equals(gpname))
    			break;
    	 }
    	 
    	 s = (Spinner) findViewById(R.id.spinner1);
    	 s.setSelection(y); 
    	 
    	//Delete button
    	   Button bt19=(Button)findViewById(R.id.button3);
           bt19.setOnClickListener(new OnClickListener()
           {
            public void onClick(View v)
            {   
          	  db.execSQL("delete from time where time = '"+val1+"'");
          	  Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
          	  Intent in=new Intent(time_class.this,main_activity.class);
          	Bundle bundle = new Bundle();
			bundle.putInt("curtab",1);
			in.putExtras(bundle);
          	  startActivity(in);
    			finish();
            }
           });
    	 //Save button
    	 
    	 b2 = (Button) findViewById(R.id.button2);
    	    b2.setOnClickListener(new View.OnClickListener() 
    	    {
    	    public void onClick(View v) 
    	    {
    	    	int count;
    	    	Button btv=(Button)findViewById(R.id.button1);
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
    	    	
    	    	btv.setEnabled(false);
    	    	ContentValues values=new ContentValues();
    	    	if(gtime==null||profile=="Choose a profile")
    	    	{
    	    		Toast.makeText(getApplicationContext(),"Position or Profile is not set", Toast.LENGTH_SHORT).show();
    	    	}
    	    	else
    	    	{
    	        values.put("pname",profile);	        
    	        db.update("time", values,"time = '"+val1+"'", null);
    	        Toast.makeText(getApplicationContext(), "Setting saved successfully", Toast.LENGTH_SHORT).show();
    	        Intent in=new Intent(time_class.this,main_activity.class);
    	    	Bundle bundle = new Bundle();
    			bundle.putInt("curtab",1);
    			in.putExtras(bundle);
    	        startActivity(in);
    			finish();
    	    	} 
    	    }
    	});
    	 
    	 
        }
        	
        }
      cur.close();
}
	
	
	
	
	 protected Dialog onCreateDialog(int id)
     {
     	switch (id) 
     	{
     	case TIME_DIALOG_ID:
     	return new TimePickerDialog(this,mTimeSetListener, 0, 0, false);
     	}
     	return null;
     	}
	 
	  public boolean onCreateOptionsMenu(Menu menu) 
	    {
	        menu.add(1,1,menu.FIRST,"Back");
	        
	        return super.onCreateOptionsMenu(menu);
	      }
	    public boolean onOptionsItemSelected(MenuItem item)
	    {    
	    	switch (item.getItemId())
	    	{   
	    	case 1:
	    		Intent in=new Intent(time_class.this,main_activity.class);
	    		Bundle bundle = new Bundle();
    			in.putExtras(bundle);
    			startActivity(in);
				finish();
	    	//	Toast.makeText(getApplicationContext(), "helooo", Toast.LENGTH_SHORT);
	    		break;    
	    	} 
	    	return true;
	    	} 

}