package damian.eiranova.santamaria.muxcler.main_activity.model;


import android.os.Bundle;

import damian.eiranova.santamaria.muxcler.AppMediador;

public class MainModel implements IMainModel {

    private static MainModel singleton = null;
    private MuscleRepository muscleRepository;


    private MainModel(){
        muscleRepository = MuscleRepository.getInstance();

    }

    public static  MainModel getInstance(){
        if(singleton == null){
            singleton = new MainModel();
        }
        return singleton;
    }


    @Override
    public void getMusclesListData() {
        Bundle extras = new Bundle();
        extras.putSerializable(AppMediador.MUSCLE_LIST_KEY,muscleRepository.getMuscleList());
        AppMediador.getInstance().sendBroadcast(AppMediador.NOTIFY_DATA_MUSCLELIST_READY,extras);

    }
}
