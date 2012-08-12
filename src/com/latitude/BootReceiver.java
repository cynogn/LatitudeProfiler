package com.latitude;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver
{   
	public void onReceive(Context context, Intent intent) 
	{         
	Intent serviceIntent = new Intent(gpservice.class.getName());         
	context.startService(serviceIntent);  
	}
} 
