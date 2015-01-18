package pl.michalgorny.eventomat.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseObject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import pl.michalgorny.eventomat.ui.EventActivity;
import pl.michalgorny.eventomat.ui.EventModeActivity;
import pl.michalgorny.eventomat.R;

/**
 * Created by misa on 2015-01-18.
 */
public class ShowEventFragment extends Fragment{

    static ParseObject mItem;

    @InjectView(R.id.eventName)
    TextView mEventName;

    @InjectView(R.id.eventDescription)
    TextView mEventDescription;

    @InjectView(R.id.joinButton)
    Button mJoinButton;

    public static Fragment newInstance(ParseObject item) {
        mItem = item;

        ShowEventFragment fragment = new ShowEventFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.show_event_fragment, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mEventDescription.setText(mItem.getString("Description"));
        mEventName.setText(mItem.getString("name"));
    }

    @OnClick(R.id.joinButton)
    public void onJoinClick(){
        Intent intent = new Intent(getActivity(), EventActivity.class);
        startActivity(intent);
    }
}
