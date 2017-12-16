package damian.eiranova.santamaria.muxcler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import damian.eiranova.santamaria.muxcler.main_activity.view.IMainView;

public class MuxclerMenuFragment extends Fragment implements View.OnClickListener {

    private IMainView mainView;

    public static MuxclerMenuFragment newInstance() {

        return new MuxclerMenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.muxcler_menu_fragment, container, false);
        CardView goToGuideBtn = view.findViewById(R.id.guide_card);
        CardView goToMapBtn = view.findViewById(R.id.map_card);
        goToGuideBtn.setOnClickListener(this);
        goToMapBtn.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.guide_card:
                if (mainView == null) {
                    mainView = AppMediador.getInstance().getMainView();
                }
                mainView.loadTabFragment();
                break;
            case R.id.map_card:
                //TODO: implementar navegacion hacia mapa
                break;
        }

    }
}
