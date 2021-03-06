package com.gargdaughters.uberbitch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    HomePagerAdapter homePagerAdapter;
    ViewPager mViewPager;
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        homePagerAdapter=new HomePagerAdapter(getSupportFragmentManager());
        mTabLayout=(TabLayout)findViewById(R.id.tablayout);
        mViewPager=(ViewPager)findViewById(R.id.viewPager1);
        mViewPager.setAdapter(homePagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.mipmap.home_bottom_tab_icon);
        mTabLayout.getTabAt(2).setIcon(R.mipmap.degign_bottom_tab_icon);
        mTabLayout.getTabAt(1).setIcon(R.mipmap.user_bottom_tab_icon);
        mTabLayout.getTabAt(3).setIcon(R.mipmap.bill_bottom_tab_icon);
        mTabLayout.getTabAt(4).setIcon(R.mipmap.settings_bottom_tab_icon);
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
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tablayout);
        if (id == R.id.nav_services) {
            Intent intent = new Intent (this, ServiceActivity.class);
            startActivity(intent);

            //tabLayout.getTabAt(0).select();
        } else if (id == R.id.nav_packages) {
            Intent intent = new Intent (this, PackageActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_customer) {
            Intent intent=new Intent(this,CustomerActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_employees) {
            Intent intent=new Intent(this,EmployeeActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_cost) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        /*if (fragment != null) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.addToBackStack(null);
            transaction.replace(R.id.drawer_layout, fragment);
            transaction.commit();
        }*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        //tabLayout.getTabAt(0).select();
        return true;
    }
}
