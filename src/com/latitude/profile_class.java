package com.latitude;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.latitude.R;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.media.AudioManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class profile_class extends Activity {
    /** Called when the activity is first created. */
SQLiteDatabase db;
int sil,vib,keys,mvol,rvol,avol,nvol;
AudioManager audMangr;
    public void onCreate(Bundle savedInstanceState)
    {    

    	 super.onCreate(savedInstanceState);
         setContentView(R.layout.profile_layout);
         Button bt9=(Button)findViewById(R.id.button4);
         bt9.setEnabled(true);
         Button bt2=(Button)findViewById(R.id.button2); 
         Button bt3=(Button)findViewById(R.id.button3);
         Button bt4=(Button)findViewById(R.id.Button01);
         Button bt=(Button)findViewById(R.id.Button02);
         Button bt5=(Button)findViewById(R.id.Button03);
         Button bt6=(Button)findViewById(R.id.Button04);
         Button bt7=(Button)findViewById(R.id.Button05);
         Button bt8=(Button)findViewById(R.id.Button06);
                
    CheckBox r =   ( CheckBox ) findViewById( R.id.checkBox1);
    	r.setOnCheckedChangeListener(new OnCheckedChangeListener()
    	{
    	    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    	    {
    	    	Button bt2=(Button)findViewById(R.id.button2); 
    	         Button bt3=(Button)findViewById(R.id.button3);
    	         Button bt4=(Button)findViewById(R.id.Button01);
    	         Button bt=(Button)findViewById(R.id.Button02);
    	         Button bt5=(Button)findViewById(R.id.Button03);
    	         Button bt6=(Button)findViewById(R.id.Button04);
    	         Button bt7=(Button)findViewById(R.id.Button05);
    	         Button bt8=(Button)findViewById(R.id.Button06);
    	         EditText e1=(EditText)findViewById(R.id.editText2);
                 EditText e2=(EditText)findViewById(R.id.EditText01);
                 EditText e3=(EditText)findViewById(R.id.EditText02);
                 EditText e4=(EditText)findViewById(R.id.EditText03);
                 
    	        if (isChecked)
    	        {
    	        	 bt2.setEnabled(false);
    	        	 bt.setEnabled(false);
    	        	 bt3.setEnabled(false);
    	        	 bt4.setEnabled(false);
    	        	 e1.setEnabled(false);
                     e2.setEnabled(false);
                     bt5.setEnabled(false);
    	        	 bt6.setEnabled(false);
    	        	 e3.setEnabled(false);
    	        	 bt7.setEnabled(false);
    	        	 bt8.setEnabled(false);
    	        	 e4.setEnabled(false);
    	        }
    	        else
    	        {
   	        	 bt2.setEnabled(true);
   	        	 bt.setEnabled(true);
   	        	 bt3.setEnabled(true);
   	        	 bt4.setEnabled(true);
   	        	 e1.setEnabled(true);
                 e2.setEnabled(true);   
                 bt5.setEnabled(true);
	        	 bt6.setEnabled(true);
	        	 e3.setEnabled(true);
	        	 bt7.setEnabled(true);
	        	 bt8.setEnabled(true);
	        	 e4.setEnabled(true);
    	        }
    	    }
    	});

        bt2.setOnClickListener(new OnClickListener()
        {
        	 public void onClick(View v)
             {
        		String val;
        		int va; 
        		EditText e1=(EditText)findViewById(R.id.editText2);
        		 val=e1.getText().toString();
        		  va=Integer.parseInt(val);
        		  if(va<15)
        		  {
        		  va++;
        		 e1.setText(va+"");
        		  }
             }
        });
        
        bt3.setOnClickListener(new OnClickListener()
        {
        	 public void onClick(View v)
             {
        		String val;
        		int va; 
        		EditText e1=(EditText)findViewById(R.id.editText2);
        		 val=e1.getText().toString();
        		  va=Integer.parseInt(val);
        		  if(va>0)
        		  {
        		  va--;
        		 e1.setText(va+"");
        		  }
             }
        });
        
        
        bt5.setOnClickListener(new OnClickListener()
        {
        	 public void onClick(View v)
             {
        		String val;
        		int va; 
        		EditText e1=(EditText)findViewById(R.id.EditText02);
        		 val=e1.getText().toString();
        		  va=Integer.parseInt(val);
        		  if(va<15)
        		  {
        		  va++;
        		 e1.setText(va+"");
        		  }
             }
        });
        
        bt6.setOnClickListener(new OnClickListener()
        {
        	 public void onClick(View v)
             {
        		String val;
        		int va; 
        		EditText e1=(EditText)findViewById(R.id.EditText02);
        		 val=e1.getText().toString();
        		  va=Integer.parseInt(val);
        		  if(va>0)
        		  {
        		  va--;
        		 e1.setText(va+"");
        		  }
             }
        });
        
        bt7.setOnClickListener(new OnClickListener()
        {
        	 public void onClick(View v)
             {
        		String val;
        		int va; 
        		EditText e1=(EditText)findViewById(R.id.EditText03);
        		 val=e1.getText().toString();
        		  va=Integer.parseInt(val);
        		  if(va<15)
        		  {
        		  va++;
        		 e1.setText(va+"");
        		  }
             }
        });
        
        bt8.setOnClickListener(new OnClickListener()
        {
        	 public void onClick(View v)
             {
        		String val;
        		int va; 
        		EditText e1=(EditText)findViewById(R.id.EditText03);
        		 val=e1.getText().toString();
        		  va=Integer.parseInt(val);
        		  if(va>0)
        		  {
        		  va--;
        		 e1.setText(va+"");
        		  }
             }
        });
    
        bt4.setOnClickListener(new OnClickListener()
        {
        	 public void onClick(View v)
             {
        		String val;
        		int va; 
        		EditText e1=(EditText)findViewById(R.id.EditText01);
        		 val=e1.getText().toString();
        		  va=Integer.parseInt(val);
        		  if(va<7)
        		  {
        		  va++;
        		 e1.setText(va+"");
        		  }
             }
        });
       
        
        bt.setOnClickListener(new OnClickListener()
        {
        	 public void onClick(View v)
             {
        		String val;
        		int va; 
        		EditText e1=(EditText)findViewById(R.id.EditText01);
        		 val=e1.getText().toString();
        		  va=Integer.parseInt(val);
        		  if(va>0)
        		  {
        		  va--;
        		  e1.setText(va+"");
        		  }
             }
        });
        

       Bundle bundle = this.getIntent().getExtras();
        final String val1 = bundle.getString("val1");
       // Toast.makeText(getApplicationContext(),val1,Toast.LENGTH_LONG).show();
               
        db=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);
       
       if(val1.equals("New Profile.."))
       {
    	  
    	   bt9.setEnabled(false);
        try
        {
        db.execSQL("create table profiles(pname TEXT PRIMARY KEY,silent integer,vibration integer,keysound integer,mediavol integer,ringvol integer,alarmvol integer,notivol integer)");
        }
        catch(SQLException e)
        {}

        Button bt1=(Button)findViewById(R.id.button1);
        bt1.setOnClickListener(new OnClickListener()
        {
         public void onClick(View v)
         {
        	 db=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
             db.setVersion(1);
             db.setLocale(Locale.getDefault());
             db.setLockingEnabled(true);
            
           String str,val1,val2,val3,val4;
                 Boolean b1;
                 int i;
                 ContentValues values = new ContentValues();
                 EditText et=(EditText)findViewById(R.id.editText1);
                 CheckBox cb1=(CheckBox)findViewById(R.id.checkBox1);
                 CheckBox cb2=(CheckBox)findViewById(R.id.checkBox2);
                 CheckBox cb3=(CheckBox)findViewById(R.id.checkBox3);
                 EditText e1=(EditText)findViewById(R.id.editText2);
                 EditText e2=(EditText)findViewById(R.id.EditText01);
                 Button bt5=(Button)findViewById(R.id.Button03);
    	         Button bt6=(Button)findViewById(R.id.Button04);
                 EditText e3=(EditText)findViewById(R.id.EditText02);
                 Button bt7=(Button)findViewById(R.id.Button05);
    	         Button bt8=(Button)findViewById(R.id.Button06);
                 EditText e4=(EditText)findViewById(R.id.EditText03);
                 
                 int flg=0;
                 
                 str=et.getText().toString();
                 b1=cb1.isChecked();
                 if(b1==true)
                 {   i=1;    
                
                 } 
                 else
                 {   i=0;    }
                 values.put("pname", str);
                 values.put("silent", i);
                 b1=cb2.isChecked();
                 if(b1==true)
                 {   i=1;    } 
                 else
                 {   i=0;    }
                 values.put("vibration", i);
                 b1=cb3.isChecked();
                 if(b1==true)
                 {   i=1;    } 
                 else
                 {   i=0;    }
                 values.put("keysound", i);
                 
                 val1=e1.getText().toString();
                 val2=e2.getText().toString();
                 val3=e3.getText().toString();
                 val4=e4.getText().toString();

                 values.put("mediavol", val1);
                 values.put("ringvol", val2);
                 values.put("alarmvol", val3);
                 values.put("notivol", val4);
                 
                 db.insert("profiles", null, values);
               Toast.makeText(getApplicationContext(),"Profile created succefully",Toast.LENGTH_LONG).show();
               Intent in=new Intent(profile_class.this,main_activity.class);
               Bundle bundle = new Bundle();
    			bundle.putInt("curtab",0);
    			in.putExtras(bundle);
               startActivity(in);
   			   finish();
         }                 
        }
        );     
        
    }
    else
    {
    	audMangr= (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);
    	 Cursor cur = db.query("profiles", new String[]{"silent","vibration","keysound","mediavol","ringvol","alarmvol","notivol"}, "pname = ?", new String[]{val1} , null, null, null, null);
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
    	
    	EditText e1=(EditText)findViewById(R.id.editText2);
        e1.setText(mvol+"");
        EditText e2=(EditText)findViewById(R.id.EditText01);
        e2.setText(rvol+"");
        EditText e3=(EditText)findViewById(R.id.EditText02);
        e3.setText(avol+"");
        EditText e4=(EditText)findViewById(R.id.EditText03);
        e4.setText(nvol+"");
        
              
        AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
       
        int mvol1 = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        int rvol1 = audio.getStreamVolume(AudioManager.STREAM_RING);
        int avol1 = audio.getStreamVolume(AudioManager.STREAM_ALARM);
        int nvol1 = audio.getStreamVolume(AudioManager.STREAM_NOTIFICATION);
        
        // Adjust media volume
   //     Toast.makeText(getApplicationContext(),"mvol "+mvol1,Toast.LENGTH_LONG).show();
      /*  int tmp;
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
        Toast.makeText(getApplicationContext(),"avol "+avol1,Toast.LENGTH_LONG).show();    
        
        
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
        Toast.makeText(getApplicationContext(),"nvol "+nvol1,Toast.LENGTH_LONG).show();    
        */
        
         EditText et=(EditText)findViewById(R.id.editText1);
    	 et.setText(val1);
    	 CheckBox cb1=(CheckBox)findViewById(R.id.checkBox1);
         CheckBox cb2=(CheckBox)findViewById(R.id.checkBox2);
         CheckBox cb3=(CheckBox)findViewById(R.id.checkBox3);
         
         if(sil==1)
         {  	
        	 cb1.setChecked(true);
        	// audMangr.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        }
         else{
        	 cb1.setChecked(false);
        //	 audMangr.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        	// audMangr.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        
         	}
         if(vib==1)
         {  	 
        	 cb2.setChecked(true);
        	// audMangr.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        }
         else
         {
        	 cb2.setChecked(false); 
        //	 audMangr.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        	// audMangr.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        }
         if(keys==1)
         {  	 cb3.setChecked(true);}
         else{cb3.setChecked(false); }
 
         Button bt19=(Button)findViewById(R.id.button4);
         bt19.setOnClickListener(new OnClickListener()
         {
          public void onClick(View v)
          {   
        	  db=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
              db.setVersion(1);
              db.setLocale(Locale.getDefault());
              db.setLockingEnabled(true);
             
        	Cursor cur;
        	db.execSQL("delete from profiles where pname='"+val1+"'");
        	cur = db.query("time", new String[]{"location"}, "pname = ?", new String[]{val1} , null, null, null, null);
        	  if(cur.getCount()!=0)
              {
              cur.moveToFirst();
              while (cur.isAfterLast() == false) 
              {
            	db.execSQL("delete from time where location ='"+cur.getString(0)+"'");
                cur.moveToNext();
              }
              }
        	Toast.makeText(getApplicationContext(), "Profile deleted", Toast.LENGTH_SHORT).show();
        	Intent in=new Intent(profile_class.this,main_activity.class);
        	Bundle bundle = new Bundle();
			bundle.putInt("curtab",0);
			in.putExtras(bundle);
        	startActivity(in);
  			finish();
          }
         });
         
         Button bt1=(Button)findViewById(R.id.button1);
         bt1.setOnClickListener(new OnClickListener()
         {
          public void onClick(View v)
          {
        	  db=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
              db.setVersion(1);
              db.setLocale(Locale.getDefault());
              db.setLockingEnabled(true);
             
        	  	  String str,v1,v2,v3,v4;
                  Boolean b1;
                  int i;
                  ContentValues values = new ContentValues();
                  EditText et=(EditText)findViewById(R.id.editText1);
                  CheckBox cb1=(CheckBox)findViewById(R.id.checkBox1);
                  CheckBox cb2=(CheckBox)findViewById(R.id.checkBox2);
                  CheckBox cb3=(CheckBox)findViewById(R.id.checkBox3);
                  EditText e1=(EditText)findViewById(R.id.editText2);
                  EditText e2=(EditText)findViewById(R.id.EditText01);
                  EditText e3=(EditText)findViewById(R.id.EditText02);
                  EditText e4=(EditText)findViewById(R.id.EditText03);
                  
                  v1=e1.getText().toString();
                  v2=e2.getText().toString();
                  v3=e3.getText().toString();
                  v4=e4.getText().toString();
                  
                  str=et.getText().toString();
                  b1=cb1.isChecked();
                  if(b1==true)
                  {   i=1;    } 
                  else
                  {   i=0;    }
                  values.put("pname", str);
                  values.put("silent", i);
                  b1=cb2.isChecked();
                  if(b1==true)
                  {   i=1;    } 
                  else
                  {   i=0;    }
                  values.put("vibration", i);
                  b1=cb3.isChecked();
                  if(b1==true)
                  {   i=1;    } 
                  else
                  {   i=0;    }
                  values.put("keysound", i);
                  values.put("mediavol", v1);
                  values.put("ringvol", v2);
                  values.put("alarmvol", v3);
                  values.put("notivol", v4);
               
                  db.update("profiles", values, "pname = '"+ val1+"'",null );
                Toast.makeText(getApplicationContext(),"Profile "+val1+" updated succefully",Toast.LENGTH_LONG).show();
                Intent in=new Intent(profile_class.this,main_activity.class);
                Bundle bundle = new Bundle();
    			bundle.putInt("curtab",0);
    			in.putExtras(bundle);
    			startActivity(in);
    			finish();
          }                 
         }
         
         );          
         int tmp1 = 0;}     
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
    		Intent in=new Intent(profile_class.this,main_activity.class);
    		Bundle bundle = new Bundle();
			bundle.putInt("curtab",0);
			in.putExtras(bundle);
    		startActivity(in);
			finish();
    	//	Toast.makeText(getApplicationContext(), "helooo", Toast.LENGTH_SHORT);
    		break;    
    	} 
    	return true;
    	} 


}