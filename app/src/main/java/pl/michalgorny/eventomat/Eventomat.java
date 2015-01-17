package pl.michalgorny.eventomat;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

public class Eventomat extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "AxoLVEF1mgZLbYGRuTa27C7ltJGhEyk5BXENud7p", "kMAcNomD1hyziMlrAO4rKoEPWHVRTTip8oJ1KG05");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
