package pl.michalgorny.eventomat.adapters;

import android.content.Context;

import com.parse.ParseQueryAdapter;

import pl.michalgorny.eventomat.pojos.Events;

/**
 * Created by misa on 2015-01-18.
 */
public class CustomAdapter extends ParseQueryAdapter<Events> {
    public CustomAdapter(Context context, String className) {
        super(context, className);
    }
}
