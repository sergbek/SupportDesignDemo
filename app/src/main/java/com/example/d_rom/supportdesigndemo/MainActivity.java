package com.example.d_rom.supportdesigndemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.d_rom.supportdesigndemo.adapter.TabFragmentAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private View mContentLayout;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContentLayout = findViewById(R.id.content);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        setCollapsedTitle();

        // Find our drawer view
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Find our drawer view
        mNavigationView = (NavigationView) findViewById(R.id.navigation);
//        mNavigationView.getMenu().add("Custom Item").setActionView(R.layout.list_item);

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.drawer_open,  R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mFab = (FloatingActionButton)findViewById(R.id.fab);
        mFab.setOnClickListener(this);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab _tab) {
                    if (_tab.getPosition() % 2 == 0){
                        mFab.show();
                    }else {
                        mFab.hide();
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab _tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab _tab) {

                }
            });
        }
    }

    private void setCollapsedTitle() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolBarLayout);
        collapsingToolbarLayout.setTitle(getTitle());
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.accent));
    }

    private void setupViewPager(ViewPager _viewPager) {
        TabFragmentAdapter adapter = new TabFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new SimpleListFragment(), "Tab 1");
        adapter.addFragment(new SimpleListFragment(), "Tab 2");
        adapter.addFragment(new SimpleListFragment(), "Long tab 3");
        adapter.addFragment(new SimpleListFragment(), "Tab 4");
        adapter.addFragment(new SimpleListFragment(), "Tab 5");
        adapter.addFragment(new SimpleListFragment(), "Tab 6");
        adapter.addFragment(new SimpleListFragment(), "Tab 7");
        _viewPager.setAdapter(adapter);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();
        if (id == R.id.action_snake) {
            Snackbar
                    .make(mContentLayout, R.string.snack_message, Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.snack_action, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Snackbar
                                    .make(mContentLayout, R.string.snacke_message_2, Snackbar.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .show();
            return true;
        }else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,SecondActivity.class));
    }
}
