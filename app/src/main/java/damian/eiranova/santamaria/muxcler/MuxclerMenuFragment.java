package damian.eiranova.santamaria.muxcler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MuxclerMenuFragment extends Fragment {



    public static MuxclerMenuFragment newInstance() {

        return new MuxclerMenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.muxcler_menu_fragment, container, false);
    }

}
