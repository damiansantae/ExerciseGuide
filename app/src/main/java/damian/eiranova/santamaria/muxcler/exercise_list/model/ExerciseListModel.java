package damian.eiranova.santamaria.muxcler.exercise_list.model;


import android.os.Bundle;

import damian.eiranova.santamaria.muxcler.AppMediador;

public class ExerciseListModel implements IExerciseListModel{

    private static ExerciseListModel singleton = null;
    private ExerciseRepository exerciseRepository;
    private String muscleID;
    private String[] starImages = new String[5];
    private String[] machineImages = new String[2];

    private final int NEED_MACHINE = 0;
    private final int NO_NEED_MACHINE = 1;


    private ExerciseListModel() {
        this.muscleID = null;
        exerciseRepository = ExerciseRepository.getInstance();
        starImages[0] = "star0";
        starImages[1] = "star1";
        starImages[2] = "star2";
        starImages[3] = "star3";
        starImages[4] = "star4";

        machineImages[NEED_MACHINE] = "weight";
        machineImages[NO_NEED_MACHINE] = "nweight";

    }

    public static ExerciseListModel getInstance() {
        if (singleton == null) {
            singleton = new ExerciseListModel();
        }
        return singleton;
    }


    @Override
    public void getExerciseListData(String muscleID) {
        this.muscleID = muscleID;
        Bundle extras = new Bundle();
        extras.putSerializable(AppMediador.EXERCISE_LIST_KEY, exerciseRepository.getExerciseList(muscleID));
        AppMediador.getInstance().sendBroadcast(AppMediador.NOTIFY_DATA_EXERCISE_LIST_READY, extras);

    }

    @Override
    public String getStarImageReference(int difficulty) {
        switch (difficulty) {
            case 0:
                return starImages[0];
            case 1:
                return starImages[1];
            case 2:
                return starImages[2];
            case 3:
                return starImages[3];
            case 4:
                return starImages[4];
        }
        return null;
    }

    @Override
    public String getMachineImageReference(boolean needMachine) {
        if (needMachine) {
            return machineImages[NEED_MACHINE];
        } else {
            return machineImages[NO_NEED_MACHINE];
        }
    }

    public void getExerciseDetail(String name) {
        Bundle extras = new Bundle();

        extras.putSerializable(AppMediador.EXERCISE_DETAIL_KEY, exerciseRepository.getExerciseDetail(name));
        AppMediador.getInstance().sendBroadcast(AppMediador.NOTIFY_DETAIL_DATA_EXERCISE_READY, extras);

    }


    public void getExerciseListDataOfCurrentMuscle() {
        Bundle extras = new Bundle();
        extras.putSerializable(AppMediador.EXERCISE_LIST_KEY, exerciseRepository.getExerciseList(muscleID));
        AppMediador.getInstance().sendBroadcast(AppMediador.NOTIFY_DATA_EXERCISE_LIST_READY, extras);

    }
}
