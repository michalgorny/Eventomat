package pl.michalgorny.eventomat.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import pl.michalgorny.eventomat.R;

/**
 * Created by misa on 2015-01-18.
 */
public abstract class SuperActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    public enum MODE{
        USER,
        ORGANIZER;
    }

    public MODE mMode = MODE.USER;

    public CharSequence mTitle;

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        if (mMode == MODE.USER)
            handleUserAction(position);
        else
            handleAdminAction(position);
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
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

    protected abstract void handleUserAction(int position);

    protected abstract void handleAdminAction(int position);
}
