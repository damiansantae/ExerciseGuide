package damian.eiranova.santamaria.muxcler.exercise_list.model;


import android.os.Bundle;

import damian.eiranova.santamaria.muxcler.AppMediador;

public class ExerciseListModel{

    private static ExerciseListModel singleton = null;
    private ExerciseRepository exerciseRepository;


    private ExerciseListModel(){
        exerciseRepository = ExerciseRepository.getInstance();

    }

    public static  ExerciseListModel getInstance(){
        if(singleton == null){
            singleton = new ExerciseListModel();
        }
        return singleton;
    }



    public void getExerciseListData(String muscleID) {
        Bundle extras = new Bundle();
        extras.putSerializable(AppMediador.EXERCISE_LIST_KEY,exerciseRepository.getExerciseList(muscleID));
        AppMediador.getInstance().sendBroadcast(AppMediador.NOTIFY_DATA_EXERCISE_LIST_READY,extras);

    }
}
