package com.dcodereapers.www.dcr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar=null;
    NavigationView navigationView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

         navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



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
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_news) {

        } else if (id == R.id.nav_elib) {
            /**
             * Inflating the E-Library fragment into the container
             */
            ElibFragment elibFragment=new ElibFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, elibFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_timetable) {

            /**
             * Inflating the Time Table fragment into the container
             */
            TimeTableFragment timeTableFragment=new TimeTableFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, timeTableFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_feedback) {


            /**
             * Setting the email intent for sending mail about Feedback
             */

            String[] TO = {"app.dcr@gmail.com"};
            String[] CC = {""};
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

            // only email apps should handle this
            emailIntent.setData(Uri.parse("mailto:"));

            //emailIntent.setType("*/*");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            //emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Thank you for giving your time to help us improve :)");

            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            }
            else
            {
                Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }

        } else if (id == R.id.nav_report) {


            /**
             * Setting the email intent for sending mail about bugs report
             */

            String[] TO = {"app.dcr@gmail.com"};
            String[] CC = {""};
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

            // only email apps should handle this
            emailIntent.setData(Uri.parse("mailto:"));

            //emailIntent.setType("*/*");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            //emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bug Report");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Please explain the error/bug you are facing");

            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);

            }
            else
            {
                Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }


        }
        else if (id == R.id.nav_about) {
            /**
             * Inflating the About fragment into the container
             */
            AboutFragment aboutFragment=new AboutFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, aboutFragment);
            fragmentTransaction.commit();


        }
        else if (id == R.id.nav_dev) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //-------------------------------------------------------------------------------------------------------------------------

    /**
     *
     * @mitra00
     * Functions for hardwiring all the buttons with their respective actions
     *
     */

 //-------------------------------------TIME TABLE BUTTONS-------------------------------------------------------------------
    /**
     *Button of the !st year Sec A Time Table
     */
    public void y1aTime(View view)
    {
        /**
         * @mitra00
         * Inflating the Time Table for !st year Section A into the container
         */
        y1aTimeFragment y1aTime=new y1aTimeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, y1aTime);
        fragmentTransaction.commit();
    }


    /**
     *Button of the !st year Sec B Time Table
     */
    public void y1bTime(View view)
    {
        /**
         * @mitra00
         * Inflating the Time Table for !st year Section B into the container
         */
        y1bTimeFragment y1bTime=new y1bTimeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, y1bTime);
        fragmentTransaction.commit();
    }

    /**
     *Button of the 2nd year Sec A Time Table
     */
    public void y2aTime(View view)
    {
        /**
         * @mitra00
         * Inflating the Time Table for 2nd year Section A into the container
         */
        y2aTimeFragment y2aTime=new y2aTimeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, y2aTime);
        fragmentTransaction.commit();
    }

    /**
     *Button of the 2nd year Sec B Time Table
     */
    public void y2bTime(View view)
    {
        /**
         * @mitra00
         * Inflating the Time Table for 2nd year Section B into the container
         */
        y2bTimeFragment y2bTime=new y2bTimeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, y2bTime);
        fragmentTransaction.commit();
    }


    /**
     *Button of the  3rd year Sec A Time Table
     */
    public void y3aTime(View view)
    {
        /**
         * @mitra00
         * Inflating the Time Table for 3rd year Section A into the container
         */
        y3aTimeFragment y3aTime=new y3aTimeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, y3aTime);
        fragmentTransaction.commit();
    }

    /**
     *Button of the  3rd year Sec B Time Table
     */
    public void y3bTime(View view)
    {
        /**
         * @mitra00
         * Inflating the Time Table for 3rd year Section B into the container
         */
        y3bTimeFragment y3bTime=new y3bTimeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, y3bTime);
        fragmentTransaction.commit();
    }

    /**
     *Button of the  4th year Sec A Time Table
     */
    public void y4aTime(View view)
    {
        /**
         * @mitra00
         * Inflating the Time Table for 4th year Section A into the container
         */
        y4aTimeFragment y4aTime=new y4aTimeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, y4aTime);
        fragmentTransaction.commit();
    }

    /**
     *Button of the  4th year Sec B Time Table
     */
    public void y4bTime(View view)
    {
        /**
         * @mitra00
         * Inflating the Time Table for 4th year Section B into the container
         */
        y4bTimeFragment y4bTime=new y4bTimeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, y4bTime);
        fragmentTransaction.commit();
    }

    //-----------------------------------------------------------------------------------------------------------------------


    //---------------------------------------------E-LIBRARY---------------------------------------------------------

    /**
     *Button of the  Sem 1
     */
    public void s1Sub(View view)
    {
        /**
         * @mitra00
         * Inflating the subjects of SEM 1 into the container
         */
        sem1SubFragment s1Sub=new sem1SubFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, s1Sub);
        fragmentTransaction.commit();
    }

    /**
     *Button of the  Sem 3
     */
    public void s3Sub(View view)
    {
        /**
         * @mitra00
         * Inflating the subjects of SEM 1 into the container
         */
        sem3SubFragment s3Sub=new sem3SubFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, s3Sub);
        fragmentTransaction.commit();
    }


    /**
     *Button of the  Sem 5
     */
    public void s5Sub(View view)
    {
        /**
         * @mitra00
         * Inflating the subjects of SEM 5 into the container
         */
        sem5SubFragment s5Sub=new sem5SubFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, s5Sub);
        fragmentTransaction.commit();
    }


}
