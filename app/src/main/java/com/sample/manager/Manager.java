package com.sample.manager;

import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int i=0,k=0;
    String name;
    String email;
    String password;
    String pno;
    String gender;
    String dob;
    String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        password = intent.getStringExtra("password");
        pno = intent.getStringExtra("pno");
        gender = intent.getStringExtra("gender");
        dob = intent.getStringExtra("dob");
        city = intent.getStringExtra("city");



        if ( isExternalStorageWritable() ) {

            File appDirectory = new File( Environment.getExternalStorageDirectory() + "/LogFolder" );
            File logDirectory = new File( appDirectory + "/log" );
            File logFile = new File( logDirectory, "logcat.txt" );

                // create app folder
                if ( !appDirectory.exists() ) {
                    appDirectory.mkdir();
                }

                // create log folder
                if ( !logDirectory.exists() ) {
                    logDirectory.mkdir();
                }

                // clear the previous logcat and then write the new one to the file
                try {
                    Runtime.getRuntime().exec("logcat -c");
                    Runtime.getRuntime().exec("logcat -f " + logFile);
                } catch ( IOException e ) {
                    e.printStackTrace();
                }

            } else if ( isExternalStorageReadable() ) {
                // only readable
            } else {
                // not accessible
            }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                String upTo = currentDateTimeString.substring(0, Math.min(currentDateTimeString.length(), 13));
                String table; int s = 0;
                MyDataBase myDataBase = new MyDataBase(getApplicationContext());

                TextView textView = (TextView) findViewById(R.id.gone);
                textView.setVisibility(View.GONE);

                CardView cardView = (CardView) findViewById(R.id.cardView);
                CardView cardView1 = (CardView) findViewById(R.id.cardView1);
                CardView cardView2 = (CardView) findViewById(R.id.cardView2);
                CardView cardView3 = (CardView) findViewById(R.id.cardView3);
                CardView cardView4 = (CardView) findViewById(R.id.cardView4);
                CardView cardView5 = (CardView) findViewById(R.id.cardView5);
                CardView cardView6 = (CardView) findViewById(R.id.cardView6);
                CardView cardView7 = (CardView) findViewById(R.id.cardView7);
                CardView cardView8 = (CardView) findViewById(R.id.cardView8);
                CardView cardView9 = (CardView) findViewById(R.id.cardView9);

                table =getResources().getString(R.string.tno)+(i+1)+"-"+upTo;
                Cursor cursor = myDataBase.checkpkey(table);
                if (cursor.getCount() == 1) {
                    cursor.moveToNext();
                    String s1 = cursor.getString(cursor.getColumnIndex(MyDataBase.col3));
                    s = Integer.parseInt(s1.substring(s1.length() - 1));
                }

                if(i ==0) {
                    cardView.setVisibility(View.VISIBLE);
                    cardView1.setVisibility(View.INVISIBLE);
                    Snackbar.make(view, "Table Added", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    if(s ==i+1) {
                        cardView.setForeground(ResourcesCompat.getDrawable(getResources(), R.drawable.booked,null));
                        cardView.setEnabled(false);
                    }
                    i++;
                } else if(i ==1) {
                    cardView1.setVisibility(View.VISIBLE);
                    Snackbar.make(view, "Table Added", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    if(s ==i+1) {

                        cardView1.setForeground(ResourcesCompat.getDrawable(getResources(), R.drawable.booked,null));
                        cardView1.setEnabled(false);
                    }
                    i++;
                } else if(i ==2) {
                    cardView2.setVisibility(View.VISIBLE);
                    cardView3.setVisibility(View.INVISIBLE);
                    Snackbar.make(view, "Table Added", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    if(s ==i+1) {

                        cardView2.setForeground(ResourcesCompat.getDrawable(getResources(), R.drawable.booked,null));
                        cardView2.setEnabled(false);
                    }
                    i++;
                } else if(i ==3) {
                    cardView3.setVisibility(View.VISIBLE);
                    cardView4.setVisibility(View.INVISIBLE);
                    Snackbar.make(view, "Table Added", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    if(s ==i+1) {

                        cardView3.setForeground(ResourcesCompat.getDrawable(getResources(), R.drawable.booked,null));
                        cardView3.setEnabled(false);
                    }
                    i++;
                } else if(i ==4) {
                    cardView4.setVisibility(View.VISIBLE);
                    cardView5.setVisibility(View.INVISIBLE);
                    Snackbar.make(view, "Table Added", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    if(s ==i+1) {

                        cardView4.setForeground(ResourcesCompat.getDrawable(getResources(), R.drawable.booked,null));
                        cardView4.setEnabled(false);
                    }
                    i++;
                } else if(i ==5) {
                    cardView5.setVisibility(View.VISIBLE);
                    Snackbar.make(view, "Table Added", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    if(s ==i+1) {

                        cardView5.setForeground(ResourcesCompat.getDrawable(getResources(), R.drawable.booked,null));
                        cardView5.setEnabled(false);
                    }
                    i++;
                } else if(i ==6) {
                    cardView6.setVisibility(View.VISIBLE);
                    cardView7.setVisibility(View.INVISIBLE);
                    Snackbar.make(view, "Table Added", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    if(s ==i+1) {

                        cardView6.setForeground(ResourcesCompat.getDrawable(getResources(), R.drawable.booked,null));
                        cardView6.setEnabled(false);
                    }
                    i++;
                } else if(i ==7) {
                    cardView7.setVisibility(View.VISIBLE);
                    Snackbar.make(view, "Table Added", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    if(s ==i+1) {

                        cardView7.setForeground(ResourcesCompat.getDrawable(getResources(), R.drawable.booked,null));
                        cardView7.setEnabled(false);
                    }
                    i++;
                } else if(i ==8) {
                    cardView8.setVisibility(View.VISIBLE);
                    cardView9.setVisibility(View.INVISIBLE);
                    Snackbar.make(view, "Table Added", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    if(s ==i+1) {

                        cardView8.setForeground(ResourcesCompat.getDrawable(getResources(), R.drawable.booked,null));
                        cardView8.setEnabled(false);
                    }
                    i++;
                } else if(i ==9) {
                    cardView9.setVisibility(View.VISIBLE);
                    Snackbar.make(view, "Table Added", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    if(s ==0) {

                        cardView9.setForeground(ResourcesCompat.getDrawable(getResources(), R.drawable.booked,null));
                        cardView9.setEnabled(false);
                    }
                    i++;
                } else {

                    Snackbar.make(view, "No Table Added", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View navHeader = navigationView.getHeaderView(0);

        TextView textView100 = navHeader.findViewById(R.id.textView100);
        TextView textView101 = navHeader.findViewById(R.id.textView101);
        textView100.setText(name);
        textView101.setText(city);

        ImageView imageView = navHeader.findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Profile.class);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                intent.putExtra("pno",pno);
                intent.putExtra("gender",gender);
                intent.putExtra("dob",dob);
                intent.putExtra("city",city);

                startActivity(intent);
            }
        });

        navigationView.setCheckedItem(R.id.nav_home);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.f1, new FirstLayout()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.manager, menu);
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
            Intent intent = new Intent(getApplicationContext(),Profile.class);
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            intent.putExtra("password",password);
            intent.putExtra("pno",pno);
            intent.putExtra("gender",gender);
            intent.putExtra("dob",dob);
            intent.putExtra("city",city);

            startActivity(intent);
            return true;
        }

        else if (id == R.id.action_log_out) {

            Intent intent1 = new Intent(getApplicationContext(),Login.class);
            startActivity(intent1);
            Intent intent =new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();
        i=0;
        TextView textView = (TextView) findViewById(R.id.gone);
        textView.setVisibility(View.VISIBLE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        if (id == R.id.nav_home) {
            fragmentManager.beginTransaction().replace(R.id.f1, new FirstLayout()).commit();
            fab.setVisibility(View.VISIBLE);
            k=1;
        }

        else
        if (id == R.id.nav_prebook) {
            fragmentManager.beginTransaction().replace(R.id.f1, new SecondLayout()).commit();
            fab.setVisibility(View.VISIBLE);
            k=2;
        }

        else
        if (id == R.id.nav_manageprofit) {
            fragmentManager.beginTransaction().replace(R.id.f1, new ThirdLayout()).commit();
            textView.setVisibility(View.GONE);
            fab.setVisibility(View.GONE);
        }

        else
        if (id == R.id.nav_menu) {
            fragmentManager.beginTransaction().replace(R.id.f1, new FourthLayout()).commit();
            textView.setVisibility(View.GONE);
            fab.setVisibility(View.GONE);
        }

        else
        if (id == R.id.nav_price) {
            fragmentManager.beginTransaction().replace(R.id.f1, new FifthLayout()).commit();
            textView.setVisibility(View.GONE);
            fab.setVisibility(View.GONE);

        }

        else
        if (id == R.id.nav_email) {

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"support@example.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Employee ID");
            emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/LogFolder/log/logcat.txt"));


            PackageManager pm = getPackageManager();

            Intent openInChooser = Intent.createChooser(emailIntent, "Send");
            Intent openInChooser2 = null;
            int j = 0;

            List<ResolveInfo> resInfo = pm.queryIntentActivities(emailIntent, 0);
            List<LabeledIntent> intentList = new ArrayList<>();
            for (int i = 0; i < resInfo.size(); i++) {
                ResolveInfo ri = resInfo.get(i);
                String packageName = ri.activityInfo.packageName;

                if(packageName.contains("android.email")) {
                    emailIntent.setPackage(packageName);
                    j=1;
                }

                else


                if(packageName.contains("android.gm")) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(packageName, ri.activityInfo.name));
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"support@example.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                    intent.putExtra(Intent.EXTRA_TEXT, "From: "+name+"\nRestaurant Name: "+city);
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/LogFolder/log/logcat.txt"));
                    intentList.clear();
                    intentList.add(new LabeledIntent(intent, packageName, ri.loadLabel(pm), ri.icon));
                     openInChooser2 = Intent.createChooser(intent, "Send");
                     j=2;

                    }
            }

            LabeledIntent[] extraIntents = intentList.toArray( new LabeledIntent[ intentList.size() ]);
            openInChooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, extraIntents);

            if (j==2)
                startActivity(openInChooser2);
            else if (j==1)
                startActivity(openInChooser);

        }

        else
        if (id == R.id.nav_address) {
            String uri = "geo:22.570935,88.421201?q=22.570935,88.421201(Restaurant Manager)";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));

            this.startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void c(View view) {


        int a = 0;
        switch (view.getId()){

            case R.id.cardView:
                a=1;
                break;
            case R.id.cardView1:
                a=2;
                break;
            case R.id.cardView2:
                a=3;
                break;
            case R.id.cardView3:
                a=4;
                break;
            case R.id.cardView4:
                a=5;
                break;
            case R.id.cardView5:
                a=6;
                break;
            case R.id.cardView6:
                a=7;
                break;
            case R.id.cardView7:
                a=8;
                break;
            case R.id.cardView8:
                a=9;
                break;
            case R.id.cardView9:
                a=10;
                break;
        }


        Intent intent = new Intent(getApplicationContext(),Course.class);
        intent.putExtra("TableNo",Integer.toString(a));
        intent.putExtra("k",Integer.toString(k));
        intent.putExtra("email",email);

        startActivity(intent);

    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent1 = new Intent(getApplicationContext(),Login.class);
            startActivity(intent1);
            Intent intent =new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }



}


















