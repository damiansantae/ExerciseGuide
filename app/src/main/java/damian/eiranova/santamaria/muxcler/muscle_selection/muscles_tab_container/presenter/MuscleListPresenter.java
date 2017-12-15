package damian.eiranova.santamaria.muxcler.muscle_selection.muscles_tab_container.presenter;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import damian.eiranova.santamaria.muxcler.AppMediador;
import damian.eiranova.santamaria.muxcler.main_activity.model.IMainModel;
import damian.eiranova.santamaria.muxcler.main_activity.model.MainModel;
import damian.eiranova.santamaria.muxcler.main_activity.model.Muscle;

public class MuscleListPresenter {


    private IMainModel mainModel;

    public MuscleListPresenter() {
        mainModel = MainModel.getInstance();
    }

    private BroadcastReceiver notificationReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(AppMediador.NOTIFY_DATA_MUSCLELIST_READY2)) {
                ArrayList<Muscle> muscleList = (ArrayList<Muscle>) intent.getSerializableExtra(AppMediador.MUSCLE_LIST_KEY);
                String[] data = new String[muscleList.size()];
                for (int i = 0; i < muscleList.size(); i++) {
                    data[i] = muscleList.get(i).getMuscleName();
                }
                AppMediador.getInstance().getMusclerListFragment().UpdateMasterMuscleList(data);
                AppMediador.getInstance().getMuscleDrawFragment().UpdateMuscleDraw(data);
            }
        }
    };


    public void getMuscleMasterListData() {
        AppMediador.getInstance().registerReceiver(notificationReceiver, AppMediador.NOTIFY_DATA_MUSCLELIST_READY2);
        mainModel.getMuclerListData2();
    }
}
