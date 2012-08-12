package com.latitude;
import java.util.Locale;

import com.latitude.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;

import android.media.AudioManager;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

public class selectprofile extends Activity {
	SQLiteDatabase db;
	Cursor cur;
	int listcnt;
	 static String[] criteria_gps;
	public void onCreate(Bundle savedInstanceState)
    {    
    	 super.onCreate(savedInstanceState);
    	 setContentView(R.layout.selectprofile);
    	 
    	 Button newprof=(Button) findViewById(R.id.button1);
         newprof.setOnClickListener(new OnClickListener()
        {
        	 public void onClick(View v)
             {
        		Intent in=new Intent(selectprofile.this,profile_class.class);
     			Bundle bundle = new Bundle();
     			bundle.putString("val1","New Profile..");
     			in.putExtras(bundle);
     			startActivity(in);
     			finish();
             }
        });
         
         db=openOrCreateDatabase("lp.db",SQLiteDatabase.CREATE_IF_NECESSARY, null);
         db.setVersion(1);
         db.setLocale(Locale.getDefault());
         db.setLockingEnabled(true);
         

         cur = db.query("profiles",null, null, null, null, null, null);
         listcnt=0;
         if(cur.getCount()!=0)
         {
         cur.moveToFirst();
         while (cur.isAfterLast() == false) 
         {
           cur.moveToNext();
          listcnt++;
         }

         criteria_gps=new String[listcnt];
         cur.moveToFirst();
         int move=0;
         while (cur.isAfterLast() == false) 
         {
         	criteria_gps[move]=cur.getString(0);
             cur.moveToNext();
             move++;
         }
         cur.close();
         


     ListView l=(ListView)findViewById(R.id.listView1); 
	 l.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1 ,criteria_gps)); 

	 l.setOnItemClickListener( new OnItemClickListener() 
	 { 

	 public void onItemClick(AdapterView<?> adapter, View view, int pos, long arg3) 
	 { 
	 String str=adapter.getItemAtPosition(pos).toString(); 
	 Intent i = new Intent(selectprofile.this, profile_class.class); 
	 Bundle bundle = new Bundle();
	 bundle.putString("val1",str);
	 i.putExtras(bundle);
	 startActivity(i);
	 //finish(); 
	 }

	 }); 

    	 
    	 
 /* String str=adapter.getItemAtPosition(pos).toString(); 
	 Intent i = new Intent(selectprofile.this, profile_class.class); 
	 Bundle bundle = new Bundle(); 
	 bundle.putString("val1",str); 
	 i.putExtras(bundle); 
	 startActivity(i); 
	 //finish(); */
         
    }
        
         }
};