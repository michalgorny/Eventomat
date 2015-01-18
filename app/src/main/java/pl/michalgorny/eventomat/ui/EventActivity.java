package pl.michalgorny.eventomat.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import pl.michalgorny.eventomat.R;
import pl.michalgorny.eventomat.SearchFragment;
import pl.michalgorny.eventomat.fragments.AgendaFragment;
import pl.michalgorny.eventomat.fragments.EventModeFragment;
import pl.michalgorny.eventomat.fragments.FeedbackFragment;
import pl.michalgorny.eventomat.fragments.MapFragment;
import pl.michalgorny.eventomat.fragments.NewsFragment;

public class EventActivity extends SuperActivity {


    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }


    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.event_mode_title_section1);
                break;
            case 2:
                mTitle = getString(R.string.event_mode_title_section2);
                break;
            case 3:
                mTitle = getString(R.string.event_mode_title_section3);
                break;
            case 4:
                mTitle = getString(R.string.event_mode_title_section4);
                break;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void handleUserAction(int number) {
        Fragment fragment = null;

        switch (number) {
            case 1: //News
                mTitle = getString(R.string.event_mode_title_section1);
                fragment = NewsFragment.newInstance();
                break;
            case 2: //Agenda
                mTitle = getString(R.string.event_mode_title_section2);
                fragment = AgendaFragment.newInstance();
                break;
            case 3: //Map
                mTitle = getString(R.string.event_mode_title_section3);
                fragment = MapFragment.newInstance();
                break;

            case 4: //Feedback
                mTitle = getString(R.string.event_mode_title_section4);
                fragment = FeedbackFragment.newInstance();
                break;


            default:
                fragment = SearchFragment.newInstance();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    protected void handleAdminAction(int position) {

    }
}
