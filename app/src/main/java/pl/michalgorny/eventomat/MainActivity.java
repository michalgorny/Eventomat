package pl.michalgorny.eventomat;

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

import pl.michalgorny.eventomat.fragments.EventModeFragment;
import pl.michalgorny.eventomat.fragments.FeedbackFragment;


public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks  {

    private NavigationDrawerFragment mNavigationDrawerFragment;

    private CharSequence mTitle;

    private enum MODE{
        USER,
        ORGANIZER;
    }

    private MODE mMode = MODE.USER;

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

        BusProvider.getInstance().register(this);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        if (mMode == MODE.USER)
            handleUserAction(position);
        else
            handleAdminAction(position);
    }

    private void handleUserAction(int number) {
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

    private void handleAdminAction(int number) {

    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            if (mMode == MODE.USER)
                mMode = MODE.ORGANIZER;
            else
                mMode = MODE.USER;

            Toast.makeText(this, "Mode changed to " + mMode.toString(), Toast.LENGTH_SHORT).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
