package pl.michalgorny.eventomat.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import pl.michalgorny.eventomat.BusProvider;
import pl.michalgorny.eventomat.NavigationDrawerFragment;
import pl.michalgorny.eventomat.R;
import pl.michalgorny.eventomat.SearchFragment;
import pl.michalgorny.eventomat.fragments.EventModeFragment;
import pl.michalgorny.eventomat.fragments.FeedbackFragment;


public class MainActivity extends SuperActivity  {


    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void handleUserAction(int number) {
        Fragment fragment = null;

        switch (number) {
            case 1: //Search
                mTitle = getString(R.string.title_section1);
                fragment = SearchFragment.newInstance();
                break;
            case 2: //EventMode
                mTitle = getString(R.string.title_section2);
                fragment = EventModeFragment.newInstance();
                break;
            case 3: //Feedback
                mTitle = getString(R.string.title_section3);
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
    public void handleAdminAction(int number) {

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

}
