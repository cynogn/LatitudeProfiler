package com.latitude;

import java.util.Locale;

import com.latitude.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class setting_class extends Activity {
	SQLiteDatabase db;
	Cursor time;
	int listcnt,filled,index;
	Button up,down;
	public void clrscr()
	{	

		PendingIntent pendingIntent = PendingIntent.getBroadcast(setting_class.this, 0,getIntent(), PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
       // alarmManager.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis() , pendingIntent);
        alarmManager.cancel(pendingIntent);
		
		TextView tv;
    	tv=(TextView)findViewById(R.id.textView4);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView5);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView6);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView7);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView8);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView9);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView10);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView11);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView12);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView13);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView14);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView15);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView16);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView17);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView18);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView19);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView20);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView21);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView22);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView23);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView24);
    	tv.setText(" ");
    /*	tv=(TextView)findViewById(R.id.textView25);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView26);
    	tv.setText(" ");
    	tv=(TextView)findViewById(R.id.textView27);
    	tv.setText(" ");
    */	Button bt;
    	bt=(Button) findViewById(R.id.button3);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button4);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button5);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button6);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button7);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button8);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button9);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button10);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button11);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button12);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button13);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button14);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button15);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button16);
    	bt.setVisibility(View.INVISIBLE);
 /*   	bt=(Button) findViewById(R.id.button17);
    	bt.setVisibility(View.INVISIBLE);
    	bt=(Button) findViewById(R.id.button18);
    	bt.setVisibility(View.INVISIBLE);
 */ 	ToggleButton tb;
    	tb=(ToggleButton)findViewById(R.id.toggleButton1);
    	tb.setVisibility(View.INVISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton2);
    	tb.setVisibility(View.INVISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton3);
    	tb.setVisibility(View.INVISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton4);
    	tb.setVisibility(View.INVISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton5);
    	tb.setVisibility(View.INVISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton6);
    	tb.setVisibility(View.INVISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton7);
    	tb.setVisibility(View.INVISIBLE);
 //   	tb=(ToggleButton)findViewById(R.id.toggleButton8);
 //   	tb.setVisibility(View.INVISIBLE);
	}
    public void onCreate(Bundle savedInstanceState)
    {
    	Button bt;
    	ToggleButton tb;
       super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        db=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);
        
        time = db.query("time",null, null, null, null, null, null);
        listcnt=time.getCount();filled=0;
        TextView tv; 
        clrscr();
        int run=1;      
        while (run==1) 
        {
    	time.moveToFirst(); 
    	for(index=0;index<listcnt;index++)
    		if(time.getInt(2)==filled+1)
    			break;
    		else if(index<listcnt-1)
    			time.moveToNext();	
    	tv=(TextView)findViewById(R.id.textView4);
    	tv.setText(time.getString(0));
    	tv=(TextView)findViewById(R.id.textView5);
    	tv.setText(time.getString(1));
    	tv=(TextView)findViewById(R.id.textView6);
    	tv.setText(time.getInt(2)+"");
    	tb=(ToggleButton) findViewById(R.id.toggleButton1);
    	tb.setChecked(time.getInt(3)==1?true:false);
    	bt=(Button) findViewById(R.id.button3);
    	bt.setVisibility(View.VISIBLE);
    	bt=(Button) findViewById(R.id.button4);
    	bt.setVisibility(View.VISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton1);
    	tb.setVisibility(View.VISIBLE);
    	if(++filled==listcnt)
    		break;

    	time.moveToFirst(); 
    	for(index=0;index<listcnt;index++)
    		if(time.getInt(2)==filled+1)
    			break;
    		else if(index<listcnt-1)
    			time.moveToNext();	
    	tv=(TextView)findViewById(R.id.textView7);
    	tv.setText(time.getString(0));
    	tv=(TextView)findViewById(R.id.textView8);
    	tv.setText(time.getString(1));
    	tv=(TextView)findViewById(R.id.textView9);
    	tv.setText(time.getInt(2)+"");
    	tb=(ToggleButton) findViewById(R.id.toggleButton2);
    	tb.setChecked(time.getInt(3)==1?true:false);
    	bt=(Button) findViewById(R.id.button6);
    	bt.setVisibility(View.VISIBLE);
    	bt=(Button) findViewById(R.id.button5);
    	bt.setVisibility(View.VISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton2);
    	tb.setVisibility(View.VISIBLE);
    	if(++filled==listcnt)
    		break;
    	
    	time.moveToFirst(); 
    	for(index=0;index<listcnt;index++)
    		if(time.getInt(2)==filled+1)
    			break;
    		else if(index<listcnt-1)
    			time.moveToNext();	
    	tv=(TextView)findViewById(R.id.textView10);
    	tv.setText(time.getString(0));
    	tv=(TextView)findViewById(R.id.textView11);
    	tv.setText(time.getString(1));
    	tv=(TextView)findViewById(R.id.textView12);
    	tv.setText(time.getInt(2)+"");
    	tb=(ToggleButton) findViewById(R.id.toggleButton3);
    	tb.setChecked(time.getInt(3)==1?true:false);
    	bt=(Button) findViewById(R.id.button7);
    	bt.setVisibility(View.VISIBLE);
    	bt=(Button) findViewById(R.id.button8);
    	bt.setVisibility(View.VISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton3);
    	tb.setVisibility(View.VISIBLE);
    	if(++filled==listcnt)
    		break;

    	time.moveToFirst(); 
    	for(index=0;index<listcnt;index++)
    		if(time.getInt(2)==filled+1)
    			break;
    		else if(index<listcnt-1)
    			time.moveToNext();	
    	tv=(TextView)findViewById(R.id.textView13);
    	tv.setText(time.getString(0));
    	tv=(TextView)findViewById(R.id.textView14);
    	tv.setText(time.getString(1));
    	tv=(TextView)findViewById(R.id.textView15);
    	tv.setText(time.getInt(2)+"");
    	tb=(ToggleButton) findViewById(R.id.toggleButton4);
    	tb.setChecked(time.getInt(3)==1?true:false);
    	bt=(Button) findViewById(R.id.button9);
    	bt.setVisibility(View.VISIBLE);
    	bt=(Button) findViewById(R.id.button10);
    	bt.setVisibility(View.VISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton4);
    	tb.setVisibility(View.VISIBLE);
    	if(++filled==listcnt)
    		break;
    	
    	time.moveToFirst(); 
    	for(index=0;index<listcnt;index++)
    		if(time.getInt(2)==filled+1)
    			break;
    		else if(index<listcnt-1)
    			time.moveToNext();	
    	tv=(TextView)findViewById(R.id.textView16);
    	tv.setText(time.getString(0));
    	tv=(TextView)findViewById(R.id.textView17);
    	tv.setText(time.getString(1));
    	tv=(TextView)findViewById(R.id.textView18);
    	tv.setText(time.getInt(2)+"");
    	tb=(ToggleButton) findViewById(R.id.toggleButton5);
    	tb.setChecked(time.getInt(3)==1?true:false);
    	bt=(Button) findViewById(R.id.button11);
    	bt.setVisibility(View.VISIBLE);
    	bt=(Button) findViewById(R.id.button12);
    	bt.setVisibility(View.VISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton5);
    	tb.setVisibility(View.VISIBLE);
    	if(++filled==listcnt)
    		break;
    	
    	time.moveToFirst(); 
    	for(index=0;index<listcnt;index++)
    		if(time.getInt(2)==filled+1)
    			break;
    		else if(index<listcnt-1)
    			time.moveToNext();	
    	tv=(TextView)findViewById(R.id.textView19);
    	tv.setText(time.getString(0));
    	tv=(TextView)findViewById(R.id.textView20);
    	tv.setText(time.getString(1));
    	tv=(TextView)findViewById(R.id.textView21);
    	tv.setText(time.getInt(2)+"");
    	tb=(ToggleButton) findViewById(R.id.toggleButton6);
    	tb.setChecked(time.getInt(3)==1?true:false);
    	bt=(Button) findViewById(R.id.button13);
    	bt.setVisibility(View.VISIBLE);
    	bt=(Button) findViewById(R.id.button14);
    	bt.setVisibility(View.VISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton6);
    	tb.setVisibility(View.VISIBLE);
    	if(++filled==listcnt)
    		break;
    	
    	time.moveToFirst(); 
    	for(index=0;index<listcnt;index++)
    		if(time.getInt(2)==filled+1)
    			break;
    		else if(index<listcnt-1)
    			time.moveToNext();	
    	tv=(TextView)findViewById(R.id.textView22);
    	tv.setText(time.getString(0));
    	tv=(TextView)findViewById(R.id.textView23);
    	tv.setText(time.getString(1));
    	tv=(TextView)findViewById(R.id.textView24);
    	tv.setText(time.getInt(2)+"");
    	tb=(ToggleButton) findViewById(R.id.toggleButton7);
    	tb.setChecked(time.getInt(3)==1?true:false);
    	bt=(Button) findViewById(R.id.button16);
    	bt.setVisibility(View.VISIBLE);
    	bt=(Button) findViewById(R.id.button15);
    	bt.setVisibility(View.VISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton7);
    	tb.setVisibility(View.VISIBLE);
    	if(++filled==listcnt)
    		break;
    	
 /*   	time.moveToFirst(); 
    	for(index=0;index<listcnt;index++)
    		if(time.getInt(2)==filled+1)
    			break;
    		else if(index<listcnt-1)
    			time.moveToNext();	
    	tv=(TextView)findViewById(R.id.textView25);
    	tv.setText(time.getString(0));
    	tv=(TextView)findViewById(R.id.textView26);
    	tv.setText(time.getString(1));
    	tv=(TextView)findViewById(R.id.textView27);
    	tv.setText(time.getInt(2)+"");
    	tb=(ToggleButton) findViewById(R.id.toggleButton8);
    	tb.setChecked(time.getInt(3)==1?true:false);
    	bt=(Button) findViewById(R.id.button17);
    	bt.setVisibility(View.VISIBLE);
    	bt=(Button) findViewById(R.id.button18);
    	bt.setVisibility(View.VISIBLE);
    	tb=(ToggleButton)findViewById(R.id.toggleButton8);
    	tb.setVisibility(View.VISIBLE);
    	if(++filled==listcnt)
    		break;   	
   */ 	run=0;
      }
    
    up=(Button)findViewById(R.id.button1);
    down=(Button)findViewById(R.id.button2);
    up.setEnabled(false);
    if(run==1)
    	down.setEnabled(false);
    	
    	
  up.setOnClickListener(new OnClickListener(){
	  	Button bt;
		TextView tv;
		ToggleButton tb;
		public void onClick(View arg0) {
	        
	        tv=(TextView)findViewById(R.id.textView4);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView5);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView6);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView7);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView8);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView9);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView10);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView11);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView12);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView13);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView14);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView15);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView16);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView17);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView18);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView19);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView20);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView21);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView22);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView23);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView24);
	    	tv.setText(" ");
	    /*	tv=(TextView)findViewById(R.id.textView25);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView26);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView27);
	    	tv.setText(" ");
	    */	bt=(Button) findViewById(R.id.button3);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button4);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button5);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button6);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button7);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button8);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button9);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button10);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button11);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button12);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button13);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button14);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button15);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button16);
	    	bt.setVisibility(View.INVISIBLE);
	    /*	bt=(Button) findViewById(R.id.button17);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button18);
	    	bt.setVisibility(View.INVISIBLE);
	    */	tb=(ToggleButton)findViewById(R.id.toggleButton1);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton2);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton3);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton4);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton5);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton6);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton7);
	    	tb.setVisibility(View.INVISIBLE);
	    //	tb=(ToggleButton)findViewById(R.id.toggleButton8);
	    //	tb.setVisibility(View.INVISIBLE);
			down.setEnabled(true);
			filled=filled-16;
			if(filled==0);
				up.setEnabled(false);
			int run=1;
			 while (run==1) 
		        {
		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView4);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView5);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView6);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button3);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button4);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton1);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;

		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView7);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView8);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView9);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button6);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button5);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton2);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;
		    	
		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView10);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView11);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView12);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button7);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button8);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton3);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;

		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView13);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView14);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView15);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button9);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button10);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton4);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;
		    	
		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView16);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView17);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView18);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button11);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button12);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton5);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;
		    	
		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView19);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView20);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView21);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button13);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button14);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton6);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;
		    	
		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView22);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView23);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView24);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button16);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button15);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton7);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;
		    	
		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		  /*  	tv=(TextView)findViewById(R.id.textView25);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView26);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView27);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button17);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button18);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton8);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;   	
		   */ 	run=0;
		      }
			if(filled>8)
				up.setEnabled(true);
			
		}
    	
    });

  down.setOnClickListener(new OnClickListener(){
    	TextView tv;
    	Button bt;
    	ToggleButton tb;
    	public void onClick(View v) {
			up.setEnabled(true);
			tv=(TextView)findViewById(R.id.textView4);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView5);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView6);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView7);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView8);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView9);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView10);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView11);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView12);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView13);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView14);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView15);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView16);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView17);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView18);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView19);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView20);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView21);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView22);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView23);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView24);
	    	tv.setText(" ");
	   /* 	tv=(TextView)findViewById(R.id.textView25);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView26);
	    	tv.setText(" ");
	    	tv=(TextView)findViewById(R.id.textView27);
	    	tv.setText(" ");
	    */	bt=(Button) findViewById(R.id.button3);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button4);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button5);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button6);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button7);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button8);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button9);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button10);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button11);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button12);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button13);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button14);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button15);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button16);
	    	bt.setVisibility(View.INVISIBLE);
	    /*	bt=(Button) findViewById(R.id.button17);
	    	bt.setVisibility(View.INVISIBLE);
	    	bt=(Button) findViewById(R.id.button18);
	    	bt.setVisibility(View.INVISIBLE);
	    */	tb=(ToggleButton)findViewById(R.id.toggleButton1);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton2);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton3);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton4);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton5);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton6);
	    	tb.setVisibility(View.INVISIBLE);
	    	tb=(ToggleButton)findViewById(R.id.toggleButton7);
	    	tb.setVisibility(View.INVISIBLE);
	    /*	tb=(ToggleButton)findViewById(R.id.toggleButton8);
	    	tb.setVisibility(View.INVISIBLE);
		*/	int run=1;
			 while (run==1) 
		        {
		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView4);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView5);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView6);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button3);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button4);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton1);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;

		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView7);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView8);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView9);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button6);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button5);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton2);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;
		    	
		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView10);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView11);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView12);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button7);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button8);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton3);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;

		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView13);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView14);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView15);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button9);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button10);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton4);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;
		    	
		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView16);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView17);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView18);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button11);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button12);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton5);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;
		    	
		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView19);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView20);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView21);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button13);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button14);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton6);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;
		    	
		    	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView22);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView23);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView24);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button16);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button15);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton7);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;
		    	
		  /*  	time.moveToFirst(); 
		    	for(index=0;index<listcnt;index++)
		    		if(time.getInt(2)==filled+1)
		    			break;
		    		else if(index<listcnt-1)
		    			time.moveToNext();	
		    	tv=(TextView)findViewById(R.id.textView25);
		    	tv.setText(time.getString(0));
		    	tv=(TextView)findViewById(R.id.textView26);
		    	tv.setText(time.getString(1));
		    	tv=(TextView)findViewById(R.id.textView27);
		    	tv.setText(time.getInt(2)+"");
		    	bt=(Button) findViewById(R.id.button17);
		    	bt.setVisibility(View.VISIBLE);
		    	bt=(Button) findViewById(R.id.button18);
		    	bt.setVisibility(View.VISIBLE);
		    	tb=(ToggleButton)findViewById(R.id.toggleButton8);
		    	tb.setVisibility(View.VISIBLE);
		    	if(++filled==listcnt)
		    		break;   	
		    */	run=0;
		      }
			
			if(time.isLast()||filled==listcnt)
			{
				down.setEnabled(false);
			}
			if(run==1)
				filled=((filled/8)*8)+8;
		}
    });
  bt = (Button)findViewById(R.id.button3);
  bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
			if(filled<=8)
				Toast.makeText(setting_class.this, "Already has the highest priority", Toast.LENGTH_SHORT);
			else
			{
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView6);
				num=Integer.parseInt((String) tv.getText());
				tv=(TextView)findViewById(R.id.textView4);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num-1), null);
				values=new ContentValues();
				values.put("priority",(num-1));
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView5);
				tv.setText(temp[1]);
			}
		}
	});
	bt=(Button)findViewById(R.id.button5);
	 bt.setOnClickListener(new OnClickListener() {
			TextView tv;
			int num;
			ContentValues values;
			String time;
			String[] temp;
			Cursor cur;
			public void onClick(View v) {
					temp=new String[2];
					tv=(TextView)findViewById(R.id.textView9);
					num=Integer.parseInt((String) tv.getText());
					tv=(TextView)findViewById(R.id.textView7);
					time=(String) tv.getText();
					
					values=new ContentValues();
					values.put("priority",num);
					db.update("time", values, "priority="+(num-1), null);
					values=new ContentValues();
					values.put("priority",num-1);
					db.update("time", values, "time='"+time+"'", null);
					
					cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
					cur.moveToFirst();
					temp[0]=cur.getString(0);
					temp[1]=cur.getString(1);
					tv.setText(temp[0]);
					tv=(TextView)findViewById(R.id.textView8);
					tv.setText(temp[1]);
					
					cur=db.query("time", null, "priority = ?", new String[]{(num-1)+""}, null, null, null);
					cur.moveToFirst();
					temp[0]=cur.getString(0);
					temp[1]=cur.getString(1);
					tv=(TextView)findViewById(R.id.textView4);
					tv.setText(temp[0]);
					tv=(TextView)findViewById(R.id.textView5);
					tv.setText(temp[1]);
				}
		});
	bt=(Button)findViewById(R.id.button7);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView12);
				num=Integer.parseInt((String) tv.getText());
				tv=(TextView)findViewById(R.id.textView10);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num-1), null);
				values=new ContentValues();
				values.put("priority",num-1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView11);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num-1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv=(TextView)findViewById(R.id.textView7);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView8);
				tv.setText(temp[1]);
			}
	}); 
	bt=(Button)findViewById(R.id.button9);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView15);
				num=Integer.parseInt((String) tv.getText());
				tv=(TextView)findViewById(R.id.textView13);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num-1), null);
				values=new ContentValues();
				values.put("priority",num-1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView14);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num-1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv=(TextView)findViewById(R.id.textView10);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView11);
				tv.setText(temp[1]);
			}
	}); 
	bt=(Button)findViewById(R.id.button11);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView18);
				num=Integer.parseInt((String) tv.getText());
				tv=(TextView)findViewById(R.id.textView16);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num-1), null);
				values=new ContentValues();
				values.put("priority",num-1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView17);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num-1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv=(TextView)findViewById(R.id.textView13);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView14);
				tv.setText(temp[1]);
			}
	});  
	bt=(Button)findViewById(R.id.button13);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView21);
				num=Integer.parseInt((String) tv.getText());
				tv=(TextView)findViewById(R.id.textView19);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num-1), null);
				values=new ContentValues();
				values.put("priority",num-1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView20);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num-1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv=(TextView)findViewById(R.id.textView16);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView17);
				tv.setText(temp[1]);
			}
	}); 
	bt=(Button)findViewById(R.id.button15);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView24);
				num=Integer.parseInt((String) tv.getText());
				tv=(TextView)findViewById(R.id.textView22);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num-1), null);
				values=new ContentValues();
				values.put("priority",num-1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView23);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num-1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv=(TextView)findViewById(R.id.textView19);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView20);
				tv.setText(temp[1]);
			}
	});
	/*bt=(Button)findViewById(R.id.button17);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView27);
				num=Integer.parseInt((String) tv.getText());
				if(num!=listcnt)
				{
				tv=(TextView)findViewById(R.id.textView25);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num-1), null);
				values=new ContentValues();
				values.put("priority",num-1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView26);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num-1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv=(TextView)findViewById(R.id.textView22);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView23);
				tv.setText(temp[1]);
			}
		}
	});*/
	 bt=(Button)findViewById(R.id.button4);
	 bt.setOnClickListener(new OnClickListener() {
			TextView tv;
			int num;
			ContentValues values;
			String time;
			String[] temp;
			Cursor cur;
			public void onClick(View v) {
					temp=new String[2];
					tv=(TextView)findViewById(R.id.textView6);
					num=Integer.parseInt((String) tv.getText());
					if(num!=listcnt)
					{
					tv=(TextView)findViewById(R.id.textView4);
					time=(String) tv.getText();
					
					values=new ContentValues();
					values.put("priority",num);
					db.update("time", values, "priority="+(num+1), null);
					values=new ContentValues();
					values.put("priority",num+1);
					db.update("time", values, "time='"+time+"'", null);
					
					cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
					cur.moveToFirst();
					temp[0]=cur.getString(0);
					temp[1]=cur.getString(1);
					tv.setText(temp[0]);
					tv=(TextView)findViewById(R.id.textView5);
					tv.setText(temp[1]);
					
					cur=db.query("time", null, "priority = ?", new String[]{(num+1)+""}, null, null, null);
					cur.moveToFirst();
					temp[0]=cur.getString(0);
					temp[1]=cur.getString(1);
					tv=(TextView)findViewById(R.id.textView7);
					tv.setText(temp[0]);
					tv=(TextView)findViewById(R.id.textView8);
					tv.setText(temp[1]);
				}
			}
		});
	bt=(Button)findViewById(R.id.button6);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView9);
				num=Integer.parseInt((String) tv.getText());
				if(num!=listcnt)
				{
				tv=(TextView)findViewById(R.id.textView7);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num+1), null);
				values=new ContentValues();
				values.put("priority",num+1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView8);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num+1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv=(TextView)findViewById(R.id.textView10);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView11);
				tv.setText(temp[1]);
			}
		}
	});
	bt=(Button)findViewById(R.id.button8);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView12);
				num=Integer.parseInt((String) tv.getText());
				if(num!=listcnt)
				{
				tv=(TextView)findViewById(R.id.textView10);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num+1), null);
				values=new ContentValues();
				values.put("priority",num+1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView11);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num+1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv=(TextView)findViewById(R.id.textView13);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView14);
				tv.setText(temp[1]);
			}
		}
	});
	bt=(Button)findViewById(R.id.button10);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView15);
				num=Integer.parseInt((String) tv.getText());
				if(num!=listcnt)
				{
				tv=(TextView)findViewById(R.id.textView13);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num+1), null);
				values=new ContentValues();
				values.put("priority",num+1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView14);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num+1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv=(TextView)findViewById(R.id.textView16);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView17);
				tv.setText(temp[1]);
			}
		}
	});
	bt=(Button)findViewById(R.id.button12);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView18);
				num=Integer.parseInt((String) tv.getText());
				if(num!=listcnt)
				{
				tv=(TextView)findViewById(R.id.textView16);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num+1), null);
				values=new ContentValues();
				values.put("priority",num+1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView17);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num+1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv=(TextView)findViewById(R.id.textView19);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView20);
				tv.setText(temp[1]);
				}
			}
	});
	bt=(Button)findViewById(R.id.button14);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView21);
				num=Integer.parseInt((String) tv.getText());
				if(num!=listcnt)
				{
				tv=(TextView)findViewById(R.id.textView19);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num+1), null);
				values=new ContentValues();
				values.put("priority",num+1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView20);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num+1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv=(TextView)findViewById(R.id.textView22);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView23);
				tv.setText(temp[1]);
			}
		}
	});
	bt=(Button)findViewById(R.id.button16);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
			
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView24);
				num=Integer.parseInt((String) tv.getText());
				if(num!=listcnt)
				{
				tv=(TextView)findViewById(R.id.textView22);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num+1), null);
				values=new ContentValues();
				values.put("priority",num+1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView23);
				tv.setText(temp[1]);
				
				cur=db.query("time", null, "priority = ?", new String[]{(num+1)+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
			/*	tv=(TextView)findViewById(R.id.textView25);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView26);
				tv.setText(temp[1]);
			*/}
		}
	});
/*	bt=(Button)findViewById(R.id.button18);
	bt.setOnClickListener(new OnClickListener() {
		TextView tv;
		int num;
		ContentValues values;
		String time;
		String[] temp;
		Cursor cur;
		public void onClick(View v) {
				if(filled>=listcnt)
					;
				else
				{
				temp=new String[2];
				tv=(TextView)findViewById(R.id.textView24);
				num=Integer.parseInt((String) tv.getText());
				tv=(TextView)findViewById(R.id.textView22);
				time=(String) tv.getText();
				
				values=new ContentValues();
				values.put("priority",num);
				db.update("time", values, "priority="+(num+1), null);
				values=new ContentValues();
				values.put("priority",num+1);
				db.update("time", values, "time='"+time+"'", null);
				
				cur=db.query("time", null, "priority = ?", new String[]{num+""}, null, null, null);
				cur.moveToFirst();
				temp[0]=cur.getString(0);
				temp[1]=cur.getString(1);
				tv.setText(temp[0]);
				tv=(TextView)findViewById(R.id.textView23);
				tv.setText(temp[1]);
			}
		}
	});*/
    tb=(ToggleButton)findViewById(R.id.toggleButton1);
    tb.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		ToggleButton tb=(ToggleButton)findViewById(R.id.toggleButton1);
			TextView tv=(TextView)findViewById(R.id.textView6);
    		ContentValues values;
    		values=new ContentValues();
    		values.put("enable",tb.isChecked()?1:0);
			////Toast.makeText(getApplicationContext(),tb.isChecked()+"",Toast.LENGTH_LONG).show();
			int priority=Integer.parseInt((String) tv.getText());
			db.update("time", values, "priority="+priority, null);
		}
	});
    tb=(ToggleButton)findViewById(R.id.toggleButton2);
    tb.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		ToggleButton tb=(ToggleButton)findViewById(R.id.toggleButton2);
			TextView tv=(TextView)findViewById(R.id.textView9);
    		ContentValues values;
    		values=new ContentValues();
    		values.put("enable",tb.isChecked()?1:0);
			//Toast.makeText(getApplicationContext(),tb.isChecked()+"",Toast.LENGTH_LONG).show();
			int priority=Integer.parseInt((String) tv.getText());
			db.update("time", values, "priority="+priority, null);
		}
	});
    tb=(ToggleButton)findViewById(R.id.toggleButton3);
    tb.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		ToggleButton tb=(ToggleButton)findViewById(R.id.toggleButton3);
			TextView tv=(TextView)findViewById(R.id.textView12);
    		ContentValues values;
    		values=new ContentValues();
    		values.put("enable",tb.isChecked()?1:0);
			//Toast.makeText(getApplicationContext(),tb.isChecked()+"",Toast.LENGTH_LONG).show();
			int priority=Integer.parseInt((String) tv.getText());
			db.update("time", values, "priority="+priority, null);
		}
	});
    tb=(ToggleButton)findViewById(R.id.toggleButton4);
    tb.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		ToggleButton tb=(ToggleButton)findViewById(R.id.toggleButton4);
			TextView tv=(TextView)findViewById(R.id.textView15);
    		ContentValues values;
    		values=new ContentValues();
    		values.put("enable",tb.isChecked()?1:0);
			//Toast.makeText(getApplicationContext(),tb.isChecked()+"",Toast.LENGTH_LONG).show();
			int priority=Integer.parseInt((String) tv.getText());
			db.update("time", values, "priority="+priority, null);
		}
	});
    tb=(ToggleButton)findViewById(R.id.toggleButton5);
    tb.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		ToggleButton tb=(ToggleButton)findViewById(R.id.toggleButton5);
			TextView tv=(TextView)findViewById(R.id.textView18);
    		ContentValues values;
    		values=new ContentValues();
    		values.put("enable",tb.isChecked()?1:0);
			//Toast.makeText(getApplicationContext(),tb.isChecked()+"",Toast.LENGTH_LONG).show();
			int priority=Integer.parseInt((String) tv.getText());
			db.update("time", values, "priority="+priority, null);
		}
	});
    tb=(ToggleButton)findViewById(R.id.toggleButton6);
    tb.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		ToggleButton tb=(ToggleButton)findViewById(R.id.toggleButton6);
			TextView tv=(TextView)findViewById(R.id.textView21);
    		ContentValues values;
    		values=new ContentValues();
    		values.put("enable",tb.isChecked()?1:0);
			//Toast.makeText(getApplicationContext(),tb.isChecked()+"",Toast.LENGTH_LONG).show();
			int priority=Integer.parseInt((String) tv.getText());
			db.update("time", values, "priority="+priority, null);
		}
	});
    tb=(ToggleButton)findViewById(R.id.toggleButton7);
    tb.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		ToggleButton tb=(ToggleButton)findViewById(R.id.toggleButton7);
			TextView tv=(TextView)findViewById(R.id.textView24);
    		ContentValues values;
    		values=new ContentValues();
    		values.put("enable",tb.isChecked()?1:0);
			//Toast.makeText(getApplicationContext(),tb.isChecked()+"",Toast.LENGTH_LONG).show();
			int priority=Integer.parseInt((String) tv.getText());
			db.update("time", values, "priority="+priority, null);
		}
	});
   /* tb=(ToggleButton)findViewById(R.id.toggleButton8);
    tb.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		ToggleButton tb=(ToggleButton)findViewById(R.id.toggleButton8);
			TextView tv=(TextView)findViewById(R.id.textView27);
    		ContentValues values;
    		values=new ContentValues();
    		values.put("enable",tb.isChecked()?1:0);
			//Toast.makeText(getApplicationContext(),tb.isChecked()+"",Toast.LENGTH_LONG).show();
			int priority=Integer.parseInt((String) tv.getText());
			db.update("time", values, "priority="+priority, null);
		}
	});*/
    }
}