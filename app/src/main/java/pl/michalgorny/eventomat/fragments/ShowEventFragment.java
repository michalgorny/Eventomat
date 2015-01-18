package pl.michalgorny.eventomat.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.parse.ParseObject;

import butterknife.ButterKnife;
import pl.michalgorny.eventomat.R;
import pl.michalgorny.eventomat.pojos.Events;

/**
 * Created by misa on 2015-01-18.
 */
public class ShowEventFragment extends Fragment{

    static ParseObject mItem;

    public static Fragment newInstance(ParseObject item) {
        mItem = item;

        ShowEventFragment fragment = new ShowEventFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity2, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(), mItem.getString("Description"), Toast.LENGTH_LONG).show();
    }
}
