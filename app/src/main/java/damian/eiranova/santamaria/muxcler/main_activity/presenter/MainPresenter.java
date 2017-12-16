package damian.eiranova.santamaria.muxcler.main_activity.presenter;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import damian.eiranova.santamaria.muxcler.AppMediador;
import damian.eiranova.santamaria.muxcler.exercise_list.model.Exercise;
import damian.eiranova.santamaria.muxcler.exercise_list.model.ExerciseListModel;
import damian.eiranova.santamaria.muxcler.main_activity.model.IMainModel;
import damian.eiranova.santamaria.muxcler.main_activity.model.MainModel;
import damian.eiranova.santamaria.muxcler.main_activity.model.Muscle;
import damian.eiranova.santamaria.muxcler.main_activity.model.MuscleRepository;

public class MainPresenter implements IMainPresenter {


    private IMainModel mainModel;
    private ExerciseListModel exerciseModel;

    public MainPresenter() {
        mainModel = MainModel.getInstance();
        exerciseModel = ExerciseListModel.getInstance();
    }

    private BroadcastReceiver notificationReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(AppMediador.NOTIFY_DATA_MUSCLELIST_READY)) {
                ArrayList<Muscle> muscleList = (ArrayList<Muscle>) intent.getSerializableExtra(AppMediador.MUSCLE_LIST_KEY);
                String[] data = new String[muscleList.size()];
                for (int i = 0; i < muscleList.size(); i++) {
                    data[i] = muscleList.get(i).getMuscleName();
                }
                AppMediador.getInstance().getMainView().UpdateMasterMuscleList(data);
            } else if (intent.getAction().equals(AppMediador.NOTIFY_DATA_EXERCISE_LIST_READY)) {
                ArrayList<Exercise> exerciseList = (ArrayList<Exercise>) intent.getSerializableExtra(AppMediador.EXERCISE_LIST_KEY);
                Exercise[] data = new Exercise[exerciseList.size()];
                for (int i = 0; i < exerciseList.size(); i++) {
                    data[i] = exerciseList.get(i);
                }
                AppMediador.getInstance().getExerciseListFragment().UpdateExerciseList(data);
            }else if (intent.getAction().equals(AppMediador.NOTIFY_DETAIL_DATA_EXERCISE_READY)){
                Exercise exercise = (Exercise) intent.getSerializableExtra(AppMediador.EXERCISE_DETAIL_KEY);
                AppMediador.getInstance().getExerciseDetailFragment().UpdateExerciseDetail(exercise);
            }
        }
    };


    @Override
    public void getExerciseList(int posicion) {
        AppMediador.getInstance().registerReceiver(notificationReceiver, AppMediador.NOTIFY_DATA_EXERCISE_LIST_READY);
        exerciseModel.getExerciseListData(MuscleRepository.getInstance().getMuscleList().get(posicion).getMuscleID());

    }

    @Override
    public void getExerciseListOfMuscle(String name) {
        AppMediador.getInstance().registerReceiver(notificationReceiver, AppMediador.NOTIFY_DATA_EXERCISE_LIST_READY);
        for (Muscle muscle : MuscleRepository.getInstance().getMuscleList()
                ) {
            if (muscle.getMuscleName().equals(name)) {
                exerciseModel.getExerciseListData(muscle.getMuscleID());
                break;
            }
        }
    }

    @Override
    public void getExerciseDetail(String name) {
        AppMediador.getInstance().registerReceiver(notificationReceiver, AppMediador.NOTIFY_DETAIL_DATA_EXERCISE_READY);
        exerciseModel.getExerciseDetail(name);
    }

    @Override
    public void getExerciseListOfCurrentMuscle() {
        exerciseModel.getExerciseListDataOfCurrentMuscle();

    }
}
