package com.ronyalvarez.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button smsButton = (Button) findViewById(R.id.sms_button);
        if (smsButton != null) {
            smsButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent sms = new Intent(Intent.ACTION_SENDTO);
                    sms.setData(Uri.parse("smsto:" + Uri.encode("3473358327")));
                    sms.putExtra("sms_body", "Rony Alvarez");
                    startActivity(sms);
                }
            });
        }

        Button phoneButton = (Button) findViewById(R.id.phone_button);
        if (phoneButton != null) {
            phoneButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent call = new Intent(Intent.ACTION_DIAL);
                    call.setData(Uri.parse("tel:3473358327"));
                    startActivity(call);

                }
            });
        }

        Button webButton = (Button) findViewById(R.id.web_button);
        if (webButton != null) {
            webButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"));
                    startActivity(web);
                }
            });
        }

        Button mapButton = (Button) findViewById(R.id.map_button);
        if (mapButton != null) {
            mapButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String geoUri = String.format("https://www.google.com/maps/place/San+Pedro+Sula,+Honduras/@15.5161461,-88.0460936,13z/data=!4m5!3m4!1s0x8f66430b113d5af1:0x323ecf76c17e8f6b!8m2!3d15.5149204!4d-87.9922684");
                    Uri geo = Uri.parse(geoUri);
                    Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                    startActivity(geoMap);
                }
            });
        }

        Button shareButton = (Button) findViewById(R.id.share_button);
        if (shareButton != null) {
            shareButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "CS639");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Join CS639");
                    shareIntent.setType("url");
                    startActivity(Intent.createChooser(shareIntent, "Share the love"));
                }
            });
        }

        Button newActivityButton = (Button) findViewById(R.id.new_activity_button);
        if (newActivityButton != null) {
            newActivityButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                    startActivity(intent);
                }
            });
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();
            return true;
        } else if(id == R.id.action_help) {
            final Intent openHelp = new Intent(getApplicationContext(), HelpActivity.class);
            startActivity(openHelp);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
