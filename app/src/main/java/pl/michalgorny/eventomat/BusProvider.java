package pl.michalgorny.eventomat;

import com.squareup.otto.Bus;

/**
 * Created by misa on 2015-01-18.
 */
public class BusProvider {

    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    private BusProvider() {
        // No instances.
    }
}
