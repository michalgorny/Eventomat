package pl.michalgorny.eventomat;

/**
 * Created by misa on 2015-01-18.
 */
public class ChangeFragmentEvent {
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    private String mName;

    public ChangeFragmentEvent(String name) {
        setmName(name);
    }
}
