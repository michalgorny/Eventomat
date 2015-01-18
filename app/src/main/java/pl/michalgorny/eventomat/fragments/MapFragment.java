package pl.michalgorny.eventomat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by misa on 2015-01-18.
 */
public class MapFragment extends Fragment {
    public static Fragment newInstance() {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}
