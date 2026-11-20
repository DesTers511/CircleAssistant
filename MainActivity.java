package com.example.circleoverlay;
import android.app.Activity; import android.os.Bundle; import android.content.Intent; import android.provider.Settings; import android.net.Uri; import android.view.View; import android.widget.*;
public class MainActivity extends Activity {
 @Override public void onCreate(Bundle b){ super.onCreate(b); LinearLayout box=new LinearLayout(this); box.setOrientation(LinearLayout.VERTICAL); box.setPadding(28,28,28,28);
 TextView title=new TextView(this); title.setText("Circle Overlay\n\nOverlay preview + slow circle gesture"); title.setTextSize(22); box.addView(title);
 Button permission=new Button(this); permission.setText("1. Allow display over other apps"); permission.setOnClickListener(v->{if(!Settings.canDrawOverlays(this)){Intent i=new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:"+getPackageName()));startActivity(i);}else Toast.makeText(this,"Overlay permission already enabled",Toast.LENGTH_SHORT).show();});box.addView(permission);
 Button accessibility=new Button(this); accessibility.setText("2. Enable Circle Overlay accessibility"); accessibility.setOnClickListener(v->startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)));box.addView(accessibility);
 Button start=new Button(this);start.setText("3. Start overlay");start.setOnClickListener(v->{if(!Settings.canDrawOverlays(this)){Toast.makeText(this,"First allow overlay permission",Toast.LENGTH_LONG).show();return;}startService(new Intent(this,OverlayService.class));Toast.makeText(this,"Overlay started",Toast.LENGTH_SHORT).show();});box.addView(start);
 TextView note=new TextView(this);note.setText("The floating controls appear over other apps. Tap DRAW to preview and send the circle gesture. Accessibility must be enabled for gesture input. Gesture center is screen center; align the game board before drawing."); note.setPadding(0,18,0,0);box.addView(note); setContentView(box); }
}
