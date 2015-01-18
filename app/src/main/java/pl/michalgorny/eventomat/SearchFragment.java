package pl.michalgorny.eventomat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.ParseQueryAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import pl.michalgorny.eventomat.fragments.ShowEventFragment;
import pl.michalgorny.eventomat.pojos.Events;

public class SearchFragment extends Fragment {

    @InjectView(R.id.eventList)
    ListView mEventList;

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SearchFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BusProvider.getInstance().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity2, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ParseQueryAdapter<Events> adapter = new ParseQueryAdapter<Events>(getActivity(), "Events");
        adapter.setTextKey("name");
        mEventList.setAdapter(adapter);

        mEventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, ShowEventFragment.newInstance(adapter.getItem(i))).addToBackStack(null).commit();
                BusProvider.getInstance().post(new ChangeFragmentEvent("ShowFragment"));
            }
        });
    }
}
